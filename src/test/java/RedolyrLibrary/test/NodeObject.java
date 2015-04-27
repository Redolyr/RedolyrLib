package RedolyrLibrary.test;

/**
 * Created by redolyr on 2015/02/12.
 */
public class NodeObject<T> {

    private Class<T> objectClass;
    private T object;
    private int objectID;
    private int size;

    public NodeObject(Class<T> objectClass, T object, int objectID, int size) {
        this.objectClass = objectClass;
        this.object = object;
        this.objectID = objectID;
        this.size = size;
    }

    public Class<T> getObjectClass() {
        return this.objectClass;
    }

    public T getObject() {
        return this.object;
    }

    public int getObjectID() {
        return this.objectID;
    }
}
/**
 * ${type.name} result ${result.name}(${type.name}, ${type.id}, ${result.key}, ${result.value})
 * result ${result.name}(${type.id}, ${result.key}, ${result.value})
 */
