/*
Name: Tan Min Rong Samson
Matric Number: A0140060A
 */

import java.util.*;

public class FileManager {
	private static ArrayList<Folder> folderList = new ArrayList<Folder>();
	static boolean debug = false;


	public static void createFolder(String name) {
		folderList.add(new Folder(name));
	}
	
	private static Folder findFolder(String name) {
		Folder found = null;
		for (Folder folder: folderList) {
			if (folder.getName().equals(name)) {
				found = folder;
			}
		}
		return found;
	}

	private static File findFile(String name) {
		File found = null;
		for (Folder folder: folderList) {
			for (File file: folder.getFileList()) {
				if (file.getName().equals(name)) {
					found = file;
				}
			}
		}
		return found;
	}

	public static void createFile(String fileName, int fileSize, String folderName) {
		Folder folder = findFolder(folderName);
		folder.add(new File(fileName, fileSize, folderName));
	}


	public static void deleteFile(String name) {
		File toRm = findFile(name);
		findFolder(toRm.getFolderName()).rmFile(toRm);
	}

	public static void moveFile(String fileName, String folderName) {
		File toMv = findFile(fileName);
		Folder toFolder = findFolder(folderName);
		toFolder.add(toMv);
		deleteFile(fileName);
		toMv.setFolderName(folderName);
	}

	public static void findLargest() {
		Folder largest = folderList.get(0);
		int size = 0;	
		for (Folder folder: folderList) {
			if (folder.getSize() > size) {
				largest = folder;
				size = folder.getSize();
			}
		}

		System.out.println(largest.getName());
	}

	public static void main(String[] args) {
		int Q;
		Scanner sc = new Scanner(System.in);
		Q = Integer.parseInt(sc.nextLine());
		
		//System.out.println(Q);

		while(Q > 0) {
			String nextLn = sc.nextLine();
			StringTokenizer st = new StringTokenizer(nextLn);
			String query = st.nextToken();
			if (query.equals("Createfile")) {
				if(debug){System.out.println(query);}
				String fileName = st.nextToken();
				int size = Integer.parseInt(st.nextToken());
				String folderName = st.nextToken();
				createFile(fileName, size, folderName);
				if(debug){System.out.println(findFile(fileName).getName());}
			} else if (query.equals("Createfolder")) {
				if(debug){System.out.println(query);}
				String name = st.nextToken();
				createFolder(name);
				if(debug){System.out.println(findFolder(name).getName());}
			} else if (query.equals("Deletefile")) {
				if(debug){System.out.println(query);}
				String name = st.nextToken();
				deleteFile(name);
			} else if (query.equals("Count")) {
				if(debug){System.out.println(query);}
				String name = st.nextToken();
				System.out.println(findFolder(name).getSize());
			} else if (query.equals("Movefile")) {
				if(debug){System.out.println(query);}
				String fileName = st.nextToken();
				String folderName = st.nextToken();
				moveFile(fileName, folderName);
			} else if (query.equals("Findlargest")) {
				if(debug){System.out.println(query);}
				findLargest();
			}
			Q--;
		}
	}
}

class File {
	//define the appropriate attributes and constructor
	private String _name;
	private int _size;
	private String _folderName;
	//private static ArrayList _fileList = new ArrayList();

	public File(String fileName, int size, String folderName) {
		_name = fileName;
		_size = size;
		_folderName = folderName;
	}

	public String getName() {
		return _name;
	}

	public int getSize() {
		return _size;
	}

	public String getFolderName() {
		return _folderName;
	}

	public void setFolderName(String name) {
		_folderName = name;
	}

}

class Folder {
	//define the appropriate attributes and constructor
	private String _name;
	private ArrayList<File> _listOfFiles;


	public Folder(String name) {
		_name = name;
		_listOfFiles = new ArrayList<File>();
	}

	public String getName() {
		return _name;
	}

	public int getSize() {
		int size = 0;
		for (File file: _listOfFiles) {
			size += file.getSize();
		}
		return size;
	}

	public void add(File file) {
		_listOfFiles.add(file);
	}

	public ArrayList<File> getFileList() {
		return _listOfFiles;
	}
	
	public void rmFile(File file) {
		_listOfFiles.remove(file);
	}
	
	/*public static void count(String folderName) {
		for(Folder folder: _folderList) {
			if (folder._name.equals(folderName)) {
				System.out.println(folder.getSize());
			}
		}
	}




	public static void moveFile(String fileName, String folderName) {	
		for (Folder folder: _folderList) {
			for (File file: folder._listOfFiles) {
				if (file.getName().equals(fileName)) {
					folderName.add(file);
					folder._listOfFiles.remove(file);
				}
			}
		}
	}
	public static void findLargest() {
		Folder largest = _folderList.get(0);

		for (Folder folder: _folderList) {
			if (folder.getSize() > largest.getSize()) {
				largest = folder;
			}
		}
		System.out.println(largest._name);
	}
*/
}

