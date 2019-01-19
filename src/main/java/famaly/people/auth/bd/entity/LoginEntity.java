package famaly.people.auth.bd.entity;

import org.hibernate.annotations.NamedNativeQuery;
import org.hibernate.annotations.Type;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import org.hibernate.annotations.NamedNativeQueries;
import javax.xml.datatype.XMLGregorianCalendar;


@Entity
@NamedNativeQueries({
@NamedNativeQuery(name ="getAuthorisation" ,
        query = "call getAuthorisation(:login, :password)",
        resultClass = LoginEntity.class)
})
public class LoginEntity {

    @Id @Column(name = "loginId", nullable = false)
    private String loginId;

    @Column(name = "userName")
    private String userName;

    @Column(name = "login")
    private String login;

    @Column(name = "isValid")
    private boolean isValid;

    @Column(name = "userSecondName")
    private String secondName;

    @Column(name = "dateCreateLogin")
    private String dateCreateAccount;

    @Column(name = "rules")
    private String rules;

    public String getRules() {
        return rules;
    }

    public String getDateCreateAccount() {
        return dateCreateAccount;
    }

    public String getLoginId() {
        return loginId;
    }

    public boolean getIsValid() {
        return isValid;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(boolean validation) {
        this.isValid = validation;
    }

    public void setUserId(String loginId) {
        this.loginId = loginId;
    }

    public void setDateCreateAccount(String dateCreateAccount) {
        this.dateCreateAccount = dateCreateAccount;
    }

    public void setRules(String rules) {
        this.rules = rules;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }
}
