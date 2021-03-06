package com.ceiba.pedido.modelo.entidad;

import java.util.Date;

import com.ceiba.pedido.exception.DescuentoFueraRangoException;

import lombok.*;

@Getter
public class BonoDescuento {
    public BonoDescuento(Long id, @NonNull String codigo, @NonNull Date inicioVigencia, @NonNull Date finVigencia, Float descuento) {
	    this.id = id;
        this.codigo = codigo;
		this.inicioVigencia = new Date(inicioVigencia.getTime());
		this.finVigencia = new Date(finVigencia.getTime());
		this.descuento = this.getDescuento(descuento);
	}
    
    public Date getInicioVigencia() {
    	return new Date(this.inicioVigencia.getTime());
    }
    
    public Date getFinVigencia() {
    	return new Date(this.finVigencia.getTime());
    }

    private Float getDescuento(Float descuento) {
		if(descuento == null) {
			return 0F;
		}else {
			if (isBetween(descuento, 0, 1)) {
				return descuento;
			}else {
				throw new DescuentoFueraRangoException();
			}
		}
	 }

    private Long id;
	private String codigo;
	private Date inicioVigencia;
	private Date finVigencia;
	   
	/** Valor de 0 a 1 */
    private Float descuento;
    
    private boolean isBetween(float x, float lower, float upper) {
  	  return lower <= x && x <= upper;
  }
}
