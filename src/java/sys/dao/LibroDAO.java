
package sys.dao;

import java.util.List;
import sys.modelo.Libro;

public interface LibroDAO {
    public List<Libro> select();
    public void insert(Libro libro);
    public void update(Libro libro);
    public void delete(Libro libro);
}
