
package control;

import java.util.List;
import javax.persistence.EntityManager;

public abstract class SuperBean<T>{
    
    private Class<T> ec;
    
    public SuperBean( Class<T> ec ){ 
        this.ec = ec; 
    }
    
    protected abstract EntityManager getEm();
    
    public T persist( T entity ){ 
        return getEm().merge( entity ); 
    }
    
    public void remove( T entity ){ 
        getEm().remove( getEm().merge( entity ) ); 
    }
    
    public T find( Object id ){ 
        return getEm().find( ec, id ); 
    }
    
    public abstract T findById( Integer id );
    
    public abstract List<T> findAll();    
}
