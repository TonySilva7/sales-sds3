package com.tony.backend.repositories;

import com.tony.backend.dto.SaleSuccessDTO;
import com.tony.backend.dto.SaleSumDTO;
import com.tony.backend.entities.Sale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SaleRepository extends JpaRepository<Sale, Long> {

    @Query("SELECT new com.tony.backend.dto.SaleSumDTO(obj.seller, SUM(obj.amount)) "
            + "from Sale AS obj GROUP BY obj.seller")
    List<SaleSumDTO> amountGroupedBySeller();

    @Query("SELECT new com.tony.backend.dto.SaleSuccessDTO(obj.seller, SUM(obj.visited), SUM(obj.deals)) "
            + "from Sale AS obj GROUP BY obj.seller")
    List<SaleSuccessDTO> successGroupedBySeller();
}
