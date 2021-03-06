//Reuben Orihuela
//11/7/17
//OOP Project 2
import javax.swing.DefaultListModel;

public class Client extends User implements Observer, Information {
	private String identification;
	private DefaultListModel<Observer> followers = new DefaultListModel<>();
	private DefaultListModel<Information> following = new DefaultListModel<>();
	private DefaultListModel<String> feed = new DefaultListModel<>();
	private boolean updated = false;
	private String message;
	private UserGroup group;

	public Client(String id) {
		setID(id);
		updated = false;
		group = null;
	}

	public void addGroup(UserGroup group) {
		if (this.group == null) {
			this.group = group;
		} else {
			System.out.println("You are already a member of a seperate group");
		}
	}

	public void postTweet(String a) {
		this.message = a;
		updated = true;
		feed.addElement(identification + ": " + a);
		contactObserver();
	}

	public DefaultListModel<Observer> getFollowers() {
		return followers;
	}

	public DefaultListModel<Information> getFollowing() {
		return following;
	}

	public DefaultListModel<String> getNewsfeed() {
		return feed;
	}

	public void follow(Client a) {
		setSubject(a);
		a.setObserver(this);
	}

	private void setSubject(Information a) {
		following.addElement(a);
	}

	public void setObserver(Observer a) {
		followers.addElement(a);
	}

	public void contactObserver() {
		if (updated) {
			updated = false;
			for (Object a : followers.toArray())
				this.InfoUpdate((Information) a);
		}
	}

	public String getUpdate(Observer a) {
		return this.message;
	}

	public void setInfo(Information a) {
		following.addElement(a);
	}

	public void InfoUpdate(Information a) {
		String update = getUpdate(this);
		feed.addElement("-" + a.toString() + ": " + update);
	}

	public String getID() {
		return identification;
	}

	public void setID(String id) {
		this.identification = id;
	}

	public String toString() {
		return this.getID();
	}

	

}
