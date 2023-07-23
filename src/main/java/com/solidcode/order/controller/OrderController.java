package com.solidcode.order.controller;

import static org.springframework.http.HttpStatus.CREATED;

import com.solidcode.order.dto.request.OrderRequest;
import com.solidcode.order.dto.response.PaymentResponse;
import com.solidcode.order.service.OrderService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/v1/api/orders")
@Validated
public class OrderController {

  private OrderService orderService;

  @Autowired
  public OrderController(OrderService orderService) {
    this.orderService = orderService;
  }

  @PostMapping("/order")
  @ResponseStatus(CREATED)
  public PaymentResponse order(@Valid @RequestBody OrderRequest request) {

    log.info("OrderController: order {}", request.toString());
    return orderService.order(request);
  }
}
