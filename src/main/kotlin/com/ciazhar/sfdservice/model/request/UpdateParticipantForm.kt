package com.ciazhar.sfdservice.model.request

import com.ciazhar.sfdservice.model.Score
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.index.Indexed
import java.util.*
import javax.validation.constraints.Email
import javax.validation.constraints.NotEmpty

/**
 * Created by ciazhar on 11/16/17.
 *
 * [ Documentation Here ]
 */
data class UpdateParticipantForm(
        @Id
        var id : String?=null,

        @field:NotEmpty
        var firstName : String?=null,

        @field:NotEmpty
        var lastName : String?=null,

        @field:NotEmpty
        @field:Email
        var email : String?=null,

        @field:NotEmpty
        var phoneNumber : String?=null
)
