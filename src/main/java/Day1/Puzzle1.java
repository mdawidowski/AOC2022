package Day1;

import java.io.*;

public class Puzzle1 {

    public static void main(String[] args) throws IOException {
        File file = new File("src/main/java/Day1/input.txt");
        InputStream inputStream = new FileInputStream(file);
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        int elfId = 1;
        int caloriesSum = 0;
        int mostCaloriesElfId = 1;
        int mostCalories = 0;
        while (reader.ready()){
            String line = reader.readLine();
            if (line.length()>0){
                caloriesSum += Integer.parseInt(line);
            } else {
                if (caloriesSum > mostCalories){
                    mostCalories = caloriesSum;
                    mostCaloriesElfId = elfId;
                }
                elfId++;
                caloriesSum = 0;
            }
        }
        System.out.println("Elf number " + mostCaloriesElfId + " has most calories: " + mostCalories);
    }

}
