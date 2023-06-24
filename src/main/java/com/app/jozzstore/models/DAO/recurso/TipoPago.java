package com.app.jozzstore.models.DAO.recurso;

import com.app.jozzstore.models.DAO.compra.CabeceraCompra;
import com.app.jozzstore.models.DAO.venta.CabeceraVenta;
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
@Table(name = "tipos_pagos")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TipoPago implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idtipopago")
    private Integer idTipoPago;

    @ManyToOne(targetEntity = EstadoTransaccion.class)
    @JoinColumn(name = "idestado", nullable = false)
    @NotNull(message = MensajeriaValidacionUtil.CAMPO_VACIO)
    private EstadoTransaccion estadoTransaccion;

    @Column(name = "nombretipopago", nullable = false, unique = true, length = 50)
    @NotEmpty(message = MensajeriaValidacionUtil.CAMPO_VACIO)
    @Size(max = 50, message = MensajeriaValidacionUtil.LONGITUD_MAXIMA_SUPERADA)
    private String nombreTipoPago;

    @Column(name = "fecharegistro", nullable = false, insertable = false, updatable = false, columnDefinition = "TIMESTAMP")
    @NotNull(message = MensajeriaValidacionUtil.CAMPO_VACIO)
    private Date fechaRegistro;

    @Column(name = "fechamodificacion", nullable = false, insertable = false, columnDefinition = "TIMESTAMP")
    @NotNull(message = MensajeriaValidacionUtil.CAMPO_VACIO)
    private Date fechaModificacion;

    // Relaciones Externas

    @OneToMany(mappedBy = "tipoPago", fetch = FetchType.LAZY, cascade = CascadeType.MERGE, targetEntity = CabeceraCompra.class)
    private List<CabeceraCompra> cabeceraCompras;

    @OneToMany(mappedBy = "tipoPago", fetch = FetchType.LAZY, cascade = CascadeType.MERGE, targetEntity = CabeceraVenta.class)
    private List<CabeceraVenta> cabeceraVentas;
}
