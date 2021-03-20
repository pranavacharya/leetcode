
import java.util.HashMap;

public class DesignAuthenticationManager {

    private HashMap<String, Integer> auth;
    private int ttl;

    public DesignAuthenticationManager(int timeToLive) {
        this.auth = new HashMap();
        this.ttl = timeToLive;
    }

    public void generate(String tokenId, int currentTime) {
        auth.put(tokenId, currentTime + this.ttl);
    }

    public void renew(String tokenId, int currentTime) {
        if (this.auth.containsKey(tokenId)) {
            if (this.auth.get(tokenId) > currentTime) {
                this.auth.put(tokenId, currentTime + this.ttl);
            }
        }
    }

    public int countUnexpiredTokens(int currentTime) {
        int count = 0;
        for (String key : this.auth.keySet()) {
            if (this.auth.get(key) > currentTime) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        DesignAuthenticationManager authenticationManager = new DesignAuthenticationManager(5);
        authenticationManager.renew("aaa", 1); // No token exists with tokenId "aaa" at time 1, so nothing happens.
        authenticationManager.generate("aaa", 2); // Generates a new token with tokenId "aaa" at time 2.
        System.out.println(authenticationManager.countUnexpiredTokens(6)); // The token with tokenId "aaa" is the only unexpired one at time 6, so return 1.
        authenticationManager.generate("bbb", 7); // Generates a new token with tokenId "bbb" at time 7.
        authenticationManager.renew("aaa", 8); // The token with tokenId "aaa" expired at time 7, and 8 >= 7, so at time 8 the renew request is ignored, and nothing happens.
        authenticationManager.renew("bbb", 10); // The token with tokenId "bbb" is unexpired at time 10, so the renew request is fulfilled and now the token will expire at time 15.
        System.out.println(authenticationManager.countUnexpiredTokens(15)); // The token with tokenId "bbb" expires at time 15, and the token with tokenId "aaa" expired at time 7, so currently no token is unexpired, so return 0.
    }
}
