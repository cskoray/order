package com.solidcode.order.dto.request;

import com.solidcode.order.validator.ValidPaymentType;
import com.solidcode.order.validator.ValidUUID;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.util.List;
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
public class OrderRequest {

  @ValidUUID
  private String paymentToken;

  @ValidPaymentType
  private String paymentType;

  @NotNull
  @Size(min = 3, max = 35)
  private String merchantName;

  private List<ProductKey> productKeys;
}
