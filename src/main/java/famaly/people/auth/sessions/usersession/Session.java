package famaly.people.auth.sessions.usersession;

import famaly.people.auth.sessions.UserSession;

import javax.xml.datatype.XMLGregorianCalendar;

public class Session {
    protected XMLGregorianCalendar dateCreateSession;
    protected String sessionName;
    protected  boolean isValidSession;

    public String getSessionName(){
        return sessionName;
    }

    public  XMLGregorianCalendar getDateCreateSession(){
        return dateCreateSession;
    }

    public boolean isValidSession() {
        return isValidSession;
    }

    public void setValidSession(boolean value){
        this.isValidSession = value;
    }
}
