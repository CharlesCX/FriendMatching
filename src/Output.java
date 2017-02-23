import java.util.Arrays;

/**
 * Created by charles on 2/11/17.
 */
public class Output {

    Results[] results;

    public Output(){}

    public Output(Results[] results) {
        this.results = results;
    }

    public Results[] getResults() {
        return results;
    }

    public void setResults(Results[] results) {
        this.results = results;
    }

    @Override
    public String toString(){
        return "Output{" +
                  "results=" + Arrays.toString(results) +
                  '}';
    }
}
