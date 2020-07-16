/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tetris;

/**
 *
 * @author Victor.Malmygin
 */
public enum Direction {   
    LEFT (0, -1),
    RIGHT (0, 1),
    UP (-1, 0),
    DOWN (1, 0);
    
    private final int dy;
    private final int dx;
    
    Direction(int dy, int dx){
        this.dy = dy;
        this.dx = dx;
    }
    public int dy(){ return dy;}
    public int dx(){return dx;}
    
}
