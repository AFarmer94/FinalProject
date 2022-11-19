package com.promineotech.whitegown.dao;

import java.util.List;

import com.promineotech.whitegown.entity.Color;
import com.promineotech.whitegown.entity.Designer;
import com.promineotech.whitegown.entity.Dresses;

public interface DressSalesDao {

	List<Dresses> fetchDresses(Designer designer, Color color);
}
