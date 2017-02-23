import java.util.Arrays;

/**
 * Created by charles on 2/11/17.
 */
public class Answers {

    int questionId;
    int answer;
    int[] acceptableAnswers;
    int importance;

    public Answers(){}

    public Answers(int questionId, int answer, int[] acceptableAnswers, int importance) {
        this.questionId = questionId;
        this.answer = answer;
        this.acceptableAnswers = acceptableAnswers;
        this.importance = importance;
    }

    public int getQuestionId() {
        return questionId;
    }

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }

    public int getAnswer() {
        return answer;
    }

    public void setAnswer(int answer) {
        this.answer = answer;
    }

    public int[] getAcceptableAnswers() {
        return acceptableAnswers;
    }

    public void setAcceptableAnswers(int[] acceptableAnswers) {
        this.acceptableAnswers = acceptableAnswers;
    }

    public int getImportance() {
        return importance;
    }

    public void setImportance(int importance) {
        this.importance = importance;
    }

    @Override
    public String toString(){
        return "Answer{" +
                  "questionId" + questionId +
                  ", answer=" + answer +
                  ", acceptableAnswers=" + Arrays.toString(acceptableAnswers) +
                  "importance" + importance +
                  '}';
    }
}
