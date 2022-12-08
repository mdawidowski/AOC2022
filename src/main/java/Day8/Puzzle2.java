package Day8;

import java.io.*;
import java.util.LinkedList;
import java.util.List;

public class Puzzle2 {

    public static void main(String[] args) throws IOException {
        File file = new File("src/main/java/Day8/input.txt");
        InputStream inputStream = new FileInputStream(file);
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        List<List<Integer>> treesMap = loadTreesMap(reader);
        System.out.println("Highest scenic score: " + getHighestScenicScore(treesMap));
    }

    private static int getHighestScenicScore(List<List<Integer>> treesMap) {
        int highestScenicScore = 0;
        for (int row = 0; row < treesMap.size(); row++) {
            for (int tree = 0; tree < treesMap.get(row).size(); tree++) {
                int scenicScore = getScenicScore(tree, row, treesMap);
                if (scenicScore > highestScenicScore){
                    highestScenicScore = scenicScore;
                }
            }
        }
        return highestScenicScore;
    }

    private static int getScenicScore(int treeIndex, int rowIndex, List<List<Integer>> treesMap) {
        int scenicScoreFromUp = getScenicScoreFromUp(treeIndex, rowIndex, treesMap);
        int scenicScoreFromDown = getScenicScoreFromDown(treeIndex, rowIndex, treesMap);
        int scenicScoreFromLeft = getScenicScoreFromLeft(treeIndex, treesMap.get(rowIndex));
        int scenicScoreFromRight = getScenicScoreFromRight(treeIndex, treesMap.get(rowIndex));
        return scenicScoreFromUp * scenicScoreFromDown * scenicScoreFromLeft * scenicScoreFromRight;
    }

    private static int getScenicScoreFromRight(int treeIndex, List<Integer> treeRow) {
        int scenicScore = 0;
        int treeValue = treeRow.get(treeIndex);
        for (int i = treeIndex+1; i < treeRow.size(); i++) {
            if (treeValue > treeRow.get(i)){
                scenicScore += 1;
            } else {
                scenicScore +=1;
                break;
            }
        }
        return scenicScore;
    }

    private static int getScenicScoreFromLeft(int treeIndex, List<Integer> treeRow) {
        int scenicScore = 0;
        int treeValue = treeRow.get(treeIndex);
        for (int i = treeIndex-1; i >= 0; i--) {
            if (treeValue > treeRow.get(i)){
                scenicScore += 1;
            } else {
                scenicScore +=1;
                break;
            }
        }
        return scenicScore;
    }

    private static int getScenicScoreFromDown(int treeIndex, int rowIndex, List<List<Integer>> treesMap) {
        int scenicScore = 0;
        int treeValue = treesMap.get(rowIndex).get(treeIndex);
        for (int i = rowIndex+1; i < treesMap.size(); i++) {
            if (treeValue > treesMap.get(i).get(treeIndex)){
                scenicScore +=1;
            } else {
                scenicScore +=1;
                break;
            }
        }
        return scenicScore;
    }

    private static int getScenicScoreFromUp(int treeIndex, int rowIndex, List<List<Integer>> treesMap) {
        int scenicScore = 0;
        int treeValue = treesMap.get(rowIndex).get(treeIndex);
        for (int i = rowIndex-1; i >= 0; i--) {
            if (treeValue > treesMap.get(i).get(treeIndex)){
                scenicScore +=1;
            } else {
                scenicScore +=1;
                break;
            }
        }
        return scenicScore;
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
