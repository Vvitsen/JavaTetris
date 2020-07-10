/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tetris;

import java.awt.Color;
import java.awt.Graphics;
import static java.lang.Math.random;

/**
 *
 * @author Victor.Malmygin
 */
public class Figure {
    
    private final int SIZE = 25;
    private int[] point = {0, 0};
    private int x = 0;
    private int y = 0;
    private final int[][][] shapes ={
        {{0,0,0,0},
         {1,1,1,1}, 
         {0,0,0,0}, 
         {0,0,0,0}}, // I
        
        {{0,0,0,0}, 
         {0,1,1,0}, 
         {0,1,1,0}, 
         {0,0,0,0}}, // O
        
        {{1,0,0,0}, 
         {1,1,1,0}, 
         {0,0,0,0}, 
         {0,0,0,0}}, // J
        
        {{0,0,1,0},
         {1,1,1,0}, 
         {0,0,0,0}, 
         {0,0,0,0}}, // L
        
        {{0,1,1,0}, 
         {1,1,0,0}, 
         {0,0,0,0}, 
         {0,0,0,0}}, // S
        
        {{1,1,1,0}, 
         {0,1,0,0}, 
         {0,0,0,0}, 
         {0,0,0,0}}, // T
        
        {{1,1,0,0},
         {0,1,1,0},
         {0,0,0,0}, 
         {0,0,0,0}}  // Z
    };
    
    private int[][][] altShapes = {
        {{y + 0, x + 0},
         {y + 0, x + 1},
         {y + 0, x + 2},
         {y + 0, x + 3}},
        
        {{y + 0, x + 0},
         {y + 0, x + 1},
         {y + 1, x + 0},
         {y + 1, x + 1}},
        
        {{y + 0, x + 0},
         {y + 0, x + 1},
         {y + 0, x + 2},
         {y + 1, x + 0}},
        
        {{y + 0, x + 0},
         {y + 0, x + 1},
         {y + 0, x + 2},
         {y + 1, x + 1}},
        
        {{y + 0, x + 0},
         {y + 0, x + 1},
         {y + 1, x + 1},
         {y + 1, x + 2}}
    };
    
    private int[][] shape;
    private int[][] altShape;

    public Figure() {
        int index = (int) (random() * 5);
        shape = shapes[index];
        index = (int) (random() * 5);
        altShape = altShapes[index];
    }
        
    public int[][] getShape(){
        return shape;
    }
    
    public int[][] getAltShape(){
        return altShape;
    }
    
    public int[] getPoint(){
        return point;
    }
    
    public void setPoint(int[] p){
        point[0] = p[0];
        point[1] = p[1];
    }
    
    public void setX (int x){
        this.x = x;
    }
    public void setY (int y){
        this.y = y;
    }

    int getY() {
        return y;
    }
    int getX() {
        return x;
    }
    
}
