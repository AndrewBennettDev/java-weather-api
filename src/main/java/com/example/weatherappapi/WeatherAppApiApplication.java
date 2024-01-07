package com.example.weatherappapi;

import java.io.IOException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class WeatherAppApiApplication {

  public static void main(String[] args) throws IOException, InterruptedException {
    SpringApplication.run(WeatherAppApiApplication.class, args);
  }

}
