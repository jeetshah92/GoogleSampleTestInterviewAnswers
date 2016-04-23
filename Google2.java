import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import java.util.regex.Pattern;

//class Neighbours {
//    
//    int left;
//    int right;
//    
//    public Neighbours(int l, int r) {
//        
//        left = l;
//        right = r;
//    }
//    
//}
class FileInfo {
	
	String fileName;
	String parentDir;
	int level;
	boolean isImage = false;
	ArrayList<FileInfo> next = new ArrayList<>();

	public FileInfo(String fn, String pd, int l) {
		
		fileName = fn;
		parentDir = pd;
		level = l;
		
	}
	
}

public class Google2 {
	
	public static int tl = 0;
	public static List<String> names = new ArrayList<>();
	
//	 public static int solution(int[] A) {
//	        // write your code in Java SE 8
//	        Arrays.sort(A);
//	        Map<Integer, Neighbours> availableSpots = new HashMap<>();
//	        
//	        int pastElement = A[0];
//	        for(int i = 1 ; i < A.length; i++) {
//	            
//	            if(A[i] != pastElement + 1 && A[i] != pastElement) {
//	                
//	                
//	                 int diff = A[i] - pastElement;
//	                 int nextSpot = pastElement;
//	                 int[] a = new int[diff - 1];
//	                 int ind = 0;
//	                 while(diff > 1) {
//	                     
//	                    nextSpot++;
//	                    a[ind++] = nextSpot;
//	                    diff--;
//	                    
//	                    
//	                 }
//	                 
//	                 int median = (a.length)/2;
//	                 availableSpots.put(a[median],new Neighbours(pastElement,A[i]));
//	                
//	            }
//	            
//	            pastElement = A[i];
//	            
//	        }
//	        
//	        if(availableSpots.size() == 0) {
//	            
//	            return 0;
//	        }
//	       
//	        
//	       
//	        Iterator<Integer> i = availableSpots.keySet().iterator();
//	        int key = i.next();
//	        Neighbours n =  availableSpots.get(key);
//	        while(i.hasNext()) {
//	            
//	            int nextKey = i.next();
//	            System.out.println(nextKey);
//	            Neighbours nextN = availableSpots.get(nextKey);
//	            
//	            int leftDiff2 =  nextKey - nextN.left;
//	            int rightDiff2 = nextN.right - nextKey;
//	            
//	            int leftDiff1 =  key - n.left;
//	            int rightDiff1 = n.right - key;
//	            
//	            if(leftDiff2 > leftDiff2 || rightDiff2 > rightDiff2) {
//	                
//	                key = nextKey;
//	                n = nextN;
//	            }
//	            
//	        }
//	        
//	        if(key - n.left < n.right - key) {
//	            
//	            return key - n.left;
//	        } else {
//	            
//	             return n.right - key;
//	        }
//	        
//	       
//	        
//	    }

//	public static int solution1(String S) {
//        // write your code in Java SE 8
//        
//        //List<String> l = new ArrayList<>();
//        int maxCount = 0;
//        char[] arr = S.toCharArray();
//        List<Character> element = new ArrayList<>();
//        String[] l = S.split("\\.|\\?|\\!");
//        
////        for(int i = 0; i < arr.length; i++) {
////            
////           
////            if(arr[i] == '?' || arr[i] == '!' || arr[i] == '.') {
////                
////            	
////            	char[]  elem = new char[element.size()];
////            	int index = 0;
////            	for(char j : element) {
////            		
////            		elem[index] = j;
////            		index++;
////            	}
////            	
////            	
////                l.add(new String(elem));
////                element.clear();
////                
////            } else {
////                
////            	
////                element.add(arr[i]);
////            }
////            
////        }
////        char[]  elem = new char[element.size()];
////    	int index = 0;
////    	for(char j : element) {
////    		
////    		elem[index] = j;
////    		index++;
////    	}
////    	
////    	
////        l.add(new String(elem));
////        System.out.println(l.size());
//       
//        for(String s : l) {
//        	 System.out.println("sentence is" + s);
//        	 s = s.trim();
//        	
//            if(!s.equals("")) {
//                
//                String[] words = s.split("\\s+");
//                int wordCount = 0;
//                for(String w : words) {
//                    
//                    if(!w.equals("")) {
//                        
//                        wordCount++;
//                    }
//                }
//                
//               
//                for(String w : words) {
//                	
//                	//System.out.println(w);
//                	
//                }
//                 if(wordCount > maxCount) {
//                
//                      maxCount = words.length;
//                     
//                 }
//                
//            }
//            
//            
//        }
//        
//        return maxCount;
//        
//        
//    }
	
	public static FileInfo createDirectoryStructure(String path) {
		
		Stack<FileInfo> s = new Stack<>();
		
		FileInfo root = new FileInfo("root", ".", 0);
		s.push(root);
		FileInfo currentDir = root;
		
		String[] dirs = path.split("\n");
	
		
		for(String d : dirs) {
			
			System.out.println(d);
			String[] splitString = d.split(Pattern.quote("."));
			int level = 0;
			char[] arr = d.toCharArray();
			if(d.charAt(0) == ' ') {
				
				level++;
				for(int i = 1; i < arr.length; i++) {
					
					if(d.charAt(i) == ' '){
						
						level++;
					} else {
						
						break;
					}
						
				}
				
				System.out.println(d + "---level--" + level);
				if((level - 1) == currentDir.level) {
					
					FileInfo f = new FileInfo("/"+ d.trim(), currentDir.fileName, level);
					if(d.contains(".")) {
						
						System.out.println(d.split(".").length);
						if(splitString[1].equals("jpeg") || splitString[1].equals("png") || splitString[1].equals("gif")) {
							
							f.isImage = true;
						}
						
					}
					
					System.out.println(f.fileName + "---" + f.parentDir + "---" + f.level + "----" + f.isImage);
					currentDir.next.add(f);
					s.push(currentDir);
					currentDir = f;
					
				} else  {
					
					
					while(s.peek().level != level - 1) {
						
						s.pop();
					}
					
					currentDir = s.peek();
					FileInfo f = new FileInfo("/"+d.trim(), currentDir.fileName, level);
					if(d.contains(".")) {
						
						System.out.println(d.split(".").length);
						if(splitString[1].equals("jpeg") || splitString[1].equals("png") || splitString[1].equals("gif")) {
							
							f.isImage = true;
						}
						
					}
					System.out.println(f.fileName + "---" + f.parentDir + "---" + f.level + "----" + f.isImage);
					currentDir.next.add(f);
					s.push(currentDir);
					currentDir = f;
					
				}
				
			} else {
				
				System.out.println("inserting in the root directory");
				s.clear();
				s.push(root);
				currentDir = root;
				FileInfo f = new FileInfo("/"+d, currentDir.fileName, level);
				if(d.contains(".")) {
					
					
					
				
					if(splitString[1].equals("jpeg") || splitString[1].equals("png") || splitString[1].equals("gif")) {
						
						f.isImage = true;
					}
					
				}
				
				System.out.println(f.fileName + "---" + f.parentDir + "---" + f.level + "---" + f.isImage);
				currentDir.next.add(f);
				s.push(currentDir);
				currentDir = f;
				
			}
			
		}
		
		return root;
		
	}
	
	public static void traverse(FileInfo root, int[] arr, int len, String[] name, int slen) {
		
		
		if(root == null) {
			
			return;
			
		} else if(root.next.size() == 0 && root.isImage) {
			
			//calculate length;
			//System.out.println("xxxxxx" + root.fileName);
			
//			for(int i = 0; i < len; i++) {
//				
//				System.out.println(arr[i]);
//				
//			}
			calculateLength(arr,len, name, slen);
			
			
		} else {
			
			
			Iterator<FileInfo> itr = root.next.iterator();
			if(!root.fileName.equals("root")) {
				
				//System.out.println(root.fileName);
				names.add(root.fileName);
				arr[len++] = root.fileName.length();
				name[slen++] = root.fileName;
			}
			while(itr.hasNext()) {
				
	
				
				
				traverse(itr.next(),arr,len, name, slen);
				
			}
			
			
		}
			
			return;
	}
	
	public static void calculateLength(int[] arr, int len, String[] name, int slen) {
		
		
		int totalLength = 0;
		
		for(int i = 0; i < len; i++) {
			
			totalLength += arr[i];
			
		}
		System.out.println("jxxx" + totalLength);
		
		tl = tl + totalLength;
		
		for(int i = 0; i < len; i++) {
			
		    System.out.println("jeet" + name[i]);
			
		}
		
		
		
		
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String path = "dir1\n dir11\n dir12\n  picture.jpeg\n  dir121\n  file1.txt\ndir2\n file2.gif";
		FileInfo root = createDirectoryStructure(path);
		int[] arr = new int[1000];
		String[] name = new String[1000];
		traverse(root,arr, 0,name,0);
//		Iterator<Integer> itr = imageFileLength.iterator();
//		if(itr.hasNext()) {
//			
//			
//			System.out.println("imageFile Length" + itr.next());
//		}
		
		
		System.out.println("imageFile name" + tl);
		Iterator<String> itr1 = names.iterator();
		if(itr1.hasNext()) {
			
			
			System.out.println("imageFile name" + itr1.next());
		}
		
		
		
//		String s = "jeet.shah ?is! angry";
//		int[] arr = {10, 0, 8, 2, -1, 12, 11, 3};
//		//System.out.println(solution(arr));
//		System.out.println(solution1(s));
		
	}

}
