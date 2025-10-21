    class Solution {
        public int[][] solution(int n) {
            int[][] answer = new int[n][n];
            int temp = 1;
            int left =0,right = n-1;
            int top = 0, bottom = n-1;
            while(temp<=n*n){
                for(int i = left;i<=right;i++){
                    answer[top][i] = temp;
                    temp++;
                }
                top++;
                for(int i = top;i<=bottom;i++){
                    answer[i][right] = temp;
                    temp++;
                }
                right--;
                for(int i = right;i>=left;i--){
                    answer[bottom][i] = temp;
                    temp++;
                }
                bottom--;
                for(int i = bottom;i>=top;i--){
                    answer[i][left] = temp;
                    temp++;
                }
                left++;
            }
            return answer;
        }
    }