
public class collectionMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		LinkedList<Integer> mylist = new LinkedList<Integer>();
		ArrayList<Integer> myarray = new ArrayList<Integer>();
		HashSet<Integer> myset = new HashSet<Integer>();
		LinkedList<String> mylist2 = new LinkedList<String>();
		ArrayList<String> myarray2 = new ArrayList<String>();
		HashSet<String> myset2 = new HashSet<String>();
		
		
		
		Integer integer=1500;
		boolean test;
		boolean test2;
		myarray.add(10);
		myarray.add(8);
		myset.add(10);
		myset.add(5);
		mylist2.add("a");
		myset2.add("b");
		myarray2.add("c");
		
		mylist.add(5);
		mylist.add(42);
		mylist.add(4532);
		mylist.add(integer);
		mylist.remove(integer);
		mylist.offer(2345);
		test=myset.contains(5);
		mylist.add(15);
		mylist.print();
		mylist.clear();
		test2=mylist.isEmpty();
		System.out.printf("%d\n", mylist.size());
		if(test==true){
			System.out.printf("Contains\n");
		}
		if(test2==true){
			System.out.printf("List cleared");
		}
	}

}
