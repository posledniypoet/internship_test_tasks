import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<HashMap<Character, Integer>,
                ArrayList<String>>
                map = new HashMap<>();
        for(String str : strs){
            HashMap<Character, Integer> tempMap = new HashMap<>();
            for (int i = 0; i < str.length(); i++) {
                if (tempMap.containsKey(str.charAt(i))) {
                    int x = tempMap.get(str.charAt(i));
                    tempMap.put(str.charAt(i), ++x);
                }
                else {
                    tempMap.put(str.charAt(i), 1);
                }
            }
            if(map.containsKey(tempMap)){
                map.get(tempMap).add(str);
            } else{
                ArrayList<String> tempList = new ArrayList<>();
                tempList.add(str);
                map.put(tempMap, tempList);
            }
        }
        List<List<String>> answer = new ArrayList<>();
        for (HashMap<Character, Integer> temp : map.keySet())
            answer.add(map.get(temp));
        return answer;
    }
}