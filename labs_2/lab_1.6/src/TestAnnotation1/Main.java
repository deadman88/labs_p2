package TestAnnotation1;

/**
 * Created by stas on 12.08.2017.
 */
@SuppressWarnings("deprecation")
public class Main {

    public static void main(String[] args) {
        System.out.println(findMax(3,7,8,3,2,11,10));
        System.out.println(findMax2(4,5,8,11,234,3,46));
    }

    @Deprecated
    public static int findMax(int...i){
        if (i.length == 0)
            return -1;
        int max = i[0];
        for (int j = 0; j < i.length; j++) {
            max = max < i[j] ? i[j] : max;
        }
        return max;
    }
    @SafeVarargs
    public static <T extends Comparable, Number> T findMax2 (T...i){
        if (i.length == 0)
            return null;
        T max = i[0];
        for (int j = 0; j < i.length; j++) {
            max = max.compareTo(i[j]) == -1 ? i[j] : max;
        }
        return max;
    }
}
