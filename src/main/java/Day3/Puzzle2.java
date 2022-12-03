package Day3;

import java.io.*;
import java.util.HashSet;
import java.util.Set;

public class Puzzle2 {

    public static void main(String[] args) throws IOException {
        File file = new File("src/main/java/Day3/input.txt");
        InputStream inputStream = new FileInputStream(file);
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        int sumOfPriorities = 0;
        while (reader.ready()){
            String firstLine = reader.readLine();
            String secondLine = reader.readLine();
            String thirdLine = reader.readLine();
            sumOfPriorities += getBadgePriority(firstLine, secondLine, thirdLine);
        }
        System.out.println("Sum of badge priorities: " + sumOfPriorities);
    }

    private static int getBadgePriority(String firstLine, String secondLine, String thirdLine) {
        char commonCharacter = getCommonCharacter(firstLine, secondLine, thirdLine);
        return getItemValue(commonCharacter);
    }

    private static char getCommonCharacter(String firstLine, String secondLine, String thirdLine) {
        char[] firstLineCharacters = firstLine.toCharArray();
        char[] secondLineCharacters = secondLine.toCharArray();
        char[] thirdLineCharacters = thirdLine.toCharArray();
        Set<Character> commonCharacters = new HashSet<>();
        for (char firstLineCharacter: firstLineCharacters) {
            for (char secondLineCharacter: secondLineCharacters) {
                if (firstLineCharacter == secondLineCharacter){
                    commonCharacters.add(firstLineCharacter);
                }
            }
        }
        for (char thirdLineCharacter: thirdLineCharacters) {
            if (commonCharacters.contains(thirdLineCharacter)){
                return thirdLineCharacter;
            }
        }
        return 0;
    }

    private static int getItemValue(char character) {
        if (Character.isUpperCase(character)){
            return getUpperCaseCharacterValue(character);
        } else {
            return getLowerCaseCharacterValue(character);
        }
    }

    private static int getLowerCaseCharacterValue(char character) {
        return (int)character-96;
    }

    private static int getUpperCaseCharacterValue(char character) {
        return (int)character-38;
    }
}
