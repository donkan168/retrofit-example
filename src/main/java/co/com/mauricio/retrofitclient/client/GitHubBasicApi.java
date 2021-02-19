package co.com.mauricio.retrofitclient.client;

import co.com.mauricio.retrofitclient.model.Contributor;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

import java.util.List;

public interface GitHubBasicApi {


    @GET("users/{user}/repos")
    Call<Object> listRepos(@Path("user") String user);

    @GET("repos/{user}/{repo}/contributors")
    Call<List<Contributor>> listRepoContributors(@Path("user") String user, @Path("repo") String repo);

}