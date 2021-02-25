package com.ceiba.pedido.testdatabuilder;

import java.util.Calendar;
import java.util.Date;

import com.ceiba.TestDataBuilderInterface;
import com.ceiba.pedido.modelo.entidad.BonoDescuento;

public class BonoDescuentoTestDataBuilder implements TestDataBuilderInterface<BonoDescuento>{

	private long id;
	private String codigo;
	private Date inicioVigencia;
	private Date finVigencia;
	private float descuento;

	public BonoDescuentoTestDataBuilder() {
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		
		this.id = 1L;
        this.codigo = "COD1";
        cal.add(Calendar.DAY_OF_YEAR, -1);
		this.inicioVigencia =cal.getTime();
		cal.add(Calendar.DAY_OF_YEAR, 3);
		this.finVigencia = cal.getTime();
		this.descuento = 0F;
	}
	
	public BonoDescuentoTestDataBuilder setId(long id) {
		this.id = id;
		return this;
	}

	public BonoDescuentoTestDataBuilder setCodigo(String codigo) {
		this.codigo = codigo;
		return this;
	}

	public BonoDescuentoTestDataBuilder setInicioVigencia(Date inicioVigencia) {
		this.inicioVigencia = inicioVigencia;
		return this;
	}

	public BonoDescuentoTestDataBuilder setFinVigencia(Date finVigencia) {
		this.finVigencia = finVigencia;
		return this;
	}

	public BonoDescuentoTestDataBuilder setDescuento(float descuento) {
		this.descuento = descuento;
		return this;
	}

	@Override
	public BonoDescuento build() {
		return new BonoDescuento(id, codigo, inicioVigencia, finVigencia, descuento);
	}
}
