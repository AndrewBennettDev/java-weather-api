package com.example.weatherappapi.controller;

import com.example.weatherappapi.services.IngestionService;
import java.io.IOException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class WeatherController {

  public IngestionService ingestionService;
  @Autowired
  public WeatherController(IngestionService ingestionService){
    this.ingestionService = ingestionService;
  }

  @GetMapping("/weather/{location}")
  public Object getCurrentWeather(@PathVariable int location) throws IOException, InterruptedException {
    log.info("Getting current weather for " + location);
    return ingestionService.getWeather(location);
  }

  @GetMapping("/astronomy/{location}")
  public Object getCurrentAstro(@PathVariable int location) throws IOException, InterruptedException {
    log.info("Getting astronomical data for " + location);
    return ingestionService.getAstronomy(location);
  }



}
