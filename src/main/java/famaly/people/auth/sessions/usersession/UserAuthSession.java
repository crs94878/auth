package famaly.people.auth.sessions.usersession;

import famaly.people.auth.obj.Token;
import famaly.people.auth.sessions.users.User;

import javax.xml.datatype.XMLGregorianCalendar;

public class UserAuthSession extends Session {
    private User user;
    private Token tokenUser;
    private String rullesUser;

    public  UserAuthSession(String sessionName, XMLGregorianCalendar dateCreateSession,
                            boolean isValidSession, User user, Token token, String rulles){
        super(sessionName, dateCreateSession, isValidSession);
        this.user = user;
        this.tokenUser = token;
        this.rullesUser = rulles;
    }

    public String getRullesUser() {
        return rullesUser;
    }

    public void setRullesUser(String rullesUser) {
        this.rullesUser = rullesUser;
    }

    public Token getTokenUser() {
        return tokenUser;
    }

    public void setTokenUser(Token tokenUser) {
        this.tokenUser = tokenUser;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
