class Solution {
    public int[] solution(int[] prices) {
        int len = prices.length;
        int[] answer = new int[len];
        
        for(int i = 0;i<len;i++){
            int dura_time = 0;
            for(int j = i + 1;j<len;j++){
                answer[i]++;
                if(prices[j] < prices[i]) break;
            }
        }
        return answer;
    }
}