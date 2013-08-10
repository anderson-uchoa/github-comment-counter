package com.tzachz.commentcounter;

import com.tzachz.commentcounter.apifacade.RepoCommentsResource;
import org.junit.Rule;
import org.junit.Test;

import java.util.Date;

import static org.hamcrest.Matchers.greaterThan;
import static org.junit.Assert.assertThat;

/**
 * Created by IntelliJ IDEA.
 * User: tzachz
 * Date: 8/8/13
 */
public class RepositoryCommentsResourceTest {

    @Rule
    public VMOptsCredentials credentials = new VMOptsCredentials();

    @Test
    public void atLeastOneCommentByAvihayOnFacterJ() throws Exception {
        RepoCommentsResource repoCommentsResource =
                new RepoCommentsResource(credentials.getUsername(), credentials.getPassword());
        UserComments comments = new UserComments();
        comments.addAll(repoCommentsResource.getUserComments("kenshoo", "facterj", new Date(0l)));
        assertThat(comments.getCommentCount("AvihayTsayeg"), greaterThan(0));
    }
}