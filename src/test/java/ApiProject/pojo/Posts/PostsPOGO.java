package ApiProject.pojo.Posts;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
public class PostsPOGO {
    @SerializedName("userId")
    int userId;
    @SerializedName("id")
    int id;
    @SerializedName("title")
    String title;
    @SerializedName("body")
    String body;
}
