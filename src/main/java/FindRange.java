public class FindRange {
    public static long findRange(int num) {
        String numStr = String.valueOf(num);
        long maxVal = num, minVal = num;

        // Finding the maximum possible value
        for (char digit = '0'; digit <= '9'; digit++) {
            if (numStr.indexOf(digit) != -1) { // If digit exists in number
                String maxStr = numStr.replace(digit, '9'); // Replace digit with '9'
                maxVal = Math.max(maxVal, Long.parseLong(maxStr));
            }
        }

        // Finding the minimum possible value
        for (char digit = '1'; digit <= '9'; digit++) { // First digit should not become '0'
            if (numStr.indexOf(digit) != -1) { // If digit exists in number
                for (char replacement = '0'; replacement < digit; replacement++) { // Replace with smaller digit
                    String minStr = numStr.replace(digit, replacement);
                    if (minStr.charAt(0) != '0') { // Ensure first digit is valid
                        minVal = Math.min(minVal, Long.parseLong(minStr));
                    }
                }
            }
        }

        return maxVal - minVal;
    }

    public static void main(String[] args) {
        int num1 = 123512;
        int num2 = 111;
        System.out.println("Difference for 123512: " + findRange(num1)); // Expected: 88808
        System.out.println("Difference for 111: " + findRange(num2));   // Expected: 888
    }
}
