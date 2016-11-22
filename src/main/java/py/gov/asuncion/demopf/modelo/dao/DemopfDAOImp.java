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
import org.hibernate.Transaction;
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

    @Override
    public void guardarUsuario(Usuario usuario) {
        Session session = null;
        Transaction tx = null;
        try {
            session = sessionFactory.openSession();
            tx = session.beginTransaction();
            session.persist(usuario);
            tx.commit();
        } catch (Exception e) {
            e.printStackTrace();
            tx.rollback();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
                session = null;
            }
        }
    }

    @Override
    public void actualizarUsuario(Usuario usuario) {
        Session session = null;
        Transaction tx = null;
        try {
            session = sessionFactory.openSession();
            tx = session.beginTransaction();
            session.update(usuario);
            tx.commit();
        } catch (Exception e) {
            e.printStackTrace();
            tx.rollback();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
                session = null;
            }
        }
    }

    @Override
    public void eliminarUsuario(Usuario usuario) {
        Session session = null;
        Transaction tx = null;
        try {
            session = sessionFactory.openSession();
            tx = session.beginTransaction();
            Usuario u = session.load(Usuario.class, usuario.getId());
            session.delete(u);
            tx.commit();
        } catch (Exception e) {
            e.printStackTrace();
            tx.rollback();
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

    @Override
    public Rol obtenerRolXId(int id) {
        Session session = null;

        try {
            session = sessionFactory.openSession();
            return (Rol) session.createQuery("FROM Rol WHERE id = :id").setParameter("id", id).getSingleResult();
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
