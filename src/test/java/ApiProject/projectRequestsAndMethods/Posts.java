package ApiProject.projectRequestsAndMethods;

import ApiProject.pojo.Posts.PostsPOGO;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Posts {

    private SoftAssert softAssert = new SoftAssert();

    public void validatePostIdData(PostsPOGO requestPost, PostsPOGO dataFromJsonFile){
        validateIdEqual(requestPost, dataFromJsonFile);
        validateUserIdEqual(requestPost, dataFromJsonFile);
    }

    private void validateIdEqual(PostsPOGO requestPost, PostsPOGO dataFromJsonFile) {
        softAssert.assertEquals(requestPost.getId(), dataFromJsonFile.getId(), "Id are different");
    }

    private void validateUserIdEqual(PostsPOGO requestPost, PostsPOGO dataFromJsonFile) {
        softAssert.assertEquals(requestPost.getUserId(), dataFromJsonFile.getUserId(),
                "UserIds are different");
    }

    public void validateBodyNotEmpty(PostsPOGO requestPost) {
        softAssert.assertFalse(requestPost.getBody().isEmpty(), "Body is empty");
    }

    public void validatePostToBeNotNull(PostsPOGO requestPost) {
        softAssert.assertNull(requestPost.getBody(), "The body isn't null");
        softAssert.assertNull(requestPost.getTitle(), "The title isn't null");
    }

    public void validateTitleToBeNotEmpty(PostsPOGO requestPost) {
        softAssert.assertFalse(requestPost.getTitle().isEmpty(), "Title is empty");
    }

    public void validatePostsToBeSortedById(PostsPOGO[] allPosts) {
        Assert.assertEquals(allPosts[0].getId(), allPosts[1].getId() - 1);
    }

    public void validateCreatedPostToBeEqual(PostsPOGO posts) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(byteArrayOutputStream));
        String id = Integer.toString(posts.getId());
        String userId = Integer.toString(posts.getUserId());
        System.out.println(posts);
        softAssert.assertTrue(byteArrayOutputStream.toString().contains(posts.getTitle()), "Current title is " +
                "not the same as in request");
        softAssert.assertTrue(byteArrayOutputStream.toString().contains(posts.getBody()), "Current body is not " +
                "the same as in request");
        softAssert.assertTrue(byteArrayOutputStream.toString().contains(id), "Current id is not the " +
                "same as in request");
        softAssert.assertTrue(byteArrayOutputStream.toString().contains(userId), "Current userId is not the " +
                "same as in request");
        softAssert.assertAll();
        System.setOut(null);
    }
}
