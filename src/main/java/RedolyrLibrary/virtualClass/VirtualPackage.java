package RedolyrLibrary.virtualClass;

import java.lang.reflect.Field;

/**
 * Created by redolyr on 2015/02/12.
 */
public class VirtualPackage {

    private Package aPackage = this.getClass().getPackage();

    private String packageName;

    public VirtualPackage(String packageName) {
        this.packageName = packageName;
        try {
            this.update();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    private void update() throws NoSuchFieldException, IllegalAccessException {
        Field field = this.aPackage.getClass().getDeclaredField("pkgName");
        field.setAccessible(true);
//        System.out.println(field.get(this.aPackage));
        field.set(this.aPackage, this.packageName);
//        System.out.println(field.get(this.aPackage));
    }

    public Package getPackage() {
        return this.aPackage;
    }

    public void setGetPackage(Package pkg) {
        try {
            Package def = this.aPackage;
            this.aPackage = pkg;
//            System.out.println(def + ", " + this.aPackage + ", " + pkg);
            this.update();
//            System.out.println(true + ", " + def + ", " + this.aPackage + ", " + pkg);
            this.aPackage = def;
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
