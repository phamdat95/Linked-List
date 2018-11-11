public class MyList<E> {
    private Node<E> head = null;
    private Node<E> tail = null;
    private int size = 0;

    MyList(){}

    void add(int index, E e){
        if (index > size || index < 0){
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }else if (size == 0 || index == 0){
            addFirst(e);
        } else if (index == size){
            addLast(e);
        } else {
            Node<E> current = head;
            for (int i = 1; i < index; i++){
                current = current.next;
            }
            Node<E> temp = current.next;
            current.next = new Node<>(e);
            (current.next).next = temp;
            size++;
        }
    }
    void addFirst(E e){
        Node<E> newNode = new Node<>(e);
        newNode.next = head;
        head = newNode;
        size++;
        if (tail == null){
            tail = head;
        }
    }
    void addLast(E e){
        if(tail == null){
            addFirst(e);
        } else {
            Node<E> newNode = new Node<>(e);
            tail.next = newNode;
            tail = newNode;
            size++;
        }
    }
    E remove(int index){
        Node<E> current = head;
        for (int i=0; i < index-1; i++){
            current = current.next;
        }
        Node<E> temp;
        if (index > size || index < 0){
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        } else if (index == size-1){
            temp = current.next;
            tail = current;
            tail.next = null;
        } else if (index == 0){
            temp = current;
            head = current.next;
        } else {
            temp = current.next;
            current.next = current.next.next;
        }
        size--;
        return temp.element;
    }
    boolean remove(Object o){
        boolean remove = false;
        Node<E> current = head;
        int i;
        if (current.element == o){
            remove = true;
            head = current.next;
            size--;
        } else {
            for (i=1; i < size; i++){
                if (current.next.element == o){
                    remove = true;
                    current.next = current.next.next;
                    size--;
                    break;
                }
                current = current.next;
            }
        }
        return remove;
    }
    int size(){
        return size;
    }
    boolean contains(E o){
        boolean contains = false;
        Node<E> current = head;
        int i;
        for (i=0; i < size; i++){
            if (current.element == o){
                contains = true;
                break;
            }
            current = current.next;
        }
        return contains;
    }
    int indexOf(E o){
        Node<E> current = head;
        int i;
        for (i=0; i < size; i++){
            if (current.element == o){
                break;
            }
            current = current.next;
        }
        return i;
    }
    boolean add(E e){
        Node<E> newNode = new Node<>(e);
        tail.next = newNode;
        tail = newNode;
        size++;
        return true;
    }

    E get(int index){
        Node<E> current = head;
        for (int i=1; i < index; i++){
            current = current.next;
        }
        return current.next.element;
    }
    E getFirst(){
        return head.element;
    }
    E getLast(){
        return tail.element;
    }
    void clear(){
        head = null;
        tail = null;
        size = 0;
    }
    void print(){
        Node<E> current = head;
        int i;
        System.out.print("[");
        for (i = 1; i < size; i++){
            System.out.print(current.element + ", ");
            current=current.next;
        }
        if (i == size){
            System.out.println(current.element + "]");
        }
    }
}
