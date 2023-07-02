package com.app.jozzstore.mapper;

import com.app.jozzstore.models.DAO.inventario.Producto;
import com.app.jozzstore.models.DTO.ProductoDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface IProductoMapper {
    @Mappings({
            @Mapping(source = "idProducto", target = "idProducto"),
            @Mapping(source = "categoria", target = "categoria"),
            @Mapping(source = "estadoTransaccion", target = "estadoTransaccion"),
            @Mapping(source = "nombreProducto", target = "nombreProducto"),
            @Mapping(source = "marca", target = "marca"),
            @Mapping(source = "stock", target = "stock"),
            @Mapping(source = "precio", target = "precio"),
            @Mapping(source = "descripcion", target = "descripcion"),
            @Mapping(source = "imagen", target = "imagen")
    })
    ProductoDTO productoToProductoDTO(Producto producto);
}
