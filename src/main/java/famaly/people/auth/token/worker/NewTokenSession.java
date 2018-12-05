package famaly.people.auth.token.worker;

import famaly.people.auth.obj.Token;

public class NewTokenSession implements TokenWorker {

    private Token token;

    @Override
    public void generate(Token token){

    }
    @Override
    public Token getNewTokenToSession() {
        return token;
    }
}
