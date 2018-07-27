package com.shunya.payumoneywebhook;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.io.IOException;

@Controller
@RequestMapping(value = "/payumoney")
public class WebhookController {

  private static final Logger logger = LoggerFactory.getLogger(WebhookController.class);

  @Autowired
  private PayuMoneyService payuMoneyService;

  @Autowired
  private ObjectMapper customObjectMapper;

  @PostMapping(value = "/success-webhook")
  @ResponseStatus(HttpStatus.OK)
  public void handleWebhookSuccess(HttpEntity<String> httpEntity) throws IOException {
    final String payuResponseBody = httpEntity.getBody();
    logger.info("Dumping Payumoney webhook the parameters. - {} ", payuResponseBody);
    final PayuPayload payload = customObjectMapper.readValue(payuResponseBody, PayuPayload.class);
    payuMoneyService.process(payload.getMerchantTransactionId(), payload);
  }
}
