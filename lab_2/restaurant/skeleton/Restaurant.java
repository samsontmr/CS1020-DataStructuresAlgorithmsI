/*
Name: Tan Min Rong Samson
Matric Number: A0140060A
 */

import java.util.*;

public class Restaurant {
	private static boolean debug = false;

	private static ArrayList<Group> groupList = new ArrayList<Group>();
	private static ArrayList<Table> tableList= new ArrayList<Table>();

	public static void createTable(String name, int capacity) {
		//PRECOND: capacity is a positive integer
		//POSTCOND: new Table object created and appended to tableLst
		tableList.add(new Table(name, capacity));
	}

	public static Table findTable(String name) 
		throws NullPointerException {
			//PRECOND: true
			//POSTCOND: Returns Table object if found, else throw NullPointerException
			Table found = null;
			for (Table table: tableList) {
				if (table.getName().equals(name)) {
					found = table;
				}
			}
			if (found == null) {
				throw new NullPointerException("invalid");
			}
			return found;
		}

	public static Group findGroup(String name) 
		throws NullPointerException {
			//PRECOND: true
			//POSTCOND: Returns Group object if found, else throw NullPointerException
			Group found = null;
			for (Group group: groupList) {
				if (group.getName().equals(name)) {
					found = group;
				}
			}
			if (found == null) {
				throw new NullPointerException("invalid");
			}
			return found;
		}

	public static void allocSpec(String groupName, int groupSize, String tableName) {
		//PRECOND: groupSize is a positive number.
		//POSTCOND: New Group Object created, appended to groupList and allocated to specified 
		//			Table if specified Table exists and is big enough. Else prints "not possible".
		try {	
			Table table = findTable(tableName);
			if (table.getCpty() < groupSize || table.getOcc()) {
				System.out.println("not possible");
			} else {
				Group group = new Group(groupName, groupSize, table);
				groupList.add(group);
				table.setOcc(true);
				table.setGroup(group);
				System.out.println(table.getName());
			}
		} catch (NullPointerException expObj) {
			//catch NullPointerException thrown by findTable if specified Table not found.
			System.out.println("not possible");
		}
	}

	public static void allocRand(String groupName, int groupSize) {	
		//PRECOND: groupSize is a positive number.
		//POSTCOND: New Group Object created, appended to groupList and allocated to lexicographically
		//			smallest available Table if it exists. Else prints "not possible".
			
			ArrayList<Table> found = new ArrayList<Table>();
			//Create new ArrayList to store available tables found.
			for (Table table: tableList) {
				if (table.getCpty() >= groupSize && !table.getOcc()) {
					found.add(table);
				}
			}	
			

			if (found.isEmpty()) {
				System.out.println("not possible");
			} else {
				//Search for lexicographically smallest Table.
				Table lexSmallest = found.get(0);

				for (Table table: found) {
					if (table.getName().compareTo(lexSmallest.getName()) < 0) {
						lexSmallest = table;
					}
				}

				Group group = new Group(groupName, groupSize, lexSmallest);
				groupList.add(group);
				lexSmallest.setOcc(true);
				lexSmallest.setGroup(group);
				System.out.println(lexSmallest.getName());
			}
	}

	public static void clearTable(String groupName) {
		//PRECOND: true
		//POSTCOND: Makes Table occupied by Group available if Group exists,
		// 			else do nothing.
		try {
			Group group = findGroup(groupName);
			Table table = group.getTable();
			table.setOcc(false);
			table.setGroup(null);
			groupList.remove(group);
		} catch(NullPointerException expObj) {
			return;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = Integer.parseInt(sc.nextLine());
		
		//Creates Tables.
		while (N > 0) {
			StringTokenizer st = new StringTokenizer(sc.nextLine());
			String name = st.nextToken();
			int size = Integer.parseInt(st.nextToken());
			createTable(name, size);
			N--;
		}

		int Q = Integer.parseInt(sc.nextLine());
		
		while (Q > 0) {
			String nextln = sc.nextLine();
			StringTokenizer st = new StringTokenizer(nextln);
			int	query = Integer.parseInt(st.nextToken());
			
			String groupName, tableName;
			int groupSize;

			if (debug) { System.out.println(nextln); }

			switch(query) {
				//Performs operations specified by different query types
				//in design document.
				case 1: 
					groupName = st.nextToken();
					groupSize = Integer.parseInt(st.nextToken());
					tableName = st.nextToken();
					allocSpec(groupName, groupSize, tableName);
					break;
				case 2: 
					groupName = st.nextToken();
					groupSize = Integer.parseInt(st.nextToken());
					allocRand(groupName, groupSize);
					break;
				case 3:
					groupName = st.nextToken();
					clearTable(groupName);
					break;
				
				//Prints Table occupied by Group or Group occupying Table respectively.
				//Catches NullPointerException and prints "invalid" if Group or Table 
				//does not exist.
				case 4:
					try {
						groupName = st.nextToken();
						Group group = findGroup(groupName);
						System.out.println(group.getTable().getName());
					} catch (NullPointerException expObj) {
						System.out.println(expObj.getMessage());
					}
					break;
				case 5:
					try {
						tableName = st.nextToken();
						Table table = findTable(tableName);
						System.out.println(table.getGroup().getName());
					} catch (NullPointerException expObj) {
						System.out.println(expObj.getMessage());
					}
					break;
			}
			Q--;
		}
	}
}

class Group {
	private String _name;
	private int _size;
	private Table _table;

	Group(String name, int size, Table table) {
		//PRECOND: size is positive integer, Table exists.
		//POSTCOND: Ngroup created and assigned to a Table.
		_name = name;
		_size = size;
		_table = table;
	}

	public String getName() {
		return _name;
	}

	public int getSize() {
		return _size;
	}

	public Table getTable() {
		return _table;
	}

	//define the appropriate constructor and methods
}

class Table {
	private String _name;
	private int _capacity;
	private Group _group;
	private boolean _occupied;

	Table(String name, int capacity) {
		//PRECOND: capacity is positive integer.
		//POSTCOND: Creates unoccupied Table.
		_name = name;
		_capacity = capacity;
		_group = null;
		_occupied = false;
	}

	public Group getGroup() 
		throws NullPointerException {
		if (_group == null){
			throw new NullPointerException("invalid");
		}
		return _group;
		
	}

	public String getName() {
		return _name;
	}

	public int getCpty() {
		return _capacity;
	}

	public boolean getOcc() {
		return _occupied;
	}

	public void setGroup(Group group) {
		//PRECOND: Group exists.
		//POSTCOND: assigns Group to Table.
		_group = group;
	}

	public void setOcc(boolean occupied) {
		_occupied = occupied;
	}
	//define the appropriate constructor and methods
}
