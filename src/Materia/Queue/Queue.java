package Materia.Queue;

import Materia.Models.Node;
import java.util.NoSuchElementException;

public class Queue {
    private Node front;
    private Node rear;
    private int size;

    public Queue() {
        this.front = null;
        this.rear = null;
        this.size = 0;
    }

    public void enqueue(int value) {
        Node newNode = new Node(value);
        if (isEmpty()) {
            front = newNode;
            rear = newNode;
        } else {
            rear.setNext(newNode);
            rear = newNode;
        }
        size++;
    }

    public Node dequeue() {
        if (isEmpty()) {
            throw new NoSuchElementException("The queue is empty");
        }
        Node node = front;
        front = front.getNext();
        if (front == null) {
            rear = null;
        }
        size--;
        return node;
    }

    public Node peek() {
        if (isEmpty()) {
            throw new NoSuchElementException("The queue is empty");
        }
        return front;
    }

    public boolean isEmpty() {
        return front == null;
    }

    public int getSize() {
        return size;
    }

    public void printQueue() {
        Node current = front;
        while (current != null) {
            System.out.print(current.getValue() + " - ");
            current = current.getNext();
        }
    }
}
