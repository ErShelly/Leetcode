package lld;

public class ValidOTPGenerator {

    public static String countValidOTPs(String num) {
        int maxNum = Integer.parseInt(num);
        int count = 0;

        for (int n = 0; n <= maxNum; n++) {
            if (n == 201 || n == 2401) continue;

            String s = String.valueOf(n);
            if (s.length() % 2 != 0) continue;

            int half = s.length() / 2;
            String firstHalf = s.substring(0, half);
            String secondHalf = s.substring(half);

            if (firstHalf.equals(secondHalf)) {
                count++;
            }
        }

        return String.valueOf(count);
    }

    public static void main(String[] args) {
        // Corner test cases
        System.out.println(countValidOTPs("33")); // Should return 10
        System.out.println(countValidOTPs("1010")); // Should return 10
    }
}