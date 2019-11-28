package com.example.demo4;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Import;

import com.example.demo4.config.Demo4Config;
import com.example.demo4.entity.Country;
import com.example.demo4.service.CountryService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Import(Demo4Config.class)
public class Demo4Application {

	@Autowired
	private CountryService countryService;

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(Demo4Application.class, args);
		Demo4Application application = context.getBean(Demo4Application.class);
		application.start();
		context.close();
	}

	private void start() {
		Country country = countryService.getByCode("FR");
		log.info("-> {}", country);
	}

	@PostConstruct
	private void init() {
		countryService.saveFromCsv("src/main/resources/countries.csv");
	}
}
