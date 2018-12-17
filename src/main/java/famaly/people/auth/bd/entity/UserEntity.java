package famaly.people.auth.bd.entity;

import org.hibernate.annotations.NamedNativeQuery;
import org.hibernate.annotations.Type;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.xml.datatype.XMLGregorianCalendar;


@Entity
@NamedNativeQuery(name ="getUsersInfo" ,query = "{call [userspeopleinformer].[getUsersInfo]{:login, :password}}",
        callable = true, resultClass = UserEntity.class)
public class UserEntity {

    @Id @Column(name = "UserId", nullable = false)
    private String userId;

    @Column(name = "login")
    private String userName;

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
}
