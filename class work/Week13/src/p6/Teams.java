package p6;

import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

public class Teams {
    public static void main(String[] args) {
        TreeMap<String, String> teams = new TreeMap<>();

        teams.put("San Francisco", "Forty-niners");
        teams.put("Chicago", "Bears");
        teams.put("Denver", "Broncos");
        teams.put("Seattle", "Seahawks");
        teams.put("Miami", "Dolphins");
        teams.put("Detroit", "Lions");

        System.out.println("Size: " + teams.size());
        System.out.println("Team from Chicago: " + teams.get("Chicago"));

        teams.put("San Francisco", "Niners");

        System.out.printf("San Diego %s a team\n",
                teams.containsKey("San Diego")? "has" : "doesn't have ");

        teams.remove("Denver");

        teams.put("Dallas", "Cowboys");

        System.out.println(teams);
        for (Map.Entry<String, String> entry : teams.entrySet()){
            System.out.printf("Key: %-15s Value: %-15s\n",
                    entry.getKey(), entry.getValue());
        }

        TreeMap<String, String> teamsDescendingOrder =
                new TreeMap<>(Collections.reverseOrder());
        teamsDescendingOrder.putAll(teams);
        System.out.println(teamsDescendingOrder);
    }
}
