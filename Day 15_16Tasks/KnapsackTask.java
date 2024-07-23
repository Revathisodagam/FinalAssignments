package Day15_16Tasks;

public class KnapsackTask {

	static int knapSack(int M, int[] w, int[] p, int n) {
		int[][] C =new int[n+1][M+1];
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=M; j++) {
				if(w[i-1]> j) {
					C[i][j] = C[i-1][j];
				} else {
					C[i][j] = Math.max(
							p[i-1] + C[i-1][j-w[i-1]],
							C[i-1][j]);
				}
			}
		}
		return C[n][M];
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
      int[] p = {80,160,240};
      int[] w = {20,30,40};
      int M = 90;
      int n=p.length;
      System.out.println("The maximum Profit:" + knapSack(M,w,p,n));
	}
}
