package com.company.priceservice.infrastructure.adapters.api.models;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
@Builder
public class ErrorMessage {

  private String message;
  private HttpStatus status;

}
