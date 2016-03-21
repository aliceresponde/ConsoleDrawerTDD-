/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package board;

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
public class PointTest {
    
    public PointTest() {
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

    /**
     * Test of getX method, of class Point.
     */
    @Test
    public void testGetX() {
        System.out.println("getX");
        Point instance = new Point(2, 4, 'o');
        int expResult = 2;
        int result = instance.getX();
        assertEquals(expResult, result);
       
    }

    /**
     * Test of getY method, of class Point.
     */
    @Test
    public void testGetY() {
        System.out.println("getY");
        Point instance = new Point(2, 4, 'o');
        int expResult = 4;
        int result = instance.getY();
        assertEquals(expResult, result);  
    }

    /**
     * Test of getColor method, of class Point.
     */
    @Test
    public void testGetColor() {
        System.out.println("getColor");
        Point instance = new Point(2, 4, 'o');
        char expResult = 'o';
        char result = instance.getColor();
        assertEquals(expResult, result);
       
    }
    
    /**
     * Define if a point is adjacent to another
     */
    @Test
    public void testIsCruzNeighbourTo(){
      System.out.println("IsNeighbor");
      Point point_a = new Point(2, 4, 'o');
      Point point_b = new Point(2, 5, 'o');
      
      //down
      boolean expecteds=true;
      boolean result = point_a.isCruzNeighbourTo(point_b);
      assertEquals(expecteds, result);
      
     //top
      point_b = new Point(2, 3, 'o');
      result = point_a.isCruzNeighbourTo(point_b);
      assertEquals(expecteds, result);
      
      
      //left
      point_b = new Point(1, 4, 'o');
      result = point_a.isCruzNeighbourTo(point_b);
      assertEquals(expecteds, result);
      
      //rigth
      point_b = new Point(3, 4, 'o');
      result = point_a.isCruzNeighbourTo(point_b);
      assertEquals(expecteds, result);
    }
}
