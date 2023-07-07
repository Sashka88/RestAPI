package ApiProject.projectRequestsAndMethods;

import framework.Requests;
import ApiProject.pojo.Posts.PostsPOGO;

public class RequestsAndMethods<T> extends Requests {

    T object;
    protected String uriOfEntity;

    public RequestsAndMethods(T object) {
        this.object = object;
        if (this.object instanceof PostsPOGO) {
            uriOfEntity = "uriPosts";
        } else {
            uriOfEntity = "uriUsers";
        }
    }

    public T getEntity(String numberOfEntity, int statusCode) {
        return (T) gson.fromJson(get(confgReader.getProperty(uriOfEntity) + numberOfEntity, statusCode),
                object.getClass());
    }

    public T[] getAllEntities(int statusCode) {
        return (T[]) gson.fromJson(get(confgReader.getProperty(uriOfEntity), statusCode),
                object.getClass().arrayType());
    }

    public void createNewEntity(T object, int statusCode) {
        post(gson.toJson(object), confgReader.getProperty(uriOfEntity), statusCode);
    }
}

