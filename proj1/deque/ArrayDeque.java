package deque;

import java.util.Iterator;

import static org.junit.Assert.assertEquals;

public class ArrayDeque<T> implements Deque<T>, Iterable<T> {
    private T[] item;
    private int size;
    public ArrayDeque() {
        item = (T[]) new Object[8];
        size = 0;
    }

    @Override
    public void addFirst(T x) {
        if (size == 0) {
            item[size++] = x;
            return;
        }
        int cap = size;
        if (size == item.length) {
            cap *= 2;
        }
        T[] temp = (T[]) new Object[cap + 1];
        System.arraycopy(item, 0, temp, 1, size);
        temp[0] = x;
        item = temp;
        size++;
    }

    private void resize(int capacity) {
        T[] temp = (T[]) new Object[capacity];
        System.arraycopy(item, 0, temp, 0, size);
        item = temp;
    }

    @Override
    public void addLast(T x) {
        if (size == item.length) {
            resize(size * 2);
        }
        item[size] = x;
        size++;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public T get(int x) {
        if (x >= size) {
            return null;
        }
        return item[x];
    }

    @Override
    public T removeLast() {
        if(size == 0) {
            return null;
        }
        T x = item[size - 1];
        item[size - 1] = null;
        size--;
        if (size < item.length / 4) {
            resize(Math.round(item.length / 4.0f));
        }
        return x;
    }

    @Override
    public T removeFirst() {
        if (size == 0) {
            return null;
        }
        T x = item[0];
        for(int i = 0; i < size - 1; i++) {
            item[i] = item[i + 1];
        }
        item[size - 1] = null;
        size--;
        if (size < item.length / 4) {
            resize(Math.round(item.length / 4.0f));
        }
        return x;
    }

    @Override
    public void printDeque() {
        for(int i = 0; i < size; i++) {
            System.out.print(item[i]);
        }
        System.out.println();
    }

    public Iterator<T> iterator() {
        return new AIterator();
    }
    private class AIterator implements Iterator<T> {
        private int wiz;
        public AIterator() {
            wiz = 0;
        }
        @Override
        public boolean hasNext() {
            return wiz < size;
        }
        @Override
        public T next() {
            return item[wiz++];
        }
    }
    @Override
    public boolean equals(Object o) {
        if(this == o) return true;
        if(o instanceof ArrayDeque obj) {
            if (size != obj.size()) return false;
            for(int i = 0; i < size; i++) {
                if(item[i] != obj.get(0)) return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        ArrayDeque<Integer> l = new ArrayDeque<Integer>();
        for (int i = 0; i < 3; i++) {
            l.addLast(i);
        }

        for (double i = 0; i < 3; i++) {
            int x = l.removeFirst();
            if( i != x)
        System.out.println(i + " " + x);}
        }
    }

