/*
* 1. Two Sum
* Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

You can return the answer in any order.



Example 1:

Input: nums = [2,7,11,15], target = 9
Output: [0,1]
Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].

Example 2:

Input: nums = [3,2,4], target = 6
Output: [1,2]

Example 3:

Input: nums = [3,3], target = 6
Output: [0,1]



Constraints:

    2 <= nums.length <= 104
    -109 <= nums[i] <= 109
    -109 <= target <= 109
    Only one valid answer exists.


Follow-up: Can you come up with an algorithm that is less than O(n2) time complexity?
* */


import java.util.*;
public class TwoSum {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter No of Array Elements");
        int noOfArrayElements = scanner.nextInt();
        int[] numArray = new int[noOfArrayElements];
        for (int i = 0; i < noOfArrayElements; i++) {
            numArray[i] = scanner.nextInt();
        }
        System.out.println("Enter resultant Sum");
        int resultantSum = scanner.nextInt();
        TwoSum twoSum = new TwoSum();
        int[] twoSumResult = twoSum.twoSum(numArray, resultantSum);
        System.out.println("the two indexes are " + twoSumResult[0] + " " + twoSumResult[1]);
    }

    /* public int[] twoSum(int[] nums, int target) {
        // TakeAway from below Arrays.asList() does not work for primitive arrays..As Arrays.asList() accept generic type T. Since Java generics work only on reference types (object types), not on primitives, our above example failed.
        //Since int[] as a whole is an object it can be added as a single element:
        //Set<Integer> arrayAsSet = new HashSet<>(Arrays.asList(nums));
        // Solution is to use functional programming using Arrays.saveAll which takes lambda function of a Integer array as below
        //  Arrays.setAll(newIntegerArray, i -> nums[i]);
        Map<Integer, Integer> duplicateArrayElementsIndexesMap = new HashMap<>();
        Map<Integer, Integer> numArrayAsMap = new HashMap<>();
        int[] returnedValueOfTwoIndexes = new int[2];
        for (int i = 0; i < nums.length; i++) {
            if (numArrayAsMap.containsKey(nums[i]) && !duplicateArrayElementsIndexesMap.containsKey(nums[i])) {
                duplicateArrayElementsIndexesMap.put(nums[i], i);
            } else {
                numArrayAsMap.put(nums[i], i);
            }
        }
        if (numArrayAsMap.containsKey(target / 2) && duplicateArrayElementsIndexesMap.containsKey(target / 2)) {
            returnedValueOfTwoIndexes[0] = numArrayAsMap.get(target / 2);
            returnedValueOfTwoIndexes[1] = duplicateArrayElementsIndexesMap.get(target / 2);
            return returnedValueOfTwoIndexes;
        }
//        Integer firstIndexedNumber = Arrays.asList(newIntegerArray).stream().filter(number -> numArrayAsMap.containsKey(target - number) && (target - number) != number).findFirst().orElse(null);
        for (int num : nums) {
            if (numArrayAsMap.containsKey(target - num) && (target-num)!=num) {
                returnedValueOfTwoIndexes[0] = numArrayAsMap.get(num);
                returnedValueOfTwoIndexes[1] = numArrayAsMap.get(target - num);
                return returnedValueOfTwoIndexes;
            }
        }
        returnedValueOfTwoIndexes[0] = -1;
        returnedValueOfTwoIndexes[1] = -1;
        return returnedValueOfTwoIndexes;
    }*/
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> hMap = new LinkedHashMap<>();
        int[] result = new int[2];
        for(int i=0;i< nums.length;i++) {
            if(hMap.containsKey(nums[i])) {
                if(target/2 == nums[i]){
                    result[0] = hMap.get(nums[i]);
                    result[1] = i;
                    return result;
                }
            }
            else {
                hMap.put(nums[i],i);
            }

        }
//        Map.Entry<Integer, Integer> k = hMap.entrySet().stream().filter(i -> hMap.containsKey(target - i.getKey()) && target/2 != i.getKey()).findFirst().get();
//        result[0] = hMap.get(k.getKey());
//        result[1] = hMap.get(target - k.getKey());
        for(Integer i: hMap.keySet()) {
            if(hMap.containsKey(target - i) && target/2 != i) {
                result[0] = hMap.get(i);
                result[1] = hMap.get(target - i);
                break;
            }
        }
        return result;


    }
}
