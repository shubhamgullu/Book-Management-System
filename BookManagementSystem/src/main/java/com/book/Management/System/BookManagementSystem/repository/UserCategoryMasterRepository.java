package com.book.Management.System.BookManagementSystem.repository;

import com.book.Management.System.BookManagementSystem.entity.UserCategoryMaster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserCategoryMasterRepository extends JpaRepository<UserCategoryMaster, Long> {

//
//    @Modifying
//    @Query("UPDATE LrRepNumberTypeDetails rtdn set rtdn.repNumberTypeDetailStatus = :repNumberTypeDetailStatus, rtdn.primaryRep = :primaryRep, " +
//            "rtdn.updatedBy =:userId, rtdn.updatedOn = :updatedOn, rtdn.sectionId = :sectionId, rtdn.screenId = :screenId " +
//            "where rtdn.repNumber.id = :repNumberId  and (rtdn.repNumberTypeDetailStatus=true OR rtdn.repNumberTypeDetailStatus IS NULL) " +
//            "and rtdn.repProfile.repProfileId <> :repProfileId")
//    int deleteRepsOfRepNumberExceptGiven(@Param("repNumberTypeDetailStatus") Boolean repNumberTypeDetailStatus, @Param("primaryRep") Boolean primaryRep,
//                                         @Param("userId") Long userId, @Param("updatedOn") Date updatedOn, @Param("sectionId") Long sectionId,
//                                         @Param("screenId") Long screenId, @Param("repNumberId") Long repNumberId, @Param("repProfileId") Long repProfileId);
}
