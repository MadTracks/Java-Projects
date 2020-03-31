import java.util.NoSuchElementException;

public class Calculator {
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
    public int ProcessPriority(char c){
        if(c=='+' || c=='-'){
            return 1;
        }
        else if(c=='*' || c=='/'){
            return 2;
        }
        return -1;
    }
    public String infixToPostfix(String infix){
        postfix = new String("");
        infix+=' ';
        MyStack<Character> newstack = new MyStack<Character>();
        for(int i=0; i<infix.length(); i++){
            char charc = infix.charAt(i);
            if(Character.isLetterOrDigit(charc)){
                if(charc>='0' && charc<='9') {
                    int m=i;
                    while(infix.length()>m && infix.charAt(m)>='0' && infix.charAt(m)<='9' || infix.charAt(m)=='.'){
                        m++;
                    }
                    String num=infix.substring(i,m);
                    postfix+= num;
                    i=m-1;
                    postfix+= " ";
                }
                else if(charc=='s'){
                    if(infix.charAt(i+1)=='i'){
                        int k=i+3;
                        while(infix.charAt(k)!=')'){
                            k++;
                        }
                        String insidepostfix=infixToPostfix(infix.substring(i+3,k+1));
                        postfix+="sin";
                        postfix+=insidepostfix;
                        i=k;
                    }
                }
                else if(charc=='c'){
                    if(infix.charAt(i+1)=='o'){
                        int k=i+3;
                        while(infix.charAt(k)!=')'){
                            k++;
                        }
                        String insidepostfix=infixToPostfix(infix.substring(i+3,k+1));
                        postfix+="cos";
                        postfix+=insidepostfix;
                        i=k;
                    }
                }
                else if(charc=='a'){
                    if(infix.charAt(i+1)=='b'){
                        int k=i+3;
                        while(infix.charAt(k)!=')'){
                            k++;
                        }
                        String insidepostfix=infixToPostfix(infix.substring(i+3,k+1));
                        postfix+="abs";
                        postfix+=insidepostfix;
                        i=k;
                    }
                }
                else{
                   if(infix.charAt(i+1)=='='){
                       i=i+1;
                       int m=i+2;
                        while(infix.charAt(m)>='0' && infix.charAt(m)<='9' || infix.charAt(m)=='.'){
                            m++;
                        }
                        String num=infix.substring(i,m);
                        i=m-1;
                        if(size==capacity){
                            reallocate();
                        }
                        variables[size]=charc;
                        values[size]=(double)infix.charAt(i);
                        size++;
                    }
                    postfix+=charc;
                    postfix+=' ';

                }
            }
            else if(charc==' '){
            }
            else if(charc=='.'){
                postfix+=charc;
            }
            else if(charc == '('){
                newstack.push(charc);
            }
            else if(charc == ')'){
                while(!newstack.empty() && newstack.peek()!='('){
                    postfix+=newstack.pop();
                    postfix+=' ';
                }
                if(!newstack.empty() && newstack.peek()!='('){
                    throw new ArithmeticException();
                }
                else{
                    newstack.pop();
                }
            }
            else{
                while(!newstack.empty() && ProcessPriority(charc) <= ProcessPriority(newstack.peek())){
                    postfix+=newstack.pop();
                }
                newstack.push(charc);
            }
        }
        while(!newstack.empty()){
            postfix+=newstack.pop();
        }
        return postfix;
    }
    public double postfixCalc(){
        for(int i=0; i<postfix.length(); i++){
            char charc=postfix.charAt(i);
            if(charc == ' '){
            }
            else if(Character.isDigit(charc)){
                double m=0;
                double num=0.0;
                int basement=0;
                while(Character.isDigit(charc) || charc=='.'){
                    boolean intpart=true;
                    if(charc=='.'){
                        num=m;
                        m=0;
                        intpart=false;
                        i++;
                        charc=postfix.charAt(i);
                    }
                    if(intpart) {
                        m = m * 10 + (double) (charc - '0');
                        i++;
                        charc = postfix.charAt(i);
                    }
                    else{
                        m = m * 10 + (double) (charc - '0');
                        basement--;
                        i++;
                        charc = postfix.charAt(i);
                    }
                }
                if(basement<0){
                    m=m*pow(10,basement);
                }
                m+=num;
                i--;
                stack.push(m);
            }
            else if(Character.isLetter(charc)){
                int j=0;
                while(charc==variables[j]){
                    j++;
                }
                stack.push(values[j]);
            }
            else {
                double num1 = stack.pop();
                double num2 = stack.pop();
                switch (charc) {
                    case '+':
                    stack.push(num2+num1); break;
                    case '-':
                    stack.push(num2-num1); break;
                    case '/':
                    stack.push(num2/num1); break;
                    case '*':
                    stack.push(num2*num1); break;
                }
            }
        }
        return stack.pop();
    }
    public double factorial(int n){
        double j=1;
        for(int i=1; i<=n; i++){
            j=i*j;
        }
        return j;
    }
    public double pow(double x,int n){
        double j=1;
        if(n>=0) {
            for (int i=1;i<=n;i++) {
                j = x*j;
            }
        }
        else{
            for(int i=-1;i>=n;i--){
                j = j/x;
            }
        }
        return j;
    }
    public double sin(double x){
        double division;
        double result=0;
        for(int n=0; n<=6; n++){
            division=pow(x,2*n+1)*pow((-1),n)/factorial(2*n+1);
            result+=division;
        }
        return result;
    }
    public double cos(double x){
        return sin(90.0-x);
    }
    public double abs(double x){
        if(x<0){
            return -x;
        }
        return x;
    }
    public void reallocate(){
        Double[] newarray = new Double[5+capacity];
        Character[] newcharacters = new Character[5+capacity];
        for(int i=0; i<size; i++){
            newarray[i]=values[i];
            newcharacters[i]=variables[i];
        }
        capacity+=5;
        values=newarray;
        variables=newcharacters;
    }
    public Calculator(){
        stack = new MyStack<Double>();
        values = new Double[5];
        variables = new Character[5];
        capacity = 5;
        size = 0;
    }
    private String postfix;
    private MyStack<Double> stack;
    private Double[] values;
    private Character[] variables;
    private int capacity;
    private int size;
}
