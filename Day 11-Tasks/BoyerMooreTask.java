package Tasks;

import java.util.Arrays;

public class BoyerMooreTask {
	
	  
		private final int R;
		private int[] right;
		private char[] pattern;
		private String pat;
		
	public BoyerMooreTask(String pat) {
			
			this.R=256;
			this.pat = pat;
			right=new int[R];
			Arrays.fill(right, -1);
			
			for(int j=0;j<pat.length();j++) {
				right[pat.charAt(j)]=j;
			}
		}
		
		
		public int search(String txt) {
			int M=pat.length();
			int N=txt.length();
			
			int skip;
			
			for(int i=0;i<=N-M;i+=skip) {
				skip=0;
				for(int j=M-1;j>=0;j--) {
					if(pat.charAt(j)!=txt.charAt(i+j)) {
						skip=Math.max(1, j-right[txt.charAt(i+j)]);
						break;
					}
				}
				if(skip==0) {
					return i; //found
				}
			}
			return N; //not Found
		}


		public static void main(String[] args) {
			// TODO Auto-generated method stub
			String txt="ABAAABCDADCD";
			String pat="AABCD";
			BoyerMooreTask bm=new BoyerMooreTask(pat);
			int result=bm.search(txt);
			
			if(result==txt.length()) {
				System.out.println("Pattern does not Found!");
			}
			else {
				System.out.println("Pattern found at index: "+result);
			}

		}
}
