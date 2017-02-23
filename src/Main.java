import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;


/**
 * Created by charles on 2/11/17.
 */
public class Main {
    public static void main(String[] args) throws IOException{
        Calculate cal = new Calculate();
        Output  output = cal.getResult();
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        System.out.print(gson.toJson(output));
    }
}
