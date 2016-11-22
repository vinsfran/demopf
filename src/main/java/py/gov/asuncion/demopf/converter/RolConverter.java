/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.gov.asuncion.demopf.converter;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import py.gov.asuncion.demopf.modelo.negocio.Rol;
import py.gov.asuncion.demopf.servicio.DemopfServicio;

/**
 *
 * @author vinsfran
 */
@ManagedBean(name = "rolConverter")
@RequestScoped
public class RolConverter implements Converter {

    @ManagedProperty(value = "#{DemopfServicio}")
    private DemopfServicio demopfServicio;

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        try {
            if (value != null && value.trim().length() > 0) {
                return demopfServicio.obtenerRolXId(Integer.parseInt(value));
            } else {
                return null;
            }
        } catch (Exception e) {
            FacesMessage msg = new FacesMessage("Error!", "Rol no válido");
            msg.setSeverity(FacesMessage.SEVERITY_ERROR);
            throw new ConverterException(msg);
        }
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value != null) {
            return String.valueOf(((Rol) value).getId());
        } else {
            return null;
        }

    }

    public void setDemopfServicio(DemopfServicio demopfServicio) {
        this.demopfServicio = demopfServicio;
    }

}
