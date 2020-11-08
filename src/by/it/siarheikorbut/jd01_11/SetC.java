package by.it.siarheikorbut.jd01_11;

import java.util.*;

/**
 * @author Siarhei Korbut
 * @see <a href="https://drive.google.com/file/d/1Dtmq3a65M1AIORy_S6eC7CHwxX6PCQGB/view?usp=sharing">Задание JD01_11</a>
 */

public class SetC<T> implements Set<T> {
    private T[] elements = (T[]) new Object[]{};

    private int size = 0;

    @Override
    public boolean contains(Object o) {
        for (T element : elements) {
            if (element == o) return true;
        }
        return false;
    }

    @Override
    public boolean add(T t) {
        if (contains(t)) return false;
        if (size == elements.length) {
            elements = Arrays.copyOf(elements, elements.length * 3 / 2 + 1);
        }
        elements[size++] = t;
        return true;
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
    public boolean remove(Object o) {

        if (size == 0) return false;
        for (int index = 0; index < size; index++) {
            if (elements[index] == o) {
                System.arraycopy(elements, index + 1,
                        elements, index, size - index - 1);
                size--;
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        boolean flag = false;
        for (Object o : c) {
            if (add((T) o)) flag = true;
        }
        return flag;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        int check = 0;
        for (Object object : c) {
            if (contains(object)) check++;
        }
        return check <= c.size();
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        if (containsAll(c) && c.containsAll(Arrays.asList(elements))) {
            clear();
            return true;
        }
        if (c.isEmpty()) return false;
        int check = 0;
        for (Object object : c) {
            if (remove(object)) check++;
        }
        return check <= c.size();
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
    public <T1> T1[] toArray(T1[] a) {
        return null;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {
        Arrays.fill(elements, null);
        size = 0;
    }
}