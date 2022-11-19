package com.promineotech.whitegown;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.promineotech.ComponentScanMarker;

@SpringBootApplication(scanBasePackageClasses = { ComponentScanMarker.class })
public class DressSales {

	public static void main(String[] args) {
		SpringApplication.run(DressSales.class, args);
	}

}
