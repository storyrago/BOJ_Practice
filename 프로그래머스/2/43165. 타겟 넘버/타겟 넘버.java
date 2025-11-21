class Solution {
    static int CNT;
    static void dfs(int[]numbers,int target,int start, int prev){
        if(start == numbers.length) { // start 가 끝까지왔고
            if(prev == target) CNT++; // prev 가 target 이면 CNT 값 증가
            return;
        }
        // index 값 넘겨주고, 지난 값에 numbers[인덱스] 인거 같은데 왜 안되냐고
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