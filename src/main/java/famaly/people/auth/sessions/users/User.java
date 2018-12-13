package famaly.people.auth.sessions.users;

public class User {
    protected String userName;
    protected String password;

    public void intialize(String userName, String password){
        this.userName = userName;
        this.password = password;
    }
}
