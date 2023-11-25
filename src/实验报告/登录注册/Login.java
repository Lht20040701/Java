package 实验报告.登录注册;

import java.util.HashMap;
import java.util.Scanner;

public class Login {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        HashMap<Integer, Integer> hm = new HashMap<>();
        System.out.println("所有数据都需要在int范围内");
        do {
            showMean();
            int op = sc.nextInt();

            if (op == 1) {
                System.out.println("输入账号");
                int zh = sc.nextInt();
                if (!hm.containsKey(zh)) {
                    System.out.println("没有该账号");
                    continue;
                }
                System.out.println("输入密码");
                int mm = sc.nextInt();
                if (hm.get(zh) != mm) {
                    System.out.println("密码不对");
                    continue;
                }
                System.out.println("登录成功");
            } else if (op == 2) {
                System.out.println("输入想注册的账号");
                int zh = sc.nextInt();
                System.out.println("输入该账号密码, 由数字组成");
                int mm = sc.nextInt();
                hm.put(zh, mm);
                System.out.println("注册成功");
            } else if (op == 3) {
                System.out.println(hm);
            } else if (op == 4) {
                System.exit(0);
            }
        } while (true);
    }

    public static void showMean() {
        System.out.println("你想干啥\n" +
                "1. 登录\n" +
                "2. 注册\n" +
                "3. 查看\n" +
                "4. 退出\n");
    }
}