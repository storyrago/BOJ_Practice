class Solution {
    static int CNT;
    static void dfs(int[]numbers,int target,int start, int prev){
        if(start == numbers.length) { // start 가 끝까지왔고
            if(prev == target) CNT++; // prev 가 target 이면 CNT 값 증가
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