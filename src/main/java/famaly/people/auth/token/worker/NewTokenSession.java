package famaly.people.auth.token.worker;

import famaly.people.auth.bd.entity.LoginEntity;
import famaly.people.auth.obj.Token;
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
public class NewTokenSession implements TokenWorker, TokenSessionGenerators {

    @Autowired
    private Token token;



    @Override
    public void generate(LoginEntity account, String appName) {
        String randomTokenStr = UUID.randomUUID().toString();
        byte[] loginByte = account.getLogin().getBytes();
        byte[] userNameByte = account.getUserName().getBytes();
        byte[] secondNameByte = account.getSecondName().getBytes();
        String loginStr = loginByte.toString().substring(3);
        String userNameStr = userNameByte.toString().substring(3);
        String secondNameStr = secondNameByte.toString().substring(3);
        String fullTokenStr = String.format("%s-%s-%s-%s-%s-%s?%s@%s", account.getLoginId(), loginStr,
                userNameStr, secondNameStr, randomTokenStr, account.getRules(),
                account.getDateCreateAccount(), account.getIsValid());
        XMLGregorianCalendar dateGeneratedToken = null;
        try {
            GregorianCalendar calendar = new GregorianCalendar();
            calendar.setTime(Date.from(LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant()));
            dateGeneratedToken =  DatatypeFactory.newInstance().newXMLGregorianCalendar(calendar);
        } catch (DatatypeConfigurationException generedDateEx){
            System.out.println(generedDateEx.getMessage());
        }
        token.initToken(account.getLoginId(), account.getLogin(), account.getUserName(), account.getSecondName(),
                true, fullTokenStr, dateGeneratedToken, account.getRules());
    }

    @Override
    public Token getNewTokenToSession() {
        return token;
    }
}
