package famaly.people.auth.token.worker;

import famaly.people.auth.bd.entity.UserEntity;
import famaly.people.auth.obj.AuthRequest;
import famaly.people.auth.obj.Token;

public interface TokenWorker {
    Token getNewTokenToSession();
}
