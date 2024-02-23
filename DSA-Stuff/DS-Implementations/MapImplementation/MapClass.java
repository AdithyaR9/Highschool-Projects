
import java.util.ArrayList;

public class MapClass<K, V> implements MapInterface<K, V> {

    private ArrayList<MapEnt<K, V>> data = new ArrayList<>();

    public String print() {
        String s = "[";
        for (int x = 0; x < data.size(); x++) {
            s += data.get(x);
            if (data.size() - 1 != x) {
                s += ", ";
            }
        }
        s += "]";
        return s;
    }

    @Override
    public void clear() {
        data.clear();
    }

    @Override
    public boolean containsKey(K key) {

        for (int x = 0; x < data.size(); x++) {
            if (data.get(x).getKey() == key) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean containsValue(V value) {

        for (int x = 0; x < data.size(); x++) {
            if (data.get(x).getValue() == value) {
                return true;
            }
        }
        return false;
    }

    @Override
    public V get(K o) {

        for (int x = 0; x < data.size(); x++) {
            if (data.get(x).getKey() == o) {
                return data.get(x).getValue();
            }
        }
        return null;
    }

    @Override
    public boolean isEmpty() {
        if (data.size() > 0) {
            return true;
        } else return false;
    }

    @Override
    public V put(K key, V value) {
        V oldV;
        oldV = null;

        for (int x = 0; x < data.size(); x++) {
            if (data.get(x).getKey() == key)

                oldV = data.get(x).getValue();
            data.get(x).setValue(value);
        }
        return oldV;
    }


    @Override
    public int size() {
        return data.size();
    }

    @Override
    public V remove(K key) {

        for (int x = data.size(); x > 0; x--) {
            if (data.get(x).getKey() == key)
                return data.get(x).getValue();
            data.remove(x);
        }
        return null;
    }


}


