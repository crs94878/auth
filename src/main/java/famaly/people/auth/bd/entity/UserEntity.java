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
@NamedNativeQuery(name ="getUsersInfo" ,
        query = "call getUsersInfo(:login, :password)",
        resultClass = UserEntity.class)
})
public class UserEntity {

    @Id @Column(name = "UserId", nullable = false)
    private String userId;

    @Column(name = "userName")
    private String userName;

    @Column(name = "login")
    private String login;

    @Column(name = "password")
    private String password;


    @Column(name = "dateCreated")
    private String dateCreateAccount;

    @Column(name = "rules")
    private String rules;

    public String getRules() {
        return rules;
    }

    public String getDateCreateAccount() {
        return dateCreateAccount;
    }

    public String getUserId() {
        return userId;
    }

    public String getPassword() {
        return password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUserId(String userId) {
        this.userId = userId;
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
}
