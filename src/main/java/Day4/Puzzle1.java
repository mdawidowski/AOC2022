package Day4;

import java.io.*;

public class Puzzle1 {

    public static void main(String[] args) throws IOException {
        File file = new File("src/main/java/Day4/input.txt");
        InputStream inputStream = new FileInputStream(file);
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        int sumOfOverlaps = 0;
        while (reader.ready()){
            String line = reader.readLine();
            sumOfOverlaps += checkIfPairOverlaps(line);
        }
        System.out.println("Total overlaps: " + sumOfOverlaps);
    }

    private static int checkIfPairOverlaps(String line) {
        String firstRange = line.substring(0, line.lastIndexOf(','));
        String secondRange = line.substring(line.lastIndexOf(',')+1);
        if (checkIfIsInRange(firstRange, secondRange)){
            return 1;
        }
        return 0;
    }

    private static boolean checkIfIsInRange(String firstRange, String secondRange) {
        int startFirstRange = Integer.parseInt(firstRange.substring(0, firstRange.lastIndexOf('-')));
        int endFirstRange = Integer.parseInt(firstRange.substring(firstRange.lastIndexOf('-')+1));
        int startSecondRange = Integer.parseInt(secondRange.substring(0, secondRange.lastIndexOf('-')));
        int endSecondRange = Integer.parseInt(secondRange.substring(secondRange.lastIndexOf('-')+1));
        if ((startFirstRange <= startSecondRange && endFirstRange >= endSecondRange) || (startFirstRange >= startSecondRange && endFirstRange <= endSecondRange)){
            return true;
        }
        return false;
    }
}
