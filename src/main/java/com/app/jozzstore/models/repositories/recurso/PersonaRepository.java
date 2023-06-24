package com.app.jozzstore.models.repositories.recurso;

import com.app.jozzstore.models.DAO.recurso.Persona;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonaRepository extends JpaRepository<Persona, Long> {
}