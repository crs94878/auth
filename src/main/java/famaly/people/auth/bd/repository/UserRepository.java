package famaly.people.auth.bd.repository;

import famaly.people.auth.bd.entity.LoginEntity;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import java.util.List;

@Transactional(readOnly = true, propagation=Propagation.NOT_SUPPORTED)
@Repository
public class UserRepository implements ReposytoryDBUserSearch{

    @Autowired
    private SessionFactory sessionFactory;

    @SuppressWarnings("uncheked")
    public LoginEntity getUserEntity(String login, String pass){
        Session session = null;
        try {
            session = sessionFactory.getCurrentSession();
        } catch (HibernateException hibEx){
            session = sessionFactory.openSession();
        }
        Query authQuery = session.getNamedQuery("getAuthorisation");

        authQuery.setParameter("login", login);
        authQuery.setParameter("password", pass);

        List<LoginEntity> listResult = authQuery.list();
        return listResult.get(0);
    }

}
