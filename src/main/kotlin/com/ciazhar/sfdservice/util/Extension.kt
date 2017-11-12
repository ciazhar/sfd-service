package com.ciazhar.sfdservice.util

import org.slf4j.Logger
import org.slf4j.LoggerFactory

/**
 * Created by ciazhar on 11/12/17.
 *
 * [ Documentation Here ]
 */
fun <T> loggerFor(clazz: Class<T>): Logger = LoggerFactory.getLogger(clazz)