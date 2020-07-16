/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tetris;

import java.util.ArrayList;

/**
 *
 * @author Victor.Malmygin
 * @param <E>
 */
public class CircularList<E> extends ArrayList<E> {
    @Override
    public E get(int index)
    {
        if(index < 0)
            index = index + size();

        return super.get(index % size());
    }
}
