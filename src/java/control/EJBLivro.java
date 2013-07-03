
package control;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import model.Livro;

@Stateless
public class EJBLivro extends SuperBean<Livro> {

    @PersistenceContext
    EntityManager em;
    
    public EJBLivro(){
        super( Livro.class );
    }

    @Override
    protected EntityManager getEm() {
        return em;
    }

    @Override
    public Livro findById(Integer id) {
        return (Livro) em.createQuery( "SELECT c FROM Livro c WHERE c.id = :id" )
                           .setParameter( "id", id ).getSingleResult();
    }

    @Override
    public List<Livro> findAll() {
        return em.createNamedQuery( "Livro.findAll" ).getResultList();
                
    }
    
}
