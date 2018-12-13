package famaly.people.auth.endpoints;

import famaly.people.auth.obj.AuthRequest;
import famaly.people.auth.obj.AuthResponse;
import famaly.people.auth.services.interfaces.GeneratedTokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class AuthServiceEndpoint {

    private static final String ENDPOINT_URL  = "http://people.famaly/auth/obj";

    @Autowired
    private GeneratedTokenService generatedTokenService;

    @PayloadRoot(namespace = ENDPOINT_URL, localPart = "authRequest")
    @ResponsePayload
    public AuthResponse getAuthResponse(@RequestPayload AuthRequest request){
        AuthResponse response = generatedTokenService.getSessionToken(request);
        return response;
    }
}
