package ApiProject.pojo.Users;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
public class CompanyPOGO {
    @SerializedName("name")
    String name;
    @SerializedName("bs")
    String bs;
    @SerializedName("catchPhrase")
    String catchPhrase;
}
