import java.util.*;
import java.io.*;

class Solution {
    
    static boolean[] visited;
    static int len;
    
    public int solution(String begin, String target, String[] words) {        
        len = words.length;
        visited = new boolean[len];
                
        return bfs(begin, target, words);
    }
    
    static int bfs(String begin, String target, String[] words) {
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(begin, 0));
        
        while(!q.isEmpty()) {
            Node current = q.poll();
            
            if (current.word.equals(target)) return current.depth;
            
            for (int i = 0; i < len; i++) {
                if (!visited[i] && transfer(current.word, words[i])) {
                    q.offer(new Node(words[i], current.depth + 1));
                    visited[i] = true;
                }
            }
        }
        return 0;
    }
    
    static boolean transfer(String before, String after) {
        int count = 0;
        
        for (int i = 0; i < before.length(); i++) {
            if (before.charAt(i) != after.charAt(i)) count++;
        }
        
        return count == 1;
    }
    
    static class Node {
        String word;
        int depth;
        
        Node(String word, int depth) {
            this.word = word;
            this.depth = depth;
        }
    }
}