public class SortUtil {
    protected static void exch(Comparable[] a, int i, int j){
        Comparable swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }

    protected static boolean less(Comparable v, Comparable w){
        return v.compareTo(w) < 0;
    }

    protected static void print(Comparable[] a) {
        String s = "";
        for (Comparable c : a) {
            s += c + ",";
        }
        System.out.println(s);
    }
}
