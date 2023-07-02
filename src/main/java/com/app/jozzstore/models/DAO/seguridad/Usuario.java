package com.app.jozzstore.models.DAO.seguridad;

import com.app.jozzstore.models.DAO.recurso.EstadoTransaccion;
import com.app.jozzstore.models.DAO.recurso.Persona;
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
@Table(name = "usuarios")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Usuario implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idusuario")
    private Long idUsuario;

    @ManyToOne(targetEntity = Persona.class)
    @JoinColumn(name = "idpersona", nullable = false)
    @NotNull(message = MensajeriaValidacionUtil.CAMPO_VACIO)
    private Persona persona;

    @ManyToOne(targetEntity = EstadoTransaccion.class)
    @JoinColumn(name = "idestado", nullable = false)
    @NotNull(message = MensajeriaValidacionUtil.CAMPO_VACIO)
    private EstadoTransaccion estadoTransaccion;

    @Column(name = "nombreusuario", nullable = false, unique = true, length = 30)
    @NotEmpty(message = MensajeriaValidacionUtil.CAMPO_VACIO)
    @Size(max = 30, message = MensajeriaValidacionUtil.LONGITUD_MAXIMA_SUPERADA)
    private String nombreUsuario;

    @Column(name = "contrasena", nullable = false, length = 100)
    @NotEmpty(message = MensajeriaValidacionUtil.CAMPO_VACIO)
    @Size(max = 100, message = MensajeriaValidacionUtil.LONGITUD_MAXIMA_SUPERADA)
    private String contrasena;

    @Column(name = "fecharegistro", nullable = false, insertable = false, updatable = false, columnDefinition = "TIMESTAMP")
    @NotNull(message = MensajeriaValidacionUtil.CAMPO_VACIO)
    private Date fechaRegistro;

    @Column(name = "fechamodificacion", nullable = false, insertable = false, columnDefinition = "TIMESTAMP")
    @NotNull(message = MensajeriaValidacionUtil.CAMPO_VACIO)
    private Date fechaModificacion;
}
