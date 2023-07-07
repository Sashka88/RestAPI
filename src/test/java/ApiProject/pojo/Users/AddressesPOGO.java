package ApiProject.pojo.Users;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
public class AddressesPOGO {
    @SerializedName("suite")
    String suite;
    @SerializedName("street")
    String street;
    @SerializedName("zipcode")
    String zipcode;
    @SerializedName("geo")
    GeoPOGO geoPojo;
    @SerializedName("city")
    String city;
}
