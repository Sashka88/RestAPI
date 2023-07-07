package ApiProject.pojo.Users;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
public class UsersPOGO {
    @SerializedName("id")
    int id;
    @SerializedName("name")
    String name;
    @SerializedName("username")
    String username;
    @SerializedName("email")
    String email;
    @SerializedName("address")
    AddressesPOGO addresses;
    @SerializedName("phone")
    String phone;
    @SerializedName("website")
    String website;
    @SerializedName("company")
    CompanyPOGO companyPojo;
}
