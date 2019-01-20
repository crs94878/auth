package famaly.people.auth.sessions;

import com.sun.istack.NotNull;
import famaly.people.auth.sessions.users.Account;
import famaly.people.auth.sessions.usersession.UserAuthSession;
import famaly.people.auth.sessions.valid.controls.SessionValidControls;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class SessionsMapWorker implements UserSession, SessionValidControls {

    @Autowired
    Account account;

    private boolean isTaskStart = false;

    @Autowired
    private HashMap<String, UserAuthSession> sessionsMap;

    @Override
    public void saveUserSession(UserAuthSession session) throws NullPointerException{
        if(session == null) throw new NullPointerException("Sesssion isn't be null");
        sessionsMap.putIfAbsent(session.getSessionName(), session);
    }

    @Override
    public HashMap<String, UserAuthSession> getSavedSessions() {
        return sessionsMap;
    }


    @Override
    public void startValidControlsSession() {
        if(!isTaskStart){
            HashMap<String, UserAuthSession> oldSessions = new HashMap<>();
            Runnable taskValidSesion = () ->{
                isTaskStart = true;
                while(true){
                    Iterator<Map.Entry<String, UserAuthSession>> iterator =
                            sessionsMap.entrySet().iterator();
                        while (iterator.hasNext()){
                            UserAuthSession session = iterator.next().getValue();
                            if (isNeadChanggeState(session)) {
                                session.setValidSession(false);
                            }

                        };
                    try {
                        Thread.sleep(1000);
                    } catch (Exception ex){}
                }
            };
            new Thread(taskValidSesion, "Valid Session Thread").start();
        }
    }

    private boolean isNeadChanggeState(@NotNull UserAuthSession session){
        int dayLogin = session.getDateCreateSession().toGregorianCalendar().get(GregorianCalendar.DAY_OF_YEAR);
        int hourLogin = session.getDateCreateSession().getHour();
        int minutLogin = session.getDateCreateSession().getMinute();
        int secondLogin = session.getDateCreateSession().getSecond();
        int l = LocalDateTime.now().getSecond();
        if((LocalDateTime.now().getSecond() - secondLogin)>2){
            return true;
        }
        return false;
    }
}
