package Tasks;


public class KMPSearch {
	private final int R ;
	private int[][] dfa;
	private char[] pattern;
	
	public KMPSearch(String pattern) {
		this.R = 256;
		this.pattern = pattern.toCharArray();
		int m= pattern.length();
		dfa = new int[R][m];
		
		dfa[pattern.charAt(0)] [0]=1;
		for(int X=0, j=1; j<m; j++) {
			for(int c=0; c< R; c++) {
				dfa[c][j]= dfa[c][X];
			}
			dfa[pattern.charAt(j)] [j] = j+1;
			X= dfa[pattern.charAt(j)] [X];
		}
	}
	public void search(String txt) {
		int n= txt.length();
		int m= pattern.length;
		int i,j;
		for(i=0,j=0; i<n && j<m; i++) {
			j= dfa[txt.charAt(i)] [j];
		}
		if(j==m) {
			System.out.println("pattern found at index: " + (i-m));
		} else {
			System.out.println("Pattern not found");
		}
		}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
      String txt = "ABABDABACDABABCABAB";
      String pat = "ABAC";
	    KMPSearch kmp = new KMPSearch(pat);
	    kmp.search(txt);
	}
}
