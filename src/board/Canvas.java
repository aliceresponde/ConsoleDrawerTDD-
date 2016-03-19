/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package board;

/**
 * The class represents the board where the user will draw with commands
 *
 * @author alice
 */
public class Canvas {

    static boolean isHorizontal(int x1, int y1, int x2, int y2) {
        return y1 == y2;
    }

    static boolean isVertical(int x1, int y1, int x2, int y2) {
        return x1 == x2;
    }

    private int width;
    private int height;
    private char content[][];

    char[][] createCanvas(int w, int h) {
        h = h + 2;
        w = w + 2;
        width = w;
        height = h;
        content = new char[w][h];

        for (h = 0; h < height; h++) {
            for (w = 0; w < width; w++) {
                if (h == 0) {
                    content[w][h] = '-';
                } else if (h == height - 1) {
                    content[w][h] = '-';
                } else if (w == width - 1 && h > 0 && h < height) {
                    content[w][h] = '|';
                } else if (w == 0 && h > 0 && h < height) {
                    content[w][h] = '|';
                } else {
                    content[w][h] = ' ';
                }
            }
        }
        
        printCanvas();

        return content;
    }

    public void printCanvas() {
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                System.out.print(content[x][y]);
            }
            System.out.println("");
        }
    }

    char[][] DrawLine(int x1, int y1, int x2, int y2) {
        if (isHorizontal(x1, y1, x2, y2)) {
            drawHorizontalLine(x1, y1, x2, y2);
        } else if (isVertical(x1, y1, x2, y2)) {
            drawVerticalLine(x1, y1, x2, y2);
        } else {
            
        }

        return content;
    }

    /**
     * Just variation on   x  in  min<=x<=max
     * @param x1
     * @param y1
     * @param x2
     * @param y2
     * @return 
     */
     char[][] drawHorizontalLine(int x1, int y1, int x2, int y2) {
        if(isValidCoordinate(x1, y1) && isValidCoordinate(x2, y2)){
            System.out.println("ok coord");
            
            int min = Math.min(x1, x2);
            int max = Math.max(x1, x2);
            
            for(int x= min; x<=max; x++){
                content[x][y1]='x';
            }
        }
        printCanvas();
        return content;
    }
    
    /**
     * Just variation on   y  in  min<=y<=max
      * @param x1
     * @param y1
     * @param x2
     * @param y2
     * @return 
     */
     char[][] drawVerticalLine(int x1, int y1, int x2, int y2) {
        if(isValidCoordinate(x1, y1) && isValidCoordinate(x2, y2)){
            System.out.println("ok coord");
            
            int min = Math.min(y1, y2);
            int max = Math.max(y1, y2);
           
            for(int y= min; y<=max; y++){
                content[x1][y]='x';
            }
        }
        return content;
    }
    
   
    
    /**
     *  1 <= y1 < height && 1 <= x1 < width valid for painting
     * @param x1
     * @param y1
     * @return 
     */
    private boolean isValidCoordinate(int x1, int y1) {
        return  isValidCoordinateX(x1) && isValidCoordinateY(y1);
    }

    /**
     *  1 <= y1 < height  valid for painting
     * @param y1
     * @return 
     */
    private boolean isValidCoordinateY(int y1) {
        return y1 < height && y1 >=1;  
    }

    /**
     *  1 <= x1 < width  valid for painting
     * @param x1
     * @return 
     */
    private boolean isValidCoordinateX(int x1) {
        return x1 < width && x1 >=1;
    }

}
