package com.mohamadk.hotelspring.controller

import com.mohamadk.hotelspring.repository.GuestRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import java.util.*

@RestController
class CheckOutController {

    @Autowired
    lateinit var guestRepository: GuestRepository

    @PostMapping("/rest/checkOut/{userId}",consumes = arrayOf(MediaType.APPLICATION_FORM_URLENCODED_VALUE))
    fun checkOut(@PathVariable("userId")userId: Long): Boolean {

        try {
            val guest=guestRepository.findById(userId).get()
            guest.checkOutDate= Date()

            guestRepository.save(guest)

            return true
        }catch (e:Exception){
            e.printStackTrace()
            return false
        }
    }


}