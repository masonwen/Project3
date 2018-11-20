public class maxValue {

    private static int n = 9;           // Size of array
    private static int k = 2;           // Allowed number of adjacency of 1

    public static void main(String[] args) {

        int [] arr = dataInput.generateRandomArray();

        System.out.println("Given array: ");
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();

        int[][] M = new int[n][k+1];
        M[0][0] = arr[0];
        M[1][0] = Math.max(arr[0], arr[1]);

        for (int i = 2; i < n; i++) {
            M[i][0] = Math.max(M[i - 1][0], M[i - 2][0] + arr[i]);
        }

        for (int j = 1; j <= k; j++) {
            M[0][j] = arr[0];
            M[1][j] = arr[0] + arr[1];

            for (int i = 2; i < n; i++) {
                M[i][j] = Math.max(M[i - 1][j], Math.max(M[i - 2][j] + arr[i], M[i - 1][j - 1] + arr[i]));
            }
        }

        for (int j = 0; j <= k; j++) {
            System.out.print(j + ":  ");
            for (int i = 0; i < n; i++) {
                System.out.print(M[i][j] + "  ");
            }
            System.out.println();
        }

        System.out.println("Maximum sum is: " + M[n-1][k]);
    }


}

/*
 * b[i]=0 => S=M[i-1, j] // a[i] not added to sum, b[1..i-1] has same number of
 * adjacent 1s (j) as b[1..i] because b[i] is zero
 *
 * b[i]=1 and b[i-1]=0 => S=M[i-2, j]+a[i] // a[i] added to sum, b[1..i-2] has
 * same number of adjacencent 1s, because b[i-1] is zero
 *
 * b[i]=1 and b[i-1]=1 => S=M[i-1, j-1]+a[i] // a[i] added to sum, since b[i]
 * and b[i-1] are both 1, they count as adjacent 1s, so b[1..i-1] contains only
 * j-1 adjacent 1s
 */