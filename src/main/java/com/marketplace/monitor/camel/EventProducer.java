package com.marketplace.monitor.camel;

import com.marketplace.monitor.jms.messages.EventMessage;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;

/**
 *
 * @author edmundas
 */
public class EventProducer implements Processor {

    @Override
    public void process(Exchange exchange) throws Exception {
        exchange.getIn().setBody(new EventMessage(EventMessage.EventType.INIT_MONITORING_TASK));
    }
}
