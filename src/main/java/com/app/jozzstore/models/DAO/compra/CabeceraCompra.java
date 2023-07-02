package com.app.jozzstore.models.DAO.compra;

import com.app.jozzstore.models.DAO.recurso.EstadoTransaccion;
import com.app.jozzstore.models.DAO.recurso.Proveedor;
import com.app.jozzstore.models.DAO.recurso.TipoPago;
import com.app.jozzstore.utils.MensajeriaValidacionUtil;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "cabeceras_compras")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CabeceraCompra implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idcabeceracompra")
    private Integer idCabeceraCompra;

    @ManyToOne(targetEntity = Proveedor.class)
    @JoinColumn(name = "idproveedor", nullable = false)
    @NotNull(message = MensajeriaValidacionUtil.CAMPO_VACIO)
    private Proveedor proveedor;

    @ManyToOne(targetEntity = TipoPago.class)
    @JoinColumn(name = "idtipopago", nullable = false)
    @NotNull(message = MensajeriaValidacionUtil.CAMPO_VACIO)
    private TipoPago tipoPago;

    @ManyToOne(targetEntity = EstadoTransaccion.class)
    @JoinColumn(name = "idestado", nullable = false)
    @NotNull(message = MensajeriaValidacionUtil.CAMPO_VACIO)
    private EstadoTransaccion estadoTransaccion;

    @Column(name = "numerocomprobante", nullable = false, unique = true, length = 20)
    @NotEmpty(message = MensajeriaValidacionUtil.CAMPO_VACIO)
    @Size(max = 20, message = MensajeriaValidacionUtil.LONGITUD_MAXIMA_SUPERADA)
    private String numeroComprobante;

    @Column(name = "fecharegistro", nullable = false, insertable = false, updatable = false, columnDefinition = "TIMESTAMP")
    @NotNull(message = MensajeriaValidacionUtil.CAMPO_VACIO)
    private Date fechaRegistro;

    @Column(name = "fechamodificacion", nullable = false, insertable = false, columnDefinition = "TIMESTAMP")
    @NotNull(message = MensajeriaValidacionUtil.CAMPO_VACIO)
    private Date fechaModificacion;
}
