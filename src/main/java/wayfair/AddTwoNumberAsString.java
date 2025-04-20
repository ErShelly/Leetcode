package wayfair;

public class AddTwoNumberAsString {
    public static void main(String[] args) {
        try {
            String num1 = "123,456,789";
            String num2 = "987,654,321";

            num1 = cleanInput(num1);
            num2 = cleanInput(num2);

            String sum = addLargeNumbers(num1, num2);
            System.out.println(sum);

            System.out.println(fibonacci(6));

        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
        }
    }

    public static String addLargeNumbers(String num1, String num2) {
        StringBuilder result = new StringBuilder();
        int carry = 0, i = num1.length() - 1, j = num2.length() - 1;
        while (i >= 0 || j >= 0 || carry > 0) {
            int digit1 = i>=0 ? num1.charAt(i--) - '0' : 0;
            int digit2 = j>=0 ? num2.charAt(j--) - '0' : 0;

            int sum = digit1 + digit2 + carry;
            carry = sum / 10;
            result.append(sum%10);
        }
        return formatWithCommas(result.reverse().toString());
    }

    public static String formatWithCommas(String num){
        StringBuilder sb = new StringBuilder(num);

        for(int i=num.length()-1;i>0; i-=3){
            sb.insert(i, ',');
        }

        return sb.toString();
    }

    public static String fibonacci(int n){
        if( n <0) throw new RuntimeException("Invalid input");
        if(n==0) return "0";
        if(n==1) return "1";

        String first = "0", second = "1", next = "0";
        for(int i=2;i<=n;i++){
            next = addLargeNumbers(first, second);
            first = second;
            second = next;
        }

        return next;
    }

    private static String cleanInput(String num) {
        if (!num.matches("[0-9,]+")) {
            throw new IllegalArgumentException("Invalid input");
        }

        return num.replaceAll(",", "");
    }
}
