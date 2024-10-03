import java.util.*;
import java.io.*;

class Solution {
    
    static List<String> list = new ArrayList<>();
    static int len;
    static boolean[] visited;
    
    public String[] solution(String[][] tickets) {
        String[] answer = {};
        
        len = tickets.length;
        visited = new boolean[len];
        
        dfs("ICN", "ICN", 0, tickets);
        
        Collections.sort(list);
        
        return list.get(0).split(" ");
    }
    
    static void dfs(String start, String path, int depth, String[][] tickets) {
        if (depth == len) {
            list.add(path);
            return;
        }
        
        for (int i = 0; i < len; i++) {
            if (!visited[i] && start.equals(tickets[i][0])) {
                visited[i] = true;
                dfs(tickets[i][1], path + " " + tickets[i][1], depth + 1, tickets);
                visited[i] = false;
            }
        }
    }
}