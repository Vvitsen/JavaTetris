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
        {{0, 0},
         {0, 1},
         {0, 2},
         {0, 3}},
        
        {{0, 0},
         {0, 1},
         {1, 0},
         {1, 1}},
        
        {{0, 0},
         {0, 1},
         {0, 2},
         {1, 0}},
        
        {{0, 0},
         {0, 1},
         {0, 2},
         {1, 1}},
        
        {{0, 0},
         {0, 1},
         {1, 1},
         {1, 2}}
    };
    
    private int[][] shape;
    private int[][] altShape;

    public Figure() {
        int index = (int) (random() * 5);
        shape = shapes[index];
        index = (int) (random() * 5);
        altShape = altShapes[index];
    }
    
    public void rotate(){
        for (int i = 0; i < 2; i++)
                for (int j = i; j < 3-i; j++)
                    { // clockwise
                        int tmp = shape[3-j][i];
                        shape[3-j][i] = shape[3-i][3-j];
                        shape[3-i][3-j] = shape[j][3-i];
                        shape[j][3-i] = shape[i][j];
                        shape[i][j] = tmp;
                    } 
    }
    
    public int[][] getShape(){
        return shape;
    }
    
    public int[][] getAltShape(){
        return altShape;
    }
    
}
