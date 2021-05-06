package com.tony.backend.controllers;

import com.tony.backend.dto.SaleDTO;
import com.tony.backend.dto.SaleSuccessDTO;
import com.tony.backend.dto.SaleSumDTO;
import com.tony.backend.services.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/sales")
public class SaleController {

    @Autowired
    private SaleService saleService;

    @GetMapping
    public ResponseEntity<Page<SaleDTO>> findAll(Pageable pageable) {
        Page<SaleDTO> sellers = saleService.findAll(pageable);
        return ResponseEntity.ok(sellers);
    }

    @GetMapping(value = "/amount-by-seller")
    public ResponseEntity<List<SaleSumDTO>> amountGroupedBySeller() {
        List<SaleSumDTO> saleSum = saleService.amountGroupedBySeller();
        return ResponseEntity.ok(saleSum);
    }

    @GetMapping(value = "/success-by-seller")
    public ResponseEntity<List<SaleSuccessDTO>> successGroupedBySeller() {
        List<SaleSuccessDTO> saleSuccess = saleService.successGroupedBySeller();
        return ResponseEntity.ok(saleSuccess);
    }

}
