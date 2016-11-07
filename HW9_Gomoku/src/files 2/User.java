
public class User implements Comparable<Object> {
	private String name;
	private int step;
	
	//constructor
	public User(String name, int step) {
		this.name = name;
		this.step = step;
	}
	//get nickname
	public String getNickname() {
		return name;
	}
	// change user nickname
	public void changeNickname(String newNickname) {
		this.name = newNickname;
	}	
	
	public int getStep() {
		return step;
	}
	
	public void changeStep(int newstep) {
		this.step = newstep;
	}
	
	//compareTo for comparable
	@Override
	public int compareTo(Object o) {
		if(!(o instanceof User)) {
			return 1;
		}
		User u = (User) o;
		if (this.name.equals(u.getNickname()) && this.step == u.getStep()) {
			return 0;
		}
		else {return 1;}
	}		
	//overriding equals method
	@Override
    public boolean equals(Object o) {
        if(!(o instanceof User)){
            return false;
        }
        User u = (User) o;
        if(u.getNickname().equals(this.name) && this.step == u.getStep()) {
            return true;
        }
        return false;
    }
	
	
	
	
}
