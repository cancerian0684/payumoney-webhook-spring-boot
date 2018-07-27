package com.shunya.payumoneywebhook;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class PayuMoneyService {
  private static final Logger logger = LoggerFactory.getLogger(PayuMoneyService.class);

  public void process(String merchantTransactionId, PayuPayload payload) {
    logger.info("merchantId {}, payload {}", merchantTransactionId, payload);
    //TODO: Process payment data and mark order as complete
  }
}
