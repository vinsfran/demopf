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
import py.gov.asuncion.demopf.modelo.negocio.Usuario;
import py.gov.asuncion.demopf.servicio.DemopfServicio;

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
    
    public UsuarioMB(){
        
    }
    
    @PostConstruct
    public void inicio(){
        
    }

    public List<Usuario> getUsuarios(){
        return demopfServicio.obtenerUsuarios();
    }
    
    public void setDemopfServicio(DemopfServicio demopfServicio) {
        this.demopfServicio = demopfServicio;
    }

}
