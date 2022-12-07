package Day7;

import java.io.*;
import java.util.HashMap;

public class Puzzle1 {

    public static void main(String[] args) throws IOException {
        File file = new File("src/main/java/Day7/input.txt");
        InputStream inputStream = new FileInputStream(file);
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        HashMap<String, Integer> directoriesMap = new HashMap<>();
        executeCommands(reader, directoriesMap);
        System.out.println(getTotalSizeOfDirectoriesWithSizeLessOrEquals100000(directoriesMap));
    }

    private static int getTotalSizeOfDirectoriesWithSizeLessOrEquals100000(HashMap<String, Integer> directoriesMap) {
        int sumOfLessOrEqual100000 = 0;
        for (int value: directoriesMap.values()) {
            if (value <= 100000){
                sumOfLessOrEqual100000 += value;
            }
        }
        return sumOfLessOrEqual100000;
    }

    private static void executeCommands(BufferedReader reader, HashMap<String, Integer> directoriesMap) throws IOException {
        String currentDir = "";
        while (reader.ready()) {
            String readLine = reader.readLine();
            String[] line = readLine.split(" ");
            switch (line[0]){
                case "$":
                    if (line[1].equals("cd")){
                        switch(line[2]){
                            case "/":
                                currentDir = ".";
                                if (!directoriesMap.containsKey(currentDir)){
                                    directoriesMap.put(currentDir, 0);
                                }
                                break;
                            case "..":
                                currentDir = currentDir.substring(0, currentDir.lastIndexOf("/"));
                                break;
                            default:
                                currentDir += "/" + line[2];
                                if (!directoriesMap.containsKey(currentDir)){
                                    directoriesMap.put(currentDir, 0);
                                }
                        }
                    }
                    break;
                case "dir":
                    if (!directoriesMap.containsKey(currentDir)){
                        directoriesMap.put(currentDir, 0);
                    }
                    break;
                default:
                    if (line[0].matches("^[-1-9]\\d*$")){
                        addDirSizeToDirectories(directoriesMap, currentDir, line[0]);
                    }
        }
    }

}

    private static void addDirSizeToDirectories(HashMap<String, Integer> directoriesMap, String currentDir, String value) {
        int intValue = Integer.parseInt(value);
        String dir = currentDir;
        while (!dir.isBlank()){
            directoriesMap.put(dir, directoriesMap.get(dir)+intValue);
            if (!dir.equals(".")){
                dir = dir.substring(0, dir.lastIndexOf("/"));
            } else {
                dir = "";
            }
        }
    }
}
