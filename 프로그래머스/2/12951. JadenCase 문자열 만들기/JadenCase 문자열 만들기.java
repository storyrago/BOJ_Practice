class Solution {
    public static String solution(String s) {
        String answer = "";
        boolean isFirst = true;
        for(int i =0;i<s.length();i++){
            char c = s.charAt(i);
            if(c==' '){
                answer += c;
                isFirst = true;
            }
            else{
                if(isFirst){
                    if(!Character.isDigit(c)){
                        answer += Character.toUpperCase(c);
                    }
                    else{
                        answer += c;
                    }
                    isFirst = false;
                }
                else{
                    answer += Character.toLowerCase(c);
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution("HELO  EWQE  DASDM"));
    }
}