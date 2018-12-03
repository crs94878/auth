package famaly.people.auth.session;

import famaly.people.auth.obj.Token;

public class UserAuthSession implements UserSession{
    @Override
    public UserAuthSession getSession(Token token) {
        return this;
    }
}
