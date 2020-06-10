package fxcheck.binaryheap;

import java.util.*;

/**
 * Create by xudong
 * Author: xudong
 * Date: 2020-06-08
 */
public class TopKeyquent {


    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> countMap = new HashMap<>();

        for(int i = 0; i < nums.length; i++){
            countMap.put(nums[i], countMap.getOrDefault(nums[i], 0) + 1);
        }

        PriorityQueue<Integer> heap = new PriorityQueue<>((n1, n2) -> countMap.get(n1) - countMap.get(n2));

        for(int n: countMap.keySet()){
            heap.add(n);
            if(heap.size() > k){
                heap.poll();
            }

        }
        int[] result = new int[k];
        int j = 0;
        while(heap.peek()!= null){
            result[j] = heap.poll();
            j++;
        }

        return result;


    }
}
