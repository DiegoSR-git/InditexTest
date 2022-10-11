package com.lognext.inditex.repository;

import java.sql.Timestamp;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.lognext.inditex.model.Price;

@Repository
public interface PriceRepository extends JpaRepository<Price, Long> {

	@Query(value = "select p.* from prices p " + "where p.product_id=:productId " + "and p.brand_id=:brandId "
			+ "and :priceApplicationDate BETWEEN p.start_date and p.end_date "
			+ "and p.priority = (select MAX(p2.priority) from prices p2 where p.product_id=p2.product_id and p.brand_id=p2.brand_id "
			+ "and :priceApplicationDate BETWEEN p2.start_date and p2.end_date )", nativeQuery = true)
	Optional<Price> getPriceFromProduct(@Param("priceApplicationDate") Timestamp priceApplicationDate,
			@Param("productId") Integer productId, @Param("brandId") Integer brandId);

}
