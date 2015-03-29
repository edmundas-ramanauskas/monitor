package com.marketplace.monitor.camel;

import org.apache.camel.CamelContext;
import org.apache.camel.CamelContextAware;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.beans.factory.InitializingBean;

/**
 *
 * @author edmundas
 */
public class AppRouteBuilder extends RouteBuilder implements InitializingBean, CamelContextAware {
    
    private CamelContext camelContext;
    private EventProducer eventProducer;

    public CamelContext getCamelContext() {
        return camelContext;
    }

    public void setCamelContext(CamelContext camelContext) {
        this.camelContext = camelContext;
        
    }
    
    public void setEventProducer(EventProducer eventProducer) {
        this.eventProducer = eventProducer;
    }

    public void afterPropertiesSet() throws Exception {
        if (camelContext != null) {
            camelContext.addRoutes(this);
        }
    }

    @Override
    public void configure() throws Exception {
        from("timer:taskEvents?period=15s").process(eventProducer)
                .to("activemq:queue:monitor.system.event.in");
    }

}