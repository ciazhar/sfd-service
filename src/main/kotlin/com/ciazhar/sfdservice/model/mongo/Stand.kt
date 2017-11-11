package com.ciazhar.sfdservice.model.mongo

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import javax.validation.constraints.NotEmpty

/**
 * Created by ciazhar on 11/11/17.
 *
 * [ Documentation Here ]
 */

@Document
data class Stand(
    @Id
    var id : String?=null,

    @field:NotEmpty
    var standName : String?=null,

    var lowestScore : Int?=null,
    var normalScore : Int?=null,
    var highestScore : Int?=null
)