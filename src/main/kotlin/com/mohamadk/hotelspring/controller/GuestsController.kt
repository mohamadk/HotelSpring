package com.mohamadk.hotelspring.controller

import com.mohamadk.hotelspring.model.Guest
import com.mohamadk.hotelspring.repository.GuestRepository
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.PageRequest
import org.springframework.data.util.Streamable
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestHeader
import org.springframework.web.bind.annotation.RestController
import java.util.*

@RestController
class GuestsController {

    val logger = LoggerFactory.getLogger(GuestsController::class.java)

    @Autowired
    lateinit var guestRepository: GuestRepository

    @GetMapping("/rest/guests")
    fun guests(
            @RequestHeader(name = "pageSize", required = false) pageSize: Int = 1000
            , @RequestHeader(name = "page", required = false) page: Int = 0
            , @RequestHeader(name = "fromDate", required = false) fromDate: Long? = null
            , @RequestHeader(name = "toDate", required = false) toDate: Long? = null
    ): Streamable<Guest> {
        logger.debug("guests pageSize=$pageSize page=$page fromDate=${Date(fromDate?:0)} toDate=${Date(toDate?:0)}")
        return if (fromDate == null) {
            guestRepository.findAll(PageRequest.of(page, pageSize))
        } else {
            val endPeriod = toDate ?: Date().time
            guestRepository.findInPeriod(Date(fromDate), Date(endPeriod), PageRequest.of(page, pageSize))
        }
    }


}