
package boundary;

import control.EJBLivro;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import model.Livro;

@Named( value = "beanLivro" )
@RequestScoped
public class BeanLivro {

    @EJB
    private EJBLivro ejb;
    private Livro livro=new Livro();
    
    public BeanLivro(){}
    
    public void persist(){
        ejb.persist(livro);
        livro = new Livro();
    }
    
    public Livro persist( Livro livro ){
        return ejb.persist(livro);
    }
    
    public List<Livro> findAll(){
        return ejb.findAll();
    }

    public EJBLivro getEjb() {
        return ejb;
    }

    public void setEjb(EJBLivro ejb) {
        this.ejb = ejb;
    }

    public Livro getLivro() {
        return livro;
    }

    public void setLivro(Livro livro) {
        this.livro = livro;
    }
    
    
}
