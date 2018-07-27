package com.shunya.payumoneywebhook;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.isEmptyString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ApplicationTest {

  @Autowired
  private MockMvc mockMvc;

  @Test
  public void shouldReturnDefaultMessage() throws Exception {
    //language=JSON
    String jsonString = "{\"split_info\":\"199764395\",\"customerName\":\"Amrit\",\"additionalCharges\":\"\",\"paymentMode\":\"UPI\",\"hash\":\"fbbd0ddc2f455a07d79bbe39ad8f6795d86c73b95963de008dd69c307b4c0c7d2ea56e2e4d28bd4e3761288c0fa4504193e9481ee8aef141b3bf2ff2a031b343\",\"status\":\"Success\",\"error_Message\":\"No Error\",\"paymentId\":\"199764395\",\"productInfo\":\"[{\\\"name\\\":\\\"ebook PDF - Cracking Java Interviews v3.4 by Munish Chandel\\\",\\\"description\\\":\\\"ebook PDF - Cracking Java Interviews v3.4 by Munish Chandel\\\",\\\"value\\\":\\\"250.00\\\",\\\"isRequired\\\":\\\"false\\\"},{\\\"name\\\":\\\"ebook PDF - Cracking Spring Microservices Interviews for Java Developers\\\",\\\"description\\\":\\\"ebook PDF - Cracking Spring Microservices Interviews for Java Developers\\\",\\\"value\\\":\\\"199.00\\\",\\\"isRequired\\\":\\\"false\\\"}]\",\"customerEmail\":\"amrita.agarwal85@gmail.com\",\"customerPhone\":\"8826170763\",\"merchantTransactionId\":\"SB2018071105101\",\"amount\":\"449.0\",\"udf2\":\"SB2018071105101\",\"notificationId\":\"9426220\",\"udf1\":\"\",\"udf5\":\"\",\"udf4\":\"\",\"udf3\":\"\"}";

    this.mockMvc.perform(post("/payumoney/success-webhook").content(jsonString))
            .andDo(print()).andExpect(status().isOk())
            .andExpect(content().string(isEmptyString()));
  }
}