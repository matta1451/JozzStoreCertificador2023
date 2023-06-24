package com.app.jozzstore.models.DAO.recurso;

import com.app.jozzstore.models.DAO.compra.CabeceraCompra;
import com.app.jozzstore.models.DAO.seguridad.Usuario;
import com.app.jozzstore.models.DAO.inventario.Categoria;
import com.app.jozzstore.models.DAO.inventario.Producto;
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
@Table(name = "estados_transacciones")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EstadoTransaccion implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idestado")
    private Integer idEstado;

    @Column(name = "nombreestado", nullable = false, length = 20, unique = true)
    @NotEmpty(message = MensajeriaValidacionUtil.CAMPO_VACIO)
    @Size(max = 20, message = MensajeriaValidacionUtil.LONGITUD_MAXIMA_SUPERADA)
    private String nombreEstado;

    @Column(name = "fecharegistro", nullable = false, insertable = false, updatable = false, columnDefinition = "TIMESTAMP")
    @NotNull(message = MensajeriaValidacionUtil.CAMPO_VACIO)
    private Date fechaRegistro;

    @Column(name = "fechamodificacion", nullable = false, insertable = false, columnDefinition = "TIMESTAMP")
    @NotNull(message = MensajeriaValidacionUtil.CAMPO_VACIO)
    private Date fechaModificacion;

    // Relaciones externas

    @OneToMany(mappedBy = "estadoTransaccion", fetch = FetchType.LAZY, cascade = CascadeType.MERGE, targetEntity = Distrito.class)
    private List<Distrito> distritos;

    @OneToMany(mappedBy = "estadoTransaccion", fetch = FetchType.LAZY, cascade = CascadeType.MERGE, targetEntity = TipoPago.class)
    private List<TipoPago> tipoPagos;

    @OneToMany(mappedBy = "estadoTransaccion", fetch = FetchType.LAZY, cascade = CascadeType.MERGE, targetEntity = Proveedor.class)
    private List<Proveedor> proveedores;

    @OneToMany(mappedBy = "estadoTransaccion", fetch = FetchType.LAZY, cascade = CascadeType.MERGE, targetEntity = Usuario.class)
    private List<Usuario> usuarios;

    @OneToMany(mappedBy = "estadoTransaccion", fetch = FetchType.LAZY, cascade = CascadeType.MERGE, targetEntity = Categoria.class)
    private List<Categoria> categorias;

    @OneToMany(mappedBy = "estadoTransaccion", fetch = FetchType.LAZY, cascade = CascadeType.MERGE, targetEntity = Producto.class)
    private List<Producto> productos;

    @OneToMany(mappedBy = "estadoTransaccion", fetch = FetchType.LAZY, cascade = CascadeType.MERGE, targetEntity = CabeceraCompra.class)
    private List<CabeceraCompra> cabeceraCompras;

    @OneToMany(mappedBy = "estadoTransaccion", fetch = FetchType.LAZY, cascade = CascadeType.MERGE, targetEntity = CabeceraVenta.class)
    private List<CabeceraVenta> cabeceraVentas;
}
