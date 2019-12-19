package be.intecbrussel.centralblogproject.listener;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import java.util.ArrayList;
import java.util.List;

public class SessionCounter implements HttpSessionListener {
    public static final String COUNTER = "session-counter";
    private List<String> sessions = new ArrayList<>();
    private List<String> loggedInSessions = new ArrayList<>();

    @Override
    public void sessionCreated(HttpSessionEvent event) {
        System.out.println("SessionCounter.sessionCreated");
        HttpSession session = event.getSession();
        sessions.add(session.getId());
        if (event.getSession().getAttribute("loggedUser") != null) {
            loggedInSessions.add(session.getId());
        }
        session.setAttribute(SessionCounter.COUNTER, this);
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent event) {
        System.out.println("SessionCounter.sessionDestroyed");
        HttpSession session = event.getSession();
        sessions.remove(session.getId());
        if (event.getSession().getAttribute("loggedUser") != null) {
            loggedInSessions.remove(session.getId());
        }
        session.setAttribute(SessionCounter.COUNTER, this);
    }

    public int getActiveSessionNumber() {
        return sessions.size();
    }

    public int getActiveLoggedInSessionNumber() {
        return loggedInSessions.size();
    }
}
