package leetcode;

public class lec16N {
    public int[] subSort(int[] a) {
        int l = -1, r = -1;
        if (a == null || a.length == 1) return new int[]{l, r};
        int maxx = Integer.MIN_VALUE;
        int minn = Integer.MAX_VALUE;
        for (int i = 0; i < a.length; i ++ ) {
            if (a[i] < maxx) r = i;
            maxx = Math.max(maxx, a[i]);
        }

        for (int i = a.length - 1; i >= 0; i -- ) {
            if (a[i] > minn) l = i;
            minn = Math.min(minn, a[i]);
        }

        return new int[]{l, r};
    }
}
