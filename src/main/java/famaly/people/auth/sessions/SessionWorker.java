package famaly.people.auth.sessions;

import famaly.people.auth.sessions.usersession.UserAuthSession;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;

public class SessionWorker implements UserSession {

    @Autowired
    private HashMap<String, UserAuthSession> sessionsMap;

    @Override
    public void saveUserSession(UserAuthSession session) throws NullPointerException{
        if(session == null) throw new NullPointerException("Sesssion isn't be null");
        sessionsMap.put(session.getSessionName(), session);
    }

    @Override
    public HashMap<String, UserAuthSession> getSavedSessions() {
        return sessionsMap;
    }
}
