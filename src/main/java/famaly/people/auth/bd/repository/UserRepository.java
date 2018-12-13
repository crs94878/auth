package famaly.people.auth.bd.repository;

import famaly.people.auth.bd.entity.UserEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;

@Repository
public class UserRepository implements ReposytoryDBUserSearch{

    @Autowired
    private SessionFactory sessionFactory;

    @SuppressWarnings("uncheked")
    public UserEntity getUserEntity(String login, String pass){
        Session session = sessionFactory.getCurrentSession();
        return (UserEntity)session.getNamedQuery("getUsersInfo").setParameter("login", login).setParameter("password", pass);

    }


}
