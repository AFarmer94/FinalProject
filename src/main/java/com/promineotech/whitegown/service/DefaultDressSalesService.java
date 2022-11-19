package com.promineotech.whitegown.service;


import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.promineotech.whitegown.dao.DressSalesDao;
import com.promineotech.whitegown.entity.Color;
import com.promineotech.whitegown.entity.Designer;
import com.promineotech.whitegown.entity.Dresses;

import lombok.extern.slf4j.Slf4j;


@Service
@Slf4j
public class DefaultDressSalesService implements DressSalesService {

	@Autowired
	private DressSalesDao dressSalesDao;
	
	@Override
	public List<Dresses> fetchDresses(Designer designer, Color color) {
		
		log.info("The fetchDresses method was called with Designer={} and color={}", designer, color);
		
		List<Dresses> dresses = dressSalesDao.fetchDresses(designer, color);
		
		if(dresses.isEmpty()) {
			String msg = String.format("No jeeps found with Designer=%s and color=%s", designer, color);
			
			throw new NoSuchElementException(msg);
		}
		return dresses;
	}

}
