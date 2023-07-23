package com.solidcode.order.service;

import com.solidcode.order.adaptor.UserClient;
import com.solidcode.order.adaptor.ZilchClient;
import com.solidcode.order.adaptor.request.CreditLimitRequest;
import com.solidcode.order.dto.request.OrderRequest;
import com.solidcode.order.dto.response.PaymentResponse;
import com.solidcode.order.repository.OrderRepository;
import com.solidcode.order.repository.ProductRepository;
import com.solidcode.order.repository.entity.Order;
import com.solidcode.order.repository.entity.Product;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RefreshScope
public class OrderService {

  private OrderRepository orderRepository;
  private ProductRepository productRepository;
  private ZilchClient zilchClient;
  private UserClient userClient;

  @Autowired
  public OrderService(OrderRepository orderRepository, ProductRepository productRepository,
      ZilchClient zilchClient, UserClient userClient) {
    this.orderRepository = orderRepository;
    this.productRepository = productRepository;
    this.zilchClient = zilchClient;
    this.userClient = userClient;
  }

  public PaymentResponse order(OrderRequest request) {

    log.info("OrderService: order {}", request.toString());
    PaymentResponse paymentResponse = zilchClient.pay(request);

    Order order = Order.builder()
        .orderKey(UUID.randomUUID().toString())
        .paymentToken(request.getPaymentToken())
        .paymentType(request.getPaymentType())
        .build();
    List<Product> products = request.getProductKeys().stream()
        .map(product -> Product.builder()
            .productKey(product.getProductKey())
            .order(order)
            .build()).collect(Collectors.toList());
    orderRepository.save(order);
    productRepository.saveAll(products);
    CreditLimitRequest creditLimitRequest = CreditLimitRequest.builder()
        .paymentToken(request.getPaymentToken())
        .amount(paymentResponse.getCashback())
        .build();
    userClient.updateCreditLimit(creditLimitRequest);
    return paymentResponse;
  }
}
