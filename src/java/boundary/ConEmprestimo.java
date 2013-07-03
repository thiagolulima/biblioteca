
package boundary;

import control.EJBEmprestimo;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import model.Emprestimo;

@Named(value = "conEmprestimo")
@RequestScoped
public class ConEmprestimo implements Converter{
    
    @EJB
    private EJBEmprestimo con;
    
    public ConEmprestimo() {
    }

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
          return con.findById( ( Integer ) Integer.parseInt( value ) );
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
          return (( Emprestimo ) value ).getId().toString();
    }
}
