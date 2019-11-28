package com.example.demo4.service;

import java.util.List;

import com.example.demo4.entity.Country;

public interface CountryService {

	Country getByCode(String code);

	List<Country> saveFromCsv(String file);

}
