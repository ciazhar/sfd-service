package com.ciazhar.sfdservice.model.mongo

import com.ciazhar.sfdservice.model.Score
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.index.Indexed
import org.springframework.data.mongodb.core.mapping.Document
import java.util.*
import javax.validation.constraints.Email
import javax.validation.constraints.NotEmpty
import kotlin.collections.ArrayList

/**
 * Created by ciazhar on 11/11/17.
 *
 * [ Documentation Here ]
 */

@Document
data class FestivalUser(
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

    var created : Date?=Date(),

    var scoreList : MutableList<Score>?=ArrayList(),

    var score : Int?=0
)
