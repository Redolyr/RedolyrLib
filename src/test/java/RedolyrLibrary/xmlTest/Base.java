package RedolyrLibrary.xmlTest;

import java.lang.reflect.Field;

/**
 * Created by redolyr on 2015/03/30.
 */
public abstract class Base {

    public abstract Class<? extends Base> getType();

    public abstract byte getID();

    public String toString() {
        String json = "{";
        Field[] fields = this.getType().getDeclaredFields();
        for (int len = 0; len < fields.length; ++len) {
            Field field = fields[len];
            try {
                json += String.format("{'%s'='%s'}", field.getName(), field.get(this)).replace('\'', '"');
                if (len != fields.length - 1) {
                    json += ", ";
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        json += "}";
        return json;
    }
}
