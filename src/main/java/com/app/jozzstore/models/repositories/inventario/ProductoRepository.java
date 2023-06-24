package com.app.jozzstore.models.repositories.inventario;

import com.app.jozzstore.models.DAO.inventario.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoRepository extends JpaRepository<Producto, Long> {
}