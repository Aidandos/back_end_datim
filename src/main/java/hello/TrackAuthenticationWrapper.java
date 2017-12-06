package hello;

import java.io.Serializable;

public class TrackAuthenticationWrapper implements Serializable {

    private static final long serialVersionUID = 1L;

    private String trackToken;
    private Long trackId;

    public String getTrackToken() {
        return trackToken;
    }

    public void setTrackToken(String trackToken) {
        this.trackToken = trackToken;
    }

    public Long getTrackId() {
        return trackId;
    }

    public void setTrackId(Long trackId) {
        this.trackId = trackId;
    }
}
