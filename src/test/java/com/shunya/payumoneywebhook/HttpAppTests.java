package com.shunya.payumoneywebhook;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class HttpAppTests {

	@Test
	public void contextLoads() {

	}

	@LocalServerPort
	private int port;

	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	public void testPayumoneyWebHook() {
		//language=JSON
		String jsonString = "{\"split_info\":\"199764395\",\"customerName\":\"Amrit\",\"additionalCharges\":\"\",\"paymentMode\":\"UPI\",\"hash\":\"fbbd0ddc2f455a07d79bbe39ad8f6795d86c73b95963de008dd69c307b4c0c7d2ea56e2e4d28bd4e3761288c0fa4504193e9481ee8aef141b3bf2ff2a031b343\",\"status\":\"Success\",\"error_Message\":\"No Error\",\"paymentId\":\"199764395\",\"productInfo\":\"[{\\\"name\\\":\\\"ebook PDF - Cracking Java Interviews v3.4 by Munish Chandel\\\",\\\"description\\\":\\\"ebook PDF - Cracking Java Interviews v3.4 by Munish Chandel\\\",\\\"value\\\":\\\"250.00\\\",\\\"isRequired\\\":\\\"false\\\"},{\\\"name\\\":\\\"ebook PDF - Cracking Spring Microservices Interviews for Java Developers\\\",\\\"description\\\":\\\"ebook PDF - Cracking Spring Microservices Interviews for Java Developers\\\",\\\"value\\\":\\\"199.00\\\",\\\"isRequired\\\":\\\"false\\\"}]\",\"customerEmail\":\"amrita.agarwal85@gmail.com\",\"customerPhone\":\"8826170763\",\"merchantTransactionId\":\"SB2018071105101\",\"amount\":\"449.0\",\"udf2\":\"SB2018071105101\",\"notificationId\":\"9426220\",\"udf1\":\"\",\"udf5\":\"\",\"udf4\":\"\",\"udf3\":\"\"}";

		HttpHeaders headers = new HttpHeaders();
		HttpEntity<String> entity = new HttpEntity<>(jsonString, headers);

		assertThat(this.restTemplate.exchange("http://localhost:" + port + "/payumoney/success-webhook", HttpMethod.POST, entity, Void.class).getStatusCode()).isEqualByComparingTo(HttpStatus.OK);
	}

}
