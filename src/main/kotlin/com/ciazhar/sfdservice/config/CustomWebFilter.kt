package com.ciazhar.sfdservice.config

import org.springframework.stereotype.Component
import org.springframework.web.server.WebFilterChain
import org.springframework.web.server.ServerWebExchange
import reactor.core.publisher.Mono
import org.springframework.web.server.WebFilter



/**
 * Created by ciazhar on 11/12/17.
 *
 * [ Documentation Here ]
 */
@Component
class CustomWebFilter : WebFilter {
    override fun filter(exchange: ServerWebExchange, chain: WebFilterChain): Mono<Void> {
        return if (exchange.request.uri.path == "/") {
            chain.filter(exchange.mutate().request(exchange.request.mutate().path("/index.html").build()).build())
        } else chain.filter(exchange)

    }
}