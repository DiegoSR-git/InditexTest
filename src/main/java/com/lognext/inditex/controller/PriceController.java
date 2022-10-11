package com.lognext.inditex.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lognext.inditex.dto.PriceDTO;
import com.lognext.inditex.service.PriceService;

@RestController
@RequestMapping("/products")
public class PriceController {

	@Autowired
	PriceService priceService;

	@GetMapping("/{id}/price")
	public ResponseEntity<PriceDTO> getTutorialById(@PathVariable("id") Integer productId,
			@RequestParam("brandId") Integer brandId,
			@RequestParam("priceApplicationDate") String priceApplicationDate) {
		PriceDTO priceDTO = priceService.getPriceForProduct(priceApplicationDate, productId, brandId);
		return new ResponseEntity<>(priceDTO, HttpStatus.OK);
	}
}
