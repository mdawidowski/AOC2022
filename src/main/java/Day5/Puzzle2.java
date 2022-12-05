package Day5;

import java.io.*;
import java.util.Collections;
import java.util.HashMap;
import java.util.Stack;

public class Puzzle2 {

    public static void main(String[] args) throws IOException {
        File file = new File("src/main/java/Day5/input.txt");
        InputStream inputStream = new FileInputStream(file);
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        HashMap<Integer, Stack<String>> stacks = getStacks(reader);

        while (reader.ready()){
            String line = reader.readLine();
            moveItemsInStacks(line, stacks);
        }
        for (int i = 1; i <= stacks.keySet().size(); i++) {
            System.out.print(stacks.get(i).pop());
        }
    }

    private static void moveItemsInStacks(String line, HashMap<Integer, Stack<String>> stacks) {
        String[] splittedLine = line.split(" ");
        int amountToMove = Integer.parseInt(splittedLine[1]);
        int from = Integer.parseInt(splittedLine[3]);
        int to = Integer.parseInt(splittedLine[5]);
        move(stacks, from, to, amountToMove);
    }

    private static void move(HashMap<Integer, Stack<String>> stacks, int from, int to, int amountToMove) {
        Stack<String> subStack = new Stack<>();
        for (int i = 0; i < amountToMove; i++) {
            subStack.push(stacks.get(from).pop());
        }
        for (int i = 0; i < amountToMove; i++) {
            stacks.get(to).push(subStack.pop());
        }

    }

    private static HashMap<Integer, Stack<String>> getStacks(BufferedReader reader) throws IOException {
        String line = reader.readLine();
        String[] columns = line.split("(?<=\\G.{" + 4 + "})");
        HashMap<Integer, Stack<String>> stacks = getEmptyStacks(columns);
        while (!line.isEmpty()){
            for (int i = 0; i < columns.length; i++) {
                if (columns[i].trim().matches("\\[[A-Z]]")){
                    stacks.get(i+1).push(columns[i].trim().replace("[","").replace("]",""));
                }
            }
            line = reader.readLine();
            if (!line.isEmpty()){
                columns = line.split("(?<=\\G.{" + 4 + "})");
            }
        }

        for (int i = 1; i <= stacks.keySet().size(); i++) {
            Collections.reverse(stacks.get(i));
        }

        return stacks;
    }

    private static HashMap<Integer, Stack<String>> getEmptyStacks(String[] columns) {
        HashMap<Integer, Stack<String>> stacks = new HashMap<>();
        for (int i = 0; i <= columns.length; i++) {
            stacks.put(i+1, new Stack<>());
        }
        return stacks;
    }
}
