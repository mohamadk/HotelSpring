package com.mohamadk.hotelspring.controller

import com.mohamadk.hotelspring.model.Guest
import com.mohamadk.hotelspring.repository.GuestRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class CheckInController {

    @Autowired
    lateinit var guestRepository: GuestRepository

    @PostMapping("/checkIn")
    fun checkIn(@RequestBody guest: Guest): Boolean {
        try {
            guestRepository.save(guest)
            return true
        } catch (e: Exception) {
            e.printStackTrace()
            return false
        }
    }


}
