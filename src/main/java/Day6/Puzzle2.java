package Day6;

import java.io.*;

public class Puzzle2 {

    public static void main(String[] args) throws IOException {
        File file = new File("src/main/java/Day6/input.txt");
        InputStream inputStream = new FileInputStream(file);
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        if (reader.ready()){
            String line = reader.readLine();
            int markerAppearancePosition = getMarkerAppearancePosition(line);
            System.out.println("Marker appearance postition: " + markerAppearancePosition);
        }
    }

    private static int getMarkerAppearancePosition(String line) {
        for (int i = 0; i < line.length(); i++) {
            boolean markerAppearance = checkIfMarkerAppears(line.substring(i, i+14));
            if (markerAppearance){
                return i+14;
            }
        }
        return 0;
    }

    private static boolean checkIfMarkerAppears(String substring) {
        for (int j = 0; j < substring.length(); j++) {
            for (int i = 0; i < substring.length(); i++) {
                if (substring.charAt(j) == substring.charAt(i) && j != i){
                    return false;
                }
            }
        }
        return true;
    }
}
