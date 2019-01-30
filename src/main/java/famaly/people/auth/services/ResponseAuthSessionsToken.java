package famaly.people.auth.services;

import famaly.people.auth.bd.entity.LoginEntity;
import famaly.people.auth.bd.repository.ReposytoryDBUserSearch;
import famaly.people.auth.obj.AuthRequest;
import famaly.people.auth.obj.AuthResponse;
import famaly.people.auth.services.interfaces.GeneratedTokenService;
import famaly.people.auth.token.worker.NewTokenSession;
import famaly.people.auth.token.worker.TokenSessionGenerators;
import famaly.people.auth.token.worker.TokenWorker;
import org.springframework.beans.factory.annotation.Autowired;

public class ResponseAuthSessionsToken implements GeneratedTokenService {

    @Autowired
    private TokenSessionGenerators tokenSession;

    @Autowired
    private ReposytoryDBUserSearch reposytoryDBUserSearch;

    @Autowired
    private AuthResponse response;

    @Override
    public AuthResponse getSessionToken(AuthRequest request) {
        LoginEntity usersEntity = reposytoryDBUserSearch.getUserEntity(request);
        this.generatToken(usersEntity, request.getApplicationnName());
        return response;
    }
    private void generatToken(LoginEntity entity ,String applicationName){
        tokenSession.generate(entity, applicationName);
        TokenWorker tokenWorker = (NewTokenSession) tokenSession;
        response.setToken(tokenWorker.getNewTokenToSession());
    }
}
