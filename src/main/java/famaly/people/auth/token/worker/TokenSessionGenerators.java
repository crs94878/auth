package famaly.people.auth.token.worker;

import famaly.people.auth.bd.entity.LoginEntity;

public interface TokenSessionGenerators {
    void generate(LoginEntity accountInDB, String appName);
}
