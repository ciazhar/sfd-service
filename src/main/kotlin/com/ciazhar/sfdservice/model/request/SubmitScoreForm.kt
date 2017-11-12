package com.ciazhar.sfdservice.model.request

import com.ciazhar.sfdservice.validation.StandMustExists
import com.ciazhar.sfdservice.validation.FestivalParticipantMustExists

/**
 * Created by ciazhar on 11/12/17.
 *
 * [ Documentation Here ]
 */

data class SubmitScoreForm(
    @FestivalParticipantMustExists
    var userId : String?=null,
    @StandMustExists
    var standId : String?=null,
    var score : Int?=null
)