package Array;

import java.util.ArrayList;
import java.util.List;

public class TeamFormation2 {
    public static void main(String[] args) {
        int[] skillLevel = {12,4,6,13,5,10};
        List<List<Integer>> teams = getTeams(skillLevel,3,4,10);
    }


    private static List<List<Integer>> getTeams(int[] skillLevel, int playersLen, int min, int max) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> tempList = new ArrayList<>();
        boolean[] isAdded = new boolean[skillLevel.length];
        backTracking(skillLevel,playersLen,min,max,result,tempList,isAdded,0);
        return result;
    }

    private static void backTracking(int[] skillLevel, int playersLen, int min, int max, List<List<Integer>> result, List<Integer> tempList, boolean[] isAdded,int startIndex) {
        if(tempList.size() == playersLen){
            List<Integer> playerList = new ArrayList<>(tempList);
            result.add(playerList);
            return;
        }

        for(int i=startIndex;i<skillLevel.length;i++){
            if(!isAdded[i]){
                if(skillLevel[i]>=min && skillLevel[i]<=max ){
                    isAdded[i] = true;
                    tempList.add(skillLevel[i]);
                    backTracking(skillLevel,playersLen,min,max,result,tempList,isAdded,startIndex+1);
                    tempList.removeLast();
                    isAdded[i]=false;
                }
            }
        }
    }
}
