package Day_13_14_Tasks;

import java.util.ArrayList;
import java.util.Collections;

public class JobSequencingTask {
	      char id;
	      int deadline,profit;
	        
		public JobSequencingTask(char id, int deadline, int profit) {
			super();
			this.id = id;
			this.deadline = deadline;
			this.profit = profit;
		}
	    
		void printJobScheduling(ArrayList<JobSequencingTask>arr, int t) {
			int n= arr.size();
			Collections.sort(arr, (a,b) -> b.profit - a.profit);
			boolean result[] = new boolean[t];
			
			char job[] = new char[t];
			for(int i=0; i<n; i++) {
				for(int j= Math.min(t-1,  arr.get(i).deadline - 1); j>=0; j--) {
					if(result[j] == false) {
						result[j] = true;
						job[j]= arr.get(i).id;
						break;
					}
				}
			}
			for(char jb: job) {
				System.out.print(jb + " ");
			}
			System.out.println();
		}
		
		public static void main(String[] args) {
			// TODO Auto-generated method stub
	    ArrayList<JobSequencingTask> arr = new ArrayList<JobSequencingTask>();
	    arr.add(new JobSequencingTask('a', 4, 100));
	    arr.add(new JobSequencingTask('b', 1, 19));
	    arr.add(new JobSequencingTask('c', 2, 30));
	    arr.add(new JobSequencingTask('d', 2, 200));
	    arr.add(new JobSequencingTask('e', 1, 15));
	    
	    JobSequencingTask obj = new JobSequencingTask(' ', 0, 0);
	    obj.printJobScheduling(arr, 3);
		}
}
