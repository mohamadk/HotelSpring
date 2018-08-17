package com.mohamadk.hotelspring.repository

import com.mohamadk.hotelspring.model.Guest
import com.mohamadk.hotelspring.model.Guest.Companion.CHECK_IN_DATE_COLUMN
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface GuestRepository : JpaRepository<Guest, Long> {

    @Query("select * from Guests g where g.$CHECK_IN_DATE_COLUMN>=:fromDate and g.$CHECK_IN_DATE_COLUMN<=:toDate ", nativeQuery = true)
    fun findInPeriod(
            @Param("fromDate") fromDate: Date
            , @Param("toDate") toDate: Date
            , pageRequest: Pageable
    ): Page<Guest>

}