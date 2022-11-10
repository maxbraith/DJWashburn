package edu.ithaca.dragon.datastructures.set;

public class IntChainedHashSet {
    
    /**
     * creates a new IntHashSet with the specified size for the underlying array
     */
    public IntChainedHashSet(int size){
       
    } 

    /**
     * @post adds an item to the set
     */
    public void add(int item){
        
    }

    /**
     * @return a valid index that will be used for a given item
     */
    public int hash(int item){
        // for now, we can just use the modulo operator and the size to choose an index
        throw new RuntimeException("Not implemented");
    }

    /**
     * @return true if the item is in the set, false otherwise
     */
    public boolean contains(int item){
        throw new RuntimeException("Not implemented");
    }

    //---------------------------------------------
    // NOTE: methods below reveal internal details used for our analysis, would not generally be public methods used regularly 

    /**
     * @post changes the size of the underlying array, and rehashes to ensure all items are in the right location
     */
    public void resize(int newSize){
        throw new RuntimeException("Not implemented");
    }

    
    /**
     * @return length of the longest chain in the hashList
     */
    public int longestChain(){
        throw new RuntimeException("Not implemented");
    }

    /**
     * @return the number of items / the size of the current hash array, or -1 if the array size is 0
     */
    public double loadFactor(){
        throw new RuntimeException("Not implemented");
    }
    
}
