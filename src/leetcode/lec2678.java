package leetcode;

public class lec2678 {
    public int countSeniors(String[] details) {
        int ans = 0;
        for (int i = 0; i < details.length; i ++ ) {
            int x = Integer.parseInt(details[i].substring(11));
            if (x / 100 > 60) ans ++ ;
        }
        return ans;
    }
}
