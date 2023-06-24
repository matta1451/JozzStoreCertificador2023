package com.app.jozzstore.models.repositories.seguridad;

import com.app.jozzstore.models.DAO.seguridad.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}