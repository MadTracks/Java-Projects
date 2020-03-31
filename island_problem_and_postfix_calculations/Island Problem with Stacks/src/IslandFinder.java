import java.util.NoSuchElementException;
import java.util.Scanner;

public class IslandFinder {
    public class MyStack<E>{

        public MyStack(){
            array = (E[]) new Object[20];
            size = 0;
            capacity = 20;
        }
        public boolean empty(){
            return size==0;
        }
        public E peek(){
            if(empty()){
                throw new NoSuchElementException();
            }
            return array[size];
        }
        public E pop(){
            if(empty()){
                throw new NoSuchElementException();
            }
            size--;
            return array[size+1];
        }
        public E push(E item){
            if(size>=capacity){
                reallocate();
            }
            size++;
            array[size]=item;
            return array[size];
        }
        private void reallocate(){
            E[] newarray = (E[]) new Object[20+capacity];
            for(int i=0; i<size; i++){
                newarray[i]=array[i];
            }
            capacity+=20;
            array=newarray;
        }
        private E[] array;
        private int size;
        private int capacity;
    }
    public class CoorPair{
        private int x,y;
        CoorPair(int ax,int ay){
            x=ax;
            y=ay;
        }
        public int getx(){
            return x;
        }
        public int gety(){
            return y;
        }
    }
    public void recreateMap(int maprow,int mapcolomn){
        int[][] newmap = new int[maprow][mapcolomn];
        for(int i=0;i<row; i++){
            for(int j=0; j<colomn; j++){
                newmap[i][j]=map[i][j];
            }
        }
        map=newmap;
        row=maprow;
        colomn=mapcolomn;
    }
    public void setMap(int rw,int colm,int element){
        map[rw][colm]=element;
    }
    public int findIsland(){
       int islandCounter=0;
       String islandseperator = "abcdefghijklmnopqrstuvwxyz";
       char islandindex= islandseperator.charAt(islandCounter);
       intToCharConverter();
       for(int i=0; i<row; i++){
           for(int j=0; j<colomn; j++){
               if(charmap[i][j]=='1'){
                   charmap[i][j]=islandindex;
                   CoorPair coor = new CoorPair(i,j);
                   stack.push(coor);
                   while(!stack.empty()){
                       if(stack.peek().gety()<colomn-1 && charmap[stack.peek().getx()][stack.peek().gety()+1]=='1'){
                           CoorPair newcoor = new CoorPair(stack.peek().getx(),stack.peek().gety()+1);
                           charmap[stack.peek().getx()][stack.peek().gety()+1]=islandindex;
                           stack.push(newcoor);
                       }
                       else if(stack.peek().getx()<row-1 && charmap[stack.peek().getx()+1][stack.peek().gety()]=='1'){
                           CoorPair newcoor = new CoorPair(stack.peek().getx()+1,stack.peek().gety());
                           charmap[stack.peek().getx()+1][stack.peek().gety()]=islandindex;
                           stack.push(newcoor);
                       }
                       else if(stack.peek().gety()>0 && charmap[stack.peek().getx()][stack.peek().gety()-1]=='1'){
                           CoorPair newcoor = new CoorPair(stack.peek().getx(),stack.peek().gety()-1);
                           charmap[stack.peek().getx()][stack.peek().gety()-1]=islandindex;
                           stack.push(newcoor);
                       }
                       else if(stack.peek().getx()>0 && charmap[stack.peek().getx()-1][stack.peek().gety()]=='1'){
                            CoorPair newcoor = new CoorPair(stack.peek().getx()-1,stack.peek().gety());
                            charmap[stack.peek().getx()-1][stack.peek().gety()]=islandindex;
                            stack.push(newcoor);
                       }
                       else{
                           stack.pop();
                       }
                   }
                   islandCounter++;
                   islandindex = islandseperator.charAt(islandCounter);
               }
           }
       }
       return islandCounter;
    }
    public void intToCharConverter(){
        charmap = new char[row][colomn];
        for(int i=0;i<row; i++){
            for(int j=0; j<colomn; j++){
                charmap[i][j]=(char)(map[i][j]+48);
            }
        }
    }
    public IslandFinder(){
        map = new int[1][30];
        stack = new MyStack<CoorPair>();
        row=1;
        colomn=30;
    }
    @Override
    public String toString(){
        for(int i=0; i<row; i++){
            for(int j=0; j<colomn; j++){
                System.out.printf("%c ",charmap[i][j]);
            }
            System.out.printf("\n");
        }
        return String.format("");
    }
    private int[][] map;
    private char[][] charmap;
    private int row;
    private int colomn;
    private MyStack<CoorPair> stack;
}
