package com.app.jozzstore.services.impl;

import com.app.jozzstore.mapper.IProductoMapper;
import com.app.jozzstore.models.DAO.inventario.Producto;
import com.app.jozzstore.models.DTO.ProductoDTO;
import com.app.jozzstore.models.repositories.inventario.ProductoRepository;
import com.app.jozzstore.services.interfaces.IProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service("ProductoService")
public class ProductoService implements IProductoService {

    private final IProductoMapper productoMapper;

    private final ProductoRepository productoRepository;

    @Autowired
    public ProductoService(ProductoRepository productoRepository, IProductoMapper productoMapper) {
        this.productoRepository = productoRepository;
        this.productoMapper = productoMapper;
    }

    @Transactional(readOnly = true)
    @Override
    public List<ProductoDTO> findAll() {
        List<Producto> productos = productoRepository.findAll();
        return productos.stream().map(productoMapper::productoToProductoDTO).collect(Collectors.toList());
    }
}
