import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

class RandomizedSet {

    ArrayList<Integer> arl;
    HashMap<Integer, Integer> mapKey;
    Random random;


    public RandomizedSet() {
        arl = new ArrayList<>();
        random = new Random();
        mapKey = new HashMap<>();
    }

    public boolean insert(int val) {
        if(!mapKey.containsKey(val)){
            arl.add(val);
            int index = arl.size() - 1;
            mapKey.put(val,index);
            return true;
        } else{
            return false;
        }
    }

    public boolean remove(int val) {
        if(mapKey.containsKey(val)){
            int index = mapKey.get(val);
            int lastItem = arl.get(arl.size() - 1);
            mapKey.put(lastItem, index);
            arl.set(index, lastItem);
            arl.remove(arl.size() - 1);
            mapKey.remove(val);
            return true;
        } else{
            return false;
        }
    }

    public int getRandom() {
        int index = random.nextInt(arl.size());
        return arl.get(index);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */