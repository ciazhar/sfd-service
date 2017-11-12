package com.ciazhar.sfdservice.model.request

import com.ciazhar.sfdservice.validation.FestivalParticipantMustExists

/**
 * Created by ciazhar on 11/12/17.
 *
 * [ Documentation Here ]
 */

data class DeleteFestivalParticipantForm(
    @FestivalParticipantMustExists
    var participantId : String?=null
)