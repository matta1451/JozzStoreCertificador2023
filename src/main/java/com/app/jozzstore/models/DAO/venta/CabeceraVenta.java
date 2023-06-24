package com.app.jozzstore.models.DAO.venta;

import com.app.jozzstore.models.DAO.recurso.EstadoTransaccion;
import com.app.jozzstore.models.DAO.recurso.TipoPago;
import com.app.jozzstore.models.DAO.seguridad.Usuario;
import com.app.jozzstore.utils.MensajeriaValidacionUtil;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "cabeceras_ventas")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CabeceraVenta implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idcabeceraventa")
    private Integer idCabeceraVenta;

    @ManyToOne(targetEntity = EstadoTransaccion.class)
    @JoinColumn(name = "idestado", nullable = false)
    @NotNull(message = MensajeriaValidacionUtil.CAMPO_VACIO)
    private EstadoTransaccion estadoTransaccion;

    @ManyToOne(targetEntity = Usuario.class)
    @JoinColumn(name = "idusuario", nullable = false)
    @NotNull(message = MensajeriaValidacionUtil.CAMPO_VACIO)
    private Usuario usuario;

    @ManyToOne(targetEntity = Delivery.class)
    @JoinColumn(name = "iddelivery", nullable = false)
    @NotNull(message = MensajeriaValidacionUtil.CAMPO_VACIO)
    private Delivery delivery;

    @ManyToOne(targetEntity = TipoPago.class)
    @JoinColumn(name = "idtipopago", nullable = false)
    @NotNull(message = MensajeriaValidacionUtil.CAMPO_VACIO)
    private TipoPago tipoPago;

    @Column(name = "fecharegistro", nullable = false, insertable = false, updatable = false, columnDefinition = "TIMESTAMP")
    @NotNull(message = MensajeriaValidacionUtil.CAMPO_VACIO)
    private Date fechaRegistro;

    @Column(name = "fechamodificacion", nullable = false, insertable = false, columnDefinition = "TIMESTAMP")
    @NotNull(message = MensajeriaValidacionUtil.CAMPO_VACIO)
    private Date fechaModificacion;

    // Relaciones Externas

    @OneToMany(mappedBy = "cabeceraVenta", targetEntity = DetalleVenta.class, cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
    @NotNull(message = MensajeriaValidacionUtil.CAMPO_VACIO)
    private List<DetalleVenta> detalleVentas;
}
