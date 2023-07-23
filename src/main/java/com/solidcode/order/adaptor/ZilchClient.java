package com.solidcode.order.adaptor;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import com.solidcode.order.dto.request.OrderRequest;
import com.solidcode.order.dto.response.PaymentResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient("ZILCH-PAY")
public interface ZilchClient {

  @PostMapping(value = "/v1/api/zilch/payment/pay", produces = APPLICATION_JSON_VALUE, consumes = APPLICATION_JSON_VALUE)
  PaymentResponse pay(OrderRequest request);
}
