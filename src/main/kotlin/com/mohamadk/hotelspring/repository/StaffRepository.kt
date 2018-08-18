package com.mohamadk.hotelspring.repository

import com.mohamadk.hotelspring.model.Staff
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository

@Repository
interface StaffRepository : JpaRepository<Staff, Long> {

    @Query("select * from Staffs s where s.userName= :userName and s.password= :password", nativeQuery = true)
    fun findUser(@Param("userName") userName: String, @Param("password") password: String): Staff


}