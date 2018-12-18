package famaly.people.auth.token.worker;

import famaly.people.auth.bd.entity.UserEntity;
import famaly.people.auth.obj.AuthRequest;
import famaly.people.auth.obj.Token;
import famaly.people.auth.sessions.UserSession;
import org.springframework.stereotype.Service;

import java.util.UUID;


@Service
public class NewTokenSession implements TokenWorker, SessionWorker, TokenSessionGenerators{

    private Token token;
    private UserSession session;

    @Override
    public void generate(AuthRequest request, UserEntity entity){
        String randomTokenStr = UUID.randomUUID().toString();
        byte[] loginByte = entity.getUserName().getBytes();
        byte[] passByte = entity.getPassword().getBytes();
        String loginStr = loginByte.toString();
        String passStr = passByte.toString();

    }
    @Override
    public Token getNewTokenToSession() {

        return token;
    }

    @Override
    public UserSession getUserSesion() {
        return session;
    }
}
