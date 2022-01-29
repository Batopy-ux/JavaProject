package com.ba.zuul.api.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.web.server.ServerWebExchange;

import reactor.core.publisher.Mono;

public class LoggingGlobalPreFilter implements GlobalFilter{
	
	   final Logger logger =
			      LoggerFactory.getLogger(LoggingGlobalPreFilter.class);

			    @Override
			    public Mono<Void> filter(
			      ServerWebExchange exchange,
			      GatewayFilterChain chain) {
			        logger.info("Global Pre Filter executed");
			        return chain.filter(exchange);
			    }

}
