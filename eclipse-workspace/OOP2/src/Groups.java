//Reuben Orihuela
//11/6/17
//OOP Project 2
//Used for Button in GUI
public class Groups implements Visitor {
	int numGroups = 0;

	public void visit(User a) {
		if (a instanceof UserGroup) {
			numGroups++;
		}
	}

	public int GetNumOfGroups() {
		return numGroups;
	}
}
