package famaly.people.auth.sessions.users;

import famaly.people.auth.bd.entity.UserEntity;

import javax.xml.datatype.XMLGregorianCalendar;

public class Account extends User{
    private String id;
    private XMLGregorianCalendar dateCreateAccount;
    private String rules;

    public void initialize(UserEntity entity){
        super.intialize(entity.getUserName(), entity.getPassword());
        this.id = entity.getUserId();
       //this.dateCreateAccount = entity.getDateCreateAccount();
        this.rules = entity.getRules();
    }

    public String getId() {
        return id;
    }

    public XMLGregorianCalendar getDateCreateAccount() {
        return dateCreateAccount;
    }
}
