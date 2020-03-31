public class PopularityGraph {
    static class Vertex{
        private int person;
        public Vertex(int p){
            person = p;
        }
    }
    class LinkedList{
        class Node{
            Vertex data;
            Node next;
            public Node(Vertex v){
                data = v;
                next = null;
            }
        }

        Node head;

        public LinkedList(){

        }

        public void addlast(Vertex v){
            Node newadd = new Node(v);
            if(head == null){
                head = newadd;
            }
            else {
                Node temp = head;
                while (temp.next != null) {
                    temp = temp.next;
                }
                temp.next = newadd;
            }
        }
        public boolean contains(int ver){
            Node temp = head;
            while (temp != null) {
                if(temp.data.person == ver){
                    return true;
                }
                temp = temp.next;
            }
            return false;
        }

        @Override
        public String toString() {
            if(head==null){
                return String.format("");
            }
            if(head.next==null){
                System.out.print("[" + head.data.person +"]");
                return String.format("");
            }
            Node temp=head.next;
            while(temp!=null){
                System.out.print("[" + head.data.person +","+ temp.data.person + "] ");
                temp = temp.next;
            }
            return String.format("");
        }
    }
    public PopularityGraph(int s){
        size = s;
        AdjList = new LinkedList[size];
        for(int i=0; i<s; i++){
            AdjList[i] = new LinkedList();
        }
    }
    public void addEdge(int v1,int v2){
        for(int i=0; i<size; i++){
            if(AdjList[i].head == null){
                Vertex ver1 = new Vertex(v1);
                Vertex ver2 = new Vertex(v2);
                AdjList[i].addlast(ver1);
                AdjList[i].addlast(ver2);
                checkTransivite(v1,v2);
                addVertex(v2);
                return;
            }
            if(AdjList[i].head.data.person == v1){
                if(AdjList[i].contains(v2)){
                    return;
                }
                Vertex vnew = new Vertex(v2);
                AdjList[i].addlast(vnew);
                checkTransivite(v1,v2);
                addVertex(v2);
                return;
            }
        }
    }
    public void addVertex(int v){
        for(int i=0; i<size; i++) {
            if(AdjList[i].head == null) {
                Vertex ver = new Vertex(v);
                AdjList[i].addlast(ver);
            }
            if(AdjList[i].head.data.person == v){
                return;
            }
        }
    }
    public void checkTransivite(int v1,int v2){
        for(int i=0; i<size; i++) {
            if(AdjList[i].head == null) {
                return;
            }
            if(AdjList[i].head.data.person == v2){
                LinkedList.Node temp = AdjList[i].head.next;
                while(temp!=null){
                    addEdge(v1,temp.data.person);
                    temp=temp.next;
                }
            }
            if(AdjList[i].contains(v1)){
                LinkedList.Node temp = AdjList[i].head;
                while(temp!=null){
                    addEdge(AdjList[i].head.data.person,v2);
                    temp=temp.next;
                }
            }
        }
    }

    public int mostPopularPeopleNumber(){
        int mppn = 0;
        int tempperson;
        int nullsize = 0;
        boolean contain=true;
        for(int i=0; i<size; i++){
            if(AdjList[i].head == null){
                nullsize++;
            }
            else if(nullsize>1){
                return 0;
            }
            else {
                tempperson = AdjList[i].head.data.person;
                for (int j = 0; j < size; j++) {
                    if (AdjList[j].head != null && !AdjList[j].contains(tempperson)) {
                        contain=false;
                        j=size+1;
                    }
                }
                if(contain){
                    mppn++;
                }
                else{
                    contain=true;
                }
            }
        }
        return mppn;
    }

    @Override
    public String toString() {
        for(int i=0; i<size; i++){
            System.out.println(AdjList[i]);
        }
        return String.format("");
    }

    LinkedList[] AdjList;
    int size;
}
