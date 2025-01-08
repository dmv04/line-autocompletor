package io.github.dmv04;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import static io.github.dmv04.util.MapSorter.sortMap;
import static io.github.dmv04.util.ValueSelector.select;;

public class Autocompletor {
    public static String autocompletion() {

        // Reading data from terminal/command line

        Scanner scanner = new Scanner(System.in);

        var inputSet = new HashMap<String, Integer>();

        var numberOfInputLines = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < numberOfInputLines; i++) {
            var scannedString = scanner.nextLine();
            var words = scannedString.split(" ");
            inputSet.put(words[0], Integer.parseInt(words[1]));
        }

        var numberOfSortingLines = Integer.parseInt(scanner.nextLine());
        var sortingSet = new String[numberOfSortingLines];

        for (int i = 0; i < numberOfSortingLines; i++) {
            sortingSet[i] = scanner.nextLine();
        }

        scanner.close();

        // Selecting of values satisfying the condition

        var completionsList = select(sortingSet, inputSet);

        // Alphabet sorting and collecting to string

        var stringBuilder = new StringBuilder();

        for (Map<String, Integer> map : completionsList) {
            stringBuilder.append(sortMap(map)).append("\n");
            stringBuilder.append("\n");
        }

        var resultString = stringBuilder.toString();

        return resultString.trim();
    }
}
