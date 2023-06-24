package com.app.jozzstore.models.repositories.compra;

import com.app.jozzstore.models.DAO.compra.DetalleCompra;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DetalleCompraRepository extends JpaRepository<DetalleCompra, Long> {
}