package ApiProject.tests;

import framework.services.JsonReader;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import ApiProject.pojo.Users.UsersPOGO;
import ApiProject.projectRequestsAndMethods.RequestsAndMethods;

import java.io.FileNotFoundException;

public class TestUsers {

    RequestsAndMethods commonRequestsAndMethods = new RequestsAndMethods(new UsersPOGO());
    JsonReader jsonReader = new JsonReader(new UsersPOGO());
    ApiProject.projectRequestsAndMethods.Users users = new ApiProject.projectRequestsAndMethods.Users();
    SoftAssert softAssert = new SoftAssert();

    @Test
    public void getAllUsersTest() throws FileNotFoundException {
        UsersPOGO[] allUsers = (UsersPOGO[]) commonRequestsAndMethods.getAllEntities(200);
        UsersPOGO theFifthUser = users.getUserByIdFromAllUsers(allUsers, 5);
        UsersPOGO dataFromJsonFile = (UsersPOGO) jsonReader.getDataFromJsonFile("user.json");
        users.validateUserData(theFifthUser, dataFromJsonFile);
        softAssert.assertAll();
    }

    @Test
    public void getCertainUserTest() throws FileNotFoundException {
        UsersPOGO certainUser = (UsersPOGO) commonRequestsAndMethods.getEntity("5", 200);
        UsersPOGO dataFromJsonFile = (UsersPOGO) jsonReader.getDataFromJsonFile("user.json");
        users.validateUserData(certainUser, dataFromJsonFile);
        softAssert.assertAll();
    }
}
