package leetcode;

public class lec2490 {
    public boolean isCircularSentence(String sentence) {
        boolean f = false;
        String[] arr = sentence.split(" ");

        if (arr[0].charAt(0) != arr[arr.length - 1].charAt(arr[arr.length - 1].length() - 1)) return false;
        for (int i = 0; i < arr.length - 1; i ++ ) {
            if (arr[i].charAt(arr[i].length() - 1) != arr[i + 1].charAt(0)) return false;
        }
        return true;
    }
}
