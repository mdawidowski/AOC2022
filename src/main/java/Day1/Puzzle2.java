package Day1;

import java.io.*;
import java.util.LinkedList;
import java.util.List;

public class Puzzle2 {

    public static void main(String[] args) throws IOException {
        List<Integer> elvesList = getElvesCaloriesList();
        printSumOfThreeBiggestElementsInList(elvesList);
    }

    private static List<Integer> getElvesCaloriesList() throws IOException {
        File file = new File("src/main/java/Day1/input.txt");
        InputStream inputStream = new FileInputStream(file);
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        LinkedList<Integer> elvesList = new LinkedList<>();
        int caloriesSum = 0;
        while (reader.ready()){
            String line = reader.readLine();
            if (line.length()>0){
                caloriesSum += Integer.parseInt(line);
            } else {
                elvesList.add(caloriesSum);
                caloriesSum = 0;
            }
        }
        return elvesList;
    }

    private static void printSumOfThreeBiggestElementsInList(List<Integer> list){
        int sum = 0;
        for (int i = 0; i < 3; i++) {
            int biggestCalories = list.get(0);
            for (int calories: list) {
                if (calories > biggestCalories){
                    biggestCalories = calories;
                }
            }
            int big = biggestCalories;
            list.removeIf(elem -> elem == big);
            sum += biggestCalories;
        }
        System.out.println("Sum of three biggest calories: " + sum);
    }
}
