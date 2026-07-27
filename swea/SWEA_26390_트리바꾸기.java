package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_26390_트리바꾸기 {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int tc = Integer.parseInt(br.readLine());

        for(int T = 0; T < tc; T++) {
            int N = Integer.parseInt(br.readLine());
            int[] degree = new int[N+1];

            for(int i = 0; i < N-1; i++) {
                st = new StringTokenizer(br.readLine());

                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());

                degree[u]++;
                degree[v]++;
            }

            long ans = 0;
            for(int i=1; i<=N; i++) {
                if(degree[i] > 2) ans += degree[i] - 2;
            }

            sb.append(ans+"\n");
        }

        System.out.print(sb);
    }

}
