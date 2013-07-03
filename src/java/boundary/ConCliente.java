
package boundary;

import control.EJBCliente;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import model.Cliente;

@Named(value = "conCliente")
@RequestScoped
public class ConCliente implements Converter{
    
    @EJB
    private EJBCliente con;
    
    public ConCliente() {
    }

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
          return con.findById( ( Integer ) Integer.parseInt( value ) );
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
          return (( Cliente ) value ).getId().toString();
    }
}
