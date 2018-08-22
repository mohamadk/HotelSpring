package com.mohamadk.hotelspring.controller

import com.mohamadk.hotelspring.exceptions.UserAlreadyExistException
import com.mohamadk.hotelspring.model.Staff
import com.mohamadk.hotelspring.repository.StaffRepository
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class StaffSignUpController {

    val logger = LoggerFactory.getLogger(StaffSignUpController::class.java)

    @Autowired
    lateinit var staffRepository: StaffRepository

    @PostMapping("/signUp")
    fun generate(@RequestBody staff: Staff): Boolean {
        logger.debug("staff=${staff}")
        try {
            staffRepository.save(staff)
            return true
        }catch (e: Exception){
            throw UserAlreadyExistException("user already exist!", e)
        }
    }

}