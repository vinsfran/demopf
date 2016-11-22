/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.gov.asuncion.demopf.managedBean;

import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import py.gov.asuncion.demopf.modelo.negocio.Rol;
import py.gov.asuncion.demopf.modelo.negocio.Usuario;
import py.gov.asuncion.demopf.servicio.DemopfServicio;
import py.gov.asuncion.demopf.util.MsgUtil;

/**
 *
 * @author vinsfran
 */
@ManagedBean(name = "usuario")
@ViewScoped
public class UsuarioMB implements Serializable {

    private static final long serialVersionID = 1L;

    @ManagedProperty(value = "#{DemopfServicio}")
    private DemopfServicio demopfServicio;

    private Usuario usuario;
    private Usuario slcUsuario;
    private boolean editar;
    private List<Usuario> filtroUsuarios;

    public UsuarioMB() {
        this.editar = false;
    }

    @PostConstruct
    public void inicio() {
        usuario = new Usuario();
    }

    public void guardar() {

        try {
            if (!editar) {
                demopfServicio.guardarUsuario(usuario);
                MsgUtil.msg("Exito", "Usuario guardado correctamente", "INFO");
            } else {
                demopfServicio.actualizarUsuario(usuario);
                MsgUtil.msg("Advertencia", "Usuario actualizado", "WARNING");
            }
            this.cancelar();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void actualizar() {
        usuario = slcUsuario;
        editar = true;
    }

    public void eliminar() {
        try {
            demopfServicio.eliminarUsuario(slcUsuario);
            MsgUtil.msg("Error", "Usuario eliminado correctamente", "ERROR");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void cancelar() {
        usuario = new Usuario();
        editar = false;
    }

    public List<Usuario> getUsuarios() {
        return demopfServicio.obtenerUsuarios();
    }

    public List<Rol> getRoles() {
        return demopfServicio.obtenerRoles();
    }

    public void setDemopfServicio(DemopfServicio demopfServicio) {
        this.demopfServicio = demopfServicio;
    }

    /**
     * @return the usuario
     */
    public Usuario getUsuario() {
        return usuario;
    }

    /**
     * @param usuario the usuario to set
     */
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    /**
     * @return the slcUsuario
     */
    public Usuario getSlcUsuario() {
        return slcUsuario;
    }

    /**
     * @param slcUsuario the slcUsuario to set
     */
    public void setSlcUsuario(Usuario slcUsuario) {
        this.slcUsuario = slcUsuario;
    }

    /**
     * @return the filtroUsuarios
     */
    public List<Usuario> getFiltroUsuarios() {
        return filtroUsuarios;
    }

    /**
     * @param filtroUsuarios the filtroUsuarios to set
     */
    public void setFiltroUsuarios(List<Usuario> filtroUsuarios) {
        this.filtroUsuarios = filtroUsuarios;
    }

}
