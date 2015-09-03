package lists;

/**
 * Created by dashenka on 27.08.15.
 */
public interface IList {
    void add(final Object element);

    void removeLast();

    int size();

    Object get(final int index);

    void set(final int index, final Object object);
}
