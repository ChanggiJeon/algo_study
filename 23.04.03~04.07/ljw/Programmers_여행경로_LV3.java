package A202304;

import java.util.*;

class Solution2 {
    private Map<String, PriorityQueue<String>> graph = new HashMap<>();
    private List<String> itinerary = new ArrayList<>();

    public String[] solution(String[][] tickets) {
        for (String[] ticket : tickets) {
            String from = ticket[0];
            String to = ticket[1];
            if (!graph.containsKey(from)) {
                graph.put(from, new PriorityQueue<String>());
            }
            graph.get(from).offer(to);
        }

        dfs("ICN");

        Collections.reverse(itinerary);
        return itinerary.toArray(new String[itinerary.size()]);
    }

    private void dfs(String airport) {
        PriorityQueue<String> destinations = graph.get(airport);

        while (destinations != null && !destinations.isEmpty()) {
            dfs(destinations.poll());
        }

        itinerary.add(airport);
    }
}