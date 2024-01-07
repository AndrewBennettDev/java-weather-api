package com.example.weatherappapi.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class IngestionService {

  public final Logger logger = LoggerFactory.getLogger(IngestionService.class);
  public final KafkaTemplate<String, String> kafkaTemplate;
  public final RestTemplate restTemplate;
  ObjectMapper objectMapper;

  private static final String BASE_URL = "https://weatherapi-com.p.rapidapi.com";

  @Autowired
  public IngestionService(KafkaTemplate<String, String> kafkaTemplate, RestTemplate restTemplate){
    this.kafkaTemplate = kafkaTemplate;
    this.restTemplate = restTemplate;
    this.objectMapper = new ObjectMapper();
  }

  public Object getWeather(int location) throws IOException, InterruptedException {
    HttpRequest request = HttpRequest.newBuilder()
        .uri(URI.create(BASE_URL + "/current.json?q=" + location))
        .header("X-RapidAPI-Key", "[secret_value]")
        .header("X-RapidAPI-Host", "weatherapi-com.p.rapidapi.com")
        .method("GET", HttpRequest.BodyPublishers.noBody())
        .build();
    HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
    return response.body();
  }

  public Object getAstronomy(int location) throws IOException, InterruptedException {
    HttpRequest request = HttpRequest.newBuilder()
        .uri(URI.create(BASE_URL + "/astronomy.json?q=" + location))
        .header("X-RapidAPI-Key", "[secret_value]")
        .header("X-RapidAPI-Host", "weatherapi-com.p.rapidapi.com")
        .build();
    HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
    return response.body();
  }
}
