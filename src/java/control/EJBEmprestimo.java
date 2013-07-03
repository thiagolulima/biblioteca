
package control;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import model.Emprestimo;

@Stateless
public class EJBEmprestimo extends SuperBean<Emprestimo> {

    @PersistenceContext
    EntityManager em;
    
    public EJBEmprestimo(){
        super( Emprestimo.class );
    }

    @Override
    protected EntityManager getEm() {
        return em;
    }

    @Override
    public Emprestimo findById(Integer id) {
        return (Emprestimo) em.createQuery( "SELECT c FROM Emprestimo c WHERE c.id = :id" )
                           .setParameter( "id", id ).getSingleResult();
    }

    @Override
    public List<Emprestimo> findAll() {
        return em.createNamedQuery( "Emprestimo.findAll" ).getResultList();
                
    }
    
}
