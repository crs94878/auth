package famaly.people.auth.session;

import famaly.people.auth.obj.Token;

public interface UserSession {
    UserAuthSession getSession(Token token);
}
