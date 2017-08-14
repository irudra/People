package com.rudra.transform.route;

import org.apache.camel.Exchange;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TransformationRouteBuilder extends RouteBuilder {

	@Override
	public void configure() throws Exception {
		from("direct:getEmployee").process(exchange -> {
			exchange.getOut().setHeader(Exchange.HTTP_METHOD, "GET");
		}).to("http4://localhost:8181/api/employee");

		from("direct:getEmployeeHobby").doTry().process(exchange -> {
			exchange.getOut().setHeader(Exchange.HTTP_METHOD, "POST");
			exchange.getOut().setBody(exchange.getIn().getBody());
			exchange.getOut().setHeader("Access-Control-Allow-Origin","null");
		}).to("http4://localhost:8182/api/hobby").endDoTry().doCatch(Exception.class).process(this::handleException);
	}

	private void handleException(Exchange exchange) {
		System.out.println("Exception in getting hobby data." + exchange.getException());
		exchange.getOut().setBody("dummy");
		return;
	}
}