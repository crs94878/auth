package famaly.people.auth.services;

import famaly.people.auth.bd.entity.LoginEntity;
import famaly.people.auth.bd.repository.ReposytoryDBUserSearch;
import famaly.people.auth.obj.AuthRequest;
import famaly.people.auth.obj.AuthResponse;
import famaly.people.auth.services.interfaces.GeneratedTokenService;
import famaly.people.auth.sessions.UserSession;
import famaly.people.auth.sessions.users.Account;
import famaly.people.auth.sessions.usersession.UserAuthSession;
import famaly.people.auth.sessions.valid.controls.SessionValidControls;
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

    @Autowired
    private Account authAccount;

    @Autowired
    private UserSession sessionsMapWorkerSave;

    @Autowired
    private AuthResponse response;

    @Override
    public AuthResponse getSessionToken(AuthRequest request) {
        UserAuthSession session;
        LoginEntity usersEntity = reposytoryDBUserSearch.getUserEntity(request);
        authAccount.initialize(usersEntity);
        this.generatToken();
        session = ((NewTokenSession)tokenSession).getUserSesion();
        sessionsMapWorkerSave.saveUserSession(session);
        ((SessionValidControls) sessionsMapWorkerSave).startValidControlsSession();
        return response;
    }
    private void generatToken(){
        tokenSession.generate(authAccount);
        TokenWorker tokenWorker = (NewTokenSession) tokenSession;
        response.setToken(tokenWorker.getNewTokenToSession());
    }
}
