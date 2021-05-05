package com.tony.backend.services;

import com.tony.backend.dto.SellerDTO;
import com.tony.backend.entities.Seller;
import com.tony.backend.repositories.SellerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SellerService {

    @Autowired
    private SellerRepository sellerRepository;

    public List<SellerDTO> findAll() {
        List<Seller> sellers = sellerRepository.findAll();
        return sellers.stream().map(e -> new SellerDTO(e)).collect(Collectors.toList());
    }
}
