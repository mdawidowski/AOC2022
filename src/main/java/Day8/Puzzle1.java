package Day8;

import java.io.*;
import java.util.LinkedList;
import java.util.List;

public class Puzzle1 {

    public static void main(String[] args) throws  IOException {
        File file = new File("src/main/java/Day8/input.txt");
        InputStream inputStream = new FileInputStream(file);
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        List<List<Integer>> treesMap = loadTreesMap(reader);
        System.out.println("Visible trees: " + getAmountOfVisibleTrees(treesMap));
    }

    private static int getAmountOfVisibleTrees(List<List<Integer>> treesMap) {
        int totalVisibleTrees = 0;
        for (int row = 0; row < treesMap.size(); row++) {
                for (int tree = 0; tree < treesMap.get(row).size(); tree++) {
                    totalVisibleTrees += isTreeVisible(tree, row, treesMap) ? 1 : 0;
                }
            }
        return totalVisibleTrees;
    }

    private static boolean isTreeVisible(int treeIndex, int rowIndex, List<List<Integer>> treesMap) {
        if (treeIndex == 0 || treeIndex == treesMap.get(rowIndex).size()-1 || rowIndex == 0 || rowIndex == treesMap.size()-1){
            return true;
        }
        if (isVisibleFromLeftOrRight(treeIndex, treesMap.get(rowIndex))){
            return true;
        }
        if (isVisibleFromUpwardsOrDownwards(treeIndex, rowIndex, treesMap)){
            return true;
        }
        return false;
    }

    private static boolean isVisibleFromUpwardsOrDownwards(int treeIndex, int rowIndex, List<List<Integer>> treesMap) {
        int treeValue = treesMap.get(rowIndex).get(treeIndex);
        boolean visibleFromUpwards = true;
        boolean visibleFromDownwards = true;
        for (int i = 0; i < rowIndex; i++) {
            if (treesMap.get(i).get(treeIndex) >= treeValue){
                visibleFromUpwards = false;
            }
        }
        for (int i = rowIndex+1; i < treesMap.size(); i++) {
            if (treesMap.get(i).get(treeIndex) >= treeValue){
                visibleFromDownwards = false;
            }
        }
        return visibleFromUpwards || visibleFromDownwards;
    }

    private static boolean isVisibleFromLeftOrRight(int treeIndex, List<Integer> treeRow) {
       int treeValue = treeRow.get(treeIndex);
        boolean visibleFromLeft = true;
        boolean visibleFromRight = true;
        for (int i = 0; i < treeIndex; i++) {
            if (treeRow.get(i) >= treeValue){
                visibleFromLeft = false;
            }
        }
        for (int i = treeIndex+1; i < treeRow.size(); i++) {
            if (treeRow.get(i) >= treeValue){
                visibleFromRight = false;
            }
        }

        return visibleFromLeft || visibleFromRight;
    }

    private static List<List<Integer>> loadTreesMap(BufferedReader reader) throws IOException {
        List<List<Integer>> treesMap = new LinkedList<>();
        while(reader.ready()){
            String line = reader.readLine();
            treesMap.add(getRowTrees(line));
        }
        return treesMap;
    }

    private static List<Integer> getRowTrees(String line) {
        char[] trees = line.toCharArray();
        List<Integer> treesRow = new LinkedList<>();
        for (char tree: trees) {
            treesRow.add(Character.getNumericValue(tree));
        }
        return treesRow;
    }
}
