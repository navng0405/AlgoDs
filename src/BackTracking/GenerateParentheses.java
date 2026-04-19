package BackTracking;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {
    

    public static void main(String[] args) {
        GenerateParentheses gp = new GenerateParentheses();
        System.out.println(gp.generateParenthesis(3));
    }

    private List<String> generateParenthesis(int i) {
        List<String> result = new ArrayList<>();
        String current = "";
        backTrackParenthesis(i,result,"",0,0);
        return result;
    }

    private void backTrackParenthesis(int max, List<String> result, String current, int open, int close) {
        //Base Condition
        if(current.length() == max*2){
            result.add(current);
            return;
        }

        if(open<max){
            backTrackParenthesis(max,result,current+"(",open+1,close);
        }

        if(close<open){
            backTrackParenthesis(max,result,current+")",open,close+1);
        }
    }


}

