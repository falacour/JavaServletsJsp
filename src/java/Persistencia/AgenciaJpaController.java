/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistencia;

import Logica.Agencia;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import Logica.Empleado;
import java.util.ArrayList;
import java.util.List;
import Logica.Cliente;
import Persistencia.exceptions.NonexistentEntityException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author falacour
 */
public class AgenciaJpaController implements Serializable {

    public AgenciaJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;
    
    public AgenciaJpaController (){
        this.emf = Persistence.createEntityManagerFactory("AgenciaTurismoPU");
    }

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Agencia agencia) {
        if (agencia.getMisEmpleados() == null) {
            agencia.setMisEmpleados(new ArrayList<Empleado>());
        }
        if (agencia.getMisClientes() == null) {
            agencia.setMisClientes(new ArrayList<Cliente>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            List<Empleado> attachedMisEmpleados = new ArrayList<Empleado>();
            for (Empleado misEmpleadosEmpleadoToAttach : agencia.getMisEmpleados()) {
                misEmpleadosEmpleadoToAttach = em.getReference(misEmpleadosEmpleadoToAttach.getClass(), misEmpleadosEmpleadoToAttach.getCodigo());
                attachedMisEmpleados.add(misEmpleadosEmpleadoToAttach);
            }
            agencia.setMisEmpleados(attachedMisEmpleados);
            List<Cliente> attachedMisClientes = new ArrayList<Cliente>();
            for (Cliente misClientesClienteToAttach : agencia.getMisClientes()) {
                misClientesClienteToAttach = em.getReference(misClientesClienteToAttach.getClass(), misClientesClienteToAttach.getCodigo());
                attachedMisClientes.add(misClientesClienteToAttach);
            }
            agencia.setMisClientes(attachedMisClientes);
            em.persist(agencia);
            for (Empleado misEmpleadosEmpleado : agencia.getMisEmpleados()) {
                Agencia oldAgenciaOfMisEmpleadosEmpleado = misEmpleadosEmpleado.getAgencia();
                misEmpleadosEmpleado.setAgencia(agencia);
                misEmpleadosEmpleado = em.merge(misEmpleadosEmpleado);
                if (oldAgenciaOfMisEmpleadosEmpleado != null) {
                    oldAgenciaOfMisEmpleadosEmpleado.getMisEmpleados().remove(misEmpleadosEmpleado);
                    oldAgenciaOfMisEmpleadosEmpleado = em.merge(oldAgenciaOfMisEmpleadosEmpleado);
                }
            }
            for (Cliente misClientesCliente : agencia.getMisClientes()) {
                Agencia oldAgenciaOfMisClientesCliente = misClientesCliente.getAgencia();
                misClientesCliente.setAgencia(agencia);
                misClientesCliente = em.merge(misClientesCliente);
                if (oldAgenciaOfMisClientesCliente != null) {
                    oldAgenciaOfMisClientesCliente.getMisClientes().remove(misClientesCliente);
                    oldAgenciaOfMisClientesCliente = em.merge(oldAgenciaOfMisClientesCliente);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Agencia agencia) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Agencia persistentAgencia = em.find(Agencia.class, agencia.getCodigo());
            List<Empleado> misEmpleadosOld = persistentAgencia.getMisEmpleados();
            List<Empleado> misEmpleadosNew = agencia.getMisEmpleados();
            List<Cliente> misClientesOld = persistentAgencia.getMisClientes();
            List<Cliente> misClientesNew = agencia.getMisClientes();
            List<Empleado> attachedMisEmpleadosNew = new ArrayList<Empleado>();
            for (Empleado misEmpleadosNewEmpleadoToAttach : misEmpleadosNew) {
                misEmpleadosNewEmpleadoToAttach = em.getReference(misEmpleadosNewEmpleadoToAttach.getClass(), misEmpleadosNewEmpleadoToAttach.getCodigo());
                attachedMisEmpleadosNew.add(misEmpleadosNewEmpleadoToAttach);
            }
            misEmpleadosNew = attachedMisEmpleadosNew;
            agencia.setMisEmpleados(misEmpleadosNew);
            List<Cliente> attachedMisClientesNew = new ArrayList<Cliente>();
            for (Cliente misClientesNewClienteToAttach : misClientesNew) {
                misClientesNewClienteToAttach = em.getReference(misClientesNewClienteToAttach.getClass(), misClientesNewClienteToAttach.getCodigo());
                attachedMisClientesNew.add(misClientesNewClienteToAttach);
            }
            misClientesNew = attachedMisClientesNew;
            agencia.setMisClientes(misClientesNew);
            agencia = em.merge(agencia);
            for (Empleado misEmpleadosOldEmpleado : misEmpleadosOld) {
                if (!misEmpleadosNew.contains(misEmpleadosOldEmpleado)) {
                    misEmpleadosOldEmpleado.setAgencia(null);
                    misEmpleadosOldEmpleado = em.merge(misEmpleadosOldEmpleado);
                }
            }
            for (Empleado misEmpleadosNewEmpleado : misEmpleadosNew) {
                if (!misEmpleadosOld.contains(misEmpleadosNewEmpleado)) {
                    Agencia oldAgenciaOfMisEmpleadosNewEmpleado = misEmpleadosNewEmpleado.getAgencia();
                    misEmpleadosNewEmpleado.setAgencia(agencia);
                    misEmpleadosNewEmpleado = em.merge(misEmpleadosNewEmpleado);
                    if (oldAgenciaOfMisEmpleadosNewEmpleado != null && !oldAgenciaOfMisEmpleadosNewEmpleado.equals(agencia)) {
                        oldAgenciaOfMisEmpleadosNewEmpleado.getMisEmpleados().remove(misEmpleadosNewEmpleado);
                        oldAgenciaOfMisEmpleadosNewEmpleado = em.merge(oldAgenciaOfMisEmpleadosNewEmpleado);
                    }
                }
            }
            for (Cliente misClientesOldCliente : misClientesOld) {
                if (!misClientesNew.contains(misClientesOldCliente)) {
                    misClientesOldCliente.setAgencia(null);
                    misClientesOldCliente = em.merge(misClientesOldCliente);
                }
            }
            for (Cliente misClientesNewCliente : misClientesNew) {
                if (!misClientesOld.contains(misClientesNewCliente)) {
                    Agencia oldAgenciaOfMisClientesNewCliente = misClientesNewCliente.getAgencia();
                    misClientesNewCliente.setAgencia(agencia);
                    misClientesNewCliente = em.merge(misClientesNewCliente);
                    if (oldAgenciaOfMisClientesNewCliente != null && !oldAgenciaOfMisClientesNewCliente.equals(agencia)) {
                        oldAgenciaOfMisClientesNewCliente.getMisClientes().remove(misClientesNewCliente);
                        oldAgenciaOfMisClientesNewCliente = em.merge(oldAgenciaOfMisClientesNewCliente);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = agencia.getCodigo();
                if (findAgencia(id) == null) {
                    throw new NonexistentEntityException("The agencia with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(int id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Agencia agencia;
            try {
                agencia = em.getReference(Agencia.class, id);
                agencia.getCodigo();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The agencia with id " + id + " no longer exists.", enfe);
            }
            List<Empleado> misEmpleados = agencia.getMisEmpleados();
            for (Empleado misEmpleadosEmpleado : misEmpleados) {
                misEmpleadosEmpleado.setAgencia(null);
                misEmpleadosEmpleado = em.merge(misEmpleadosEmpleado);
            }
            List<Cliente> misClientes = agencia.getMisClientes();
            for (Cliente misClientesCliente : misClientes) {
                misClientesCliente.setAgencia(null);
                misClientesCliente = em.merge(misClientesCliente);
            }
            em.remove(agencia);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Agencia> findAgenciaEntities() {
        return findAgenciaEntities(true, -1, -1);
    }

    public List<Agencia> findAgenciaEntities(int maxResults, int firstResult) {
        return findAgenciaEntities(false, maxResults, firstResult);
    }

    private List<Agencia> findAgenciaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Agencia.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Agencia findAgencia(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Agencia.class, id);
        } finally {
            em.close();
        }
    }

    public int getAgenciaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Agencia> rt = cq.from(Agencia.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
