package com.solidcode.order.dto.request;

import com.solidcode.order.validator.ValidUUID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class ProductKey {

  @ValidUUID
  private String productKey;
}
