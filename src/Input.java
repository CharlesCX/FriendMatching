import java.util.Arrays;

/**
 * Created by charles on 2/11/17.
 */
public class Input {

    Profiles[] profiles;

    public Input(){}

    public Input(Profiles[] profiles) {
        this.profiles = profiles;
    }

    public Profiles[] getProfiles() {
        return profiles;
    }

    public void setProfiles(Profiles[] profiles) {
        this.profiles = profiles;
    }

    @Override
    public String toString(){
        return "Input{" +
                  "profile=" + Arrays.toString(profiles) +
                  '}';
    }
}
