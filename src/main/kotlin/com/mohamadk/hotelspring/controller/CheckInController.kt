package com.mohamadk.hotelspring.controller

import com.mohamadk.hotelspring.model.Guest
import com.mohamadk.hotelspring.repository.GuestRepository
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class CheckInController {
    val logger = LoggerFactory.getLogger(CheckInController::class.java)
    @Autowired
    lateinit var guestRepository: GuestRepository

    @PostMapping("/checkIn")
    fun checkIn(@RequestBody guest: Guest): Boolean {

        try {
            guestRepository.save(guest)
            logger.debug("checkIn=true\nguest=$guest")
            return true
        } catch (e: Exception) {
            e.printStackTrace()
            logger.error("checkIn=false\nguest=$guest",e)
            return false
        }
    }


}
