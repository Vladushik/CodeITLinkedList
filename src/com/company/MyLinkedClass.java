package com.company;

public class MyLinkedClass<E> implements SimpleLinkedList<E> {

    Node<E> first;
    Node<E> last;
    private int size = 0;

    private static class Node<E> {

        E item;
        Node<E> next;
        Node<E> prev;
        Node(Node<E> prev, E item, Node<E> next) {
            this.item = item;
            this.next = next;
            this.prev = prev;
        }
    }

    @Override
    public int size() {
        return size;
    }



    @Override
    public void add(int index, E element) throws RuntimeException {
        if (index < 0) {
            throw new RuntimeException("No Index");
        }
        if (index == 0) {
            addFirst(element);
            return;
        }
        if (index == size) {
            addLast(element);
            return;
        }
        Node<E> temp = first;
        for (int i = 0; i < index - 1; i++) {
            temp = temp.next;
        }
        Node<E> newNode = new Node<E>(temp, element, temp.next);
        temp.next.prev = newNode;
        temp.next = newNode;
        size++;
    }

    //
    @Override
    public void remove(int index) throws RuntimeException {
        if (index < 0 || index >= size) return;
        Node temp = first;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        if (index == 0) {
            first = temp.next;
        }
        else {
            temp.prev.next = temp.next;
        }
        size--;
    }

    @Override
    public void clear() {
        Node<E> i;
        for (i = first; i != null; ) {
            Node<E> next = i.next;
            i.item = null;
            i.next = null;
            i.prev = null;
            i = next;
        }
        first = last = null;
        size = 0;
    }

    @Override
    public int indexOf(E element) throws RuntimeException {
        int index = 0;
        Node<E> temp;
        if (element == null) {
            for (temp = first; temp != null; temp = temp.next, index++) {
                if (temp.item == null) {
                    return index;
                }
            }
        } else {
            for (temp = first; temp != null; temp = temp.next, index++) {
                if (element.equals(temp.item)) {
                    return index;
                }
            }
        }
        return -1;
    }

    private void addLast(E data) {
        if ( size == 0){
            first = last = new Node<E>(null,data, null);
        } else {
            last.next = new Node<E>(last, data, null);
            last = last.next;
        }
        size++;
    }


    private  void addFirst(E data) {
        if ( size == 0){
            first = last = new Node<E>(null,data, null);
        } else {
            first.prev = new Node<E>(null, data, first);
            first = first.prev;
        }
        size++;
    }
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        Node<E> temp = first;
        while (temp != null) {
            sb.append(temp.item);
            if (temp.next != null) {
                sb.append(", ");
            }
            temp = temp.next;
        }
        sb.append("]");
        return sb.toString();
    }



}