class Solution
{
    public int solution(int n, int a, int b)
    {
        int answer = 1;

        while(n >= 1){
            if(Math.max(a,b) % 2 == 0 && Math.max(a,b) - 1 == Math.min(a,b)) break;
            answer++;
            if(a%2 == 0) a /= 2;
            else {
                a/=2;
                a += 1;
            }
            if(b%2 == 0) b /= 2;
            else {
                b/=2;
                b += 1;
            }
            n--;
        }
        return answer;
    }
}
// 1 2 / 3 4 / 5 6 / 7 8
// -> 1 / 2 / 3 / 4