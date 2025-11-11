class Solution {
    public static int solution(int n) {
        int answer = 0;
        int[]dp = new int[n+1];
        for(int i = 1;i<=n;i++){
            int sum = i;
            int temp = i+1;
            dp[sum]++;
            for(int j = i;j<=n;j++){
                sum += temp++;
                if(sum > n) break;
                dp[sum]++;
            }
        }
        answer= dp[n];
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution(15));
    }
}