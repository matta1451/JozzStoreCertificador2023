package com.app.jozzstore.models.DAO.recurso;

import com.app.jozzstore.models.DAO.venta.Delivery;
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
@Table(name = "distritos")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Distrito implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "iddistrito")
    private Integer idDistrito;

    @ManyToOne(targetEntity = EstadoTransaccion.class)
    @JoinColumn(name = "idestado", nullable = false)
    @NotNull(message = MensajeriaValidacionUtil.CAMPO_VACIO)
    private EstadoTransaccion estadoTransaccion;

    @Column(name = "nombredistrito", length = 50, nullable = false, unique = true)
    @NotEmpty(message = MensajeriaValidacionUtil.CAMPO_VACIO)
    @Size(max = 50, message = MensajeriaValidacionUtil.LONGITUD_MAXIMA_SUPERADA)
    private String nombreDistrito;

    @Column(name = "fecharegistro", nullable = false, insertable = false, updatable = false, columnDefinition = "TIMESTAMP")
    @NotNull(message = MensajeriaValidacionUtil.CAMPO_VACIO)
    private Date fechaRegistro;

    @Column(name = "fechamodificacion", nullable = false, insertable = false, columnDefinition = "TIMESTAMP")
    @NotNull(message = MensajeriaValidacionUtil.CAMPO_VACIO)
    private Date fechaModificacion;
}
