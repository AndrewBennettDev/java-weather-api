package com.example.weatherappapi.models;

import lombok.Data;

@Data
public class GatewayRequest {

  private String uri;
  private String key;
  private String host;
}
