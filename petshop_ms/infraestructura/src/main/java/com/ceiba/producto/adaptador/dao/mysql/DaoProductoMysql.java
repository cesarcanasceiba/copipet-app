package com.ceiba.producto.adaptador.dao.mysql;

import java.util.List;
import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.producto.adaptador.dao.mysql.mapeo.MapeoProducto;
import com.ceiba.producto.adaptador.dao.mysql.mapeo.MapeoProductoDetalleDto;
import com.ceiba.producto.adaptador.dao.mysql.mapeo.MapeoProductoResumenDto;
import com.ceiba.producto.modelo.dto.ProductoDetalleDTO;
import com.ceiba.producto.modelo.dto.ProductoResumenDTO;
import com.ceiba.producto.modelo.entidad.CategoriaProducto;
import com.ceiba.producto.modelo.entidad.Producto;
import com.ceiba.producto.puerto.dao.DaoCategoriaProducto;
import com.ceiba.producto.puerto.dao.DaoMarcaProducto;
import com.ceiba.producto.puerto.dao.DaoProducto;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Component;

@Component
public class DaoProductoMysql implements DaoProducto {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;
    private DaoCategoriaProducto daoCategoriaProducto;
    private DaoMarcaProducto daoMarcaProducto;

    @SqlStatement(namespace = "producto", value = "listaResumen")
    private static String sqlListar;

    @SqlStatement(namespace = "producto", value = "listaFiltroCategoria")
    private static String sqlListarFiltroCategoria;

    @SqlStatement(namespace = "producto", value = "consultarDetalleProducto")
    private static String consultarDetalleProducto;

    @SqlStatement(namespace = "producto", value = "consultarProductosPorId")
    private static String sqlConsultarProductosPorId;

    @SqlStatement(namespace = "producto", value = "consultarProductosPorPedido")
    private static String sqlConsultarProductosPorPedido;

    public DaoProductoMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate,
            DaoCategoriaProducto daoCategoriaProducto, DaoMarcaProducto daoMarcaProducto) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
        this.daoCategoriaProducto = daoCategoriaProducto;
        this.daoMarcaProducto = daoMarcaProducto;
    }

    @Override
    public List<ProductoResumenDTO> listaProductosResumen() {
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(sqlListar,
                new MapeoProductoResumenDto());
    }

    @Override
    public List<ProductoResumenDTO> listaProductosPorCategoria(CategoriaProducto categoria) {
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("categoria_id", categoria.getId());
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(sqlListarFiltroCategoria,
                params, new MapeoProductoResumenDto());
    }

    @Override
    public ProductoDetalleDTO verDetalleProducto(Long id) {
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("id", id);
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate()
                .queryForObject(consultarDetalleProducto, params, new MapeoProductoDetalleDto());
    }

    @Override
    public List<Producto> listaDeProductosPorId(List<Long> listado) {
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("listadoIds", listado);
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(sqlConsultarProductosPorId,
                params, new MapeoProducto(this.daoMarcaProducto, this.daoCategoriaProducto));
    }

    @Override
    public List<Producto> listaDeProductosPorPedido(Long pedidoId) {
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("pedidoId", pedidoId);
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(
                sqlConsultarProductosPorPedido, params,
                new MapeoProducto(this.daoMarcaProducto, this.daoCategoriaProducto));
    }
}
