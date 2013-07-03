
package control;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import model.Cliente;

@Stateless
public class EJBCliente extends SuperBean<Cliente> {
    @PersistenceContext
    EntityManager em;
    
    public EJBCliente(){
        super( Cliente.class );
    }

    @Override
    protected EntityManager getEm() {
        return em;
    }

    @Override
    public Cliente findById(Integer id) {
        return (Cliente) em.createQuery( "SELECT c FROM Cliente c WHERE c.id = :id" )
                           .setParameter( "id", id ).getSingleResult();
    }

    @Override
    public List<Cliente> findAll() {
        return em.createNamedQuery( "Cliente.findAll" ).getResultList();
                
    }
    
}
