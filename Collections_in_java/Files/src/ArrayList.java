
public class ArrayList<E> implements List<E> {
	
	public ArrayList(){
		array = (E[]) new Object[1];
		
		iter = new Iterator<E>(array,asize);
		
	}
	@Override
	public Iterator<E> iterator(){
		return iter;
	}
	
	@Override
	public void add(E e){
		asize++;
		E[] temparray = (E[]) new Object[asize];
		for(int i=0; i<asize-1; i++){
			temparray[i]=array[i];
		}
		temparray[asize-1]=e;
		array=temparray;
		update();
	}
	@Override
	public void addAll(Collection<E> c){
		asize+=c.size();
		E[] temparray = (E[]) new Object[asize];
		for(int i=0; i<asize-c.size(); i++){
			temparray[i]=array[i];
		}
		int k=0;
		for(int j=asize-c.size(); j<asize; j++){
			temparray[j]=c.iterator().iterElem();
			k++;
		}
		array=temparray;
		update();
	}
	@Override
	public void clear(){
		array = (E[]) new Object[0];
		asize=0;
		update();
	}
	@Override
	public boolean contains(E e){
		for(int i=0; i<asize; i++){
			if(array[i]==e){
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
		for(int i=0; i<asize; i++){
			if(array[i]==c.iterator().iterElem()){
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
		for(int i=0; i<asize; i++){
			if(array[i]==e){
				iter.remove();
			}
			else{
				iter.next();
			}
		}
		update();
	}
	@Override
	public void removeAll(Collection<E> c){
		for(int i=0; i<asize; i++){
			if(array[i]==c.iterator().iterElem()){
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
		for(int i=0; i<asize; i++){
			if(array[i]!=c.iterator().iterElem()){
				iter.remove();
			}
			else{
				iter.next();
			}
		}
		update();
	}
	@Override
	public int size(){
		return asize;
	}
	
	public void print(){
		for(int i=0; i<asize; i++)
		System.out.printf("%d\n", array[i]);
	}
	public void update(){
		iter = new Iterator<E>(array,asize);
	}
	
	private E[] array;
	private int asize;
	private Iterator<E> iter;
}
