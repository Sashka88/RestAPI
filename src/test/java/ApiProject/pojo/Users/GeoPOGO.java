package ApiProject.pojo.Users;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
public class GeoPOGO {
    @SerializedName("lat")
    String lat;
    @SerializedName("lng")
    String lng;
}
