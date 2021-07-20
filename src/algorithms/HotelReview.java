package algorithms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class HotelReview {

	public static void main(String[] args) {
		List<String> B = new ArrayList<>();
		B.add("water_is_cool");
		B.add("cold_ice_drink");
		B.add("cool_wifi_speed");
		System.out.println(hotelReview("cool_ice_wifi", B));

	}
	
	public static List<Integer> hotelReview(String A, List<String> B) {
		String[] a = A.split("_");
        TrieNode head = new TrieNode();
        TrieNode t = new TrieNode();
        for(String b : a){
            t.insert(head, b);
        }
        TreeMap<Integer, List<Integer>> map = new TreeMap<>();
        for(int i = 0;i<B.size();i++){
            int count = 0;
            a = B.get(i).split("_");
            for(String c : a){
                if(t.search(head, c)){
                    count++;
                }
            }
            if(!map.containsKey(count)){
                map.put(count,new ArrayList<Integer>());
            }
            map.get(count).add(i);
        }
        ArrayList<Integer> res = new ArrayList<Integer>();
        for(int j = map.lastKey();j>=map.firstKey();j--){
            if(map.containsKey(j)){
                res.addAll(map.get(j));
            }
        }
        return res;
	}
	
	public static class TrieNode{
	    boolean isEnd;
	    Map<Character, TrieNode> map;
	    TrieNode(){
	        map = new HashMap<Character, TrieNode>();
	    }
	    public TrieNode getNewNode(){
	        TrieNode t = new TrieNode();
	        t.isEnd = false;
	        return t;
	    }
	    public void insert(TrieNode head, String str){
	        TrieNode cur = head;
	        for(int i = 0;i<str.length();i++){
	            if(!cur.map.containsKey(str.charAt(i))){
	                cur.map.put(str.charAt(i), getNewNode());
	            }
	            cur = cur.map.get(str.charAt(i));
	        }
	        cur.isEnd = true;
	    }
	    public boolean search(TrieNode head, String str){
	        if(head==null){
	            return false;
	        }
	        TrieNode cur = head;
	        for(int i = 0;i<str.length();i++){
	            if(!cur.map.containsKey(str.charAt(i))){
	                return false;
	            }
	            cur = cur.map.get(str.charAt(i));
	        }
	        return cur.isEnd;
	    }
	}

}
