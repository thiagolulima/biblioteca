
package boundary;

import control.EJBCliente;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import model.Cliente;

@Named( value = "beanCliente" )
@RequestScoped
public class BeanCliente {

    @EJB
    private EJBCliente ejb;
    private Cliente cliente=new Cliente();
    
    
    public BeanCliente(){}
    
    public void persist(){
        ejb.persist(cliente);
        cliente = new Cliente();
    }
    
    public void persist( Cliente cliente ){
        ejb.persist(cliente);
    }
    
    public List<Cliente> findAll(){
        return ejb.findAll();
    }

    public EJBCliente getEjb() {
        return ejb;
    }

    public void setEjb(EJBCliente ejb) {
        this.ejb = ejb;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    
    
}
