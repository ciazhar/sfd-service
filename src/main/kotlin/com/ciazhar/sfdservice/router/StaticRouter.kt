package com.ciazhar.sfdservice.router

import org.springframework.context.annotation.Configuration
import org.springframework.core.io.ClassPathResource
import org.springframework.web.reactive.function.server.router

/**
 * Created by ciazhar on 11/12/17.
 *
 * [ Documentation Here ]
 */
@Configuration
internal class StaticRouter {

    companion object{
        private val ROUTE = "/**"
        private val PUBLIC = "static/"
    }

    fun doRoute() = router {
        resources(ROUTE, ClassPathResource(PUBLIC))
    }
}