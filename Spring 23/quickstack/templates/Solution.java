import java.io.*;
import java.util.HashMap;

class Solution {
    /**
     * Output a possible configuration of the chest after performing quickstack
     * 
     * N: the number of items the player has
     * M: the number of items the chest has
     * P: the list of items on the player
     * C: the list of items in the chest
     */
    static void solve(int N, int M, char[] P, char[] C) {
        // YOUR CODE HERE
        HashMap<Character, Integer> map = new HashMap<>();
        for(char p : P){
            map.put(p, map.getOrDefault(p, 0)+1);
        }
        for(char p : C){
            map.put(p, map.getOrDefault(p, 0)+1);
        }
        StringBuilder builder = new StringBuilder();
        
        for(char c : C){
            String tmp =  c+"";
            builder.append(tmp.repeat(map.getOrDefault(c, 1)));
        }
        System.out.println(builder);
    }
    
    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter out = new PrintWriter(System.out);

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(in.readLine());
        for (int i = 0; i < T; i++) {
            String[] temp = in.readLine().split(" ");
            int N = Integer.parseInt(temp[0]);
            int M = Integer.parseInt(temp[1]);
            char[] P = new char[N];
            temp = in.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                P[j] = temp[j].charAt(0);
            }
            char[] C = new char[M];
            temp = in.readLine().split(" ");
            for (int j = 0; j < M; j++) {
                C[j] = temp[j].charAt(0);
            }
            solve(N, M, P, C);
        }
        out.flush();
    }
}
