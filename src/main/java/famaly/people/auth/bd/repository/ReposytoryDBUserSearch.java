package famaly.people.auth.bd.repository;

import famaly.people.auth.bd.entity.LoginEntity;
import famaly.people.auth.obj.AuthRequest;

public interface ReposytoryDBUserSearch {
    LoginEntity getUserEntity(AuthRequest request);
}
