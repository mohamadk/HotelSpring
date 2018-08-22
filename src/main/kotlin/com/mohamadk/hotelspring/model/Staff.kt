package com.mohamadk.hotelspring.model

import javax.persistence.*
import javax.validation.constraints.NotNull
import javax.validation.constraints.Size

@Entity
@Table(name = "Staffs")
data class Staff(
        @Column(name = "USERNAME", length = 50, unique = true)
        @NotNull
        @Size(min = 4, max = 50)
        val userName: String = "username"
        ,
        @NotNull
        @Column(name = "PASSWORD")
        @Size(min = 4, max = 50)
        val password: String? = null
        ,
        @Size(max = 50)
        val firstName: String? = null
        ,
        @Size(max = 50)
        val lastName: String? = null

        ,
        @Size(max = 50)
        val role: String? = null


) {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "staff_seq")
    @SequenceGenerator(name = "staff_seq", sequenceName = "staff_seq", allocationSize = 1)
    var id: Long = 0

}