package com.book.Management.System.BookManagementSystem.entityManager;

import com.book.Management.System.BookManagementSystem.entity.CityMaster;
import com.book.Management.System.BookManagementSystem.entity.CountryMaster;
import com.book.Management.System.BookManagementSystem.entity.UserAddressDetails;
import com.book.Management.System.BookManagementSystem.entityManager.convertors.AddressConverter;
import com.book.Management.System.BookManagementSystem.entityManager.convertors.CityConvertor;
import com.book.Management.System.BookManagementSystem.entityManager.convertors.CountaryConvertor;

import java.util.HashMap;
import java.util.Map;

public class ConverterFactory {


    private final Map<Class<?>, BaseConverter<?>> converterRegistry = new HashMap<>();

    // Register converters dynamically in the constructor
    public ConverterFactory(CountaryConvertor countryConverter, AddressConverter addressConverter, CityConvertor cityConverter) {
        registerConverter(CountryMaster.class, countryConverter);
        registerConverter(UserAddressDetails.class, addressConverter);
        registerConverter(CityMaster.class, cityConverter);
    }

    // Generic method to register a converter
    public <T> void registerConverter(Class<T> entityType, BaseConverter<T> converter) {
        converterRegistry.put(entityType, converter);
    }

    // Generic method to get a converter by entity class
    @SuppressWarnings("unchecked")
    public <T> BaseConverter<T> getConverter(Class<T> entityType) {
        return (BaseConverter<T>) converterRegistry.get(entityType);
    }

//    private final Map<Class<?>, BaseConverter<?>> converterRegistry = new HashMap<>();
//
//    public ConverterFactory(ApplicationContext applicationContext) {
//        // Get all BaseConverter beans
//        Map<String, BaseConverter<?>> converters = applicationContext.getBeansOfType(BaseConverter.class);
////        Map<String, BaseConverter<?>> converters = applicationContext.getBeansOfType(BaseConverter.class);
//
//        // Register each converter dynamically using its entity type
//        converters.forEach((name, converter) -> registerConverter(converter.getEntityType(), converter));
//    }
//
//    public <T> void registerConverter(Class<T> entityType, BaseConverter<T> converter) {
//        if (entityType != null) {
//            converterRegistry.put(entityType, converter);
//        }
//    }
//
//    @SuppressWarnings("unchecked")
//    public <T> BaseConverter<T> getConverter(Class<T> entityType) {
//        return (BaseConverter<T>) converterRegistry.get(entityType);
//    }


//    private final Map<Class<?>, BaseConverter<?>> converterRegistry = new HashMap<>();
//
//    // Automatically discover all BaseConverter implementations
//    public ConverterFactory(ApplicationContext applicationContext) {
//        Map<String, BaseConverter<?>> converters = applicationContext.getBeansOfType(BaseConverter.class);
//        converters.forEach((name, converter) -> registerConverter(getGenericType(converter), converter));
//    }
//
//    // Generic method to register a converter
//    public <T> void registerConverter(Class<T> entityType, BaseConverter<T> converter) {
//        if (entityType != null) {
//            converterRegistry.put(entityType, converter);
//        }
//    }
//
//    // Generic method to get a converter by entity class
//    @SuppressWarnings("unchecked")
//    public <T> BaseConverter<T> getConverter(Class<T> entityType) {
//        return (BaseConverter<T>) converterRegistry.get(entityType);
//    }
//
//    // Extracts the generic type (e.g., CountryMaster, AddressMaster, etc.) from BaseConverter<T>
//    private Class<?> getGenericType(BaseConverter<?> converter) {
//        return converter.getClass().getGenericSuperclass() instanceof java.lang.reflect.ParameterizedType
//                ? (Class<?>) ((java.lang.reflect.ParameterizedType) converter.getClass().getGenericSuperclass()).getActualTypeArguments()[0]
//                : null;
//    }
//    private final Map<String, BaseConverter<?>> converterRegistry = new HashMap<>();
//
//
//    //need to add
//    public ConverterFactory(CountaryConvertor countryConverter) {
//        registerConverter("CountryConverter", countryConverter);
//        registerConverter("CountryConverter", countryConverter);
//    }
//
//    public void registerConverter(String key, BaseConverter<?> converter) {
//        converterRegistry.put(key, converter);
//    }
//
//    @SuppressWarnings("unchecked")
//    public <T> BaseConverter<T> getConverter(String key) {
//        return (BaseConverter<T>) converterRegistry.get(key);
//    }
}
