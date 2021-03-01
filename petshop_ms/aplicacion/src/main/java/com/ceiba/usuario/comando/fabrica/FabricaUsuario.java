package com.ceiba.usuario.comando.fabrica;

import com.ceiba.ciudad.modelo.entidad.Ciudad;
import com.ceiba.ciudad.puerto.dao.DaoCiudad;
import com.ceiba.mascota.modelo.entidad.TipoMascota;
import com.ceiba.mascota.puerto.dao.DaoTipoMascota;
import com.ceiba.usuario.comando.ComandoUsuario;
import com.ceiba.usuario.modelo.entidad.Usuario;
import com.ceiba.usuario.servicio.exception.UsuarioNoAceptaTerminosException;

import org.springframework.stereotype.Component;

@Component
public class FabricaUsuario {

    private DaoCiudad daoCiudad;
    private DaoTipoMascota daoTipoMascota;

    public FabricaUsuario(DaoCiudad daoCiudad, DaoTipoMascota daoTipoMascota) {
        this.daoCiudad = daoCiudad;
        this.daoTipoMascota = daoTipoMascota;
    }

    public Usuario crear(ComandoUsuario comandoUsuario) throws UsuarioNoAceptaTerminosException {
        Ciudad ciudad = this.daoCiudad.encontrarPorId(comandoUsuario.getCiudad());
        TipoMascota tipoMascota = this.daoTipoMascota.encontrarMascotaPorId(comandoUsuario.getTipoMascota());
        return new Usuario(comandoUsuario.getId(), comandoUsuario.getNombre(), ciudad, tipoMascota, "",
                comandoUsuario.getDireccion(), comandoUsuario.getDireccion(), comandoUsuario.isAceptaTerminos());
    }
}
