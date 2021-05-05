package com.tony.backend.services;

import com.tony.backend.dto.SaleDTO;
import com.tony.backend.entities.Sale;
import com.tony.backend.repositories.SaleRepository;
import com.tony.backend.repositories.SellerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class SaleService {

    @Autowired
    private SaleRepository saleRepository;
    @Autowired
    private SellerRepository sellerRepository;

    @Transactional(readOnly = true)
    public Page<SaleDTO> findAll(Pageable pageable) {
        sellerRepository.findAll();
        Page<Sale> sales = saleRepository.findAll(pageable);
        return sales.map(e -> new SaleDTO(e));
    }
}
