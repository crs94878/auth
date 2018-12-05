package famaly.people.auth.endpoints;

import famaly.people.auth.obj.AuthRequest;
import famaly.people.auth.obj.AuthResponse;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class AuthServiceEndpoint {

    private static final String ENDPOINT_URL  = "http://people.famaly/auth/obj";

    @PayloadRoot(namespace = ENDPOINT_URL, localPart = "authRequest")
    @ResponsePayload
    public AuthResponse getAuthResponse(@RequestPayload AuthRequest request){
        return new AuthResponse();
    }

}
