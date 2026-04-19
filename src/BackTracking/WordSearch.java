package BackTracking;

public class WordSearch {
    public static void main(String[] args) {
        char[][] givenArray = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        String searchStr = "ABCB";
        System.out.println("Found :" + searchWord(givenArray,searchStr));
    }

    private static boolean searchWord(char[][] givenArray, String searchStr) {

        for (int i = 0; i < givenArray.length; i++) {
            for (int j = 0; j < givenArray[0].length; j++) {
                if(dfs(givenArray,searchStr,i,j,0)){
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean dfs(char[][] givenArray, String searchStr, int row, int col, int stringIndex) {
        if (stringIndex == searchStr.length()) return true;
        if(row<0 || row>=givenArray.length || col<0 || col>=givenArray[0].length || givenArray[row][col] != searchStr.charAt(stringIndex)){
            return false;
        }
        char temp = givenArray[row][col];
        givenArray[row][col] = '*';
       boolean fount =  dfs(givenArray,searchStr,row-1,col,stringIndex+1) ||
        dfs(givenArray,searchStr,row+1,col,stringIndex+1) ||
        dfs(givenArray,searchStr,row,col-1,stringIndex+1) ||
        dfs(givenArray,searchStr,row,col+1,stringIndex+1);
        givenArray[row][col] = temp;
        return fount;
    }
}
