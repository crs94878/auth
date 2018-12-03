package famaly.people.auth.endpoints;

import famaly.people.auth.obj.AuthRequest;
import famaly.people.auth.obj.AuthResponse;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;

@Endpoint
public class AuthServiceEndpoint {

    private static final String ENDPOINT_URL  = "http://people.famaly/auth/obj";

    public AuthResponse getAuthResponse(@RequestPayload AuthRequest request){
        return new AuthResponse();
    }

}
