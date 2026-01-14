import java.util.ArrayList;

public class P1 {

    public static void replace(ArrayList<String> aList, String oldItem, String newItem) {
        for (int i = 0; i < aList.size(); i++) {
            if (oldItem.equals(aList.get(i))) {
                aList.set(i, newItem);
            }
        }
    }
}
