import java.util.ArrayList;

//Part Of Composite Design Pattern
public class UserGroup extends User {
	private String identification;
	private ArrayList<Client> groupUser = new ArrayList<>();
	
	public String getID() {
		return identification;
	}
	
	public void setID(String id) {
		this.identification = id;
	}
	
	public String toString() {
		return this.getID();
	}

	public UserGroup(String id) {
		setID(id);
	}

	public void addUsers(String id) {
		Client a = new Client(id);
		groupUser.add(a);
		a.addGroup(this);

	}

}
