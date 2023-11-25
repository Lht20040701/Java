package leetcode;

import java.util.Arrays;

public class lec1460 {
    public static void main(String[] args) {

    }
    public boolean canBeEqual(int[] target, int[] arr) {
        Arrays.sort(target);
        Arrays.sort(arr);
        for (int i = 0; i < arr.length; i ++ ) {
            if (target[i] != arr[i]) return false;
        }
        return true;
    }
}
