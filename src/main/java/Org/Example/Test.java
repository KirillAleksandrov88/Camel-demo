package Org.Example;

import org.apache.camel.CamelContext;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;
import org.apache.camel.util.Scanner;

public class Test {
    public static void main(String args[]) throws Exception {
        CamelContext context = new DefaultCamelContext();
        context.addRoutes(new RouteBuilder() {
            public void configure() {
                from("file:data/inbox?noop=true").to("file:data/outbox");
            }
        });
        context.start();
        System.out.println("Press enter to continue...");

        context.stop();
    }
}