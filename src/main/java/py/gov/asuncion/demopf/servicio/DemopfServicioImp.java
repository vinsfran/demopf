/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.gov.asuncion.demopf.servicio;

import java.io.Serializable;
import java.util.List;
import org.springframework.transaction.annotation.Transactional;
import py.gov.asuncion.demopf.modelo.negocio.Rol;
import py.gov.asuncion.demopf.modelo.negocio.Usuario;
import py.gov.asuncion.demopf.modelo.dao.DemopfDAO;

/**
 *
 * @author vinsfran
 */
@Transactional(readOnly = true)
public class DemopfServicioImp implements DemopfServicio, Serializable {

    private static final long serialVersionID = 1L;
    private DemopfDAO demopfDAO;

    @Override
    public List<Usuario> obtenerUsuarios() {
        return demopfDAO.obtenerUsuarios();
    }
    
    @Transactional(readOnly = false)
    @Override
    public void guardarUsuario(Usuario usuario){
       demopfDAO.guardarUsuario(usuario);
    }
    
    @Transactional(readOnly = false)
    @Override
    public void actualizarUsuario(Usuario usuario){
       demopfDAO.actualizarUsuario(usuario);
    }
    
    @Transactional(readOnly = false)
    @Override
    public void eliminarUsuario(Usuario usuario){
       demopfDAO.eliminarUsuario(usuario);
    }

    @Override
    public List<Rol> obtenerRoles() {
        return demopfDAO.obtenerRoles();
    }

    @Override
    public Rol obtenerRolXId(int id) {
        return demopfDAO.obtenerRolXId(id);
    }

    public void setDemopfDAO(DemopfDAO demopfDAO) {
        this.demopfDAO = demopfDAO;
    }

}
