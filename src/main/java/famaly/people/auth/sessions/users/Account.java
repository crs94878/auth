package famaly.people.auth.sessions.users;

import javax.xml.datatype.XMLGregorianCalendar;

public class Account extends User{
    private String id;
    private XMLGregorianCalendar dateCreateAccount;
    private String rules;

    public String getId() {
        return id;
    }

    public XMLGregorianCalendar getDateCreateAccount() {
        return dateCreateAccount;
    }
}
