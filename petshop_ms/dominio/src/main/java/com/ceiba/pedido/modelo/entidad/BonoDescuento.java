package com.ceiba.pedido.modelo.entidad;

import java.util.Date;
import lombok.*;

@Getter
public class BonoDescuento {
   private Long id;
   private String codigo;
   private Date inicioVigencia;
   private Date finVigencia;
   
   /** Valor de 0 a 1 */
   private Float descuento;
}
