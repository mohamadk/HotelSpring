package com.mohamadk.hotelspring.model

import org.springframework.lang.Nullable
import java.util.*
import javax.persistence.*
import javax.validation.constraints.NotNull
import javax.validation.constraints.Size

@Entity
@Table(name = "Guests")
data class Guest(
        @Column(length = 50, unique = true)
        @NotNull
        @Size(min = 4, max = 50)
        val userName: String="username"
        ,
        @Size(max = 50)
        val firstName: String?=null
        ,
        @Size(max = 50)
        val lastName: String?=null
        ,
        @Temporal(TemporalType.TIMESTAMP)
        @NotNull
        @Column(name = CHECK_IN_DATE_COLUMN)
        val checkInDate: Date=Date(),
        @Temporal(TemporalType.TIMESTAMP)
        @Column(name = CHECK_OUT_DATE_COLUMN)
        @Nullable
        var checkOutDate: Date?=null

){

        @Id
        @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "guest_seq")
        @SequenceGenerator(name = "guest_seq", sequenceName = "guest_seq", allocationSize = 1)
        val id: Long=0

        companion object {
            const val CHECK_IN_DATE_COLUMN="CHECKINDATE"
            const val CHECK_OUT_DATE_COLUMN="CHECKOUTDATE"

        }
}