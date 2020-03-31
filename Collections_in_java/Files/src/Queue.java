
public interface Queue<E> extends Collection<E> {
	
	public E element();
	public void offer(E e);
	public void poll();
}
