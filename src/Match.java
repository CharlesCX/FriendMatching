/**
 * Created by charles on 2/11/17.
 */
public class Match {

    int profileId;
    float score;

    public Match(){}

    public Match(int profileId, float score) {
        this.profileId = profileId;
        this.score = score;
    }

    public int getProfileId() {
        return profileId;
    }

    public void setProfileId(int profileId) {
        this.profileId = profileId;
    }

    public float getScore() {
        return score;
    }

    public void setScore(float score) {
        this.score = score;
    }

    @Override
    public String toString(){
        return "Match{" +
                  "profileId=" + profileId +
                  ", score=" + score +
                  '}';
    }
}
