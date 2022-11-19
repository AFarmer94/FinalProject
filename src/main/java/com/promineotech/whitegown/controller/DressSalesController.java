package com.promineotech.whitegown.controller;

import java.util.List;

import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.promineotech.whitegown.entity.Color;
import com.promineotech.whitegown.entity.Designer;
import com.promineotech.whitegown.entity.Dresses;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.servers.Server;

@Validated
@RequestMapping("/dresses")
@OpenAPIDefinition(info = @Info(title = "Dress Sales Service"), servers = {
		@Server(url = "http://localhost:8080", description = "Local server.") })

public interface DressSalesController {

	//@formatter:off
		@Operation(
			summary = "Returns a list of Dresses",
			description = "Returns a list of Dresses given an optional Designer and/or color",
			responses = {
				@ApiResponse(
						responseCode = "200", 
						description = "A list of Dresses is returned.", 
						content = @Content(mediaType = "application/json", 
						schema = @Schema(implementation = Dresses.class))),
				@ApiResponse(
						responseCode = "400", 
						description = "The request parameters are invalid.", 
						content = @Content(mediaType = "application/json")),
				@ApiResponse(
						responseCode = "404", 
						description = "No Dresses were found with the input criteria", 
						content = @Content(mediaType = "application/json")),
				@ApiResponse(
						responseCode = "500", 
						description = "An unplanned error occurred.", 
						content = @Content(mediaType = "application/json"))
			}
		)

		
		@GetMapping
		@ResponseStatus(code = HttpStatus.OK)
		List<Dresses> fetchDresses(
				@RequestParam(
						required = false) Color color, 
				@Pattern(regexp = "[\\w\\s]*")
				@RequestParam(
						required = false) Designer designer);
		//@formatter:on


		List<Dresses> fetchDresses(Designer designer, Color color);
}
