package hello;

import java.io.Serializable;
import java.util.List;

public class UserAuthenticationWrapper implements Serializable {

    private static final long serialVersionUID = 1L;

    private String userToken;
    private Long userId;
    private String userPassword;

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
