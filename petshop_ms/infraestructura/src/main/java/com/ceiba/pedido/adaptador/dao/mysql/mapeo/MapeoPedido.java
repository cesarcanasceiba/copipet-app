package com.ceiba.pedido.adaptador.dao.mysql.mapeo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import com.ceiba.citapeluqueria.modelo.entidad.CitaPeluqueria;
import com.ceiba.citapeluqueria.puerto.dao.DaoCitaPeluqueria;
import com.ceiba.infraestructura.jdbc.MapperResult;
import com.ceiba.pedido.currency.TipoMoneda;
import com.ceiba.pedido.currency.converter.ConversorMonedaInterface;
import com.ceiba.pedido.modelo.entidad.BonoDescuento;
import com.ceiba.pedido.modelo.entidad.Pedido;
import com.ceiba.pedido.puerto.dao.DaoBonoDescuento;
import com.ceiba.producto.modelo.entidad.Producto;
import com.ceiba.producto.puerto.dao.DaoProducto;

import org.springframework.jdbc.core.RowMapper;

public class MapeoPedido implements RowMapper<Pedido>, MapperResult {

    private DaoBonoDescuento daoBonoDescuento;
    private ConversorMonedaInterface conversorMoneda;
    private DaoProducto daoProducto;
    private DaoCitaPeluqueria daoCitaPeluqueria;

    public MapeoPedido(DaoProducto daoProducto, DaoCitaPeluqueria daoCitaPeluqueria, DaoBonoDescuento daoBonoDescuento,
            ConversorMonedaInterface conversorMoneda) {
        this.daoProducto = daoProducto;
        this.daoCitaPeluqueria = daoCitaPeluqueria;
        this.daoBonoDescuento = daoBonoDescuento;
        this.conversorMoneda = conversorMoneda;
    }

    @Override
    public Pedido mapRow(ResultSet rs, int rowNum) throws SQLException {
        Long id = rs.getLong("id");
        List<Producto> productos = daoProducto.listaDeProductosPorPedido(id);
        List<CitaPeluqueria> citasPeluqueria = daoCitaPeluqueria.consultarPorPedido(id);
        BonoDescuento bonoDescuento = daoBonoDescuento.obtenerBonoPorId(rs.getLong("bonoDescuento_id"));
        Date fechaEntrega = rs.getDate("fechaEntrega");
        TipoMoneda tipoMoneda = TipoMoneda.COP;
        ConversorMonedaInterface conversorMoneda = this.conversorMoneda;
        return new Pedido(id, productos, citasPeluqueria, bonoDescuento, fechaEntrega, tipoMoneda, conversorMoneda);
    }

}
