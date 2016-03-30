/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package board;

import java.util.AbstractQueue;
import java.util.Queue;

/**
 * The class represents the board where the user will draw with commands
 *
 * @author alice
 */
public class Canvas {

    private int width = 0;
    private int height = 0;
    private char content[][];

    public Canvas(int w, int h) {
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
                } 
                else {
                    content[w][h] = ' ';
                }
            }
        }
    }

    public char[][] getContent() {
        return content;
    }

    static boolean isHorizontal(int x1, int y1, int x2, int y2) {
        return y1 == y2;
    }

    static boolean isVertical(int x1, int y1, int x2, int y2) {
        return x1 == x2;
    }

    

    public void DrawLine(int x1, int y1, int x2, int y2) {
        if (isHorizontal(x1, y1, x2, y2)) {
            drawHorizontalLine(x1, y1, x2, y2);
        } else if (isVertical(x1, y1, x2, y2)) {
            drawVerticalLine(x1, y1, x2, y2);
        }
    }

    /**
     * Just variation on x in min<=x<=max
     *
     * @param x1
     * @param y1
     * @param x2
     * @param y2
     *
     */
    void drawHorizontalLine(int x1, int y1, int x2, int y2) {
        if (isValidCoordinate(x1, y1) && isValidCoordinate(x2, y2)) {
            int min = Math.min(x1, x2);
            int max = Math.max(x1, x2);

            for (int x = min; x <= max; x++) {
                content[x][y1] = 'x';
            }
        }
    }

    /**
     * Just variation on y in min<=y<=max
     *
     * @param x1
     * @param y1
     * @param x2
     * @param y2
     * @return
     */
    void drawVerticalLine(int x1, int y1, int x2, int y2) {
        if (isValidCoordinate(x1, y1) && isValidCoordinate(x2, y2)) {
            int min = Math.min(y1, y2);
            int max = Math.max(y1, y2);

            for (int y = min; y <= max; y++) {
                content[x1][y] = 'x';
            }
        }
    }

    /**
     * 1 <= y1 < height && 1 <= x1 < width valid for painting @param x1 @
     *
     * p
     * ara
     *
     * m y1 @return
     */
    private boolean isValidCoordinate(int x1, int y1) {
        return isValidCoordinateX(x1) && isValidCoordinateY(y1);
    }

    /**
     * 1 <= y1 < height valid for painting @param y1 @re
     *
     * t
     * ur
     *
     * n
     */
    private boolean isValidCoordinateY(int y1) {
        return y1 < height && y1 >= 1;
    }

    /**
     * 1 <= x1 < width valid for painting @param x1 @r
     *
     * e
     * tu
     *
     * rn
     */
    private boolean isValidCoordinateX(int x1) {
        return x1 < width && x1 >= 1;
    }

    void drawRectangle(int x1, int y1, int x2, int y2) {
        if (isValidCoordinate(x1, y1) && isValidCoordinate(x2, y2)) {
            int min_x = Math.min(x1, x2);
            int max_x = Math.max(x1, x2);

            int min_y = Math.min(y1, y2);
            int max_y = Math.max(y1, y2);

            for (int h = min_y; h <= max_y; h++) {
                for (int w = min_x; w <= max_x; w++) {
                    //  -------------------- 
                    if (h == min_y || h == max_y) {
                        content[w][h] = 'x';
                    } //|||||||||||
                    else if (w == min_x || w == max_x) {
                        content[w][h] = 'x';
                    }
                }
            }

        }
    }

    void BucketFill(int x, int y, char new_color) {
        //original coord valid && it was not nodified (new_color)
        if (isValidCoordinate(x, y) && content[x][y] != new_color) {
            char previous_color = content[x][y];
            fillWithColor(x, y, previous_color, new_color);
        }
    }

    /**
     * initial point with a previous_color
     *
     * @param coord_x1
     * @param coord_y1
     *
     * candidate with same previous color
     * @param x
     * @param y
     *
     * to paint
     * @param new_color
     */
    void fillWithColor(int x, int y, char previous_color, char new_color) {

        // make sure row and col are inside the canvas
        if (isValidCoordinate(x, y) && content[x][y] == previous_color) {
            content[x][y] = new_color;

            fillWithColor(x, y + 1, previous_color, new_color);
            fillWithColor(x, y - 1, previous_color, new_color);
            fillWithColor(x + 1, y, previous_color, new_color);
            fillWithColor(x - 1, y, previous_color, new_color);
        } else {
//            printCanvas();
            return;
        }
    }

    @Override
    public String toString() {
        String str_canvas = "";
        for (int y = 0; y < this.height; y++) {
            for (int x = 0; x < this.width; x++) {
                str_canvas = str_canvas + content[x][y];
            }
            str_canvas = str_canvas + ""
                    + "\n";
        }
        return str_canvas;
    }
}
