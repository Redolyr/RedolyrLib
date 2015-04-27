package RedolyrLibrary.enums;

import java.lang.reflect.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by redolyr on 2015/02/03.
 */
public class EnumCustomer {

    public static final EnumCustomer instance = new EnumCustomer();

    public static boolean setup = false;

    public static Object reflectionFactory = null;
    public static Method newConstructorAccessor = null;
    public static Method newInstance = null;
    public static Method newFieldAccessor = null;
    public static Method fieldAccessorSet = null;

    public static final boolean RUNTIME_DEFB = true;
    public static final int flags = RUNTIME_DEFB ? Modifier.PUBLIC : Modifier.PRIVATE | Modifier.STATIC | Modifier.FINAL | 0x1000 /* Modifier.SYNTHETIC */;

    public static final String value = "VALUES";
    public static final String enumValue = "ENUM$VALUES";

    public static final String[] enumCatchs = new String[]{"enumConstantDirectory", "enumConstants"};

    private static final void setup() throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {

        if (setup) return;

        reflectionFactory = ((Method) Class.forName("sun.reflect.ReflectionFactory").getDeclaredMethod("getReflectionFactory")).invoke(null);
        newConstructorAccessor = Class.forName("sun.reflect.ReflectionFactory").getDeclaredMethod("newConstructorAccessor", Constructor.class);
        newInstance = Class.forName("sun.reflect.ConstructorAccessor").getDeclaredMethod("newInstance", Object[].class);
        newFieldAccessor = Class.forName("sun.reflect.ReflectionFactory").getDeclaredMethod("newFieldAccessor", Field.class, boolean.class);
        fieldAccessorSet = Class.forName("sun.reflect.FieldAccessor").getDeclaredMethod("set", Object.class, Object.class);

        setup = true;
    }

    public Object getConstructorAccessor(Class<?> enumClass, Class<?>[] classes) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Class<?>[] classes1 = new Class[classes.length + 2];
        classes1[0] = String.class;
        classes1[1] = int.class;
        System.arraycopy(classes, 0, classes1, 2, classes.length);
        return this.newConstructorAccessor.invoke(this.reflectionFactory, enumClass.getDeclaredConstructor(classes));
    }

    public <T extends Enum> T makeEnum(Class<T> enumClass, String name, int oridinal, Class<?>[] classes, Object[] objects) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Object[] objects1 = new Object[objects.length + 2];
        objects1[0] = name;
        objects1[1] = Integer.valueOf(oridinal);
        System.arraycopy(objects, 0, objects1, 2, objects.length);
        return enumClass.cast(this.newInstance.invoke(this.getConstructorAccessor(enumClass, classes), new Object[]{objects1}));
    }

    public void setFailsafeFieldValue(Field field, Object target, Object value) throws NoSuchFieldException, InvocationTargetException, IllegalAccessException {
        field.setAccessible(true);
        Field field1 = Field.class.getDeclaredField("modifiers");
        field1.setAccessible(true);
        field1.setInt(field, field.getModifiers() & ~Modifier.FINAL);
        Object object = this.newFieldAccessor.invoke(this.reflectionFactory, field, false);
        this.fieldAccessorSet.invoke(object, target, value);
    }

    public void blankField(Class<?> enumClass, String fieldName) throws IllegalAccessException, NoSuchFieldException, InvocationTargetException {
        for (Field field : Class.class.getDeclaredFields()) {
            if (field.getName().contains(fieldName)) {
                field.setAccessible(true);
                this.setFailsafeFieldValue(field, enumClass, null);
                break;
            }
        }
    }

    public <T extends Enum> T addEnum(Class<T> enumClass, String name, Class<?>[] classes, Object[] objects) {

        T newEnum = null;

        Field field = null;
        Field[] fields = enumClass.getDeclaredFields();

        for (Field field1 : fields) {
            if (this.equalsValueType(field1.getName())) {
                field = field1;
                break;
            }
        }

        if (field == null) {
            for (Field field1 : fields) {
                if ((field1.getModifiers() & this.flags) == this.flags && replaceValueType(field1.getType().getName(), false).equals(replaceValueType(field1.getName(), true))) {
                    field = field1;
                    break;
                }
            }
        }

        if (field == null) {
            return null;
        }

        field.setAccessible(true);

        try {
            T[] ts = (T[]) field.get(enumClass);
            List<T> tList = new ArrayList<T>(Arrays.asList(ts));
            newEnum = makeEnum(enumClass, name, tList.size(), classes, objects);
            tList.add(newEnum);
            this.setFailsafeFieldValue(field, null, tList.toArray((T[]) Array.newInstance(enumClass, 0)));
            for (String enumCatch : this.enumCatchs) {
                this.blankField(enumClass, enumCatch);
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
        return newEnum;
    }

    public static final boolean equalsValueType(String type) {
        return type.equals(value) || type.equals(enumValue);
    }

    public static final String replaceValueType(String type, boolean isC_PP) {
        return isC_PP ? "[L" : "" + type.replace('.', '/');
    }
}
