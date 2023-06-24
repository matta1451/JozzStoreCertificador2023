package com.app.jozzstore.models.repositories.venta;

import com.app.jozzstore.models.DAO.venta.DetalleVenta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DetalleVentaRepository extends JpaRepository<DetalleVenta, Long> {
}