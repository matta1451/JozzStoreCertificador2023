package com.app.jozzstore.models.DAO.venta;

import com.app.jozzstore.models.DAO.inventario.Producto;
import com.app.jozzstore.utils.MensajeriaValidacionUtil;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Table(name = "detalles_ventas")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DetalleVenta implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "iddetalleventa")
    private Long idDetalleVenta;

    @ManyToOne(targetEntity = CabeceraVenta.class)
    @JoinColumn(name = "idcabeceraventa", nullable = false)
    @NotNull(message = MensajeriaValidacionUtil.CAMPO_VACIO)
    private CabeceraVenta cabeceraVenta;

    @ManyToOne(targetEntity = Producto.class)
    @JoinColumn(name = "idproducto", nullable = false)
    @NotNull(message = MensajeriaValidacionUtil.CAMPO_VACIO)
    private Producto producto;

    @Column(name = "cantidad", nullable = false)
    @Min(value = 1, message = MensajeriaValidacionUtil.VALOR_ENTERO_MAYOR_QUE_CERO)
    private int cantidad;

    @Column(name = "precio", nullable = false, precision = 8, scale = 3, columnDefinition = "DECIMAL(8,3)")
    @NotNull(message = MensajeriaValidacionUtil.CAMPO_VACIO)
    @Min(value = 1, message = MensajeriaValidacionUtil.VALOR_ENTERO_MAYOR_QUE_CERO)
    private BigDecimal precio;
}
