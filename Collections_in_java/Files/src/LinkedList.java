
public class LinkedList<E> implements Queue<E>, List<E> {
	
	public LinkedList(){
		list = (E[]) new Object[1];
		
		iter = new Iterator<E>(list,lsize);
		
	}
	
	@Override
	public Iterator<E> iterator(){
		return iter;
	}
	
	@Override
	public void add(E e){
		lsize++;
		E[] templist = (E[]) new Object[lsize];
		for(int i=0; i<lsize-1; i++){
			templist[i]=list[i];
		}
		templist[lsize-1]=e;
		list=templist;
		update();
	}
	@Override
	public void addAll(Collection<E> c){
		lsize+=c.size();
		E[] templist = (E[]) new Object[lsize];
		for(int i=0; i<lsize-c.size(); i++){
			templist[i]=list[i];
		}
		int k=0;
		for(int j=lsize-c.size(); j<lsize; j++){
			templist[j]=c.iterator().iterElem();
			k++;
		}
		list=templist;
		update();
	}
	@Override
	public void clear(){
		list = (E[]) new Object[0];
		lsize=0;
		update();
	}
	@Override
	public boolean contains(E e){
		for(int i=0; i<lsize; i++){
			if(list[i]==e){
				return true;
			}
		}
		return false;
	}
	@Override
	public boolean containsAll(Collection<E> c){
		boolean ret;
		ret=false;
		for(int j=0; j<c.size(); j++)
		for(int i=0; i<lsize; i++){
			if(list[i]==c.iterator().iterElem()){
				ret=true;
			}
		}
		return ret;
	}
	@Override
	public boolean isEmpty(){
		if(iter.hasNext()==false){
			return true;
		}
		return false;
	}
	@Override
	public void remove(E e){
		for(int i=0; i<lsize; i++){
			if(list[i]==e){
				iter.remove();
				list=iter.getarray();
				lsize--;
			}
			iter.iterElem();
		}
		update();
	}
	@Override
	public void removeAll(Collection<E> c){
		for(int i=0; i<lsize; i++){
			if(list[i]==c.iterator().iterElem()){
				iter.remove();
			}
			else{
				iter.next();
			}
		}
		update();
	}
	@Override
	public void retainAll(Collection<E> c){
		
	}
	@Override
	public int size(){
		return lsize;
	}
	public E element(){
		return iter.iterElem();
	}
	public void offer(E e){
		lsize++;
		E[] templist = (E[]) new Object[lsize];
		for(int i=0; i<lsize-1; i++){
			templist[i]=list[i];
		}
		templist[lsize-1]=e;
		list=templist;
		update();
	}
	public void poll(){
		iter.remove();
	}
	
	public void print(){
		for(int i=0; i<lsize; i++)
		System.out.printf("%d\n", list[i]);
	}
	public void update(){
		iter = new Iterator<E>(list,lsize);
	}
	private E[] list;
	private int lsize;
	private Iterator<E> iter;
}
