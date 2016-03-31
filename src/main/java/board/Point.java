/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package board;

/**
 *
 * @author alice
 */
class Point {
     private int x; 
     private int y;
     private char color;

    public Point(int x, int y, char color) {
        this.x = x;
        this.y = y;
        this.color = color;
    }
 
     
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    } 

    public char getColor() {
        return color;
    }

    /**
     * Say  if a point is continuous to other point, checking that are adjacent in vertical and horizontal
     * @param otherPoint
     * @return 
     */
    boolean isCruzNeighbourTo(Point otherPoint) {
        
        //vertical
        if( this.getX() == otherPoint.getX() && 
                (this.getY() == otherPoint.getY()-1 || this.getY() == otherPoint.getY()+1) ){
            return true;
        }
        //horizontal
        else if(this.getY() == otherPoint.getY() &&
                (this.getX() == otherPoint.getX()-1 || this.getX() == otherPoint.getX()+1)){
            return true;
        }
        else   return false;       
    }
    
    
    
    
    
     
}
