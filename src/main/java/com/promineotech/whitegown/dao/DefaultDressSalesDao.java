package com.promineotech.whitegown.dao;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.promineotech.whitegown.entity.Color;
import com.promineotech.whitegown.entity.Designer;
import com.promineotech.whitegown.entity.Dresses;

import lombok.extern.slf4j.Slf4j;


@Service
@Component
@Slf4j
public class DefaultDressSalesDao implements DressSalesDao {

	@Autowired
	private NamedParameterJdbcTemplate jdbcTemplate;
	
	@Override
	public List<Dresses> fetchDresses(Designer designer, Color color) {
		
			log.debug("DAO: designer={}, color={}", designer, color);
			
			//@formatter:off
			String sql = ""
				+ "SELECT * "
				+ "FROM dresses "
				+ "WHERE designer = :designer AND color = :color";
			//@formatter:on
			
			Map<String, Object> params = new HashMap<>();
			params.put("designer", designer.toString());
			params.put("color", color);		
			
			return jdbcTemplate.query(sql,  params, new RowMapper<>() {

				@Override
				public Dresses mapRow(ResultSet rs, int rowNum) throws SQLException {
					//@formatter:off
					return Dresses.builder()
							.price(new BigDecimal(rs.getString("price")))
							.color(Color.valueOf(rs.getString("color")))
							.build();
					//@formatter:on
				}
			});
		}
}

