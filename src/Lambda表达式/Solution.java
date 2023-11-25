package Lambda表达式;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        String[] arr = {"李菜菜", "阿衰", "大脸妹", "令狐冲", "死党"};

        Arrays.sort(arr, (o1, o2) -> o1.length() - o2.length());

        for (String i : arr) System.out.println(i);
    }
}
