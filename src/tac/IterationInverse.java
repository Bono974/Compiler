package tac;

import java.util.List;
import java.util.Iterator;
import java.util.ListIterator;
import java.lang.Iterable;


// Utilitaire, permet l'itération inverse dans un for each;
// Trouvé sur stackoverflow.com

public class IterationInverse<T> implements Iterable<T> {
    private final List<T> original;

    public IterationInverse(List<T> original) {
        this.original = original;
    }

    public Iterator<T> iterator() {
        final ListIterator<T> i = original.listIterator(original.size());

        return new Iterator<T>() {
            public boolean hasNext() { return i.hasPrevious(); }
            public T next() { return i.previous(); }
            public void remove() { i.remove(); }
        };
    }

    public static <T> IterationInverse<T> reversed(List<T> original) {
        return new IterationInverse<T>(original);
    }
}
