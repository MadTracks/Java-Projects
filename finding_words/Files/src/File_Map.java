import java.util.*;

public class File_Map implements Map
{
    /*
    For this hashmap, you will use arraylists which will provide easy but costly implementation.
    Your should provide and explain the complexities for each method in your report.
    * */
   ArrayList<String> fnames = new ArrayList<String>();
   ArrayList<List<Integer>> occurances = new ArrayList<List<Integer>>();

    @Override
    public int size() {
        return fnames.size();
    }

    @Override
    public boolean isEmpty() {
        return fnames.isEmpty();
    }

    @Override
    public boolean containsKey(Object key) {
        return fnames.contains(key);
    }

    @Override
    public boolean containsValue(Object value) {
        for(int i=0; i<occurances.size(); i++) {
            if(occurances.get(i).contains(value)){
                 return true;
            }
        }
        return false;
    }

    @Override
    public Object get(Object key) {
        if(containsKey(key)){
            int index=fnames.indexOf(key);
            return occurances.get(index);
        }
        return null;
    }

    @Override
    /*Each put operation will extend the occurance list*/
    public Object put(Object key, Object value) {
        if(containsKey(key)){
            int index = fnames.indexOf(key);
            if(!containsValue(value)) {
                occurances.get(index).add((Integer) value);
                int returnindex = occurances.get(index).lastIndexOf(value);
                return occurances.get(index).get(returnindex - 1);
            }
            else{
                return null;
            }
        }
        fnames.add((String)key);
        int index = fnames.indexOf(key);
        List<Integer> newlist = new ArrayList<Integer>();
        newlist.add((Integer)value);
        occurances.add(newlist);
        return null;
    }

    @Override
    public Object remove(Object key) {
        if(containsKey(key)) {
            int index = fnames.indexOf(key);
            fnames.remove(index);
            List<Integer> ret = occurances.get(index);
            occurances.remove(index);
            return ret;
        }
        return null;
    }

    @Override
    public void putAll(Map m) {
        File_Map map = (File_Map) m;
        fnames.addAll(map.fnames);
        occurances.addAll(map.occurances);
    }

    @Override
    public void clear() {
        fnames.clear();
        occurances.clear();
    }

    @Override
    public Set keySet() {
        Set<String> set = new HashSet<String>();
        for(int i=0; i<fnames.size(); i++){
            set.add(fnames.get(i));
        }
        return set;
    }

    @Override
    public Collection values() {
        return occurances;
    }

    @Override
    public Set<Entry> entrySet() {
        return null;
    }

    @Override
    public String toString() {
        for(int i=0; i<fnames.size(); i++){
            System.out.print("File Map Key: " + fnames.get(i));
            for(int j=0; j<occurances.get(i).size(); j++){
                System.out.print(" File Map Value: " + occurances.get(i).get(j) + " ");
            }
        }
        return String.format("");
    }
}
