package com.lognext.inditex;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.web.util.UriComponentsBuilder;

import com.lognext.inditex.dto.PriceDTO;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class InditexApplicationTests {

	@LocalServerPort
	private int port;

	@Autowired
	private TestRestTemplate restTemplate;

	private static final String PRODUCT_ID = "35455";
	private static final String BRAND_ID = "1";

	@Test
	public void priceApiShouldReturnCorrectValuesForThe14thAt10() throws Exception {
		String url = "http://localhost:" + port + "/products/" + PRODUCT_ID + "/price";
		UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(url).queryParam("brandId", BRAND_ID)
				.queryParam("priceApplicationDate", "2020-06-14 10:00:00");

		String priceExpected = "35.5 EUR";
		String ulrDecoded = URLDecoder.decode(builder.toUriString(), StandardCharsets.UTF_8.toString());
		PriceDTO priceDTO = restTemplate.getForObject(ulrDecoded, PriceDTO.class);
		assertNotNull(priceDTO);
		assertEquals(priceExpected, priceDTO.getPrice());

	}

	@Test
	public void priceApiShouldReturnCorrectValuesForThe14thAt16() throws Exception {
		String url = "http://localhost:" + port + "/products/" + PRODUCT_ID + "/price";
		UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(url).queryParam("brandId", BRAND_ID)
				.queryParam("priceApplicationDate", "2020-06-14 16:00:00");

		String priceExpected = "25.45 EUR";
		String ulrDecoded = URLDecoder.decode(builder.toUriString(), StandardCharsets.UTF_8.toString());
		PriceDTO priceDTO = restTemplate.getForObject(ulrDecoded, PriceDTO.class);
		assertNotNull(priceDTO);
		assertEquals(priceExpected, priceDTO.getPrice());

	}

	@Test
	public void priceApiShouldReturnCorrectValuesForThe14thAt21() throws Exception {
		String url = "http://localhost:" + port + "/products/" + PRODUCT_ID + "/price";
		UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(url).queryParam("brandId", BRAND_ID)
				.queryParam("priceApplicationDate", "2020-06-14 21:00:00");

		String priceExpected = "35.5 EUR";
		String ulrDecoded = URLDecoder.decode(builder.toUriString(), StandardCharsets.UTF_8.toString());
		PriceDTO priceDTO = restTemplate.getForObject(ulrDecoded, PriceDTO.class);
		assertNotNull(priceDTO);
		assertEquals(priceExpected, priceDTO.getPrice());

	}

	@Test
	public void priceApiShouldReturnCorrectValuesForThe15thAt10() throws Exception {
		String url = "http://localhost:" + port + "/products/" + PRODUCT_ID + "/price";
		UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(url).queryParam("brandId", BRAND_ID)
				.queryParam("priceApplicationDate", "2020-06-15 10:00:00");

		String priceExpected = "30.5 EUR";
		String ulrDecoded = URLDecoder.decode(builder.toUriString(), StandardCharsets.UTF_8.toString());
		PriceDTO priceDTO = restTemplate.getForObject(ulrDecoded, PriceDTO.class);
		assertNotNull(priceDTO);
		assertEquals(priceExpected, priceDTO.getPrice());

	}

	@Test
	public void priceApiShouldReturnCorrectValuesForThe16thAt21() throws Exception {
		String url = "http://localhost:" + port + "/products/" + PRODUCT_ID + "/price";
		UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(url).queryParam("brandId", BRAND_ID)
				.queryParam("priceApplicationDate", "2020-06-16 21:00:00");

		String priceExpected = "38.95 EUR";
		String ulrDecoded = URLDecoder.decode(builder.toUriString(), StandardCharsets.UTF_8.toString());
		PriceDTO priceDTO = restTemplate.getForObject(ulrDecoded, PriceDTO.class);
		assertNotNull(priceDTO);
		assertEquals(priceExpected, priceDTO.getPrice());

	}

}
