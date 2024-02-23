package HeapDisplay;

import java.util.ArrayList;

public class MaxHeap<E extends Comparable<E>> implements HeapInterface<E> {

    ArrayList<E> maxHeap = new ArrayList<>();

    @Override
    public boolean add(E item) {
        maxHeap.add(item);
        if (maxHeap.size() == 1)
            return true;

        for (int x = maxHeap.size() - 1; x >
                0; x = (x - 1) / 2) {

            if (maxHeap.get((x - 1) / 2).compareTo(maxHeap.get(x)) > 0) {
                return true;
            } else {
                E temp = maxHeap.get((x - 1) / 2);
                maxHeap.set((x - 1) / 2, maxHeap.get(x));
                maxHeap.set(x, temp);
            }
        }

        //  while (x >= 0 || maxHeap.get((x - 1) / 2).compareTo(maxHeap.get(x)) > 0) {
        //            // if ((x - 1) / 2 >= 0) {
        //            //if (maxHeap.get((x - 1) / 2).compareTo(maxHeap.get(x)) < 0) {
        //            temp = maxHeap.get((x - 1) / 2);
        //            maxHeap.set((x - 1) / 2, maxHeap.get(x));
        //            maxHeap.set(x, temp);
        //            //}
        //            x = (x - 1) / 2;
        //            //}
        //        }
        return true;
    }

    @Override
    public E remove() {

        if (maxHeap.size() == 0) {
            return null;
        } else if (maxHeap.size() == 1) {
            E var = maxHeap.get(0);
            clear();
            return var;
        } else {
            E temp;
            temp = maxHeap.get(0);
            maxHeap.set(0, maxHeap.get(maxHeap.size() - 1));
            maxHeap.set(maxHeap.size() - 1, temp);
            maxHeap.remove(maxHeap.size() - 1);
            int x = 0;
            while ((x * 2 + 1 < maxHeap.size() && maxHeap.get(x * 2 + 1).compareTo(maxHeap.get(x)) > 0) || (x * 2 + 1 < maxHeap.size() && x * 2 + 2 < maxHeap.size() && maxHeap.get(x * 2 + 2).compareTo(maxHeap.get(x)) > 0)) {

                if (maxHeap.get(x * 2 + 1).compareTo(maxHeap.get(x * 2 + 2)) > 0) {
                    E temp2 = maxHeap.get(x * 2 + 1);
                    maxHeap.set(x * 2 + 1, maxHeap.get(x));
                    maxHeap.set(x, temp2);
                    x = x * 2 + 1;
                } else {
                    E temp3 = maxHeap.get(x * 2 + 2);
                    maxHeap.set(x * 2 + 2, maxHeap.get(x));
                    maxHeap.set(x, temp3);
                    x = x * 2 + 2;
                }
            }
            return temp;
        }
    }

    //public void heapifyDown() {
    //        int x = 0;
    //        E temp2 = null;
    //
    //        while (maxHeap.get(x * 2 + 1).compareTo(maxHeap.get(x)) > 0 || maxHeap.get(x * 2 + 2).compareTo(maxHeap.get(x)) > 0) {
    //            if (x * 2 + 1 <= maxHeap.size() - 1 || x * 2 + 2 <= maxHeap.size() - 1) {
    //                if (maxHeap.get(x * 2 + 1).compareTo(maxHeap.get(x)) > 0 || maxHeap.get(x * 2 + 2).compareTo(maxHeap.get(x)) > 0) {
    //                    if (maxHeap.get(x * 2 + 1).compareTo(maxHeap.get(x * 2 + 2)) > 0) {
    //                        temp2 = maxHeap.get(x * 2 + 1);
    //                        maxHeap.set(x * 2 + 1, maxHeap.get(x));
    //                        maxHeap.set(x, temp2);
    //                        x = x * 2 + 1;
    //                    } else {
    //                        temp2 = maxHeap.get(x * 2 + 2);
    //                        maxHeap.set(x * 2 + 2, maxHeap.get(x));
    //                        maxHeap.set(x, temp2);
    //                        x = x * 2 + 2;
    //                    }
    //                }
    //            }
    //        }
    //    }

    @Override
    public boolean isEmpty() {
        return maxHeap.isEmpty();
    }

    @Override
    public int size() {
        return maxHeap.size();
    }

    @Override
    public E get(int x) {
        return maxHeap.get(x);
    }

    @Override
    public void clear() {
        maxHeap.clear();
    }

    public String toString() {
        //if(maxHeap.size() == 0){
        //            return "[]";
        //        }
        //
        //        String s = "";
        //
        //        for(int x = 0; x < maxHeap.size();x++){
        //            s=s+maxHeap.get(x) + ", ";
        //
        //        }
        //
        //        return  "[" + s
        //    }

        return maxHeap.toString();
    }
}






