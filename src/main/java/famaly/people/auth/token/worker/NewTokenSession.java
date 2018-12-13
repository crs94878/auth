package famaly.people.auth.token.worker;

import famaly.people.auth.obj.AuthRequest;
import famaly.people.auth.obj.Token;

public class NewTokenSession implements TokenWorker {

    private Token token;

    @Override
    public void generate(AuthRequest request, Token token){

    }
    @Override
    public Token getNewTokenToSession() {
        return token;
    }
}
