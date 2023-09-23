/*  Student information for assignment:
 *
 *  On our honor, Nathan Chase and Diego Wearden, this programming assignment is our own work
 *  and we have not provided this code to any other student.
 *
 *  Number of slip days used:
 *
 *  Student 1 (Student whose Canvas account is being used)
 *  UTEID: ntc477
 *  email address: ntc477@cs.utexas.edu
 *  Grader name: Lily Tian
 *
 *  Student 2
 *  UTEID: daw3784
 *  email address: dialwera@gmail.com
 *
 */
import java.util.ArrayList;

public class PriorityQueue314<E extends Comparable<E>> {
    ArrayList<E> con;

    public PriorityQueue314(){
        con = new ArrayList<E>();
    }

    public void enqueue(E val){
        if(con.size() == 0){
            con.add(val);
        }else{
            int placeAt = findPlace(val);
            con.add(placeAt, val);
        }
    }
    private int findPlace(E other){
        for (int i = con.size() - 1; i >= 0; i--) {
            int diff = other.compareTo(con.get(i));
            if (diff < 0) { //is smaller goes in from
                return i + 1;
            }
        }
        return 0; //our new treeNode is the biggest one add to very end
    }

    public E dequeue(){
        return con.remove(con.size() - 1);
    }

    public String toString() {
        return con.toString();
    }

    public boolean isCompleteTree(){
        return con.size() == 1;
    }
}
