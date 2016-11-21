/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.gov.asuncion.demopf.servicio;

import java.util.List;
import py.gov.asuncion.demopf.modelo.negocio.Rol;
import py.gov.asuncion.demopf.modelo.negocio.Usuario;

/**
 *
 * @author vinsfran
 */
public interface DemopfServicio {

    //Usuario
    public List<Usuario> obtenerUsuarios();

    //Rol
    public List<Rol> obtenerRoles();

}
