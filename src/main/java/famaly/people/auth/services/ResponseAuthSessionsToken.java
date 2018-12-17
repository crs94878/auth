package famaly.people.auth.services;

import famaly.people.auth.obj.AuthRequest;
import famaly.people.auth.obj.AuthResponse;
import famaly.people.auth.obj.Token;
import famaly.people.auth.services.interfaces.GeneratedTokenService;
import famaly.people.auth.token.worker.NewTokenSession;
import org.springframework.beans.factory.annotation.Autowired;

public class ResponseAuthSessionsToken implements GeneratedTokenService {

    @Autowired
    private NewTokenSession tokenSession;

    @Override
    public AuthResponse getSessionToken(AuthRequest request, Token token) {
        tokenSession.generate(request, token);
        tokenSession.getNewTokenToSession();
        return new AuthResponse();
    }
}
