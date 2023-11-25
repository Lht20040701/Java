package leetcode;

public class lec2525 {
    public String categorizeBox(int length, int width, int height, int mass) {
        boolean bulky = (length > 10000 || width > 10000 || height > 10000 || length * width * height > 1000000000);
        boolean heavy = mass >= 100;
        if (bulky && heavy) return "Both";
        else if (bulky) return "Bulky";
        else if (heavy) return "Heavy";
        return "Neither";
    }
}
