import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.xml.transform.Result;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;

/**
 * Created by charles on 2/11/17.
 */
public class Calculate {

    int[] importanceWeights = {0, 1, 10, 50, 250};

    public Output getResult() throws FileNotFoundException{
        Output result = new Output();
        Input input = deserializeJson();
        Profiles[] profiles = input.getProfiles();
        List<Results> list = new ArrayList<>();
        for(int i = 0; i < profiles.length; i++){
            list.add(topTenMatch(profiles, i));
        }
        Results[] results = new Results[list.size()];
        for(int i = 0; i < results.length; i++){
            results[i] = list.get(i);
        }
        result.setResults(results);
        return result;
    }

    public Results topTenMatch(Profiles[] profiles, int index){
        Results output = new Results();
        output.setProfileId(profiles[index].getId());
        PriorityQueue<Match> pq = new PriorityQueue<Match>(new Comparator<Match>(){
            @Override
            public int compare(Match m1, Match m2){
                return Float.compare(m1.getScore(), m2.getScore());
            }
        });
        for(int i = 0; i < profiles.length; i++){
            if(i == index){
                continue;
            }
            float score = calculateScore(profiles[index], profiles[i]);
            if (pq.size() < 10){
                Match match = new Match(profiles[i].getId(), score);
                pq.offer(match);
            } else if(pq.peek().getScore() < score){
                Match match = new Match(profiles[i].getId(), score);
                pq.poll();
                pq.offer(match);
            }
        }
        Match[] array = new Match[pq.size()];
        for(int i = 0; i < array.length; i++){
            array[i] = pq.poll();
        }
        output.setMatches(array);
        return output;
    }

    public Input deserializeJson() throws FileNotFoundException{
        Gson gson = new GsonBuilder().create();
        return gson.fromJson(new FileReader("input.json"), Input.class);
    }

    private float calculateScore(Profiles profile1, Profiles profile2) {
        Answers[] answers1 = profile1.getAnswers();
        Answers[] answers2 = profile2.getAnswers();
        float result = 0;
        Map<Integer, Answers> map1 = new HashMap<>();
        for (Answers answer : answers1) {
            map1.put(answer.getQuestionId(), answer);
        }
        int answer1 = 0;
        int expect1 = 0;
        int expect2 = 0;
        int answer2 = 0;
        int count = 0;
        for (Answers answer : answers2) {
            if (map1.containsKey(answer.getQuestionId())) {
                count++;
                Answers temp = map1.get(answer.getQuestionId());
                expect1 += importanceWeights[temp.getImportance()];
                expect2 += importanceWeights[answer.getImportance()];
                for (int acceptable : temp.getAcceptableAnswers()) {
                    if (answer.getAnswer() == acceptable) {
                        answer1 += importanceWeights[temp.getImportance()];
                        break;
                    }
                }
                for (int acceptable : answer.getAcceptableAnswers()) {
                    if (temp.getAnswer() == acceptable) {
                        answer2 += importanceWeights[answer.getImportance()];
                        break;
                    }
                }
            }
        }
        double ratio1 = answer1 * 1.0 / expect1;
        double ratio2 = answer2 * 1.0 / expect2;
        result = (float) Math.sqrt(ratio1 * ratio2) - (float) (1.0 / count);
        return result;
    }
}
