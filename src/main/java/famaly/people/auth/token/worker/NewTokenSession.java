package famaly.people.auth.token.worker;

import famaly.people.auth.obj.Token;
import famaly.people.auth.sessions.users.Account;
import famaly.people.auth.sessions.usersession.UserAuthSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.GregorianCalendar;
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
        byte[] loginByte = account.getLogin().getBytes();
        byte[] userNameByte = account.getUserName().getBytes();
        byte[] secondNameByte = account.getSecondName().getBytes();
        String loginStr = loginByte.toString().substring(3);
        String userNameStr = userNameByte.toString().substring(3);
        String secondNameStr = secondNameByte.toString().substring(3);

        String fullTokenStr = String.format("%s-%s-%s-%s-%s-%s?%s@%s", account.getId(), loginStr,
                userNameStr, secondNameStr, randomTokenStr, account.getRules(),
                account.getDateCreateAccount(), account.isValid());
        XMLGregorianCalendar dateGeneratedToken = null;
        try {
            GregorianCalendar calendar = new GregorianCalendar();
            calendar.setTime(Date.from(LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant()));
            dateGeneratedToken =  DatatypeFactory.newInstance().newXMLGregorianCalendar(calendar);
        } catch (DatatypeConfigurationException generedDateEx){
            System.out.println(generedDateEx.getMessage());
        }
        token.initToken(account.getId(), account.getLogin(), account.getUserName(), account.getSecondName(),
                true, fullTokenStr, dateGeneratedToken, account.getRules());
        userAuthSession.initUserAuthSession(account.getId(), dateGeneratedToken, true, account, token);
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
