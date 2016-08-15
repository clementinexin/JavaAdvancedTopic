import retrofit2.Call;
import retrofit2.Retrofit;

import java.io.IOException;
import java.util.List;

/**
 * Created by daijiajia on 16/8/15.
 */
public class Main {

    public static void main(String[] args) throws IOException {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.github.com/")
                .build();

        GithubService service = retrofit.create(GithubService.class);

        Call<List<Repo>> repos = service.listRepos("octocat");
        System.out.println(repos.execute().raw());
    }
}
