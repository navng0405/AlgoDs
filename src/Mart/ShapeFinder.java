package Mart;

import com.sun.source.tree.BreakTree;

import java.util.ArrayList;
import java.util.List;

public class ShapeFinder {
    public static void main(String[] args) {
        int[][] image1 = {
                {1, 0, 1, 1, 1, 1, 1},
                {1, 0, 0, 1, 0, 1, 1},
                {0, 1, 1, 0, 0, 0, 1},
                {1, 0, 1, 1, 0, 1, 1},
                {1, 0, 1, 0, 1, 1, 1},
                {1, 0, 0, 0, 0, 1, 1},
                {1, 1, 1, 0, 0, 1, 1},
                {0, 1, 0, 1, 1, 1, 0},
        };

        List<List<List<Integer>>> shapes = findShapes(image1);
        System.out.println("Shapes found: " + shapes);
    }

    private static List<List<List<Integer>>> findShapes(int[][] image1) {
        List<List<List<Integer>>> shapes = new ArrayList<>();

        for(int row=0;row<image1.length;row++){
            for(int col=0;col<image1[0].length;col++){
                if(image1[row][col] == 0){
                    List<List<Integer>> shape = new ArrayList<>();
                    dfsShape(image1,shape,row,col);
                    if(!shape.isEmpty()){
                        shapes.add(shape);
                    }
                }
            }
        }
        return shapes;
    }

    private static void dfsShape(int[][] image1, List<List<Integer>> shape, int row, int col) {
        if(row<0 || row >= image1.length || col<0 || col>=image1[0].length || image1[row][col] != 0){
            return;
        }
        image1[row][col] = -1; // visited
        shape.add(List.of(row,col));

        dfsShape(image1,shape,row-1,col);
        dfsShape(image1,shape,row+1,col);
        dfsShape(image1,shape,row,col+1);
        dfsShape(image1,shape,row,col-1);
    }


}
