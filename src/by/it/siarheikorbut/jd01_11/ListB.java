package by.it.siarheikorbut.jd01_11;

import java.util.*;

/**
 * @author Siarhei Korbut
 * @see <a href="https://drive.google.com/file/d/1Dtmq3a65M1AIORy_S6eC7CHwxX6PCQGB/view?usp=sharing">Задание JD01_11</a>
 */

public class ListB<T> implements List<T> {

    private T[] elements = (T[]) new Object[]{};
    private int size = 0;


    @Override
    public boolean add(T element) {
        if (size == elements.length) {
            elements = Arrays.copyOf(elements, elements.length * 3 / 2 + 1);
        }
        elements[size++] = element;
        return true;
    }

    @Override
    public T remove(int index) {
        T element = elements[index];
        System.arraycopy(elements, index + 1, elements, index, size - index - 1);
        size--;
        return element;
    }

    @Override
    public T get(int index) {

        return elements[index];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public String toString() {
        StringBuilder out = new StringBuilder();
        out.append("[");
        for (int i = 0; i < size; i++) {
            if (i > 0) {
                out.append(", ");
            }
            out.append(elements[i]);
        }
        out.append("]");
        return out.toString();
    }

    @Override
    public T set(int index, T e) {
        T old = elements[index];
        elements[index] = e;
        return old;
    }

    @Override
    public void add(int index, T element) {
        elements = Arrays.copyOf(elements, elements.length * 3 / 2 + 1);
        size++;
        if (size - 1 - index >= 0) System.arraycopy(elements, index, elements, index + 1, size - 1 - index);
        elements[index] = element;
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        Object[] a = c.toArray();
        elements = Arrays.copyOf(elements, elements.length + a.length);
        System.arraycopy(a, 0, elements, size, a.length);
        size += a.length;
        return a.length != 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean contains(Object o) {
        for (T element : elements) {
            if (element == o) return true;
        }
        return false;
    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return Arrays.copyOf(elements, size);
    }

    @Override
    public <T> T[] toArray(T[] a) {
        if (a.length < size)
            // Make a new array of a's runtime type, but my contents:
            return (T[]) Arrays.copyOf(elements, size, a.getClass());
        System.arraycopy(elements, 0, a, 0, size);
        if (a.length > size)
            a[size] = null;
        return a;
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(int index, Collection<? extends T> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public int indexOf(Object o) {
        for (int index = 0; index < size; index++) {
            if (elements[index] == o) return index;
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    public ListIterator<T> listIterator() {
        return null;
    }

    @Override
    public ListIterator<T> listIterator(int index) {
        return null;
    }

    @Override
    public List<T> subList(int fromIndex, int toIndex) {
        return null;
    }
}