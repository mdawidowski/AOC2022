package Day2;

import java.io.*;

public class Puzzle2 {

    public static void main(String[] args) throws IOException {
        File file = new File("src/main/java/Day2/input.txt");
        InputStream inputStream = new FileInputStream(file);
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        int totalScore = 0;
        while (reader.ready()){
            String line = reader.readLine();
            totalScore += getScoreFromLine(line);
        }
        System.out.println("Total score: " + totalScore);
    }

    private static int getScoreFromLine(String line) {
        int score = 0;
        String[] inputs = line.split(" ");
        switch (inputs[1]){
            case "X":
                score += getValueOfLoseRound(inputs[0]);
                break;
            case "Y":
                score += getValueOfDrawRound(inputs[0]);
                break;
            case "Z":
                score += getValueOfWinRound(inputs[0]);
                break;
        }
        return score;
    }

    // A - rock, B - paper, C - scissors
    private static int getValueOfWinRound(String input) {
        switch (input){
            case "A":
                return 2+6;
            case "B":
                return 3+6;
            case "C":
                return 1+6;
        }
        return 0;
    }

    private static int getValueOfDrawRound(String input) {
        switch (input){
            case "A":
                return 1+3;
            case "B":
                return 2+3;
            case "C":
                return 3+3;
        }
        return 0;
    }

    private static int getValueOfLoseRound(String input) {
        switch (input){
            case "A":
                return 3;
            case "B":
                return 1;
            case "C":
                return 2;
        }
        return 0;
    }
}
