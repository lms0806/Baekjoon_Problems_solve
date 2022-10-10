import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		
		int coincount = Math.min((int) (Double.parseDouble(br.readLine()) / 0.99), 2);
		
		int n = Integer.parseInt(br.readLine());
		
		int[] arr = new int[n];
		int[][] dp = new int[n][coincount + 1];
		
		int maxsolve = 0;
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			maxsolve = Math.max(maxsolve, arr[i]);
		}
		
		dp[0][0] = arr[0] > 0 ? 1 : 0;
		if(dp[0][0] == 0 && coincount != 0) {
			dp[0][1] = 1;
		}
		for(int i = 1; i < n; i++) {
			if(arr[i] > 0) {
				for(int j = 0; j < dp[i].length; j++) {
					dp[i][j] = dp[i - 1][j] + 1;
				}
			}
			else {
				for(int j = 1; j < dp[i].length; j++) {
					dp[i][j] = dp[i - 1][j - 1] + 1;
				}
			}
		}
		
		int answer = 0;
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < dp[i].length; j++) {
				answer = Math.max(answer, dp[i][j]);
			}
		}
		System.out.print(answer + "\n" + maxsolve);
	}
}
