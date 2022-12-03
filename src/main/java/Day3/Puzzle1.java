package Day3;

import java.io.*;

public class Puzzle1 {

    public static void main(String[] args) throws IOException {
        File file = new File("src/main/java/Day3/input.txt");
        InputStream inputStream = new FileInputStream(file);
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        int sumOfPriorities = 0;
        while (reader.ready()){
            String line = reader.readLine();
            sumOfPriorities += getPriorityValueOfRepeatedItem(line);
        }
        System.out.println("Sum of the priorities: " + sumOfPriorities);
    }

    private static int getPriorityValueOfRepeatedItem(String line) {
        char[] firstCompartment = line.substring(0, line.length()/2).toCharArray();
        char[] secondCompartment = line.substring(line.length()/2).toCharArray();
        for (char firstCompartmentCharacter : firstCompartment) {
            for (char secondCompartmentCharacter : secondCompartment) {
                if (firstCompartmentCharacter == secondCompartmentCharacter){
                    System.out.println("First: " + firstCompartment.length + " second: " + secondCompartment.length + " duplicated: " + firstCompartmentCharacter);
                    return getItemValue(firstCompartmentCharacter);
                }
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
