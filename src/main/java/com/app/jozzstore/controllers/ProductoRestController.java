package com.app.jozzstore.controllers;

import com.app.jozzstore.models.DTO.ProductoDTO;
import com.app.jozzstore.services.interfaces.IProductoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/producto")
public class ProductoRestController {

    private final IProductoService productoService;

    public ProductoRestController(IProductoService productoService) {
        this.productoService = productoService;
    }

    @GetMapping("/lista")
    public ResponseEntity<List<ProductoDTO>> findAll() {
        return ResponseEntity.ok(productoService.findAll());
    }
}
