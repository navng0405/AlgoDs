package Matrices;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix1 {
    public static void main(String args[]){
        int[][] array = {{1,2,3,4},{12,13,14,5},{11,16,15,6},{10,9,8,7}};
        for(int i=0;i<array.length;i++){
            for(int j=0;j<array[i].length;j++){
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
        spiralMatrix(array);
    }

    public static void spiralMatrix(int[][] array) {
        List<List<Integer>> result = new ArrayList<>();
        int rows = array.length;
        int cols = array[0].length;
        int top = 0;
        int bottom = rows-1;
        int left = 0;
        int right = cols-1;
        int dir=1;
        while(top<=bottom && left<=right){
            if(dir == 1){
                List<Integer> temp= new ArrayList<>();
                for(int i=left;i<=right;i++){
                    temp.add(array[top][i]);
                }
                result.add(temp);
                top++;
                dir=2;
            }else if(dir == 2){
                List<Integer> temp= new ArrayList<>();
                for(int i=top;i<=bottom;i++){
                    temp.add(array[i][right]);
                }
                result.add(temp);
                right--;
                dir=3;
            }else if(dir == 3){
                List<Integer> temp= new ArrayList<>();
                for(int i=right;i>=left;i--){
                    temp.add(array[bottom][i]);
                }
                result.add(temp);
                bottom--;
                dir=4;
            }else if(dir == 4){
                List<Integer> temp= new ArrayList<>();
                for(int i=bottom;i>=top;i--){
                    temp.add(array[i][left]);
                }
                result.add(temp);
                left++;
                dir=1;
            }
        }
        for(List<Integer> values : result){
            System.out.println(values.stream().toString());
        }
    }
}

