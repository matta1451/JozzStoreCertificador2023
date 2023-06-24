package com.app.jozzstore.models.repositories.venta;

import com.app.jozzstore.models.DAO.venta.Delivery;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeliveryRepository extends JpaRepository<Delivery, Long> {
}