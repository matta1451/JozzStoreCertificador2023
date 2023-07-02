package com.app.jozzstore.models.DAO.inventario;

import com.app.jozzstore.models.DAO.compra.DetalleCompra;
import com.app.jozzstore.models.DAO.recurso.EstadoTransaccion;
import com.app.jozzstore.models.DAO.venta.DetalleVenta;
import com.app.jozzstore.utils.MensajeriaValidacionUtil;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "productos")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Producto implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idproducto")
    private Long idProducto;

    @ManyToOne(targetEntity = Categoria.class, fetch = FetchType.EAGER)
    @JoinColumn(name = "idcategoria", nullable = false)
    @NotNull(message = MensajeriaValidacionUtil.CAMPO_VACIO)
    private Categoria categoria;

    @ManyToOne(targetEntity = EstadoTransaccion.class)
    @JoinColumn(name = "idestado", nullable = false)
    @NotNull(message = MensajeriaValidacionUtil.CAMPO_VACIO)
    private EstadoTransaccion estadoTransaccion;

    @Column(name = "nombreproducto", nullable = false, unique = true, length = 100)
    @Size(max = 100, message = MensajeriaValidacionUtil.LONGITUD_MAXIMA_SUPERADA)
    private String nombreProducto;

    @Column(name = "marca", nullable = false, length = 50)
    @Size(max = 50, message = MensajeriaValidacionUtil.LONGITUD_MAXIMA_SUPERADA)
    private String marca;

    @Column(name = "stock", nullable = false)
    @Min(value = 0, message = MensajeriaValidacionUtil.VALOR_ENTERO_MINIMO)
    private int stock;

    @Column(name = "precio", nullable = false, precision = 8, scale = 3, columnDefinition = "DECIMAL(8,3)")
    @Min(value = 0, message = MensajeriaValidacionUtil.VALOR_ENTERO_MINIMO)
    private BigDecimal precio;

    @Column(name = "descripcion", nullable = false, columnDefinition = "TEXT")
    @NotEmpty(message = MensajeriaValidacionUtil.CAMPO_VACIO)
    private String descripcion;

    @Lob
    @Column(name = "imagen", nullable = false, columnDefinition = "LONGBLOB")
    private byte[] imagen;
}
