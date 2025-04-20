package org.example.string;

public class ReverseWords {
    public static void main(String[] args){
        String str = "The sky is blue";
        System.out.println(reverseWords(str));
        System.out.println(reverseWords2(str));
    }

    //Time and space: O(n)
    public static String reverseWords(String s) {
        char[] arr = s.toCharArray();
        int end = arr.length -1;
        int res_idx = 0;
        char[] res = new char[arr.length];

        while(end>=0){
            while(end>=0 && arr[end] == ' '){
                end--;
            }

            int start = end;
            while(start>=0 && arr[start] != ' '){
                start--;
            }

            if(res_idx > 0){
                res[res_idx++] = ' ';
            }

            for(int i=start+1; i<=end; i++){
                res[res_idx++] = arr[i];
            }

            end = start-1;
        }

        return new String(res, 0, res_idx).trim();
    }


    //TIme and space and complexity : O(n)
    //Method 2 (split()):
    //
    //s.trim().split("\\s+") creates a new array of words → O(N) extra space.
    //StringBuilder res also creates another new string → O(N) extra space.
    //In total, it requires two extra copies of the data.
    public static String reverseWords2(String s){
        String[] words = s.trim().split("\\s+");
        StringBuilder res = new StringBuilder();

        for(int i=words.length-1; i>=0; i--){
            res.append(words[i]);

            if(i>0) res.append(" ");
        }

        return res.toString();
    }
}
