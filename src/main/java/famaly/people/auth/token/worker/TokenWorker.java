package famaly.people.auth.token.worker;

import famaly.people.auth.obj.AuthRequest;
import famaly.people.auth.obj.Token;

public interface TokenWorker {
    void generate(AuthRequest request, Token token);
    Token getNewTokenToSession();
}
