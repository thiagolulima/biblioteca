
package boundary;

import control.EJBLivro;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import model.Livro;

@Named(value = "conLivro")
@RequestScoped
public class ConLivro implements Converter{
    
    @EJB
    private EJBLivro con;
    
    public ConLivro() {
    }

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
          return con.findById( ( Integer ) Integer.parseInt( value ) );
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
          return (( Livro ) value ).getId().toString();
    }
}
