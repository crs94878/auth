package famaly.people.auth.sessions.usersession;

import famaly.people.auth.obj.Token;
import famaly.people.auth.sessions.users.Account;
import famaly.people.auth.sessions.users.User;

import javax.xml.datatype.XMLGregorianCalendar;

public class UserAuthSession extends Session {
    private Account user;
    private Token tokenUser;

    public  void initUserAuthSession(String sessionName, XMLGregorianCalendar dateCreateSession,
                            boolean isValidSession, Account user, Token token){
        super.sessionName = sessionName;
        super.dateCreateSession = dateCreateSession;
        super.isValidSession = isValidSession;
        this.user = user;
        this.tokenUser = token;
    }

    public Token getTokenUser() {
        return tokenUser;
    }

    public void setTokenUser(Token tokenUser) {
        this.tokenUser = tokenUser;
    }

    public Account getUser() {
        return user;
    }

    public void setUser(Account user) {
        this.user = user;
    }
}
