package SupplyPower.virtualClass;

import java.lang.reflect.Field;

/**
 * Created by redolyr on 2016/08/10.
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
        field.set(this.aPackage, this.packageName);
    }

    public Package getPackage() {
        return this.aPackage;
    }

    public void setGetPackage(Package pkg) {
        try {
            Package def = this.aPackage;
            this.aPackage = pkg;
            this.update();
            this.aPackage = def;
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
