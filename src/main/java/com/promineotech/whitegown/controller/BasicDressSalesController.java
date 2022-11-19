package com.promineotech.whitegown.controller;


import java.util.List;

import javax.validation.constraints.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.promineotech.whitegown.entity.Color;
import com.promineotech.whitegown.entity.Designer;
import com.promineotech.whitegown.entity.Dresses;
import com.promineotech.whitegown.service.DressSalesService;

import lombok.extern.slf4j.Slf4j;


@RestController
@Slf4j
public class BasicDressSalesController implements DressSalesController {

	
	@Autowired
	private DressSalesService dressSalesService;
	
	@Override
	public List<Dresses> fetchDresses(Designer designer, Color color) {
		log.info("designer={}, color={}", designer, color);
		return dressSalesService.fetchDresses(designer, color);
	}

	@Override
	public List<Dresses> fetchDresses(Color color, @Pattern(regexp = "[\\w\\s]*") String trim) {
		// TODO Auto-generated method stub
		return null;
	}

}
