package Matrices;

/**
 * i.Check given matrix is null
 * ii.initialize rowLength & col Length
 * 3. Iterate the given Matrix
 * 4. for each cell call dfs method by passing givenMAtrix,word, index Of current character in that word which return wordfound or not
 * dfs - > check startIndex of word is equal to word length then return true
 * check boundaries , if it falls out of boundaries then return false
 * mark visited cell by changing it's character and store that character value in temp
 * call dfs method for all 4 directions
 * backtracking change current cell value back to temp
 */
public class WordSearch {
    public static void main(String[] args) {
        char[][] givenMAtrix = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        System.out.println(wordExist(givenMAtrix));
    }

    private static boolean wordExist(char[][] givenMAtrix) {
        String searchWord = "ABCCEDA";
        int rowLength = givenMAtrix.length;
        int colLength = givenMAtrix[0].length;

        for(int row = 0;row<=rowLength-1;row++){
            for(int col = 0;col<=colLength-1;col++){
                if(dfsWordSearch(givenMAtrix,searchWord,row,col,0)){
                    return true;
                }
            }
        }

        return false;
    }

    private static boolean dfsWordSearch(char[][] givenMAtrix, String searchWord, int row, int col, int wordIndex) {
        //final words condition
        if(wordIndex == searchWord.length()){
            return true;
        }

        //boundary condition
        if(row<0 || row>=givenMAtrix.length || col<0 || col>=givenMAtrix[0].length || givenMAtrix[row][col] != searchWord.charAt(wordIndex)){
            return false;
        }

        char temp = givenMAtrix[row][col];
        givenMAtrix[row][col] = '#';

        boolean found = dfsWordSearch(givenMAtrix,searchWord,row-1,col,wordIndex+1) ||
        dfsWordSearch(givenMAtrix,searchWord,row+1,col,wordIndex+1) ||
        dfsWordSearch(givenMAtrix,searchWord,row,col-1,wordIndex+1) ||
        dfsWordSearch(givenMAtrix,searchWord,row,col+1,wordIndex+1);

        givenMAtrix[row][col] = temp;

        return found;
    }
}
