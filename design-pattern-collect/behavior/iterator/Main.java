package behavior.iterator;

interface Iterator_<E> {
    boolean hasNext();
    E next();
}

interface Collection_<E> {
    void add(E element);
    Iterator_<E> iterator();
}

class ArrayList_<E> implements Collection_<E> {
    Iterator_<E> iterator_ = new ArrayListIterator();
    @SuppressWarnings("unchecked") 
    E[] elements = (E[]) new Object[10];
    private int index = 0;

    public Iterator_<E> iterator() {
        return iterator_;
    }

    public void add(E element) {
        if (index == elements.length) {
            @SuppressWarnings("unchecked") 
            E[] newElements = (E[]) new Object[2 * elements.length];
            System.arraycopy(elements, 0, newElements, 0, elements.length);
            elements = newElements;
        }
        elements[index] = element;
        index++;
    }

    private class ArrayListIterator implements Iterator_<E> {
        private int currentIndex = 0;
        @Override
        public boolean hasNext() {
            if (currentIndex < index) {
                return true;
            }
            return false;
        }

        @Override
        public E next() {
            return elements[currentIndex++];
        }

    }
}

class Node<E> {
    public E data;
    public Node<E> next = null;

    public Node(E data) {
        this.data = data;
    }
}

class LinkList_<E> implements Collection_<E> {
    public Node<E> head = null;
    public Node<E> tail = null;
    public Iterator_<E> LinkListIterator = new LinkListIterator();

    public void add(E element) {
        if (head == null) {
            head = new Node<E>(element);
            tail = head;
            return;
        }

        tail.next = new Node<E>(element);
        tail = tail.next;
    }

    public Iterator_<E> iterator() {
        return LinkListIterator;
    }

    private class LinkListIterator implements Iterator_<E> {

        @Override
        public boolean hasNext() {
            if (head != null) {
                return true;
            }
            return false;
        }

        @Override
        public E next() {
            E element = head.data;
            head = head.next;
            return element;
        }

    } 
}

public class Main {
    public static void main(String[] args) {
        ArrayList_<Integer> linkList_ = new ArrayList_<>();

        for (int i = 0; i < 15; i++) {
            linkList_.add(i);
        }

        Iterator_<Integer> iterator_ = linkList_.iterator();

        while(iterator_.hasNext()) {
            System.out.println(iterator_.next());
        }
    }
}

