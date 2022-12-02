package Day2;

import java.io.*;

public class Puzzle1 {

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
        inputs[1] = translateLetter(inputs[1]);
        if (inputs[0].equals(inputs[1])){
            score += 3;
        } else {
            score += checkIfWon(inputs[0] + inputs[1]);
        }
        score += getLetterValue(inputs[1]);
        return score;
    }
    // A - rock, B - paper, C - scissors
    private static int checkIfWon(String line) {
        switch (line){
            case "AB":
            case "BC":
            case "CA":
                return 6;
        }
        return 0;
    }

    private static String translateLetter(String letter){
        switch (letter){
            case "X":
                letter = "A";
                break;
            case "Y":
                letter = "B";
                break;
            case "Z":
                letter = "C";
        }
        return letter;
    }

    private static int getLetterValue(String letter){
        switch (letter){
            case "A":
                return 1;
            case "B":
                return 2;
            case "C":
                return 3;
        }
        return 0;
    }
}
