package co.com.mauricio.retrofitclient.controller;

import co.com.mauricio.retrofitclient.service.GitHubBasicService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping(path = "repository/api")
public class RepoController {

    private final GitHubBasicService repoService;


    public RepoController(GitHubBasicService repoService) {
        this.repoService = repoService;
    }

    @GetMapping(value = {"{user}"})
    public Object getRepos(@PathVariable String user) throws IOException {
        return repoService.getTopContributors(user);
    }

    @GetMapping(value = {"{user}/{repo}"})
    public Object getContributors(@PathVariable String user, @PathVariable String repo) throws IOException {
        return repoService.getContributors(user, repo);
    }
}
