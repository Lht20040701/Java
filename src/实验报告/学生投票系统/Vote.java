package 实验报告.学生投票系统;

import java.util.HashSet;
import java.util.Scanner;

public class Vote {
    private static int cnt;
    private static HashSet<Vote> st = new HashSet<>();
    public static final int Max_Num = 10;
    public static int yes = 0, no = 0;
    private static boolean fe = true;

    public void vote() {
        if (cnt >= Max_Num) {
            if (fe) {
                System.out.println("投票结束");
                fe = false;
            }
            return ;
        }

        Scanner sc = new Scanner(System.in);

        int rt = sc.nextInt();

        if (st.contains(this)) System.out.println("请勿重复投票");
        else {
            st.add(this);

            System.out.println("感谢你的投票");
            if (rt == 1) yes ++ ;
            else no ++ ;
            cnt ++ ;
        }
    }
}
