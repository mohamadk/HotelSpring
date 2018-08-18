package com.mohamadk.hotelspring.controller

import com.mohamadk.hotelspring.model.Staff
import com.mohamadk.hotelspring.repository.StaffRepository
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class StaffSignUpController {

    val logger = LoggerFactory.getLogger(HelloController::class.java)

    @Autowired
    lateinit var staffRepository: StaffRepository

    @PostMapping("/signUp")
    fun generate(@RequestBody staff: Staff): Boolean {
        logger.debug("staff=${staff}")

        staffRepository.save(staff)

        return true
    }

}