package com.tony.backend.dto;

import com.tony.backend.entities.Seller;

import java.io.Serializable;

public class SellerDTO implements Serializable {
    public static final long serialVersionUID = 1L;

    private Long id;
    private String name;

    public SellerDTO() {
    }

    public SellerDTO(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public SellerDTO(Seller seller) {
        id = seller.getId();
        name = seller.getName();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
