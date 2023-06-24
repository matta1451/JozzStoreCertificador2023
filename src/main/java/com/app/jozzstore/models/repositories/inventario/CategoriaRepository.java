package com.app.jozzstore.models.repositories.inventario;

import com.app.jozzstore.models.DAO.inventario.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria, Integer> {
}