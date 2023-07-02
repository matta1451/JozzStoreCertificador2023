package com.app.jozzstore.services.interfaces;

import com.app.jozzstore.models.DTO.ProductoDTO;

import java.util.List;

public interface IProductoService {
    List<ProductoDTO> findAll();
}
