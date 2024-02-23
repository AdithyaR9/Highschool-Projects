
public class LinkedList<E> {

    LLNode<E> first, last;
    private int numNodes = 0;

    public void print() {
        LLNode<E> n = first;

        while (n != null) {
            System.out.println(n.getData());
            n = n.getNext();
        }

    }

    public LinkedList() {

        first = null;
        last = null;
    }

    public LinkedList(E data) {
        first = new LLNode<>(data);
        last = new LLNode<>(data);
    }

    public E getFirst() {
        return first.getData();
    }

    public LLNode<E> getFirstNode() {
        return first;
    }

    public E getLast() {
        return last.getData();
    }

    public LLNode<E> getLastNode() {
        return last;
    }

    public E removeFirst() {
        E data = first.getData();
        first = first.getNext();
        return data;
    }

    public E removeLast() {
        //LLNode<E> n = first;
        //        LLNode<E> removed = null;
        //
        //        while (n.getNext().getNext() != null) {
        //            n = n.getNext();
        //        }
        //        removed.setData(n.getNext().getData());
        //        n.setNext(null);
        //        last = n;
        //        return removed.getData();
        if (first == null) {
            return null;
        } else if (first.getNext() == null) {
            E data = first.getData();
            clear();
            return data;
        } else {
            LLNode<E> n = first;
            while (n.getNext().getNext() != null) {
                n = n.getNext();
            }
            E data = n.getNext().getData();
            n.setNext(null);
            return data;
        }

    }

    public void addFirst(E data) {
        LLNode<E> n = new LLNode<>(data);

        if (first == null) {
            first = n;
            last = n;
        } else {
            n.setNext(first);
            last = first;
            first = n;
        }
    }

    public void addLast(E data) {
        LLNode<E> n = new LLNode<>(data);

        if (first == null) {
            first = n;
            last = n;
        } else {
            last.setNext(n);
            last = n;
        }
    }

    public void clear() {
        first = null;
        last = null;
    }

    public int size() {
        if (first == null) {
            return 0;
        }
        if (first != null && first.getNext() == null) {
            return 1;
        }
        LLNode<E> n = first;
        int counter = 1;
        while (n.getNext() != null) {
            n = n.getNext();
            counter++;
        }
        return counter;
    }

    public boolean isEmpty() {
        if (first == null && last == null) {
            return true;
        } else return false;
    }

    public E get(int x) {
        if (first == null) {
            return null;
        }
        LLNode<E> n = first;
        int index = 0;
        while (n.getNext() != null) {
            n = n.getNext();
            index++;
            if (index == x) {
                return n.getData();
            }
        }
        return null;
    }

    public E remove(int x) {
        // if (first == null) {
        //            return null;
        //        }
        //        LLNode<E> before = first;
        //        LLNode<E> current = null;
        //        LLNode<E> after = null;
        //        int index = 0;
        //        while (before.getNext() != null) {
        //            before = before.getNext();
        //            if (index == x - 1 && before.getNext() != null) {
        //                current = before.getNext();
        //                after = current.getNext();
        //                before.setNext(after);
        //                return current.getData();
        //            }
        //            index++;
        //        }
        //        return null;
        if (first == null) {
            return null;
        } else if (x == 0) {
            return removeFirst();
        } else {
            LLNode<E> n = first;
            for (int a = 0; a < x - 1; a++) {
                if (n != null) {
                    n = n.getNext();
                }
            }
            if (n == null || n.getNext() == null) {
                return null;
            }
            E data = n.getNext().getData();
            n.setNext(n.getNext().getNext());
            return data;
        }
    }

    public void add(int x, E data) {
        // if (first == null) {
        //            addFirst(data);
        //        } else if (x == size() - 1) {
        //            addLast(data);
        //        } else {
        //            LLNode<E> n = first;
        //            LLNode<E> temp;
        //            for (int i = 0; i < x - 1 && n.getNext() != null; i++) {
        //                n = n.getNext();
        //            }
        //            temp = n.getNext();
        //            n.setNext(new LLNode<>(data));
        //            n.getNext().setNext(temp);
        //        }
        if (first == null) {
            addFirst(data);
        } else if (x == 0) {
            addFirst(data);
        } else {
            LLNode<E> n = first;
            for (int a = 0; a < x - 1; a++) {
                if (n != null)
                    n = n.getNext();
            }
            if (n != null) {
                LLNode<E> temp = n.getNext();
                n.setNext(new LLNode<E>(data));
                n.getNext().setNext(temp);
            }

        }
    }

    public E set(int x, E data) {
        LLNode<E> removed = null;
        LLNode<E> n = first;
        int index = 0;

        if (first == null) {
            return null;
        }
        if (x == size() - 1) {
            removed.setData(last.getData());
            last.setData(data);
            return removed.getData();
        }
        while (n.getNext() != null) {
            n = n.getNext();
            if (index == x) {
                removed.setData(n.getData());
                n.setData(data);
            }
            index++;
        }
        return removed.getData();
    }

    public String toString() {
        return null;
    }

}
