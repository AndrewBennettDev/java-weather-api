package com.example.weatherappapi;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
public class WeatherAppApiApplication {

  public static void main(String[] args) throws IOException, InterruptedException {
    SpringApplication.run(WeatherAppApiApplication.class, args);

//    HttpRequest request = HttpRequest.newBuilder()
//        .uri(URI.create("https://weatherapi-com.p.rapidapi.com/current.json?q=30276"))
//        .header("X-RapidAPI-Key", "d403938b14mshe8d8263d5d95dfbp1d81b4jsn9b37fb36178f")
//        .header("X-RapidAPI-Host", "weatherapi-com.p.rapidapi.com")
//        .method("GET", HttpRequest.BodyPublishers.noBody())
//        .build();
//    HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
//    log.info("Returning current weather");
//    log.info(response.body());
  }

}
