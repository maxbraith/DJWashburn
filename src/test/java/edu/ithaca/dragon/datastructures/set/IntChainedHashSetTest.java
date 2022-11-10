package edu.ithaca.dragon.datastructures.set;


import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

public class IntChainedHashSetTest {
   
    @Test
    public void addResizeTest(){
        IntChainedHashSet mySet = new IntChainedHashSet(7);
        List<Integer> someItems = Arrays.asList(2, 11, 1, 12, 5, 8, 26, -5);
        List<Integer> itemsNotIncluded = Arrays.asList(0, 9, 13, -1);

        for (int item : someItems){
            mySet.add(item);
        }
        
        for (int item : someItems){
            assertTrue(mySet.contains(item));
        }

        for (int item : itemsNotIncluded){
            assertFalse(mySet.contains(item));
        }

        mySet.resize(13);
        for (int item : someItems){
            assertTrue(mySet.contains(item));
        }

        for (int item : itemsNotIncluded){
            assertFalse(mySet.contains(item));
        }
    }
}
