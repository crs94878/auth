package famaly.people.auth.bd.repository;

import famaly.people.auth.bd.entity.UserEntity;

public interface ReposytoryDBUserSearch {
    UserEntity getUserEntity(String login, String pass);
}
