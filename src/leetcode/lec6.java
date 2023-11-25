package leetcode;

public class lec6 {
    public static void main(String[] args) {
        String s = "ABCDEFGHIJ";
        System.out.println(convert(s, 4));
    }
    public static String convert(String s, int numRows) {
        if (numRows == 1) return s;

        if (numRows == 2) {
            StringBuilder ansr = new StringBuilder();
            StringBuilder ansc = new StringBuilder();
            for (int i = 0; i < s.length(); i ++ )
                if (i % 2 == 0) ansr.append(s.charAt(i));
                else ansc.append(s.charAt(i));
                return ansr.append(ansc.toString()).toString();
        }

        StringBuilder ans = new StringBuilder();
        int base = (numRows - 1) * 2;
        int flag = -1;
        for (int i = 0; i < numRows; i ++ ) {
            if (i >= numRows / 2) flag = 1;
            for (int j = i; ; j += base) {
                if (flag == -1) {
                    if (j < s.length()) ans.append(s.charAt(j));
                    if (j + base - 2 * i < s.length() && i != 0) ans.append(s.charAt(j + base - 2 * i));
                    if (j + base - 2 * i >= s.length()) break;
                }

                if (flag == 1) {
                    if (j < s.length()) ans.append(s.charAt(j));
                    if (j + 2 * (numRows - 1 - i) < s.length() &&  numRows - 1 - i != 0) ans.append(s.charAt(j + 2 * (numRows - 1 - i)));
                    if (j + 2 * (numRows - 1 - i) >= s.length()) break;
                }
            }
        }
        return ans.toString();
    }
}
