package ApiProject.projectRequestsAndMethods;

import ApiProject.pojo.Users.UsersPOGO;
import org.testng.asserts.SoftAssert;

public class Users {

    private SoftAssert softAssert = new SoftAssert();

    public void validateUserData(UsersPOGO requestUser, UsersPOGO dataFromJsonFile){
        validateNameEqual(requestUser, dataFromJsonFile);
        validateUsernameEqual(requestUser, dataFromJsonFile);
        validateEmailEqual(requestUser, dataFromJsonFile);
        validateStreetEqual(requestUser, dataFromJsonFile);
        validateSuiteEqual(requestUser, dataFromJsonFile);
        validateCityEqual(requestUser, dataFromJsonFile);
        validateZipcodeEqual(requestUser, dataFromJsonFile);
        validateLatValueEqual(requestUser, dataFromJsonFile);
        validateLngValueEqual(requestUser, dataFromJsonFile);
        validatePhoneNumbersEqual(requestUser, dataFromJsonFile);
        validateWebsiteEqual(requestUser, dataFromJsonFile);
        validateCompanyNameEqual(requestUser, dataFromJsonFile);
        validateCompanyCatchPhraseEqual(requestUser, dataFromJsonFile);
        validateCompanyBsEqual(requestUser, dataFromJsonFile);
    }

    private void validateNameEqual(UsersPOGO requestUser, UsersPOGO dataFromJsonFile) {
        softAssert.assertEquals(requestUser.getName(), dataFromJsonFile.getName(), "Names are different");
    }

    private void validateUsernameEqual(UsersPOGO requestUser, UsersPOGO dataFromJsonFile) {
        softAssert.assertEquals(requestUser.getUsername(), dataFromJsonFile.getUsername(),
                "Usernames are different");
    }

    private void validateEmailEqual(UsersPOGO requestUser, UsersPOGO dataFromJsonFile) {
        softAssert.assertEquals(requestUser.getEmail(), dataFromJsonFile.getEmail(),
                "Emails are different");
    }

    private void validateStreetEqual(UsersPOGO requestUser, UsersPOGO dataFromJsonFile) {
        softAssert.assertEquals(requestUser.getAddresses().getStreet(),
                dataFromJsonFile.getAddresses().getStreet(), "Streets are different");
    }

    private void validateSuiteEqual(UsersPOGO requestUser, UsersPOGO dataFromJsonFile) {
        softAssert.assertEquals(requestUser.getAddresses().getSuite(), dataFromJsonFile.getAddresses().getSuite(),
                "Suites are different");
    }

    private void validateCityEqual(UsersPOGO requestUser, UsersPOGO dataFromJsonFile) {
        softAssert.assertEquals(requestUser.getAddresses().getCity(), dataFromJsonFile.getAddresses().getCity(),
                "Cities are different");
    }

    private void validateZipcodeEqual(UsersPOGO requestUser, UsersPOGO dataFromJsonFile) {
        softAssert.assertEquals(requestUser.getAddresses().getZipcode(), dataFromJsonFile.getAddresses().getZipcode(),
                "Zipcodes are different");
    }

    private void validateLatValueEqual(UsersPOGO requestUser, UsersPOGO dataFromJsonFile) {
        softAssert.assertEquals(requestUser.getAddresses().getGeoPojo().getLat(),
                dataFromJsonFile.getAddresses().getGeoPojo().getLat(), "Lat values are different");
    }

    private void validateLngValueEqual(UsersPOGO requestUser, UsersPOGO dataFromJsonFile) {
        softAssert.assertEquals(requestUser.getAddresses().getGeoPojo().getLng(),
                dataFromJsonFile.getAddresses().getGeoPojo().getLng(), "Lng values are different");
    }


    private void validatePhoneNumbersEqual(UsersPOGO requestUser, UsersPOGO dataFromJsonFile) {
        softAssert.assertEquals(requestUser.getPhone(), dataFromJsonFile.getPhone(),
                "Phone numbers are different");
    }

    private void validateWebsiteEqual(UsersPOGO requestUser, UsersPOGO dataFromJsonFile) {
        softAssert.assertEquals(requestUser.getWebsite(), dataFromJsonFile.getWebsite(),
                "Websites are different");
    }

    private void validateCompanyCatchPhraseEqual(UsersPOGO requestUser, UsersPOGO dataFromJsonFile) {
        softAssert.assertEquals(requestUser.getCompanyPojo().getCatchPhrase(),
                dataFromJsonFile.getCompanyPojo().getCatchPhrase(), "Company catch phrases are different");
    }

    private void validateCompanyNameEqual(UsersPOGO requestUser, UsersPOGO dataFromJsonFile) {
        softAssert.assertEquals(requestUser.getCompanyPojo().getName(), dataFromJsonFile.getCompanyPojo().getName(),
                "Company names are different");
    }

    private void validateCompanyBsEqual(UsersPOGO requestUser, UsersPOGO dataFromJsonFile) {
        softAssert.assertEquals(requestUser.getCompanyPojo().getBs(), dataFromJsonFile.getCompanyPojo().getBs(),
                "Bs values are different");
    }

    public UsersPOGO getUserByIdFromAllUsers(UsersPOGO[] users, int id) {
        UsersPOGO oneUser = null;
        for (UsersPOGO user : users) {
            if (user.getId() == id) {
                oneUser = user;
            }
        }
        return oneUser;
    }
}
