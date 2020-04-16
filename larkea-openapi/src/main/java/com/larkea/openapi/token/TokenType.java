package com.larkea.openapi.token;

import lombok.Getter;

@Getter
public enum TokenType {
  Bearer(1, "Bearer"),
  Basic(2, "Basic"),
  ;

  Integer value;

  String description;

  TokenType(Integer value, String description) {
    this.value = value;
    this.description = description;
  }
}
