
package boundary;

import control.EJBEmprestimo;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import model.Emprestimo;

@Named( value = "beanEmprestimo" )
@RequestScoped
public class BeanEmprestimo {

    @EJB
    private EJBEmprestimo ejb;
    private Emprestimo emprestimo=new Emprestimo();
    
    public BeanEmprestimo(){}
    
    public void persist(){
        ejb.persist(emprestimo);
        emprestimo = new Emprestimo();
    }
    
    public Emprestimo persist( Emprestimo emprestimo ){
        return ejb.persist(emprestimo);
    }
    
    public List<Emprestimo> findAll(){
        return ejb.findAll();
    }

    public EJBEmprestimo getEjb() {
        return ejb;
    }

    public void setEjb(EJBEmprestimo ejb) {
        this.ejb = ejb;
    }

    public Emprestimo getEmprestimo() {
        return emprestimo;
    }

    public void setEmprestimo(Emprestimo emprestimo) {
        this.emprestimo = emprestimo;
    }
    
     public void updateEmprestimo(){
        ejb.persist(emprestimo);
        emprestimo = new Emprestimo();
    }
    
}
