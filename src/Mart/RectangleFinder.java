package Mart;

public class RectangleFinder {

    public static int[] findRectangle(int[][] image) {
        for (int row = 0; row < image.length; row++) {
            for (int col = 0; col < image[row].length; col++) {
                // Find the top-left corner of the rectangle
                if (image[row][col] == 0) {
                    int width = 0;
                    int height = 0;

                    // Determine the width
                    while (col + width < image[row].length && image[row][col + width] == 0) {
                        width++;
                    }

                    // Determine the height
                    while (row + height < image.length && image[row + height][col] == 0) {
                        height++;
                    }

                    // Return the top-left coordinates, width, and height
                    // Format: [top-left row, top-left col, width, height]
                    return new int[] {row, col, width, height};
                }
            }
        }
        // Return an empty array if no rectangle is found
        return new int[] {};
    }

    public static void main(String[] args) {
        int[][] image = {
                {1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1},
                {1, 1, 0, 0, 1, 1},
                {1, 1, 0, 0, 1, 1},
                {1, 1, 1, 1, 1, 1},
        };

        int[] rectangle = findRectangle(image);
        if (rectangle.length > 0) {
            System.out.println("Top-Left: [" + rectangle[0] + ", " + rectangle[1] + "], Width: " + rectangle[2] + ", Height: " + rectangle[3]);
        } else {
            System.out.println("No rectangle filled with 0s found.");
        }
    }
}

