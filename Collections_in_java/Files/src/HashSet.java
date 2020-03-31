
public class HashSet<E> implements Set<E> {
	
	public HashSet(){
		set = (E[]) new Object[1];
		
		iter = new Iterator<E>(set,ssize);
		
	}
	
	
	@Override
	public Iterator<E> iterator(){
		return iter;
	}
	
	@Override
	public void add(E e){
		if(contains(e)!=true){
			ssize++;
			E[] tempset = (E[]) new Object[ssize];
			for(int i=0; i<ssize-1; i++){
				tempset[i]=set[i];
			}
			tempset[ssize-1]=e;
			set=tempset;
			update();
		}
	}
	@Override
	public void addAll(Collection<E> c){
		for(int l=0; l<c.size(); l++){
			if(contains(c.iterator().iterElem())!=true){
				ssize+=c.size();
				E[] tempset = (E[]) new Object[ssize];
				for(int i=0; i<ssize-c.size(); i++){
					tempset[i]=set[i];
				}
				int k=0;
				for(int j=ssize-c.size(); j<ssize; j++){
					tempset[j]=c.iterator().iterElem();
					k++;
				}
				set=tempset;
				update();
			}
		}
	}
	@Override
	public void clear(){
		set = (E[]) new Object[0];
		ssize=0;
		update();
	}
	@Override
	public boolean contains(E e){
		for(int i=0; i<ssize; i++){
			if(set[i]==e){
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
		for(int i=0; i<ssize; i++){
			if(set[i]==c.iterator().iterElem()){
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
		for(int i=0; i<ssize; i++){
			if(set[i]==e){
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
		for(int i=0; i<ssize; i++){
			if(set[i]==c.iterator().iterElem()){
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
		for(int i=0; i<ssize; i++){
			if(set[i]!=c.iterator().iterElem()){
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
		return ssize;
	}
	
	public void print(){
		for(int i=0; i<ssize; i++)
		System.out.printf("%d\n", set[i]);
	}
	public void update(){
		iter = new Iterator<E>(set,ssize);
	}
	
	private E[] set;
	private int ssize;
	private Iterator<E> iter;
}
