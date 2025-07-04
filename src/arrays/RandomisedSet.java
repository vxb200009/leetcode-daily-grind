class RandomizedSet {
    Map<Integer,Integer> dict;
    List<Integer> list;
    Random rand = new Random();

    public RandomizedSet() {
        dict = new HashMap<>();
        list = new ArrayList<>();
    }
    
    public boolean insert(int val) {
        if(dict.containsKey(val)) return false;

        dict.put(val,list.size());
        list.add(list.size(),val);
        return true;
        
    }
    
    public boolean remove(int val) {
        if(!dict.containsKey(val)) return false;
        
        int elemIndex = dict.get(val);
        int lastElem = list.get(list.size()-1);
        list.set(elemIndex,lastElem);
        dict.put(lastElem,elemIndex);

        list.remove(list.size()-1);
        dict.remove(val);
        return true;

    }
    
    public int getRandom() {
        return list.get(rand.nextInt(list.size()));
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */