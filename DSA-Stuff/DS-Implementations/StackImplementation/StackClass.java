

import java.util.ArrayList;

public class StackClass<E> implements StackInterface<E> {

    public ArrayList<E> classArray = new ArrayList<E>();

    public String print() {
        String s = "";
        for (int x = 0; x < classArray.size(); x++) {
            s+=classArray.get(x);
        }
        return s;
    }

    @Override
    public E push(E o) {
        classArray.add(o);
        return o;
    }

    @Override
    public E peek() {
        return classArray.get(classArray.size()-1);
    }

    @Override
    public E pop() {
        return classArray.remove(classArray.size()-1);
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
        return classArray.get(classArray.size()-1);
    }
}
