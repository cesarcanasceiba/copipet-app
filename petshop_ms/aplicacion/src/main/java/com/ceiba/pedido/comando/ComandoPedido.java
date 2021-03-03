package com.ceiba.pedido.comando;

import java.util.Date;
import java.util.List;
import com.ceiba.citapeluqueria.comando.ComandoCitaPeluqueria;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ComandoPedido {
    private Long id;
    private List<Long> productos;
    private List<ComandoCitaPeluqueria> citasPeluqueria;
    private Long bonoDescuento;
    private Date fechaEntrega;
    private String tipoMoneda;
}
