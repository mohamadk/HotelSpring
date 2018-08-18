package com.mohamadk.hotelspring.model

import java.util.*
import javax.persistence.*
import javax.validation.constraints.NotNull
import javax.validation.constraints.Size

@Entity
@Table(name = "Guests")
data class Guest(
        @Id
        @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "guest_seq")
        @SequenceGenerator(name = "guest_seq", sequenceName = "guest_seq", allocationSize = 1)
        val id: Long = 0
        ,
        @Column(length = 50, unique = true)
        @NotNull
        @Size(min = 4, max = 50)
        val userName: String = "username"
        ,
        @Size(max = 50)
        val firstName: String? = null
        ,
        @Size(max = 50)
        val lastName: String? = null
        ,
        @Temporal(TemporalType.TIMESTAMP)
        @NotNull
        val date: Date = Date()
)