package lld;

public class SumOfSimilarity {

    // Method to count the number of similar bits between two numbers
    private static int countSimilarBits(int x, int y) {
        int count = 0;
        int xor = x ^ y; // XOR gives bits that are different
        // We count the number of bits that are the same (i.e., zero in the XOR result)
        for (int i = 0; i < 32; i++) {
            if ((xor & (1 << i)) == 0) {
                count++; // If the bit in XOR is 0, the bits are the same
            }
        }
        return count;
    }

    // Method to calculate similarity sums for each A[i]
    public static int[] sumOfSimilarity(int[] A, int N) {
        int[] result = new int[N];

        for (int i = 0; i < N; i++) {
            int sum = 0;
            int max = A[i];
            // Calculate similarity sum for all consecutive pairs from 0 to max
            for (int j = 0; j < max; j++) {
                sum += countSimilarBits(j, j + 1);
            }
            result[i] = sum;
        }

        return result;
    }

    public static void main(String[] args) {
        int[] A1 = {1, 2};
        int N1 = 2;
        int[] result1 = sumOfSimilarity(A1, N1);
        System.out.println("Result 1: " + java.util.Arrays.toString(result1));

        int[] A2 = {5};
        int N2 = 1;
        int[] result2 = sumOfSimilarity(A2, N2);
        System.out.println("Result 2: " + java.util.Arrays.toString(result2));

//
//        SELECT td.train_id, td.train_name, td.train_type, td.departure_time,
//                tsf.station_name AS station_from, tst.station_name AS station_to, td.train_speed
//        FROM train_details_tbl td
//        INNER JOIN train_stations_tbl tsf ON td.train_from = tsf.station_id
//        INNER JOIN train_stations_tbl tst ON td.train_to = tst.station_id
//        WHERE tsf.station_name LIKE '% %' OR tst.station_name LIKE '% %';
    }
}

