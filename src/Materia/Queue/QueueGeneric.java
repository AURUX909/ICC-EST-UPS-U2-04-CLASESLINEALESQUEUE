package Materia.Queue;

import Materia.Models.NodeGeneric;
import java.util.NoSuchElementException;

public class QueueGeneric<T> {
    private NodeGeneric<T> front;
    private NodeGeneric<T> rear;
    private int size;

    public QueueGeneric() {
        this.front = null;
        this.rear = null;
        this.size = 0;
    }

    public void enqueue(T value) {
        NodeGeneric<T> newNode = new NodeGeneric<>(value);
        if (isEmpty()) {
            front = newNode;
            rear = newNode;
        } else {
            rear.setNext(newNode);
            rear = newNode;
        }
        size++;
    }

    public T dequeue() {
        if (isEmpty()) {
            throw new NoSuchElementException("The queue is empty");
        }
        T value = front.getValue();
        front = front.getNext();
        if (front == null) {
            rear = null;
        }
        size--;
        return value;
    }

    public T peek() {
        if (isEmpty()) {
            throw new NoSuchElementException("The queue is empty");
        }
        return front.getValue();
    }

    public boolean isEmpty() {
        return front == null;
    }

    public int getSize() {
        return size;
    }

    public void printQueue() {
        NodeGeneric<T> current = front;
        while (current != null) {
            System.out.print(current.getValue() + " - ");
            current = current.getNext();
        }
    }
}