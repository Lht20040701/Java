package 实验报告.学生投票系统;

import java.util.Scanner;

public class VoteTest {
    public static void main(String[] args) {
        boolean f = true;

        System.out.println("请输入你的票 1同意, 0反对");
        for (int i = 0; i < 15; i ++ ) {
            Vote v = new Vote();
            v.vote();
            if (f && Vote.yes > Vote.Max_Num / 2) {
                System.out.println("是否结束投票 ? 输入1结束投票");
                Scanner sc = new Scanner(System.in);
                int rt = sc.nextInt();
                if (rt == 1) System.exit(0);
                f = false;
            }
        }
    }
}
