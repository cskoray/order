package com.solidcode.order.adaptor;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import com.solidcode.order.adaptor.request.CreditLimitRequest;
import com.solidcode.order.dto.response.PaymentResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

@FeignClient("API-USERS")
public interface UserClient {

  @PutMapping(value = "/v1/api/users/user/credit-limit", produces = APPLICATION_JSON_VALUE, consumes = APPLICATION_JSON_VALUE)
  PaymentResponse updateCreditLimit(CreditLimitRequest request);
}
