import java.util.ArrayList;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {



    }

    public static void replace(ArrayList<String> aList, String oldItem, String newItem){

        for (String s: aList){
            if (s.equals(oldItem)){
                s = newItem;
            }
        }
    }

    /** Deletes the first occurrence of target in aList. */
    public static void delete(ArrayList<String> aList, String target){
        for (String s: aList){
            if (s.equals(target)){
                aList.remove(s);
            }
        }
    }
}