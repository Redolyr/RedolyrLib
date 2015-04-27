package RedolyrLibrary.virtualClass;

import sun.reflect.ConstructorAccessor;
import sun.reflect.ReflectionFactory;

import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;

/**
 * Created by redolyr on 2015/02/11.
 */
public class VirtualIOException extends IOException {

    private VirtualPackage virtualPackage;

    private Class<? extends Exception> virtualClass = (Class<? extends Exception>) this.getClass();

    private String virtualClassName;

    private int constructorLength;
    private Class[] constructorClasses = new Class[0];
    private Object[] constructorObjects = new Object[0];

    private Class<? extends Exception>[] constructorExceptions = new Class[0];

    private int constructorModifier = Modifier.PUBLIC;

    private String errorMessage;

    public VirtualIOException(Class<? extends Exception> classException) {
        this(classException.getPackage().getName(), classException.getName(), classException.getModifiers(), new Class[]{}, new Object[]{}, new Class[]{});
    }

    public VirtualIOException(Class<? extends Exception> classException, String message) {
        this(classException.getPackage().getName(), classException.getName(), classException.getModifiers(), new Class[]{String.class}, getConstructorObjects(classException, new Class[] {String.class}, message, null), new Class[]{});
    }

    public VirtualIOException(Class<? extends Exception> classException, String message, Throwable throwable) {
        this(classException.getPackage().getName(), classException.getName(), classException.getModifiers(), new Class[]{String.class, Throwable.class}, getConstructorObjects(classException, new Class[] {String.class, Throwable.class}, message, throwable), new Class[]{});
    }

    public VirtualIOException(Class<? extends Exception> classException, Throwable throwable) {
        this(classException.getPackage().getName(), classException.getName(), classException.getModifiers(), new Class[]{Throwable.class}, getConstructorObjects(classException, new Class[] {Throwable.class}, null, throwable), new Class[] {});
    }

    public VirtualIOException(String virtualPackageName, String virtualClassName, int constructorModifier, Class[] constructorClasses, Object[] constructorObjects, Class<? extends Exception>... constructorExceptions) {
        this.virtualClassName = virtualClassName;
        this.constructorModifier = constructorModifier;
        this.constructorLength = constructorClasses.length;
        this.constructorClasses = constructorClasses;
        this.constructorObjects = constructorObjects;
        this.constructorExceptions = constructorExceptions;
        this.virtualPackage = new VirtualPackage(virtualPackageName);

        if (constructorClasses[0] == String.class) {
            this.errorMessage = (String) constructorObjects[0];
        }

        if (this.constructorClasses.length == this.constructorObjects.length) {
            for (int len = 0; len < constructorClasses.length; ++len) {
                this.addConstructor(this.constructorClasses[len], this.constructorObjects[len]);
            }
        }

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
        String packageName = this.virtualClass.getPackage().getName();
        String virtualName = packageName + "." + this.virtualClassName.replace(packageName, ".").replace("..", "");
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

        Constructor<?> constructor = Constructor.class.getDeclaredConstructor(new Class[] {Class.class, Class[].class, Class[].class, int.class, int.class, String.class, byte[].class, byte[].class});
        Field[] fields = getFields(Constructor.class, true, "clazz", "slot", "parameterTypes", "exceptionTypes", "modifiers", "signature", "genericInfo", "annotations");
        this.setFieldsValue(constructor, fields, this.virtualClass, this.constructorClasses, this.constructorExceptions, this.constructorModifier, 0, "", new byte[0], new byte[0]);
        constructor.setAccessible(true);

        ConstructorAccessor constructorAccessor = reflectionFactory.newConstructorAccessor(constructor);
        Object object = constructorAccessor.newInstance(new Object[] {this.virtualClass, this.constructorClasses, this.constructorExceptions, this.constructorModifier, 0, "", new byte[0], new byte[0]});

        this.updateClassName();
    }

    public String getVirtualClassSimpleName() {
        return this.virtualClassName;
    }

    public String getVirtualClassName() {
        return this.virtualClass.getPackage().getName() + "." + this.virtualClassName;
    }

    public Class<? extends Exception> getVirtualClass() {
        return this.virtualClass;
    }

    public String getMessage() {
        return this.errorMessage;
    }

    private static Object[] getConstructorObjects(Class<? extends Exception> classException, Class[] constructorClasses, String errorMessage, Throwable cause) {
        Object[] objects = new Object[constructorClasses.length];
        try {
            Exception exception = classException.newInstance();
            String message = exception.getMessage();
            Throwable throwable = exception.getCause();
            for (int len = 0; len < constructorClasses.length; ++len) {
                if (constructorClasses[len] == String.class && errorMessage == null) {
                    objects[len] = message;
                } else if (errorMessage != null) {
                    objects[len] = errorMessage;
                } else if (constructorClasses[len] == String.class) {
                    objects[len] = "";
                }
                if (constructorClasses[len] == Throwable.class && cause == null) {
                    objects[len] = throwable;
                } else if (cause != null) {
                    objects[len] = cause;
                }
            }
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return objects;
    }
}
