package famaly.people.auth.sessions.users;

public class User {
    protected String userName;
    protected String secondName;

    protected void intialize(String userName, String secondName){
        this.userName = userName;
        this.secondName = secondName;
    }

    public String getUserName() {
        return userName;
    }

    public String getSecondName() {
        return secondName;
    }
}
