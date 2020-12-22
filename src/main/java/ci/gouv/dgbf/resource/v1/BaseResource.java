package ci.gouv.dgbf.resource.v1;

import java.util.List;

public interface BaseResource<T> {
    public List<T> listAll();
    public T findById(String uuid);
    public void persist(T t);
    public void update(T t);
    public void delete(String uuid);
}
