
package sys.bean;

import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.inject.Named;
import javax.faces.bean.ViewScoped;
import sys.dao.LibroDAO;
import sys.impl.LibroDAOImpl;
import sys.modelo.Libro;

@ManagedBean
@Named(value = "libroBean")
@ViewScoped
public class LibroBean {
    
    private Libro libro = null;
    private List<Libro> libros=null;

    public LibroBean() {
    }
    
    public List<Libro> getLibros() {
        LibroDAO datos = new LibroDAOImpl();
        this.libros = datos.select();
        
        return libros;
    }
    
    public void prepareLibro(){
        this.libro=new Libro();
    }
    
    public void insertLibro(){
        LibroDAO datos=new LibroDAOImpl();
        datos.insert(libro);
    }
    
    public void updateLibro(){
        LibroDAO datos=new LibroDAOImpl();
        datos.update(libro);
        this.libro=new Libro();
    }
    
    public void deleteLibro(){
        LibroDAO datos=new LibroDAOImpl();
        datos.delete(libro);
        this.libro=new Libro();
    }

    public Libro getLibro() {
        return libro;
    }

    public void setLibro(Libro libro) {
        this.libro = libro;
    }

    public void setLibros(List<Libro> libros) {
        this.libros = libros;
    }
    
    
    
}
