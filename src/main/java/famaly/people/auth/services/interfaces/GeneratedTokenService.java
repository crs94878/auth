package famaly.people.auth.services.interfaces;

import famaly.people.auth.obj.AuthRequest;
import famaly.people.auth.obj.AuthResponse;
import famaly.people.auth.obj.Token;

public interface GeneratedTokenService {

    AuthResponse getSessionToken(AuthRequest request);
}
