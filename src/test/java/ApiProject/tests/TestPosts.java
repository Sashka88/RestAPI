package ApiProject.tests;

import ApiProject.projectRequestsAndMethods.Posts;
import com.github.javafaker.Faker;
import framework.services.JsonReader;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import ApiProject.pojo.Posts.PostsPOGO;
import ApiProject.projectRequestsAndMethods.RequestsAndMethods;

import java.io.FileNotFoundException;

public class TestPosts {

    RequestsAndMethods requestsAndMethods = new RequestsAndMethods(new PostsPOGO());
    JsonReader jsonReader = new JsonReader(new PostsPOGO());
    Faker faker = new Faker();
    Posts posts = new Posts();
    SoftAssert softAssert = new SoftAssert();

    @Test
    public void getallPostsTest() {
        PostsPOGO[] allPosts = (PostsPOGO[]) requestsAndMethods.getAllEntities(200);
        posts.validatePostsToBeSortedById(allPosts);
    }

    @Test
    public void getOnePostTest() throws FileNotFoundException {
        PostsPOGO onePost = (PostsPOGO) requestsAndMethods.getEntity("99", 200);
        PostsPOGO dataJsonFile = (PostsPOGO) jsonReader.getDataFromJsonFile("post99.json");
        posts.validatePostIdData(onePost, dataJsonFile);
        posts.validateBodyNotEmpty(onePost);
        posts.validateTitleToBeNotEmpty(onePost);
        softAssert.assertAll();
    }

    @Test
    public void createPostTest() throws FileNotFoundException {
        PostsPOGO newPost = (PostsPOGO) jsonReader.getDataFromJsonFile("postcreate.json");
        newPost.setBody(faker.business().toString());
        newPost.setTitle(faker.name().toString());
        requestsAndMethods.createNewEntity(newPost, 201);
        posts.validateCreatedPostToBeEqual(newPost);
    }

    @Test
    public void getNonexistentPostTest() {
        PostsPOGO actualPost = (PostsPOGO) requestsAndMethods.getEntity("150", 404);
        posts.validatePostToBeNotNull(actualPost);
        softAssert.assertAll();
    }
}
