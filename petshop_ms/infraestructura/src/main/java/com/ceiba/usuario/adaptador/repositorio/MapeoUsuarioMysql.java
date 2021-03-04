package com.ceiba.usuario.adaptador.repositorio;

public class MapeoUsuarioMysql {
    private Long id;
    private String nombre;
    private String password;
    private String direccion;
    private String telefono;
    private Boolean aceptaTerminos;
    private Long ciudad;
    private Long tipoMascota;

    public Long getId() {
		return id;
	}

	public String getNombre() {
		return nombre;
	}

	public String getPassword() {
		return password;
	}

	public String getDireccion() {
		return direccion;
	}

	public String getTelefono() {
		return telefono;
	}

	public Boolean getAceptaTerminos() {
		return aceptaTerminos;
	}

	public Long getCiudad() {
		return ciudad;
	}

	public Long getTipoMascota() {
		return tipoMascota;
	}


    public MapeoUsuarioMysql(Long id, String nombre, String password, String direccion, String telefono,
            Boolean acepta_terminos, Long ciudad_id, Long tipo_mascota_id) {
        this.id = id;
        this.nombre = nombre;
        this.password = password;
        this.direccion = direccion;
        this.telefono = telefono;
        this.aceptaTerminos = acepta_terminos;
        this.ciudad = ciudad_id;
        this.tipoMascota = tipo_mascota_id;
    }
}
