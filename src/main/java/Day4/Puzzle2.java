package Day4;

import java.io.*;

public class Puzzle2 {

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
        String[] sectionOneIds = getSectionIds(firstRange);
        String[] sectionTwoIds = getSectionIds(secondRange);
        for (String sectionOneId: sectionOneIds) {
            for (String sectionTwoId: sectionTwoIds) {
                if (sectionOneId.equals(sectionTwoId)){
                    return true;
                }
            }
        }
        return false;
    }

    private static String[] getSectionIds(String range) {
        int startRange = Integer.parseInt(range.substring(0, range.lastIndexOf('-')));
        int endRange = Integer.parseInt(range.substring(range.lastIndexOf('-')+1));
        String[] rangeFull = new String[endRange-startRange+1];
        int index = 0;
        for (int i = startRange; i <= endRange; i++) {
            rangeFull[index] = String.valueOf(i);
            index++;
        }
        return rangeFull;
    }
}
