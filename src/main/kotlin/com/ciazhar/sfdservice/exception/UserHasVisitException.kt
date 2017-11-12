package com.ciazhar.sfdservice.exception

/**
 * Created by ciazhar on 11/12/17.
 *
 * [ Documentation Here ]
 */
class UserHasVisitException(message: String="User Has Visit This Stand Before", throwable: Throwable? = null) : Exception(message, throwable)