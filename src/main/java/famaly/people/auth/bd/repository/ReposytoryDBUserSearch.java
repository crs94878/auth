package famaly.people.auth.bd.repository;

import famaly.people.auth.bd.entity.LoginEntity;

public interface ReposytoryDBUserSearch {
    LoginEntity getUserEntity(String login, String pass);
}
