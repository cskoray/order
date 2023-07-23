package com.solidcode.order.repository.entity;

import static jakarta.persistence.FetchType.LAZY;
import static jakarta.persistence.GenerationType.IDENTITY;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.ToString.Exclude;

@Entity
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name = "orders")
public class Order {

  @Id
  @GeneratedValue(strategy = IDENTITY)
  private long id;

  @Column(name = "order_key", nullable = false)
  private String orderKey;

  @Column(name = "payment_token", nullable = false)
  private String paymentToken;

  @Column(name = "payment_type", nullable = false)
  private String paymentType;

  @Exclude
  @OneToMany(mappedBy = "order", fetch = LAZY)
  private List<Product> products;
}
