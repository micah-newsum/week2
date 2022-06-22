

public class Selection {
    public static void sort(Comparable[] a) {
        int n = a.length;
        for (int i = 0; i < n; i++) {
            int min = i;
            for (int j = i + 1; j < n; j++) {
                if (SortUtil.less(a[j], a[min])) {
                    min = j;
                }
            }
            SortUtil.exch(a, i, min);
        }
    }

    public static void main(String[] args) {
        Character[] a = {'S','O','R','T','E','X','A','M','P','L','E'};
        sort(a);
        SortUtil.print(a);
    }
}