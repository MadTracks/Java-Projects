import java.util.Comparator;

public class PriorityQ {
    public PriorityQ(Comparator c){
        capacity = 100;
        size = 0;
        array = new RGBcolor[capacity];
        comp = c;
    }
    private void reallocate(){
        int i=0;
        RGBcolor[] temp = new RGBcolor[capacity*2];
        while(i<size){
            temp[i]=array[i];
            i++;
        }
        capacity*=2;
        array=temp;
    }
    private int parent(int i){
        return (i-1)/2;
    }
    private int left(int i){
        return 2*(i+1)-1;
    }
    private int right(int i){
        return 2*(i+1);
    }
    private void swap(int i,int j){
        RGBcolor temp;
        temp=array[i];
        array[i]=array[j];
        array[j]=temp;
    }
    public synchronized void insert(RGBcolor p){
        if(size>=capacity){
            reallocate();
        }
        else if(size==0){
            array[size]=p;
            size++;
        }
        else{
            array[size]=p;
            int temp=size;
            int control = comp.compare(array[parent(temp)],array[temp]);
            while(control == 1) {
                swap(parent(temp), temp);
                temp = parent(temp);
                control = comp.compare(array[parent(temp)], array[temp]);
            }
            size++;
        }
        notifyAll();
    }
    public synchronized RGBcolor remove_max() throws InterruptedException {
        while(size==0){
            wait();
        }
        if(size==1){
            size--;
            return array[0];
        }
        swap(0,size-1);
        RGBcolor returnelement = array[size-1];
        size--;
        int temp = 0;
        while(left(temp)<size && comp.compare(array[temp], array[left(temp)])==1) {
            //System.out.println(size);
            if(right(temp)<size) {
                int control1 = comp.compare(array[temp], array[left(temp)]);
                int control2 = comp.compare(array[temp], array[right(temp)]);
                if (control1 == 1 && control2 == 0) {
                    swap(temp, left(temp));
                    temp = left(temp);
                } else if (control1 == 0 && control2 == 1) {
                    swap(temp, right(temp));
                    temp = right(temp);
                } else if (control1 == 1 && control2 == 1) {
                    int control3 = comp.compare(array[left(temp)], array[right(temp)]);
                    if (control3 == 0) {
                        swap(temp, left(temp));
                        temp = left(temp);
                    } else {
                        swap(temp, right(temp));
                        temp = right(temp);
                    }
                } else {
                    temp = size;
                }
            }
            else{
                int control4 = comp.compare(array[temp], array[left(temp)]);
                if (control4 == 1) {
                    swap(temp, left(temp));
                    temp = left(temp);
                }
            }
        }
        return returnelement;
    }
    public boolean isEmpty(){
        return (size<=0);
    }
    @Override
    public String toString() {
        for(int i=0; i<size; i++){
            System.out.println(array[i]);
        }
        return String.format("");
    }
    public int size(){
        return size;
    }
    private RGBcolor[] array;
    private int size;
    private int capacity;
    private Comparator comp;
}
