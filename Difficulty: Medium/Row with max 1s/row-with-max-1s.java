// User function Template for Java

class Solution {
    public int rowWithMax1s(int arr[][]) {
        // code here
           int n = arr.length;
        int m = arr[0].length;
        int maxOnes = 0;
        int rowIndex = -1;
        for (int i = 0; i < n; i++) {
            int firstOneIndex = firstOne(arr[i], m);
            if (firstOneIndex != -1) {
                int countOnes = m - firstOneIndex;
                if (countOnes > maxOnes) {
                    maxOnes = countOnes;
                    rowIndex = i;
                }
            }
        }
        return rowIndex;
    }
    int firstOne(int[] row, int m) {
        int l = 0, r = m - 1;
        int ans = -1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (row[mid] == 1) {
                ans = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return ans;
    }
}