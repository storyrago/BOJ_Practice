class Solution {
    static int CNT;
    static void dfs(int[]numbers,int target,int start, int prev){
        if(start == numbers.length) {
            if(prev == target) CNT++;
            return;
        }
        dfs(numbers,target,start + 1, prev + numbers[start]);
        dfs(numbers,target,start + 1, prev - numbers[start]);
    }
    public int solution(int[] numbers, int target) {
        int answer = 0;
        dfs(numbers,target,0,0);
        answer = CNT;
        return answer;
    }
}