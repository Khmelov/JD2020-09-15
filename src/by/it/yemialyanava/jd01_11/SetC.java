package by.it.yemialyanava.jd01_11;
import java.util.*;

public class SetC<T> implements Set<T> {
   private T[] elements = (T[]) new Object[0];

   private int size = 0;

    @Override
    public boolean add(T t) {
        for (int i = 0; i < size; i++) {
            if (elements[i].equals(t)) {
                return false;
            }
        }
        if (elements.length == size) {
            elements = Arrays.copyOf(elements, elements.length * 3 / 2 + 1);
        }
        elements[size++] = t;
        return true;
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        T[] arr = (T[])c.toArray();
        for(int i = 0; i < arr.length; i++) {
            T currentNewElement = arr[i];
            boolean elementNotInCollection = true;
            for (T element : elements ) {
                if (currentNewElement.equals(element)){
                    elementNotInCollection = false;
                }
                if (elementNotInCollection) {
                    size = size + c.size();
                    elements[++size] = currentNewElement;
                }
            }
        }
       return true;
    }

    /*private boolean elementNotInCollection (T[] elements, T currentNewElement) {
        for (T element : elements ) {
            if (currentNewElement.equals(element)){
                return false;
            }
        }
        return true;
    }*/

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean remove(Object o) {
        T del = (T) o;
        for (int i = 0; i < size; i++) {
            if (elements[i].equals(o)) {
                System.arraycopy(elements, i+1, elements, i, size-i-1);
                size--;
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        T[] arr = (T[])c.toArray();
        for(int i = 0; i < size; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (elements[i].equals(arr[j])) {
                    System.arraycopy(elements, i + 1, elements, i, size - i - 1);
                    size--;
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public boolean isEmpty() {
        if (size == 0){
            return true;
        }
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        T[] arr = (T[])c.toArray();
        for(int i = 0; i < size; i++) {
            for (int j = 0; j < arr.length; j++) {
                int count = 0;
                if (elements[i].equals(arr[j])) {
                    count= count +1;
                    if (count == arr.length){
                        return true;
                    }
                }
            }
        }
        return false;
    }

    @Override
    public boolean contains(Object o) {
        for (int i = 0; i < size; i++) {
            if (elements[i].equals(o)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        StringBuilder out = new StringBuilder("[");
        String delimiter = "";
        for (int j = 0; j < size; j++){
            out.append(delimiter).append(elements[j]);
            delimiter = ", ";
        }
        out.append("]");
        return out.toString();

    }
    //

    @Override
    public Iterator<T> iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T1> T1[] toArray(T1[] a) {
        return null;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {

    }
}
