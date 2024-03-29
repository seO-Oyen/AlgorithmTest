import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken()); // 배열 크기
		int m = Integer.parseInt(st.nextToken());
		
		// 입력받는 이차원 배열
		int[][] s = new int[n + 1][n + 1];
		
		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= n; j++) {
				s[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// 구간합 이차원 배열
		int[][] d = new int[n + 1][n + 1];
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				// System.out.println(s[i][j]);
				d[i][j] = d[i][j - 1] + d[i - 1][j] - d[i - 1][j - 1] + s[i][j];
			}
		}
		
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			
			int result = d[x2][y2] - d[x1 - 1][y2] - d[x2][y1 - 1] + d[x1 - 1][y1 - 1];
			System.out.println(result);
		}
		
	}

}