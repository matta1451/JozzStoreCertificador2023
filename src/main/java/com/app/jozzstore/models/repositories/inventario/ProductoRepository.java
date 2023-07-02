package com.app.jozzstore.models.repositories.inventario;

import com.app.jozzstore.models.DAO.inventario.Producto;
import com.app.jozzstore.models.DTO.ProductoDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductoRepository extends JpaRepository<Producto, Long> {
}