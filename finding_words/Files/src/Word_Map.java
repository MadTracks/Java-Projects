import java.util.*;

public class Word_Map implements Map, Iterable
{

    final static int INITCAP=10;  //initial capacity
    int CURRCAP = INITCAP;   //current capacity
    final static float LOADFACT = 0.75f;
    private Node table[];
    public File_Map filemap;
    public Word_Map() {
        this.table = new Node[INITCAP];
        filemap = new File_Map();
    }

    public MyIterator iter;
    public Node head;
    public class MyIterator implements Iterator{

        public MyIterator(Word_Map map){
            cursor = map.head;
        }

        @Override
        public boolean hasNext() {
            return cursor!=null;
        }

        @Override
        public Object next() {
            Object ret = cursor.getKey();
            cursor = cursor.next;
            return ret;
        }

        public Object valuenext(){
            Object ret = cursor.getValue();
            cursor =cursor.next;
            return ret;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
        private Node cursor;

    }

    @Override
    public Iterator iterator() {
        return new MyIterator(this);
    }

    static class Node {
        private Object value;
        private Object key;
        private Node next;

        public Node(Object k,Object v){
            key=k;
            value=v;
            next=null;
        }

        public Object getKey(){
            return key;
        }
        public Object getValue(){
            return value;
        }
    }

    @Override
    public int size() {
        iter=(MyIterator) iterator();
        int size = 0;
        while(iter.hasNext()){
            iter.next();
            size++;
        }
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size()<=0;
    }

    @Override
    /*Use linked structure instead of table index
    to perform search operation effectively
     * */
    public boolean containsKey(Object key) {
        iter=(MyIterator) iterator();
        while(iter.hasNext()){
            if(iter.next().equals(key)){
                return true;
            }
        }
        return false;
    }

    @Override
    /*Use linked structure instead of table index
    to perform search operation effectively
     * */
    public boolean containsValue(Object value) {
        iter=(MyIterator) iterator();
        while(iter.hasNext()){
            if(iter.valuenext().equals(value)){
                return true;
            }
        }
        return false;
    }

    @Override
    public Object get(Object key) {
        int keyhash = key.hashCode();
        keyhash = keyhash % CURRCAP;
        int i=keyhash;
        if(containsKey(key)) {
            while (table[i].key != key) {
                i++;
            }
        }
        return table[i].value;
    }

    @Override
    /*
    Use linear probing in case of collision
    * */
    public Object put(Object key, Object value) {
        if(size()<=0){
            int keyhash = key.hashCode();
            keyhash = keyhash % CURRCAP;
            while(keyhash<0){
                keyhash=keyhash+CURRCAP;
            }
            Node newnode = new Node(key,value);
            table[keyhash]=newnode;
            head=table[keyhash];
            return null;
        }
        else if(size()/CURRCAP*1.0 >= LOADFACT){
            Node[] newtable = new Node[CURRCAP*2];
            int NEWCURRCAP = CURRCAP * 2;
            for(int i=0; i<CURRCAP; i++){
                if(table[i]!=null){
                    int keyhash = table[i].key.hashCode();
                    keyhash = keyhash % NEWCURRCAP;
                    while(keyhash<0){
                        keyhash=keyhash+CURRCAP;
                    }
                    int j = keyhash;
                    while(newtable[j]!=null){
                        j++;
                        j = j % NEWCURRCAP;
                    }
                    if(newtable[j]==null) {
                        newtable[j] = table[i];
                    }
                }
            }
            table = newtable;
            CURRCAP = NEWCURRCAP;
        }
        iter=(MyIterator) iterator();
        while(iter.cursor.next != null){
            iter.next();
        }
        int keyhash = key.hashCode();
        keyhash = keyhash % CURRCAP;
        while(keyhash<0){
            keyhash=keyhash+CURRCAP;
        }
        Node newnode = new Node(key,value);
        int k = keyhash;
        while(table[k]!=null && !table[k].key.equals(key)){
            k++;
            k = k % CURRCAP;
        }
        if(table[k]==null) {
            table[k] = newnode;
            iter.cursor.next=newnode;
        }
        return null;
    }

    @Override
    /*You do not need to implement remove function
    * */
    public Object remove(Object key) {
        return null;
    }
    public File_Map callFile_Map(Object key){
        iter=(MyIterator) iterator();
        while(iter.hasNext()){
            if(iter.cursor.key.equals(key)){
                return (File_Map)iter.cursor.value;
            }
            iter.next();
        }
        return null;
    }
    public File_Map createFile_Map(Object k,Object v){
        filemap = callFile_Map(k);
        if(filemap == null) {
            filemap = new File_Map();
            filemap.put(k, v);
            return filemap;
        }
        filemap.put(k,v);
        return filemap;
    }

    @Override
    public void putAll(Map m) {
        Word_Map map = (Word_Map) m;
        for(int i=0; i<map.CURRCAP; i++){
            if(map.table[i]!=null){
                put(map.table[i].key,map.table[i].value);
            }
        }
    }

    @Override
    public void clear() {
        head=null;
        table = new Node[CURRCAP];
    }

    @Override
    /*Use linked structure instead of table index
    for efficiency
     * */
    public Set keySet() {
        Set<String> set = new HashSet<String>();
        iter=(MyIterator) iterator();
        while(iter.hasNext()){
            set.add((String)iter.cursor.key);
            iter.next();
        }
        return set;
    }

    @Override
    /*Use linked structure instead of table index
    for efficiency
     * */
    public Collection values() {
        ArrayList<File_Map> valuelist = new ArrayList<File_Map>();
        iter=(MyIterator) iterator();
        while(iter.hasNext()){
            valuelist.add((File_Map)iter.cursor.value);
            iter.next();
        }
        return valuelist;
    }

    @Override
    /*You do not need to implement entrySet function
     * */
    public Set<Entry> entrySet() {
        return null;
    }

    @Override
    public String toString() {
        iter=(MyIterator) iterator();
        while(iter.hasNext()){
            System.out.print("Key: " + iter.cursor.key + " Value: ");
            System.out.println(iter.cursor.value);
            iter.next();
        }
        return String.format("");
    }
}
