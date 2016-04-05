import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class Google1 {

	public Google1() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		long a = 45504550;
		System.out.println("original is" + a);
		String s = Long.toString(a);
		long max = 0;
		ArrayList<Integer> dupIndexes = new ArrayList<>();
		
		char[] arr = s.toCharArray();
		
		for(int i=0; i<arr.length; ) {
			
			
			char current = arr[i];
			int index = i;
			boolean dupFlag = false;
			for(int j=i+1; j<arr.length; j++) {
				
				if(arr[j] == current) {
					
					if(!dupFlag) {
						
						dupIndexes.add(j);
						System.out.println("duplicate is" + j);
						dupFlag = true;
					}
					
					index = j;
					
				} else {
					
					break;
				}
				
			}
			
			
			i = index + 1;
			
		}
		
			Iterator<Integer> i = dupIndexes.iterator();
			
			
			while(i.hasNext()) {
				
				int dupIndex = i.next();
				char[] buff = new char[arr.length-1];
				int bufIndex = 0;
				
				for(int index=0; index<arr.length; index++) {
					
					if(index != dupIndex) {
						
						 buff[bufIndex] = arr[index];
						 bufIndex++;
						
					}
					
				}
				
				Long dupRemoved = Long.parseLong(new String(buff));
				System.out.println(dupRemoved);
				if(dupRemoved > max) {
					
					max = dupRemoved;
				}
				
				
			}
			
			System.out.println("result is" + max);
		
		

	}

}
