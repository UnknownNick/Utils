/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util.suma;

/**
 *
 * @author JH
 */
public class Iterator {
    protected boolean[] indexes;
    protected int count;
    Iterator(int count) {
        indexes = new boolean[count];
        this.count = count;
    }
    
    boolean next() {
        boolean changed = false;
        while(!changed) {
            for(int i = 0; i <= indexes.length ;i++) {
                if(i == indexes.length){
                    return false;
                }
                if(indexes[i] == false) {
                    indexes[i] = true;
                    changed = true;
                    break;
                } else {
                    indexes[i] = false;
                }
            }
        }
        return true;
    }
    
    public int[] getNumbers() {
        int[] n = new int[this.count];
        for(int i = 0 ; i < this.count ; i++)
            n[i] = indexes[i] ? 1 : 0;
        return n;
    }
    
    public boolean[] getArray() {
        return indexes;
    }
}
