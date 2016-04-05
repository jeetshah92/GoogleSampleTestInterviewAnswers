import java.util.ArrayList;
import java.util.Stack;
import java.util.regex.Pattern;

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

	public static void createDirectoryStructure(String path) {
		
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
					
					FileInfo f = new FileInfo(d, currentDir.fileName, level);
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
					FileInfo f = new FileInfo(d, currentDir.fileName, level);
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
				FileInfo f = new FileInfo(d, currentDir.fileName, level);
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
		
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String path = "Dir1\n Dir2\n  Dir3\n   Dir4\n  Dir5\nimage.jpeg";
		createDirectoryStructure(path);

	}

}
