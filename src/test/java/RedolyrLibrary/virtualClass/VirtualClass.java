package RedolyrLibrary.virtualClass;

import sun.reflect.ConstructorAccessor;
import sun.reflect.ReflectionFactory;

import java.lang.reflect.*;

/**
 * Created by redolyr on 2015/02/11.
 */
public class VirtualClass<T> {

    private VirtualPackage virtualPackage;

    private Class<T> virtualClass = (Class<T>) this.getClass();

    private String virtualClassName;

    private int constructorLength;
    private Class[] constructorClasses = new Class[0];
    private Object[] constructorObjects = new Object[0];

    private Class<? extends Exception>[] constructorExceptions = new Class[0];

    private int constructorModifier = Modifier.PUBLIC;

    public VirtualClass(String virtualPackageName, String virtualClassName, int constructorModifier, Class[] constructorClasses, Object[] constructorObjects, Class<? extends Exception>... constructorExceptions) {
        this.virtualClassName = virtualClassName;
        this.constructorModifier = constructorModifier;
        this.constructorLength = constructorClasses.length;
        this.constructorClasses = constructorClasses;
        this.constructorObjects = constructorObjects;
        this.constructorExceptions = constructorExceptions;
        this.virtualPackage = new VirtualPackage(virtualPackageName);

        try {
            this.update();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
    }

    public void addConstructor(Class constructorClass, Object constructorObject) {
        if (this.constructorClasses == null) this.constructorClasses = new Class[this.constructorLength + 1];
        else this.constructorClasses = new Class[this.constructorLength + 1];

        if (this.constructorObjects == null) this.constructorObjects = new Object[this.constructorLength + 1];
        else this.constructorObjects = new Object[this.constructorLength + 1];

        this.constructorClasses[this.constructorLength] = constructorClass;
        this.constructorObjects[this.constructorLength] = constructorObject;

        ++this.constructorLength;
    }

    public Field[] getFields(Class parentClass, boolean isDeclared, String... strings) throws NoSuchFieldException {
        Field[] fields = new Field[strings.length];

        for (int len = 0; len < strings.length; ++len) {
            String string = strings[len];
            if (string != null || string != "") {
                if (isDeclared) {
                    fields[len] = parentClass.getDeclaredField(string);
                } else {
                    fields[len] = parentClass.getField(string);
                }
            }
        }

        Field[] fields1 = null;
        int length = 0;
        for (int len = 0; len < fields.length; ++len) {
            if (fields[len] != null) {
                if (fields1 == null) fields1 = new Field[1];
                else fields1 = new Field[length + 1];

                fields1[length] = fields[len];

                ++length;
            }
        }
        return fields1;
    }

    public void setFieldsValue(Object setParent, Field[] fields, Object... values) throws IllegalAccessException {
        for (int len = 0; len < fields.length; ++len) {
            Field field = fields[len];
            if (field != null) {
                field.setAccessible(true);
                field.set(setParent, values[len]);
            }
        }
    }

    private void updateClassName() throws IllegalAccessException, NoSuchFieldException, NoSuchMethodException {
        String virtualName = this.virtualClass.getPackage().getName() + "." + this.virtualClassName;
        Field name = this.virtualClass.getClass().getDeclaredField("name");
        name.setAccessible(true);
        name.set(this.getClass(), virtualName);
        name.set(this.virtualClass.getClass(), virtualName);
        Package pkg = this.virtualClass.getPackage();
        if (this.virtualClass != null && pkg != null) {
            this.virtualPackage.setGetPackage(pkg);
        }
    }

    private void update() throws NoSuchFieldException, IllegalAccessException, NoSuchMethodException, InvocationTargetException, ClassNotFoundException, InstantiationException {
        ReflectionFactory reflectionFactory = ReflectionFactory.getReflectionFactory();

        Constructor<T> constructor = (Constructor<T>) Constructor.class.getDeclaredConstructor(new Class[] {Class.class, Class[].class, Class[].class, int.class, int.class, String.class, byte[].class, byte[].class});
        Field[] fields = getFields(Constructor.class, true, "clazz", "slot", "parameterTypes", "exceptionTypes", "modifiers", "signature", "genericInfo", "annotations");
        this.setFieldsValue(constructor, fields, this.virtualClass, this.constructorClasses, this.constructorExceptions, this.constructorModifier, 0, "", new byte[0], new byte[0]);
        constructor.setAccessible(true);

        ConstructorAccessor constructorAccessor = reflectionFactory.newConstructorAccessor(constructor);
        Object object = constructorAccessor.newInstance(new Object[] {this.virtualClass, this.constructorClasses, this.constructorExceptions, this.constructorModifier, 0, "", new byte[0], new byte[0]});
        System.out.println(object + ", " + object.getClass().getSimpleName());

        this.updateClassName();
    }

    public String getVirtualClassSimpleName() {
        return this.virtualClassName;
    }

    public String getVirtualClassName() {
        return this.virtualClass.getPackage().getName() + "." + this.virtualClassName;
    }

    public Class<T> getVirtualClass() {
        return this.virtualClass;
    }
}
