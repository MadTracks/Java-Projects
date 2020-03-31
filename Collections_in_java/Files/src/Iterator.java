
public class Iterator<E> {
	public Iterator(E[] arr,int size){
		array=arr;
		iter=0;
		iterend=size-1;
		}
	public boolean hasNext(){
		if(iter>=iterend){
			return false;
		}
		else{
			return true;
		}
	}
	public E next(){
		iter++;
		return array[iter];
	}
	
	public void remove(){
		for(int i=iter; i<iterend; i++){
			array[i]=array[i+1];
		}
		iterend-=1;
	}

	public E iterElem(){
		iter++;
		return array[iter-1];
	}
	
	public E[] getarray(){
		return array;
	}
	
	private int iter;
	private int iterend;
	private E[] array;
}
