import java.util.ArrayList;

public class P2 {

    public static void delete(ArrayList<String> aList, String target) {
        for (int i = aList.size() - 1; i >= 0; i--) {
            if (target.equals(aList.get(i))) {
                aList.remove(i);
            }
        }
    }
}
