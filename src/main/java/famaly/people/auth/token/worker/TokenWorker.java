package famaly.people.auth.token.worker;

import famaly.people.auth.obj.Token;

public interface TokenWorker {
    void generate(Token token);
    Token getNewTokenToSession();
}
