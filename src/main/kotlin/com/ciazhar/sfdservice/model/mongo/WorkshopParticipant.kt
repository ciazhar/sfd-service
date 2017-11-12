package com.ciazhar.sfdservice.model.mongo

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.index.Indexed
import org.springframework.data.mongodb.core.mapping.Document
import java.util.*
import javax.validation.constraints.Email
import javax.validation.constraints.NotEmpty

/**
 * Created by ciazhar on 11/12/17.
 *
 * [ Documentation Here ]
 */
@Document
data class WorkshopParticipant(
    @Id
    var id : String?=null,

    @field:NotEmpty
    var firstName : String?=null,

    @field:NotEmpty
    var lastName : String?=null,

    @field:NotEmpty
    @field:Indexed(unique = true)
    var username : String?=null,

    @field:NotEmpty
    @field:Email
    var email : String?=null,

    @field:NotEmpty
    var phoneNumber : String?=null,

    var created : Date?= Date()
)