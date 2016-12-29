package org.java.learn.topic.basic;

public class FIFO<T> {

    public static void main(String[] args) {
        FIFO fifo = new FIFO<String>();
        fifo.pop();
        System.out.println(fifo);
        fifo.put("a");
        fifo.put("b");
        fifo.put("c");
        System.out.println(fifo);
        fifo.pop();
        fifo.put("d");
        fifo.pop();
        System.out.println(fifo);
    }


    private int length = 3;
    private T[] items;


    public FIFO() {
        items = (T[]) new Object[length];
    }


    private int size = 0;

    public boolean isFull() {
        return size == length;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public T pop() {
        if (isEmpty()) {
            return null;
        }

        T result = items[length - 1];
        for (int i = length - 1; i > length - size; i--) {
            items[i] = items[i - 1];
        }
        items[length - size] = null;
        size--;
        return result;
    }


    public boolean put(T item) {
        if (isFull()) {
            return false;
        }

        items[length - size - 1] = item;
        size++;
        return true;
    }

    @Override
    public String toString() {
        StringBuffer buffer = new StringBuffer();
        for (int i = length - size; i < length; i++) {
            buffer.append(items[i].toString());
        }
        return "FIFO [items=" + buffer.toString() + "]";
    }

}
