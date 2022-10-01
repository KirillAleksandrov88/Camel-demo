package Org.Example;

import org.apache.camel.CamelContext;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestClass {
    private static final Logger log = LoggerFactory.getLogger(TestClass.class);

    public static void main(String[] args) throws Exception {



        CamelContext context = new DefaultCamelContext();
        context.addRoutes(new RouteBuilder() {
            public void configure() {
                log.info ("Hello, world!");
                from("file:data/outbox")
                        .to("file:src/main/java/Org.Example/TestClass?noop=true");
            }
        });
        context.start();
        Thread.sleep(15000);
        context.stop();
    }
}
