package famaly.people.auth.token.worker;

import famaly.people.auth.bd.entity.UserEntity;
import famaly.people.auth.obj.AuthRequest;
import famaly.people.auth.obj.Token;
import famaly.people.auth.sessions.UserSession;
import famaly.people.auth.sessions.users.Account;
import famaly.people.auth.sessions.usersession.UserAuthSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.datatype.XMLGregorianCalendar;
import java.util.UUID;


@Service
public class NewTokenSession implements TokenWorker, SessionWorker, TokenSessionGenerators {

    @Autowired
    private Token token;


    @Autowired
    private UserAuthSession userAuthSession;

    @Override
    public void generate(Account account) {
        String randomTokenStr = UUID.randomUUID().toString();
        byte[] loginByte = account.getUserName().getBytes();
        byte[] passByte = account.getPassword().getBytes();
        String loginStr = loginByte.toString().substring(3);
        String passStr = passByte.toString().substring(3);
        String fullTokenStr = String.format("%s-%s-%s?%s@%s*", loginStr, passStr,
                randomTokenStr, account.getRules(), account.getDateCreateAccount());
        XMLGregorianCalendar dateGeneratedToken = null; //TODO НАПИСАТЬ ВРЕМЯ ГЕНЕРАЦИИ ТОКЕНА
        XMLGregorianCalendar dateCreateSession = null; //TODO НАПИСАТЬ ВРЕМЯ ГЕНЕРАЦИИ ТОКЕНА
        token.initToken(loginStr, account.getLogin(), account.getUserName(), true, fullTokenStr, dateGeneratedToken);
        userAuthSession.initUserAuthSession(loginStr, dateCreateSession, true, account, token);
    }

    @Override
    public Token getNewTokenToSession() {
        return token;
    }

    @Override
    public UserAuthSession getUserSesion() {
        return userAuthSession;
    }
}
