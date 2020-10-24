package by.it.yemialyanava.jd01_11;

import java.lang.reflect.Array;
import java.util.*;

public class ListB<T> implements List<T> {
    private T[] elements = (T[]) new Object[0];
    private int size = 0;

    @Override
    public boolean add(T t) {
        if (elements.length == size){
            elements =Arrays.copyOf(elements, elements.length*3 /2 +1);
        }
        elements[size++] = t;
        return true;
    }

    @Override
    public T remove(int index) {
        T del = elements[index];
        System.arraycopy(elements, index+1,elements, index, size-index-1);
        elements[--size] = null;
        return del;
    }

    @Override
    public T get(int index) {
        return elements[index];
    }

    @Override
    public T set(int index, T element) {
        T deleted = elements[index];
        elements[index] = element;
        return deleted;
    }

    @Override
    public void add(int index, T element) {
        if (elements.length ==size){
            elements = Arrays.copyOf(elements,elements.length * 3/2 +1);
        }
        System.arraycopy(elements,index, elements, index+1, size - index);
        elements[index] = element;
        size++;
    }


    public boolean addAll(Collection<? extends T> c) {
        elements = Arrays.copyOf(elements, elements.length*3/2+c.size());
        T[] arr = (T[])c.toArray();
        System.arraycopy(arr, 0, elements, size, c.size());
        size = size + c.size();
        return true;
    }


    @Override
    public int size() {
        return size;
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

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public Iterator<T> iterator() {
        return iterator();
    }

    @Override
    public Object[] toArray() {
        return elements;
    }

    @Override
    public <T1> T1[] toArray(T1[] a) {
        return null;
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
        return 0;
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
