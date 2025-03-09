package com.book.Management.System.BookManagementSystem.Testng.Generic.Code;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.support.JpaRepositoryFactory;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.List;

@Component
public class DynamicRepositoryFactory {


    @Autowired
    private EntityManager entityManager;

    public <T, ID> DynamicJpaRepository<T, ID> createRepository(Class<T> entityClass, Class<ID> idClass) {
        JpaRepositoryFactory factory = new JpaRepositoryFactory(entityManager);
        SimpleJpaRepository<T, ID> simpleJpaRepository = new SimpleJpaRepository<>(entityClass, entityManager);
        return (DynamicJpaRepository<T, ID>) Proxy.newProxyInstance(
                DynamicJpaRepository.class.getClassLoader(),
                new Class[]{DynamicJpaRepository.class},
                new DynamicJpaRepositoryInvocationHandler<>(entityManager, entityClass, simpleJpaRepository)
        );
    }

    private static class DynamicJpaRepositoryInvocationHandler<T, ID> implements InvocationHandler {

        private final EntityManager entityManager;
        private final Class<T> entityClass;
        private final SimpleJpaRepository<T, ID> simpleJpaRepository;

        public DynamicJpaRepositoryInvocationHandler(EntityManager entityManager, Class<T> entityClass, SimpleJpaRepository<T, ID> simpleJpaRepository) {
            this.entityManager = entityManager;
            this.entityClass = entityClass;
            this.simpleJpaRepository = simpleJpaRepository;
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            if (method.getName().equals("findBy")) {
                return findByColumn(args);
            }
            return method.invoke(simpleJpaRepository, args); // Delegate to JpaRepository methods
        }

        private List<T> findByColumn(Object[] args) {
            if (args.length != 2 || !(args[0] instanceof String)) {
                throw new IllegalArgumentException("findBy method requires a column name and a value.");
            }
            String columnName = (String) args[0];
            Object value = args[1];

            String jpql = "SELECT e FROM " + entityClass.getSimpleName() + " e WHERE e." + columnName + " = :value";
            return entityManager.createQuery(jpql, entityClass).setParameter("value", value).getResultList();
        }
    }
//
//    @Autowired
//    private EntityManager entityManager;
//
//    public <T, ID> T createRepository(Class<T> repositoryInterface, Class<?> entityClass) {
//        JpaRepositoryFactory factory = new JpaRepositoryFactory(entityManager);
//        SimpleJpaRepository<?, ?> simpleJpaRepository = (SimpleJpaRepository<?, ?>) factory.getRepository(repositoryInterface, entityClass);
//
//        return (T) Proxy.newProxyInstance(
//                repositoryInterface.getClassLoader(),
//                new Class[]{repositoryInterface},
//                new DynamicRepositoryInvocationHandler(entityManager, entityClass, simpleJpaRepository)
//        );
//    }
//
//    private static class DynamicRepositoryInvocationHandler implements InvocationHandler {
//
//        private final EntityManager entityManager;
//        private final Class<?> entityClass;
//        private final SimpleJpaRepository<?, ?> simpleJpaRepository;
//        private final Map<String, Method> dynamicMethods = new HashMap<>();
//
//        public DynamicRepositoryInvocationHandler(EntityManager entityManager, Class<?> entityClass, SimpleJpaRepository<?, ?> simpleJpaRepository) {
//            this.entityManager = entityManager;
//            this.entityClass = entityClass;
//            this.simpleJpaRepository = simpleJpaRepository;
//            createDynamicMethods();
//        }
//
//        private void createDynamicMethods() {
//            EntityType<?> entityType = entityManager.getMetamodel().entity(entityClass);
//            entityType.getSingularAttributes().forEach(attribute -> {
//                String methodName = "findBy" + capitalize(attribute.getName());
//                try {
//                    Method method = entityClass.getMethod("get" + capitalize(attribute.getName()));
//                    dynamicMethods.put(methodName, method);
//                } catch (NoSuchMethodException e) {
//                    e.printStackTrace();
//                }
//            });
//        }
//
//        @Override
//        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
//            String methodName = method.getName();
//
//            if (dynamicMethods.containsKey(methodName)) {
//                SingularAttribute<?, ?> attribute = getAttributeFromMethodName(methodName);
//                if (attribute != null) {
//                    String attributeName = attribute.getName();
//                    String jpql = "SELECT e FROM " + entityClass.getSimpleName() + " e WHERE e." + attributeName + " = :value";
//                    return entityManager.createQuery(jpql, entityClass).setParameter("value", args[0]).getResultList();
//                }
//            }
//            return method.invoke(simpleJpaRepository, args); // Delegate to the original repository for standard methods.
//        }
//
//        private SingularAttribute<?, ?> getAttributeFromMethodName(String methodName) {
//            String attributeName = methodName.substring(6).toLowerCase(); // Remove "findBy" and lowercase
//            EntityType<?> entityType = entityManager.getMetamodel().entity(entityClass);
//            return entityType.getSingularAttribute(attributeName);
//        }
//
//        private String capitalize(String str) {
//            if (str == null || str.isEmpty()) {
//                return str;
//            }
//            return str.substring(0, 1).toUpperCase() + str.substring(1);
//        }
//    }
}
