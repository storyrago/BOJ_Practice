class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        int[][] answer = {};
        int aHeight = arr1.length;
        int aWidth = arr2[0].length;
        answer = new int[aHeight][aWidth];
        for(int i = 0;i<aHeight;i++){
            for(int j = 0;j<aWidth;j++){
                for(int k = 0;k<arr2.length;k++){
                    answer[i][j] += arr1[i][k] * arr2[k][j];
                }
            }
        }
        return answer;
    }
}
/*
1 4   3 3
3 2   3 3
4 1

*/