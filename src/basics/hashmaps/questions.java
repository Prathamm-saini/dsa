package basics.hashmaps;

import java.util.HashMap;


public class questions {
    public static void main(String[] args) {
        int[] array = {1,2,2,1,3,6,6,6};
        mostFrequentElementsBrute(array);
        mostFrequentElements(array);

    }
    static void mostFrequentElementsBrute(int[] array){
        // time complexity -> o(n square) space complexity is o(n)
        boolean[] visited = new boolean[array.length];
        int maxFrequency = 0;
        int element = -1;

        for (int i = 0; i < array.length; i++) {
            int currentFrequency = 1;
            if(visited[i]){
                continue;
            }

            for (int j = i + 1; j < array.length; j++) {
                if (array[i] == array[j]) {
                    currentFrequency++;
                    visited[j] = true; // marked duplicates as visited
                }
            }

            if (currentFrequency > maxFrequency) {
                maxFrequency = currentFrequency;
                element = array[i];
            }
        }

        System.out.println(element + " appears " + maxFrequency + " times");
    }
    static void mostFrequentElements(int[] array){
        HashMap<Integer, Integer> map = new HashMap<>();
        int maxFrequency = 0;
        int element = -1;
        // concept of frequency map
        for(int value : array){
            int frequency = map.getOrDefault(value, 0)+1;
            map.put(value, frequency);
            if(frequency > maxFrequency){
                maxFrequency = frequency;
                element = value;
            }
        }
        System.out.println(element + " appears " + maxFrequency + " times");
    }
    static boolean arraySubsetOfAnotherBrute(int[] array1, int [] array2) {
        boolean[] visited = new boolean[array1.length];

        for (int i = 0; i <array2.length; i++) {
            boolean found = false;
            for (int j = 0; j <array1.length; j++) {
                if(!visited[j] && array2[i] == array1[j]){
                    visited[j] = true;
                    found = true;
                    break;
                }
            }
            if(!found){
                return false;
            }
        }
        return true;
    }

}
