package Org.Example;

import org.apache.camel.CamelContext;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;

public class Application {
    public static void main(String[] args) throws Exception {
        CamelContext context = new DefaultCamelContext();
        context.addRoutes(new RouteBuilder() {
            public void configure() {
                String sours = "file:Camel-file-input?noop=true";
                String destination = "file:Camel-file-output";
                from (sours).to(destination).log("Файл ${file:absolute.path} перемещается в директорию " + destination);

            }
        });
        context.start();
        Thread.sleep(10000);
        context.stop();

    }

}
