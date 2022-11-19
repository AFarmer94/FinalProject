package com.promineotech.whitegown.service;

import java.util.List;

import com.promineotech.whitegown.entity.Color;
import com.promineotech.whitegown.entity.Designer;
import com.promineotech.whitegown.entity.Dresses;



public interface DressSalesService {

	List<Dresses> fetchDresses(Designer designer, Color color);

}
