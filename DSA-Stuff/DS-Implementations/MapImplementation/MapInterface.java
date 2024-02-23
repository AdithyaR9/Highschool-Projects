

public interface MapInterface<K,V>
{
	public void clear();
	public boolean containsKey(K key);
	public boolean containsValue(V value);
	public V get(K o);
	public boolean isEmpty();
	public V put(K key, V value);
	public int size();
	public V remove(K key);

}