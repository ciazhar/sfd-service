package com.ciazhar.sfdservice.model.request

import com.ciazhar.sfdservice.validation.WorkshopParticipantMustExists

/**
 * Created by ciazhar on 11/12/17.
 *
 * [ Documentation Here ]
 */
data class DeleteWorkshopParticipantForm(
    @WorkshopParticipantMustExists
    var participantId : String?=null
)