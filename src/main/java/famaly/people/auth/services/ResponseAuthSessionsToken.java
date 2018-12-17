package famaly.people.auth.services;

import famaly.people.auth.bd.entity.UserEntity;
import famaly.people.auth.bd.repository.ReposytoryDBUserSearch;
import famaly.people.auth.obj.AuthRequest;
import famaly.people.auth.obj.AuthResponse;
import famaly.people.auth.obj.Token;
import famaly.people.auth.services.interfaces.GeneratedTokenService;
import famaly.people.auth.token.worker.NewTokenSession;
import famaly.people.auth.token.worker.SessionWorker;
import famaly.people.auth.token.worker.TokenSessionGenerators;
import famaly.people.auth.token.worker.TokenWorker;
import org.springframework.beans.factory.annotation.Autowired;

public class ResponseAuthSessionsToken implements GeneratedTokenService {

    @Autowired
    private TokenSessionGenerators tokenSession;

    @Autowired
    private ReposytoryDBUserSearch reposytoryDBUserSearch;

    @Override
    public AuthResponse getSessionToken(AuthRequest request) {
        AuthResponse response = new AuthResponse();
        UserEntity usersEntity = reposytoryDBUserSearch.getUserEntity(request.getLogin(),request.getPassword());
        tokenSession.generate(request, usersEntity);
        TokenWorker tokenWorker = (NewTokenSession)tokenSession;
        SessionWorker sessionWorker = (NewTokenSession) tokenSession;
        response.setToken(tokenWorker.getNewTokenToSession());
        sessionWorker.getUserSesion();
        return response;
    }
}
