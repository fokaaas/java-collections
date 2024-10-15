package com.stbasarab.collections;

/**
 * A generic doubly linked list implementation.
 * This class allows for dynamic storage and manipulation of elements.
 *
 * @param <T> the type of elements stored in the list
 */
public class DoublyLinkedList<T> {
    private class Node {
        T data;
        Node next;
        Node prev;

        Node(T data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    private Node head;
    private Node tail;
    private int size;

    /**
     * Constructs an empty DoublyLinkedList.
     */
    public DoublyLinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    /**
     * Adds a new element to the end of the list.
     *
     * @param data the element to be added
     */
    public void add(T data) {
        Node newNode = new Node(data);
        if (size == 0) {
            head = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
        }
        tail = newNode;
        size++;
    }

    /**
     * Adds a new element at the specified index in the list.
     *
     * @param index the position to insert the element
     * @param data  the element to be added
     * @throws IndexOutOfBoundsException if the index is invalid
     */
    public void add(int index, T data) {
        if (isNotValidIndex(index)) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        Node newNode = new Node(data);
        if (index == 0) {
            if (size == 0) {
                head = newNode;
                tail = newNode;
            } else {
                newNode.next = head;
                head.prev = newNode;
                head = newNode;
            }
        } else if (index == size) {
            add(data);
        } else {
            Node current = head;
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
            newNode.prev = current.prev;
            newNode.next = current;
            current.prev.next = newNode;
            current.prev = newNode;
        }
        size++;
    }

    /**
     * Retrieves the element at the specified index.
     *
     * @param index the position of the element to retrieve
     * @return the element at the specified index
     * @throws IndexOutOfBoundsException if the index is invalid
     */
    public T get(int index) {
        if (isNotValidIndex(index)) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        Node current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.data;
    }

    /**
     * Removes the element at the specified index.
     *
     * @param index the position of the element to remove
     * @return the removed element
     * @throws IndexOutOfBoundsException if the index is invalid
     */
    public T remove(int index) {
        if (isNotValidIndex(index)) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        Node current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        if (current.prev != null) {
            current.prev.next = current.next;
        } else {
            head = current.next;
        }
        if (current.next != null) {
            current.next.prev = current.prev;
        } else {
            tail = current.prev;
        }
        size--;
        return current.data;
    }

    /**
     * Checks if the provided index is invalid.
     *
     * @param index the index to check
     * @return true if the index is invalid; false otherwise
     */
    private boolean isNotValidIndex(int index) {
        return index < 0 || index >= size;
    }

    /**
     * Gets the current size of the list.
     *
     * @return the number of elements in the list
     */
    public int getSize() {
        return size;
    }

    /**
     * Checks if the list contains the specified element.
     *
     * @param o the element to check for
     * @return true if the element is found; false otherwise
     */
    public boolean contains(Object o) {
        Node current = head;
        while (current != null) {
            if (current.data.equals(o)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    /**
     * Replaces the element at the specified index with a new element.
     *
     * @param index the index of the element to replace
     * @param data  the new element to insert
     * @throws IndexOutOfBoundsException if the index is invalid
     */
    public void set(int index, T data) {
        if (isNotValidIndex(index)) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        Node current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        current.data = data;
    }
}
