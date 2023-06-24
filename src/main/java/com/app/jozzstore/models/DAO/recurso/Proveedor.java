package com.app.jozzstore.models.DAO.recurso;

import com.app.jozzstore.models.DAO.compra.CabeceraCompra;
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
@Table(name = "proveedores")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Proveedor implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idproveedor")
    private Integer idProveedor;

    @ManyToOne(targetEntity = EstadoTransaccion.class)
    @JoinColumn(name = "idestado", nullable = false)
    @NotNull(message = MensajeriaValidacionUtil.CAMPO_VACIO)
    private EstadoTransaccion estadoTransaccion;

    @Column(name = "nombreproveedor", nullable = false, length = 100, unique = true)
    @NotEmpty(message = MensajeriaValidacionUtil.CAMPO_VACIO)
    @Size(max = 100, message = MensajeriaValidacionUtil.LONGITUD_MAXIMA_SUPERADA)
    private String nombreProveedor;

    @Column(name = "ruc", length = 20, unique = true)
    @Size(max = 20, message = MensajeriaValidacionUtil.LONGITUD_MAXIMA_SUPERADA)
    private String ruc;

    @Column(name = "telefono", nullable = false, length = 30)
    @NotEmpty(message = MensajeriaValidacionUtil.CAMPO_VACIO)
    @Size(max = 30, message = MensajeriaValidacionUtil.LONGITUD_MAXIMA_SUPERADA)
    private String telefono;

    @Column(name = "correoelectronico", unique = true, length = 100)
    @Size(max = 100, message = MensajeriaValidacionUtil.LONGITUD_MAXIMA_SUPERADA)
    private String correoElectronico;

    @Column(name = "fecharegistro", nullable = false, insertable = false, updatable = false, columnDefinition = "TIMESTAMP")
    @NotNull(message = MensajeriaValidacionUtil.CAMPO_VACIO)
    private Date fechaRegistro;

    @Column(name = "fechamodificacion", nullable = false, insertable = false, columnDefinition = "TIMESTAMP")
    @NotNull(message = MensajeriaValidacionUtil.CAMPO_VACIO)
    private Date fechaModificacion;

    // Relaciones Externas

    @OneToMany(mappedBy = "proveedor", fetch = FetchType.LAZY, cascade = CascadeType.MERGE, targetEntity = CabeceraCompra.class)
    private List<CabeceraCompra> cabeceraCompras;

}
