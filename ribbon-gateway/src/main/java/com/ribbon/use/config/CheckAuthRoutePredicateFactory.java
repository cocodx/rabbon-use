package com.ribbon.use.config;

import org.springframework.cloud.gateway.handler.predicate.AbstractRoutePredicateFactory;
import org.springframework.cloud.gateway.handler.predicate.GatewayPredicate;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;
@Component
public class CheckAuthRoutePredicateFactory extends AbstractRoutePredicateFactory<CheckAuthRoutePredicateFactory.Config> {
    public CheckAuthRoutePredicateFactory() {
        super(Config.class  );
    }

    @Override
    public List<String> shortcutFieldOrder() {
        return Collections.singletonList("name");
    }

    @Override
    public Predicate<ServerWebExchange> apply(Config config) {
        return new GatewayPredicate() {
            @Override
            public boolean test(ServerWebExchange serverWebExchange) {
//                if (config.getName().equals("fox")){
//                    return true;
//                }else{
//                    return false;
//                }
                ServerHttpRequest request =  serverWebExchange.getRequest();
                System.out.println(request.getQueryParams().get("name").toString());
                if (request.getQueryParams().get("name").get(0).equals("fox")){
                    return true;
                }else {
                    return false;
                }
            }
        };
    }

    public static class Config{
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
