package list;

/**
 * Created by Fran on 04/04/14.
 */
public interface ListI {

    public Object actualObject();
    public void deleteAll();
    public boolean isEmpty();
    public void insertBefore(Object object);
    public void insertAfter(Object object);
    public void next();
    public void before();
    public void position(int position);
    public void delete();

}
