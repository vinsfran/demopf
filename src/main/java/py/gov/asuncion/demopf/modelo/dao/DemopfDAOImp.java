/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.gov.asuncion.demopf.modelo.dao;

import java.io.Serializable;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import py.gov.asuncion.demopf.modelo.negocio.Rol;
import py.gov.asuncion.demopf.modelo.negocio.Usuario;

/**
 *
 * @author vinsfran
 */
public class DemopfDAOImp implements DemopfDAO, Serializable {

    private static final long serialVersionID = 1L;
    private SessionFactory sessionFactory;

    @SuppressWarnings("unchecked")
    @Override
    public List<Usuario> obtenerUsuarios() {

        Session session = null;

        try {
            session = sessionFactory.openSession();
            return (List<Usuario>) session.createQuery("FROM Usuario").getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
                session = null;
            }
        }

    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Rol> obtenerRoles() {
        Session session = null;

        try {
            session = sessionFactory.openSession();
            return (List<Rol>) session.createQuery("FROM Rol").getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
                session = null;
            }
        }

    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

}
