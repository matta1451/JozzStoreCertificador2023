package com.app.jozzstore.models.DAO.venta;

import com.app.jozzstore.models.DAO.recurso.Distrito;
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
import java.util.List;

@Entity
@Table(name = "deliveries")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Delivery implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "iddelivery")
    private Long idDelivery;

    @ManyToOne(targetEntity = Distrito.class)
    @JoinColumn(name = "iddistrito", nullable = false)
    @NotNull(message = MensajeriaValidacionUtil.CAMPO_VACIO)
    private Distrito distrito;

    @Column(name = "direccion", nullable = false, columnDefinition = "TEXT")
    @NotEmpty(message = MensajeriaValidacionUtil.CAMPO_VACIO)
    private String direccion;

    @Column(name = "referencia", length = 100)
    @Size(max = 100, message = MensajeriaValidacionUtil.LONGITUD_MAXIMA_SUPERADA)
    private String referencia;

    // Relaciones Externas

    @OneToMany(mappedBy = "delivery", fetch = FetchType.LAZY, cascade = CascadeType.ALL, targetEntity = CabeceraVenta.class)
    @NotNull(message = MensajeriaValidacionUtil.CAMPO_VACIO)
    private List<CabeceraVenta> cabeceraVentas;
}
