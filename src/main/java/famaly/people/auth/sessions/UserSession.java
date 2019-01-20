package famaly.people.auth.sessions;

import famaly.people.auth.sessions.usersession.UserAuthSession;

import java.util.HashMap;

public interface UserSession {
    void saveUserSession(UserAuthSession session);
    UserAuthSession getSavedSession(String sessionName);
    boolean isSessionFound(String login);

}
