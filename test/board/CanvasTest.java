/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package board;

import javax.sound.midi.Soundbank;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author alice
 */
public class CanvasTest {

    public CanvasTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

//    @Test
//    public void testSomeMethod() {
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
    @Test
    public void TestIsHorizontal() {
        System.out.println("***************************************");
        System.out.println("*IsHorizontal");        
        
        final int x1 = 1;
        final int y1 = 2;
        final int x2 = 6;
        final int y2 = 2;

        final int w = 20;
        final int h= 4;
        
        Canvas canvasInstance = new Canvas();
        canvasInstance.createCanvas(w, h);
       
        
        boolean expectedResult =true;
        System.out.println("*isHorizontal?");
        System.out.println("("+x1+ ","+y1+ ")");
        System.out.println("("+x2+ ","+y2+ ")");
        boolean result = Canvas.isHorizontal(x1, y1 , x2,y2);
        assertEquals(expectedResult, result);
    }
    
    @Test
    public void TestIsVertical() {
        System.out.println("***************************************");
        System.out.println("*IsVertival");
        final int x1 = 3;
        final int y1 = 1;
        final int x2 = 3;
        final int y2 = 3;

        
        boolean expectedResult =true;
        System.out.println("*isVertical?");
        System.out.println("("+x1+ ","+y1+ ")");
        System.out.println("("+x2+ ","+y2+ ")");
        boolean result = Canvas.isVertical(x1, y1 , x2,y2);
        assertEquals(expectedResult, result);
    }
    
    /**
     * Draw an horizontal or  vertical line 
     * (1,2)
     * (6,2)
     */
    @Test 
    public void TestDrawLine(){
        System.out.println("***************************************");
        System.out.println("*DrawLine");
        
        //vertical
        int x1 = 1;
        int y1 = 2;
        int x2 = 6;
        int y2 = 2;
        
        int height = 4;
        int width = 20;
        
        Canvas canvasInstance = new Canvas();
        
        System.out.println("Original canvas");
        canvasInstance.createCanvas(width, height);
             
        char[][] expectResult = new char[][]{
            {'-', '|', '|', '|', '|', '-'},
            {'-', ' ', 'x', ' ', ' ', '-'},
            {'-', ' ', 'x', ' ', ' ', '-'},
            {'-', ' ', 'x', ' ', ' ', '-'},
            {'-', ' ', 'x', ' ', ' ', '-'},
            {'-', ' ', 'x', ' ', ' ', '-'},
            {'-', ' ', 'x', ' ', ' ', '-'},
            {'-', ' ', ' ', ' ', ' ', '-'},
            {'-', ' ', ' ', ' ', ' ', '-'},
            {'-', ' ', ' ', ' ', ' ', '-'},
            {'-', ' ', ' ', ' ', ' ', '-'},
            {'-', ' ', ' ', ' ', ' ', '-'},
            {'-', ' ', ' ', ' ', ' ', '-'},
            {'-', ' ', ' ', ' ', ' ', '-'},
            {'-', ' ', ' ', ' ', ' ', '-'},
            {'-', ' ', ' ', ' ', ' ', '-'},
            {'-', ' ', ' ', ' ', ' ', '-'},
            {'-', ' ', ' ', ' ', ' ', '-'},
            {'-', ' ', ' ', ' ', ' ', '-'},
            {'-', ' ', ' ', ' ', ' ', '-'},
            {'-', ' ', ' ', ' ', ' ', '-'},
            {'-', '|', '|', '|', '|', '-'}
        };
        
        System.out.println("canvas expectedResult");

        for (int y = 0; y < height + 2; y++) {
            for (int x = 0; x < width+2; x++) {
                System.out.print(expectResult[x][y]);
            }
            System.out.println("");
        }
        
        
        //line horizontal-------------------------------------------------
        char[][] result = canvasInstance.DrawLine(x1, y1, x2, y2);
        assertArrayEquals(expectResult, result);
        
        
        expectResult = new char[][]{
            {'-', '|', '|', '|', '|', '-'},
            {'-', ' ', 'x', ' ', ' ', '-'},
            {'-', ' ', 'x', ' ', ' ', '-'},
            {'-', ' ', 'x', ' ', ' ', '-'},
            {'-', ' ', 'x', ' ', ' ', '-'},
            {'-', ' ', 'x', ' ', ' ', '-'},
            {'-', ' ', 'x', 'x', 'x', '-'},
            {'-', ' ', ' ', ' ', ' ', '-'},
            {'-', ' ', ' ', ' ', ' ', '-'},
            {'-', ' ', ' ', ' ', ' ', '-'},
            {'-', ' ', ' ', ' ', ' ', '-'},
            {'-', ' ', ' ', ' ', ' ', '-'},
            {'-', ' ', ' ', ' ', ' ', '-'},
            {'-', ' ', ' ', ' ', ' ', '-'},
            {'-', ' ', ' ', ' ', ' ', '-'},
            {'-', ' ', ' ', ' ', ' ', '-'},
            {'-', ' ', ' ', ' ', ' ', '-'},
            {'-', ' ', ' ', ' ', ' ', '-'},
            {'-', ' ', ' ', ' ', ' ', '-'},
            {'-', ' ', ' ', ' ', ' ', '-'},
            {'-', ' ', ' ', ' ', ' ', '-'},
            {'-', '|', '|', '|', '|', '-'}
        };
        System.out.println("=====================");
        System.out.println("canvas expectedResult");

        for (int y = 0; y < height + 2; y++) {
            for (int x = 0; x < width+2; x++) {
                System.out.print(expectResult[x][y]);
            }
            System.out.println("");
        }
        
        
         x1 = 6;
         y1 = 3;
         x2 = 6;
         y2 = 4;
        canvasInstance.DrawLine(x1, y1, x2, y2);
        
         System.out.println("canvasResult");
         canvasInstance.printCanvas();
                
        
    }
    
    
    /**
     * Draw  horizontal line between (6,3) and (6,4)
     * Variation on y
     */
    @Test
    public void TestDrawVerticalLine(){
        System.out.println("***************************************");
         System.out.println("*DrawVerticalLine");
        int height = 4;
        int width = 20;
        
        Canvas canvasInstance = new Canvas();
        System.out.println("Original canvas");
        canvasInstance.createCanvas(width, height);
        
        //Vertical
        final int x1 = 6;
        final int y1 = 3;
        final int x2 = 6;
        final int y2 = 4;
        
        char[][] expectResult = new char[][]{
            {'-', '|', '|', '|', '|', '-'},
            {'-', ' ', ' ', ' ', ' ', '-'},
            {'-', ' ', ' ', ' ', ' ', '-'},
            {'-', ' ', ' ', ' ', ' ', '-'},
            {'-', ' ', ' ', ' ', ' ', '-'},
            {'-', ' ', ' ', ' ', ' ', '-'},
            {'-', ' ', ' ', 'x', 'x', '-'},
            {'-', ' ', ' ', ' ', ' ', '-'},
            {'-', ' ', ' ', ' ', ' ', '-'},
            {'-', ' ', ' ', ' ', ' ', '-'},
            {'-', ' ', ' ', ' ', ' ', '-'},
            {'-', ' ', ' ', ' ', ' ', '-'},
            {'-', ' ', ' ', ' ', ' ', '-'},
            {'-', ' ', ' ', ' ', ' ', '-'},
            {'-', ' ', ' ', ' ', ' ', '-'},
            {'-', ' ', ' ', ' ', ' ', '-'},
            {'-', ' ', ' ', ' ', ' ', '-'},
            {'-', ' ', ' ', ' ', ' ', '-'},
            {'-', ' ', ' ', ' ', ' ', '-'},
            {'-', ' ', ' ', ' ', ' ', '-'},
            {'-', ' ', ' ', ' ', ' ', '-'},
            {'-', '|', '|', '|', '|', '-'}
        };
        
        System.out.println("canvas expectedResult");

        for (int y = 0; y < height + 2; y++) {
            for (int x = 0; x < width+2; x++) {
                System.out.print(expectResult[x][y]);
            }
            System.out.println("");
        }
        
        System.out.println("canvasResult");
        char[][] result = canvasInstance.drawVerticalLine(x1, y1, x2, y2);
        canvasInstance.printCanvas();
       
        assertArrayEquals(expectResult, result);
        
        
    }
    
    /**
     * Draw  horizontal line between (1,2) and (6,2)
     * Variation on X
     */
    @Test
    public void TestDrawHorizontalLine(){
         System.out.println("***************************************");
         System.out.println("*DrawHorizontalLine");
        int height = 4;
        int width = 20;
        
        //horizontal
        final int x1 = 1;
        final int y1 = 2;
        final int x2 = 6;
        final int y2 = 2;

        Canvas canvasInstance = new Canvas();
        System.out.println("Original canvas");
        canvasInstance.createCanvas(width, height);
              
        char[][] expectResult = new char[][]{
            {'-', '|', '|', '|', '|', '-'},
            {'-', ' ', 'x', ' ', ' ', '-'},
            {'-', ' ', 'x', ' ', ' ', '-'},
            {'-', ' ', 'x', ' ', ' ', '-'},
            {'-', ' ', 'x', ' ', ' ', '-'},
            {'-', ' ', 'x', ' ', ' ', '-'},
            {'-', ' ', 'x', ' ', ' ', '-'},
            {'-', ' ', ' ', ' ', ' ', '-'},
            {'-', ' ', ' ', ' ', ' ', '-'},
            {'-', ' ', ' ', ' ', ' ', '-'},
            {'-', ' ', ' ', ' ', ' ', '-'},
            {'-', ' ', ' ', ' ', ' ', '-'},
            {'-', ' ', ' ', ' ', ' ', '-'},
            {'-', ' ', ' ', ' ', ' ', '-'},
            {'-', ' ', ' ', ' ', ' ', '-'},
            {'-', ' ', ' ', ' ', ' ', '-'},
            {'-', ' ', ' ', ' ', ' ', '-'},
            {'-', ' ', ' ', ' ', ' ', '-'},
            {'-', ' ', ' ', ' ', ' ', '-'},
            {'-', ' ', ' ', ' ', ' ', '-'},
            {'-', ' ', ' ', ' ', ' ', '-'},
            {'-', '|', '|', '|', '|', '-'}
        };
    
        System.out.println("canvas expectedResult");

        for (int y = 0; y < height + 2; y++) {
            for (int x = 0; x < width+2; x++) {
                System.out.print(expectResult[x][y]);
            }
            System.out.println("");
        }        
        
        System.out.println("canvasResult");
        char[][] result = canvasInstance.drawHorizontalLine(x1, y1, x2, y2);
        assertArrayEquals(expectResult, result);
    }
    
    
    
    /**
     * Test if the canvas creation for specific 
     * width
     * height
     * and a margin 
     */
    @Test
    public void TestreateCanvas() {
        System.out.println("***************************************");
        System.out.println("*CreateCanvas");
        int height = 4;
        int width = 20;

        Canvas canvasInstance = new Canvas();
        char[][] result;
        char[][] expectResult = new char[][]{
            {'-', '|', '|', '|', '|', '-'},
            {'-', ' ', ' ', ' ', ' ', '-'},
            {'-', ' ', ' ', ' ', ' ', '-'},
            {'-', ' ', ' ', ' ', ' ', '-'},
            {'-', ' ', ' ', ' ', ' ', '-'},
            {'-', ' ', ' ', ' ', ' ', '-'},
            {'-', ' ', ' ', ' ', ' ', '-'},
            {'-', ' ', ' ', ' ', ' ', '-'},
            {'-', ' ', ' ', ' ', ' ', '-'},
            {'-', ' ', ' ', ' ', ' ', '-'},
            {'-', ' ', ' ', ' ', ' ', '-'},
            {'-', ' ', ' ', ' ', ' ', '-'},
            {'-', ' ', ' ', ' ', ' ', '-'},
            {'-', ' ', ' ', ' ', ' ', '-'},
            {'-', ' ', ' ', ' ', ' ', '-'},
            {'-', ' ', ' ', ' ', ' ', '-'},
            {'-', ' ', ' ', ' ', ' ', '-'},
            {'-', ' ', ' ', ' ', ' ', '-'},
            {'-', ' ', ' ', ' ', ' ', '-'},
            {'-', ' ', ' ', ' ', ' ', '-'},
            {'-', ' ', ' ', ' ', ' ', '-'},
            {'-', '|', '|', '|', '|', '-'}
        };

        System.out.println("canvas expectedResult");

        for (int y = 0; y < height + 2; y++) {
            for (int x = 0; x < width+2; x++) {
                System.out.print(expectResult[x][y]);
            }
            System.out.println("");
        }
        System.out.println("canvas");

        result = canvasInstance.createCanvas(width, height);
        assertArrayEquals(expectResult, result);
    }
}
