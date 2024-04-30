import java.util.*;
import java.io.*;

public class Main {
   
   static int N, M, V;
   static List<List<Integer>> graph = new ArrayList<>();
   static boolean[] visited;
   static int[] result;
   static StringBuilder sb = new StringBuilder();
   
   public static void main(String[] args) throws Exception {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st = new StringTokenizer(br.readLine());
      
      N = Integer.parseInt(st.nextToken());
      M = Integer.parseInt(st.nextToken());
      V = Integer.parseInt(st.nextToken());
      
      for (int i = 0; i <= N; i++) {
         graph.add(new ArrayList<>());
      }
      
      
      for (int i = 0; i < M; i++) {
         st = new StringTokenizer(br.readLine());
         int u = Integer.parseInt(st.nextToken());
         int v = Integer.parseInt(st.nextToken());
         
         graph.get(u).add(v);
         graph.get(v).add(u);
      }
      
      for (int i = 0; i < graph.size(); i++) {
    	  Collections.sort(graph.get(i));
      }
      
      visited = new boolean[N+1];
      dfs(V);
      
      sb.append("\n");
      
      visited = new boolean[N+1];
      bfs(V);
      
      System.out.println(sb);
      
   }
   
   static void dfs(int start) {
	   if(visited[start]) return;
	   
	   visited[start] = true;
       sb.append(start).append(" ");
      
       for (int i = 0; i < graph.get(start).size(); i++) {
    	   int w = graph.get(start).get(i);
    	   if(!visited[w]) {
    		   dfs(w);
    	   }
       }
   }
   
   static void bfs(int start) {
      Queue<Integer> q = new LinkedList<>();   
      
      q.offer(start);
      visited[start] = true;
      
      while(!q.isEmpty()) {
         int v = q.poll();
         sb.append(v).append(" ");
         
         for (int i = 0; i < graph.get(v).size(); i++) {
             int w = graph.get(v).get(i);
             
        	 if(!visited[w]) {
               q.offer(w);
               visited[w] = true;
            }
         }
      }
   }
}