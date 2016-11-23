/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.gov.asuncion.demopf.managedBean;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.servlet.ServletContext;
import py.gov.asuncion.demopf.modelo.negocio.Rol;
import py.gov.asuncion.demopf.reporte.Reportes;
import py.gov.asuncion.demopf.servicio.DemopfServicio;

/**
 *
 * @author vinsfran
 */
@ManagedBean(name = "reporte")
@ViewScoped
public class ReporteMB implements Serializable {
    
    @ManagedProperty(value = "#{DemopfServicio}")
    private DemopfServicio demopfServicio;

    private String nombreReporte;
    private Integer idRol;
    private String tipoReporte;

    /**
     * Creates a new instance of ReporteMB
     */
    public ReporteMB() {
    }

    //Metodo para invocar el reporte y enviarle los parametros si es que necesita
    public void verReporteUsuariosCompleto() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        nombreReporte = "ReporteUsuario";
        verReporte(null);
    }
    
    public void verReporteUsuariosPorRol() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        nombreReporte = "ReporteUsuarioParametro";
        Map parametros = new HashMap();
        parametros.put("idRol", getIdRol());
        verReporte(parametros);
    }

    private void verReporte(Map parametros) throws ClassNotFoundException, SQLException {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        ServletContext servletContext = (ServletContext) facesContext.getExternalContext().getContext();
        Reportes.getReporte(servletContext.getRealPath("WEB-INF/reportes/" + nombreReporte + ".jasper"), parametros, tipoReporte);
        FacesContext.getCurrentInstance().responseComplete();
    }
    
    
    public List<Rol> getRoles() {
        return demopfServicio.obtenerRoles();
    }
    
    public void setDemopfServicio(DemopfServicio demopfServicio) {
        this.demopfServicio = demopfServicio;
    }

    /**
     * @return the idRol
     */
    public Integer getIdRol() {
        return idRol;
    }

    /**
     * @param idRol the idRol to set
     */
    public void setIdRol(Integer idRol) {
        this.idRol = idRol;
    }

    /**
     * @return the tipoReporte
     */
    public String getTipoReporte() {
        return tipoReporte;
    }

    /**
     * @param tipoReporte the tipoReporte to set
     */
    public void setTipoReporte(String tipoReporte) {
        this.tipoReporte = tipoReporte;
    }



}
