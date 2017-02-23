import java.util.Arrays;

/**
 * Created by charles on 2/11/17.
 */
public class Results {
    int profileId;
    Match[] matches;

    public Results(){}

    public Results(int profileId, Match[] matches) {
        this.profileId = profileId;
        this.matches = matches;
    }

    public int getProfileId() {
        return profileId;
    }

    public void setProfileId(int profileId) {
        this.profileId = profileId;
    }

    public Match[] getMatches() {
        return matches;
    }

    public void setMatches(Match[] matches) {
        this.matches = matches;
    }

    @Override
    public String toString(){
        return "Result{" +
                  "profileId=" + profileId +
                  ", matches=" + Arrays.toString(matches) +
                  '}';
    }
}
