package com.solidcode.order.repository.entity;

import static jakarta.persistence.GenerationType.IDENTITY;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name = "products")
public class Product {

  @Id
  @GeneratedValue(strategy = IDENTITY)
  private long id;

  @Column(name = "product_key", nullable = false)
  private String productKey;

  @ManyToOne
  @JoinColumn(name = "order_key", referencedColumnName = "order_key")
  private Order order;
}
