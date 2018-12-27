package famaly.people.auth.sessions.users;

import famaly.people.auth.bd.entity.UserEntity;

import javax.xml.datatype.XMLGregorianCalendar;

public class Account extends User{
    private String id;
    private XMLGregorianCalendar dateCreateAccount;
    private String rules;
    private String login;

    public void initialize(UserEntity entity){
        super.intialize(entity.getUserName(), entity.getPassword());
        this.id = entity.getUserId();
       //this.dateCreateAccount = entity.getDateCreateAccount();
        this.rules = entity.getRules();
        this.login = entity.getLogin();
    }

    public String getId() {
        return id;
    }

    public XMLGregorianCalendar getDateCreateAccount() {
        return dateCreateAccount;
    }

    public String getRules() {
        return rules;
    }

    public void setRules(String rules) {
        this.rules = rules;
    }

    public void setDateCreateAccount(XMLGregorianCalendar dateCreateAccount) {
        this.dateCreateAccount = dateCreateAccount;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }
}
