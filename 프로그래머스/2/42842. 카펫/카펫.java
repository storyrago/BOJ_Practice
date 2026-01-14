class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = {};
        int tot = brown + yellow;
        int i;
        int prev = 0;
        for(i = tot;i>=1;i--){
            if(tot/i > i) break;
            if(tot % i == 0 && (i-2)*(tot/i - 2) == yellow) {
                prev = i;
            }
        }
        answer = new int[]{prev, tot/prev};
        return answer;
    }
}