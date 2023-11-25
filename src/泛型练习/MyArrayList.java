package 泛型练习;

import java.util.Arrays;

public class MyArrayList<E> {
    Object[] obj = new Object[10];
    int size = 0;

    public boolean add(E e) {
        obj[size ++ ] = e;
        return true;
    }

    public E get(int index) {
        return (E) obj[index];
    }

    @Override
    public String toString() {
        return Arrays.toString(obj);
    }
}
