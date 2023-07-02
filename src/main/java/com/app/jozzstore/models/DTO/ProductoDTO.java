package com.app.jozzstore.models.DTO;

import com.app.jozzstore.models.DAO.inventario.Categoria;
import com.app.jozzstore.models.DAO.recurso.EstadoTransaccion;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductoDTO {
    private Long idProducto;

    private Categoria categoria;

    private EstadoTransaccion estadoTransaccion;

    private String nombreProducto;

    private String marca;

    private int stock;

    private BigDecimal precio;

    private String descripcion;

    private byte[] imagen;
}
