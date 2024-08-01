package deque;

import java.util.Iterator;

public class LinkedListDeque<T> implements Deque<T>, Iterable<T> {
    public LinkedListDeque() {
        head = new Node(null, null, null);
        head.next = head;
        head.prev = head;
        size = 0;
    }

    private class Node {
        public T item;
        public Node next;
        public Node prev;

        public Node(T val, Node n, Node p) {
            item = val;
            next = n;
            prev = p;
        }
    }

    private final Node head;
    private int size;

    @Override
    public void addFirst(T val) {
        head.next = new Node(val, head.next, head);
        head.next.next.prev = head.next;
        size++;
    }

    @Override
    public void addLast(T val) {
        head.prev = new Node(val, head, head.prev);
        head.prev.prev.next = head.prev;
        size++;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void printDeque() {
        for (Node p = head.next; p != head; p = p.next) {
            System.out.print(p.item + " ");
        }
        System.out.println();
    }

    @Override
    public T removeFirst() {
        if (head.next == head) {
            return null;
        }
        T x = head.next.item;
        head.next = head.next.next;
        head.next.prev = head;
        size--;
        return x;
    }

    @Override
    public T removeLast() {
        if (head.next == head) {
            return null;
        }
        T x = head.prev.item;
        head.prev = head.prev.prev;
        head.prev.next = head;
        size--;
        return x;
    }

    @Override
    public T get(int index) {
        if (index >= size || index < 0) {
            return null;
        }
        Node p = head.next;
        while (index > 0) {
            index--;
            p = p.next;
        }
        return p.item;
    }

    private T getRecursive(int i, Node p) {
        if (i == 0) {
            return p.item;
        }
        return getRecursive(i - 1, p.next);
    }
    public T getRecursive(int index) {
        if (index >= size || index < 0) {
            return null;
        }
        return getRecursive(index, head.next);
    }

    public Iterator<T> iterator() {
        return new DIterator();
    }

    private class DIterator implements Iterator<T> {
        private int wiz;

        public DIterator() {
            wiz = 0;
        }

        @Override
        public boolean hasNext() {
            return wiz < size;
        }

        @Override
        public T next() {
            Node p = head;
            for (int i = 0; i <= wiz; i++) {
                p = p.next;
            }
            wiz++;
            return p.item;
        }
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o instanceof LinkedListDeque) {
            LinkedListDeque<T> obj = (LinkedListDeque) o;
            if (size != obj.size()) {
                return false;
            }
            Node p = this.head.next;
            Node po = obj.head.next;
            while (p != this.head) {
                if (!p.item.equals(po.item)) {
                    return false;
                }
                p = p.next;
                po = po.next;
            }
        }
        return true;
    }

}

