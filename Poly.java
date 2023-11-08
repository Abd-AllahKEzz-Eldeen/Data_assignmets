import java.util.*;
interface IPolynomialSolver {
    void setPolynomial(char poly, int[][] terms);
    String print(char poly);
    void clearPolynomial(char poly);
    float evaluatePolynomial(char poly, float value);
    int[][] add(char poly1, char poly2);
    int[][] subtract(char poly1, char poly2);
    int[][] multiply(char poly1, char poly2);
}
class Object { int data;Object next;
}
public class PolynomialSolver implements IPolynomialSolver{

    static PolynomialSolver A     = new PolynomialSolver();
    static PolynomialSolver B     = new PolynomialSolver();
    static PolynomialSolver C     = new PolynomialSolver();
    static PolynomialSolver R     = new PolynomialSolver();
    static PolynomialSolver A_exp = new PolynomialSolver();
    static PolynomialSolver B_exp = new PolynomialSolver();
    static PolynomialSolver C_exp = new PolynomialSolver();
    static PolynomialSolver R_exp = new PolynomialSolver();
    Object head = null;Object lastN = null;int size  = 0;
    /* Implement your linked list class here*/

    public void add(Object element) {

        if(size == 0) {
            head = element;
            lastN = element;
            size++;
        }
        else {
            lastN.next = element;
            lastN = element;
            size ++;}}
    public void display(){
        if(size == 0){
            System.out.print("[]");
            return;
        }
        Object pointer = head;
        System.out.print("[" + head.data);
        for(int i = 0;i<size-1;i++){
            pointer = pointer.next;
            System.out.print(", " + pointer.data);
        }
        System.out.println("]");}
    public void setPolynomial(char poly, int[][] terms){
        PolynomialSolver set = new PolynomialSolver();
        if(poly == 'A'){
            set = A;
        }else if(poly == 'B'){
            set = B;
        }else if(poly == 'C'){
            set = C;
        }

    }
    public int size() {
        return size;
    }
    public String print(char poly){
        PolynomialSolver set = new PolynomialSolver();
        PolynomialSolver setexp = new PolynomialSolver();
        if(poly == 'A'){
            set = A;
            setexp = A_exp;
        }else if(poly == 'B'){
            set = B;
            setexp = B_exp;
        }else if(poly == 'C'){
            set = C;
            setexp = C_exp;
        }else if(poly == 'R'){
            set = R;
            setexp = R_exp;
        }
        if(set.size == 0){
            return null;
        }
        int condition = 0;
        Object pointer = set.head;
        Object w = setexp.head;
        if(pointer.data != 0 && pointer.data != 1){
            System.out.print(pointer.data);
            condition = 1;
        }
        if(w.data != 0 && w.data != 1 && pointer.data != 0){
            System.out.print("x^" + w.data);
            condition = 1;
        }else if(w.data == 1 && pointer.data != 0){
            System.out.print("x");
            condition = 1;
        }
        for(int i = 1;i<set.size;i++){
            pointer = pointer.next;
            w = w.next;
            if(pointer.data == 0){
                continue;
            }else if(pointer.data > 0 && pointer.data != 1 && condition == 1){
                System.out.print("+" + pointer.data);
            }else if(pointer.data != 1){
                System.out.print(pointer.data);
            }else if(pointer.data == 1 && condition == 1){
                System.out.print("+");
            }
            if(w.data != 0 && w.data != 1){
                System.out.print("x^" + w.data);
            }else if(w.data == 1){
                System.out.print("x");
            }
            condition = 1;
        }
        System.out.print("\n");
        return null;
    }
    public float evaluatePolynomial(char poly, float value){
        PolynomialSolver set = new PolynomialSolver();
        if(poly == 'A'){
            set = A;
        }else if(poly == 'B'){
            set = B;
        }else if(poly == 'C'){
            set = C;
        }
        float sum = 0;
        Object pointer = set.head;
        int k = set.size-1;
        for(int i = 0;i<set.size;i++){
            sum += pointer.data * Math.pow(value, k--);
            pointer = pointer.next;
        }
        return sum;
    }


    public int[][] add(char poly1, char poly2){
        PolynomialSolver add1 = new PolynomialSolver();
        PolynomialSolver add2 = new PolynomialSolver();
        if(poly1 == 'A'){
            add1 = A;
        }else if(poly1 == 'B'){
            add1 = B;
        }else if(poly1 == 'C'){
            add1 = C;
        }
        if(poly2 == 'A'){
            add2 = A;
        }else if(poly2 == 'B'){
            add2 = B;
        }else if(poly2 == 'C'){
            add2 = C;
        }
        Object pointer = add1.head;
        Object w = add2.head;
        for(int i = 0;i<add1.size();i++){
            Object e = new Object();
            e.data = pointer.data + w.data;
            R.add(e);
            pointer = pointer.next;
            w = w.next;
        }
        int k = R.size-1;
        while(k >= 0){
            Object q = new Object();
            q.data = k--;
            R_exp.add(q);
        }
        R.print('R');
        return null;}
    public void clearPolynomial (char poly){
        if(poly == 'A'){
            A.head = null;
            A.lastN = null;
            A.size = 0;
        }else if(poly == 'B'){
            B.head = null;
            B.lastN = null;
            B.size = 0;
        }else if(poly == 'C'){
            C.head = null;
            C.lastN = null;
            C.size = 0;}}
    public int[][] subtract(char poly1, char poly2){
        PolynomialSolver sub1 = new PolynomialSolver();
        PolynomialSolver sub2 = new PolynomialSolver();
        if(poly1 == 'A'){
            sub1 = A;
        }else if(poly1 == 'B'){
            sub1 = B;
        }else if(poly1 == 'C'){
            sub1 = C;
        }
        if(poly2 == 'A'){
            sub2 = A;
        }else if(poly2 == 'B'){
            sub2 = B;
        }else if(poly2 == 'C'){
            sub2 = C;
        }
        Object pointer = sub1.head;
        Object w = sub2.head;
        for(int i = 0;i<sub1.size();i++){
            Object e = new Object();
            e.data = pointer.data - w.data;
            R.add(e);
            pointer = pointer.next;
            w = w.next;
        }
        int k = R.size-1;
        while(k >= 0){
            Object q = new Object();
            q.data = k--;
            R_exp.add(q);
        }
        R.print('R');

        return null;
    }

    public int[][] multiply(char poly1, char poly2){
        PolynomialSolver Multiplication1 = new PolynomialSolver();
        PolynomialSolver MULTIPLICATION2 = new PolynomialSolver();
        if(poly1 == 'A'){
            Multiplication1 = A;
        }else if(poly1 == 'B'){
            Multiplication1 = B;
        }else if(poly1 == 'C'){
            Multiplication1 = C;
        }
        if(poly2 == 'A'){
            MULTIPLICATION2 = A;
        }else if(poly2 == 'B'){
            MULTIPLICATION2 = B;
        }else if(poly2 == 'C'){
            MULTIPLICATION2 = C;
        }
        Object pointer = Multiplication1.head;
        Object w = MULTIPLICATION2.head;
        int[] m = new int[2 * Multiplication1.size - 1];
        for(int i = 0;i<Multiplication1.size;i++){
            for(int j = 0;j<Multiplication1.size;j++){
                m[(i + j)] += pointer.data * w.data;
                w = w.next;
            }
            pointer = pointer.next;
            w = MULTIPLICATION2.head;
        }
        for(int i = 0;i < 2 * Multiplication1.size - 1;i++){
            Object e = new Object();
            e.data = m[i];
            R.add(e);
        }
        int k = R.size-1;
        while(k >= 0){
            Object q = new Object();
            q.data = k--;
            R_exp.add(q);
        }
        R.print('R');
        return null;
    }
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner input = new Scanner(System.in);
        PolynomialSolver poly = new PolynomialSolver();
        int ca = 0, cb = 0, cc = 0;
        String A = new String();String B = new String();String C = new String();String text = new String();
        char x;float y;
        String set = new String();
        int CONDITION = 1;
        while (CONDITION == 1 && CONDITION != 2){
            CONDITION = 0;
            text = input.nextLine();
            set = input.nextLine();
            if(text.equals("set")){
                CONDITION = 1;
                if(set.equals("A")){
                    A = input.nextLine().replaceAll("\\[|\\]", "");
                    ca = 1;
                    String[] s = A.split(",");
                    if (s.length == 1 && s[0].isEmpty()){
                        System.out.println("Error");
                        System.exit(0);
                    }else {
                        for(int i = 0; i < s.length; ++i){
                            Object ob = new Object();
                            ob.data = Integer.parseInt(s[i]);
                            PolynomialSolver.A.add(ob);
                        }
                    }
                    int k = s.length-1;
                    while(k >= 0){
                        Object pointer = new Object();
                        pointer.data = k--;
                        A_exp.add(pointer);
                    }
                }else if(set.equals("B")){
                    B = input.nextLine().replaceAll("\\[|\\]", "");
                    cb = 1;
                    String[] s = B.split(",");
                    if (s.length == 1 && s[0].isEmpty()){
                        System.out.println("Error");
                        System.exit(0);
                    }else {
                        for(int i = 0; i < s.length; ++i){
                            Object ob = new Object();
                            ob.data = Integer.parseInt(s[i]);
                            PolynomialSolver.B.add(ob);
                        }
                    }
                    int k = s.length-1;
                    while(k >= 0){
                        Object ob = new Object();
                        ob.data = k--;
                        B_exp.add(ob);
                    }
                }else if(set.equals("C")){
                    C = input.nextLine().replaceAll("\\[|\\]", "");
                    cc = 1;
                    String[] s = C.split(",");
                    if (s.length == 1 && s[0].isEmpty()){
                        System.out.println("Error");
                        System.exit(0);
                    }else {
                        for(int i = 0; i < s.length; ++i){
                            Object pointer = new Object();
                            pointer.data = Integer.parseInt(s[i]);
                            PolynomialSolver.C.add(pointer);
                        }
                    }
                    int k = s.length-1;
                    while(k >= 0){
                        Object pointer = new Object();
                        pointer.data = k--;
                        C_exp.add(pointer);
                    }
                }else{
                    System.out.println("Error");
                    System.exit(0);
                }
            }else if(text.equals("print")){
                CONDITION = 1;
                if(set.equals("A")){
                    poly.print('A');
                }else if(set.equals("B")){
                    poly.print('B');
                }else if(set.equals("C")){
                    poly.print('C');
                    CONDITION = 2;
                }else{
                    System.out.println("Error");
                    System.exit(0);
                }
            }else if(text.equals("add")){
                x = input.next().charAt(0);
                if(!(x == 'A' || x == 'B' || x == 'C')){
                    System.out.println("Error");
                    System.exit(0);
                }
                if(!(set.charAt(0) == 'A' || set.charAt(0) == 'B' || set.charAt(0) == 'C')){
                    System.out.println("Error");
                    System.exit(0);
                }
                poly.add(set.charAt(0), x);
            }else if(text.equals("sub")){
                x = input.next().charAt(0);
                if(!(x == 'A' || x == 'B' || x == 'C')){
                    System.out.println("Error");
                    System.exit(0);
                }
                if(!(set.charAt(0) == 'A' || set.charAt(0) == 'B' || set.charAt(0) == 'C')){
                    System.out.println("Error");
                    System.exit(0);
                }
                poly.subtract(set.charAt(0), x);
            }else if(text.equals("mult")){
                x = input.next().charAt(0);
                if(!(x == 'A' || x == 'B' || x == 'C')){
                    System.out.println("Error");
                    System.exit(0);
                }
                if(!(set.charAt(0) == 'A' || set.charAt(0) == 'B' || set.charAt(0) == 'C')){
                    System.out.println("Error");
                    System.exit(0);
                }
                poly.multiply(set.charAt(0), x);
            }
            else if(text.equals("eval")){
                y = input.nextFloat();
                if(!(set.charAt(0) == 'A' || set.charAt(0) == 'B' || set.charAt(0) == 'C')){
                    System.out.println("Error");
                    System.exit(0);
                }
                System.out.println((int)poly.evaluatePolynomial(set.charAt(0), y));
            }
            else if(text.equals("clear"))
            {
                if(set.equals("A"))
                {
                    poly.clearPolynomial('A');PolynomialSolver.A.display();
                }
                else if(set.equals("B"))
                {
                    poly.clearPolynomial('B');PolynomialSolver.B.display();
                }
                else if(set.equals("C"))
                {
                    poly.clearPolynomial('C');PolynomialSolver.C.display();
                }
                else
                {
                    System.out.println("Error");System.exit(0);
                }
            }
            else
            {
                System.out.println("Error");System.exit(0);}}}}