package problems.sets.easy;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DestinationCity {
    public static void main(String[] args) {
        List<List<String>> paths = new ArrayList<>();
        paths.add(List.of("London", "New York"));
        paths.add(List.of("New York", "Lima"));
        paths.add(List.of("Lima", "Sao Paulo"));
        String result = destCity(paths);
        System.out.println(result);
    }

    public static String destCity(List<List<String>> paths) {
        Set<String> startingCities = new HashSet<>();

        for (List<String> path : paths) {
            startingCities.add(path.getFirst());
        }

        for (List<String> path : paths) {
            String destinationCity = path.get(1);
            if (!startingCities.contains(destinationCity)) {
                return destinationCity;
            }
        }

        return "";
    }
}