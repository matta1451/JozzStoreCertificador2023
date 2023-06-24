package com.app.jozzstore.models.DAO.recurso;

import com.app.jozzstore.models.DAO.seguridad.Usuario;
import com.app.jozzstore.utils.MensajeriaValidacionUtil;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "personas")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Persona implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idpersona", nullable = false)
    private Long idPersona;

    @ManyToOne(targetEntity = Distrito.class)
    @JoinColumn(name = "iddistrito", nullable = false)
    @NotNull(message = MensajeriaValidacionUtil.CAMPO_VACIO)
    private Distrito distrito;

    @Column(name = "nombres", nullable = false, length = 100)
    @NotEmpty(message = MensajeriaValidacionUtil.CAMPO_VACIO)
    @Size(max = 100, message = MensajeriaValidacionUtil.LONGITUD_MAXIMA_SUPERADA)
    private String nombres;

    @Column(name = "apellidos", nullable = false, length = 100)
    @NotEmpty(message = MensajeriaValidacionUtil.CAMPO_VACIO)
    @Size(max = 100, message = MensajeriaValidacionUtil.LONGITUD_MAXIMA_SUPERADA)
    private String apellidos;

    @Column(name = "genero", nullable = false, length = 15)
    @NotEmpty(message = MensajeriaValidacionUtil.CAMPO_VACIO)
    @Size(max = 15, message = MensajeriaValidacionUtil.LONGITUD_MAXIMA_SUPERADA)
    private String genero;

    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "fechanacimiento", nullable = false)
    private Date fechaNacimiento;

    @Column(name = "tipodocumento", nullable = false, length = 10)
    @NotEmpty(message = MensajeriaValidacionUtil.CAMPO_VACIO)
    @Size(max = 10, message = MensajeriaValidacionUtil.LONGITUD_MAXIMA_SUPERADA)
    private String tipoDocumento;

    @Column(name = "numerodocumento", nullable = false, length = 15, unique = true)
    @NotEmpty(message = MensajeriaValidacionUtil.CAMPO_VACIO)
    @Size(max = 15, message = MensajeriaValidacionUtil.LONGITUD_MAXIMA_SUPERADA)
    private String numeroDocumento;

    @Column(name = "correoelectronico", nullable = false, length = 100, unique = true)
    @NotEmpty(message = MensajeriaValidacionUtil.CAMPO_VACIO)
    @Size(max = 100, message = MensajeriaValidacionUtil.LONGITUD_MAXIMA_SUPERADA)
    @Email(message = MensajeriaValidacionUtil.EMAIL_INVALIDO)
    private String correoElectronico;

    @Column(name = "telefonoprincipal", nullable = false, length = 9)
    @NotEmpty(message = MensajeriaValidacionUtil.CAMPO_VACIO)
    @Size(min = 7, max = 9, message = MensajeriaValidacionUtil.LONGITUD_MAXIMA_SUPERADA)
    private String telefonoPrincipal;

    @Column(name = "telefonosecundario", length = 9)
    @Size(min = 7, max = 9, message = MensajeriaValidacionUtil.LONGITUD_MAXIMA_SUPERADA)
    private String telefonoFinal;

    @Column(name = "direccion", nullable = false, length = 100)
    @NotEmpty(message = MensajeriaValidacionUtil.CAMPO_VACIO)
    @Size(max = 100, message = MensajeriaValidacionUtil.LONGITUD_MAXIMA_SUPERADA)
    private String direccion;

    @Column(name = "referencia", length = 100)
    @Size(max = 100, message = MensajeriaValidacionUtil.LONGITUD_MAXIMA_SUPERADA)
    private String referencia;

    @Column(name = "fecharegistro", nullable = false, insertable = false, updatable = false, columnDefinition = "TIMESTAMP")
    @NotNull(message = MensajeriaValidacionUtil.CAMPO_VACIO)
    private Date fechaRegistro;

    @Column(name = "fechamodificacion", nullable = false, insertable = false, columnDefinition = "TIMESTAMP")
    @NotNull(message = MensajeriaValidacionUtil.CAMPO_VACIO)
    private Date fechaModificacion;

    // Relaciones externas

    @OneToMany(mappedBy = "persona", fetch = FetchType.LAZY, cascade = CascadeType.MERGE, targetEntity = Usuario.class)
    private List<Usuario> usuarios;

}
