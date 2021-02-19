package co.com.mauricio.retrofitclient.service;


import co.com.mauricio.retrofitclient.client.GitHubBasicApi;
import co.com.mauricio.retrofitclient.config.APIClient;
import co.com.mauricio.retrofitclient.exeption.DataNotFoundException;
import co.com.mauricio.retrofitclient.model.Contributor;
import co.com.mauricio.retrofitclient.model.RepositoryGithub;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.NoHandlerFoundException;
import retrofit2.Call;
import retrofit2.Response;

import javax.validation.constraints.Null;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class GitHubBasicService {

    public Object getTopContributors(String userName) throws IOException {
        Response<Object> repos = APIClient.getClient().create(GitHubBasicApi.class)
                .listRepos(userName).execute();

        List<RepositoryGithub> repositories = new Gson().fromJson(
                new Gson().toJson(repos.body()) , new TypeToken<List<RepositoryGithub>>(){}.getType());
        return repositories;
    }

    @SneakyThrows
    public List<Contributor> getContributors(String userName, String repositoryName) {

        return Optional.of(APIClient.getClient().create(GitHubBasicApi.class)
                .listRepoContributors(userName, repositoryName).execute())
                .map(e -> e.body())
                .orElseThrow(DataNotFoundException::new)
                .stream().filter(contributor -> contributor.getContributions() > 1)
                .collect(Collectors.toList());
    }
}