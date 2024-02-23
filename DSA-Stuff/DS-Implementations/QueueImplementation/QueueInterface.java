
public interface QueueInterface<E>
{
	public boolean add(E o);
	public boolean offer(E o);

	public E peek();
	public E element();

	public E poll();
	public E remove();

	public boolean empty();

	public int size();
	public E get(int x);
}
