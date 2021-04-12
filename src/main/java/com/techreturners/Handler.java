package com.techreturners;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.techreturners.model.Task;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class Handler implements RequestHandler<Map<String, Object>, ApiGatewayResponse> {

	private static final Logger LOG = LogManager.getLogger(Handler.class);

	@Override
	public ApiGatewayResponse handleRequest(Map<String, Object> input, Context context) {
		LOG.info("received: {}", input);

		Task t1 = new Task("abc123", "Pick up the newspapers", false);
		Task t2 = new Task("qbc456", "Enjoy java!", false);

		List<Task> tasks = new ArrayList<>();
		tasks.add(t1);
		tasks.add(t2);

		return ApiGatewayResponse.builder()
				.setStatusCode(200)
				.setObjectBody(tasks)
				.setHeaders(Collections.singletonMap("X-Powered-By", "AWS Lambda & serverless"))
				.build();
	}
}
