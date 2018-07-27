package com.shunya.payumoneywebhook;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class PayuPayload {
    private String hash;
    @JsonProperty("merchantTransactionId")
    private String merchantTransactionId;
    private String paymentId;
    private String paymentMode;
    private String status;
    private String amount;
    @JsonProperty("error_Message")
    private String error_Message;
    private String customerName;
    private String customerEmail;
    private String customerPhone;

    private String notificationId;
    private String additionalCharges;
    private String productInfo;
    @JsonProperty("split_info")
    private String split_info;
    private String udf1;
    private String udf2;
    private String udf3;

    private String bankCode;
    private String netAmountDebit;
    private String bankRefNum;
    private String mihpayid;

}
