package com.ciazhar.sfdservice.model.request

import com.ciazhar.sfdservice.validation.StandMustExists

/**
 * Created by ciazhar on 11/12/17.
 *
 * [ Documentation Here ]
 */
data class DeleteStandForm(
    @StandMustExists
    var standId : String?=null
)