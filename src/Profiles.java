import java.util.Arrays;

/**
 * Created by charles on 2/11/17.
 */
public class Profiles {

    int id;
    Answers[] answers;

    public  Profiles(){}

    public Profiles(int id, Answers[] answers){
        this.id = id;
        this.answers = answers;
    }

    public int getId(){
        return id;
    }

    public void setId(int id){
        this.id = id;
    }

    public Answers[] getAnswers() {
        return answers;
    }

    public void setAnswers(Answers[] answers){
        this.answers = answers;

    }

    @Override
    public String toString(){
        return "Profile" +
                  "id" + id +
                ", answers=" + Arrays.toString(answers) +
                '}';
    }

}
