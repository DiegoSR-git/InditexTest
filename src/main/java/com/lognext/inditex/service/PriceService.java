package com.lognext.inditex.service;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lognext.inditex.dto.PriceDTO;
import com.lognext.inditex.exceptions.ProductNotfoundException;
import com.lognext.inditex.model.Price;
import com.lognext.inditex.repository.PriceRepository;

@Service
public class PriceService {

	@Autowired
	PriceRepository priceRepository;

	public PriceDTO getPriceForProduct(String priceApplicationDate, Integer productId, Integer brandId) {
		PriceDTO priceDTO = new PriceDTO();
		Timestamp priceAppDate = Timestamp.valueOf(priceApplicationDate);

		Price price = priceRepository.getPriceFromProduct(priceAppDate, productId, brandId)
				.orElseThrow(() -> new ProductNotfoundException("Product with id " + productId + " not found"));

		if (price.getPrice() != null) {
			String priceStr = price.getPrice().toString() + " " + price.getCurr();
			priceDTO.setPrice(priceStr);
		}
		
		if (price.getEndDate() != null) {
			String endDate = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss").format(price.getEndDate());
			priceDTO.setEndDate(endDate);
		}
		
		if (price.getStartDate() != null) {
			String startDate = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss").format(price.getStartDate());
			priceDTO.setStartDate(startDate);
		}
		priceDTO.setBrandId(price.getBrandId());
		priceDTO.setProductId(price.getProductId());
		priceDTO.setPriceList(price.getPriceList());
		return priceDTO;
	}

}
