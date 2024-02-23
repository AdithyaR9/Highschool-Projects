
import java.util.*;

//size
//remove
//is empty
//peek
//get
//add
//print
//exit in main


public class QueueClass<E> implements QueueInterface<E> {

    public ArrayList<E> classArray = new ArrayList<E>();

    public String print() {
        String s = "";
        for (int x = 0; x < classArray.size(); x++) {
            s+=classArray.get(x);
            s+= ", ";
        }
        return s;
    }

    @Override
    public boolean add(E o) {
        classArray.add(o);
        return true;
    }

    @Override
    public boolean offer(E o) {
        return false;
    }

    @Override
    public E peek() {
        return classArray.get(0);
    }

    @Override
    public E element() {
        return null;
    }

    @Override
    public E poll() {
        return null;
    }

    @Override
    public E remove() {
        return classArray.remove(0);
    }

    @Override
    public boolean empty() {
        if (classArray.size() == 0) {
            return true;
        } else return false;
    }

    @Override
    public int size() {
        return classArray.size();
    }

    @Override
    public E get(int x) {
        return classArray.get(x);
    }

}
