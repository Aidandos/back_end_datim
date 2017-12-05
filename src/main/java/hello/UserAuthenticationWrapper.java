package hello;

import java.io.Serializable;

/**
 * Created by rafael on 24/04/16.
 */
public class UserAuthenticationWrapper implements Serializable {

    private static final long serialVersionUID = 1L;

    private String userToken;
    private Long userId;

    public String getUserToken() {
        return userToken;
    }

    public void setUserToken(String userToken) {
        this.userToken = userToken;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
