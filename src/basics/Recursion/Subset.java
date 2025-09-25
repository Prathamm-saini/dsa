package basics.Recursion;

import java.util.ArrayList;

public class Subset {
    public static void main(String[] args) {
        int[] array = {1,2,3};
        ArrayList<ArrayList<Integer>> list = subset(array);
        System.out.println(list);

    }
    // The base idea is at every move we go down we just create copy of previous oldList and add a num
    // and add it in original list creating two list of lists for 1 -> [] [1] - level 1
    // similarly for level 2 -> [] [1]{copy created of outerList} -> add 2 in both -> [2],[1,2]
    // ofc for level 2 previous is already stored so its -> [],[1],[2],[1,2], same for 3
    private static ArrayList<ArrayList<Integer>> subset(int[] array){
        ArrayList<ArrayList<Integer>> outerList = new ArrayList<>();
        outerList.add(new ArrayList<>()); // added an empty element
        for (int num : array) { // pick an element
            int size = outerList.size();
            for (int i = 0; i <size; i++) {
                // concept is adding copy of previous olderlist and adding a num onto it and add it
                // in original list.
                ArrayList<Integer> internalList = new ArrayList<>(outerList.get(i));
                internalList.add(num);
                outerList.add(internalList);
            }
        }
        return outerList;
    }
}
