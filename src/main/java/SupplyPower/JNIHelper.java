package SupplyPower;

import java.io.*;
import java.lang.reflect.Array;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by redolyr on 2016/08/10.
 */
public class JNIHelper {

    public enum Signature {
        V("Void", "V", "void", "jvoid", "java.lang.Void"),
        Z("Boolean", "Z", "boolean", "jboolean", "java.lang.Boolean"),
        B("Byte", "B", "byte", "jbyte", "java.lang.Byte"),
        C("Character", "C", "char", "jchar", "java.lang.Character"),
        S("Short", "S", "short", "jshort", "java.lang.Short"),
        I("Integer", "I", "int", "jint", "java.lang.Integer"),
        J("Long", "J", "long", "jlong", "java.lang.Long"),
        F("Float", "F", "float", "jfloat", "java.lang.Float"),
        D("Double", "D", "double", "jdouble", "java.lang.Double");

        public static final Signature[] signatures = new Signature[] {V, Z, B, C, S, I, J, F, D};
        public static final int length = 9;

        public final String primitiveClassName;
        public final String signature;
        public final String objectSignature;
        public final String cppDefine;
        public final String primitiveClass;

        Signature(String primitiveClassName, String signature, String objectSignature, String cppDefine, String primitiveClass) {
            this.primitiveClassName = primitiveClassName;
            this.signature = signature;
            this.objectSignature = objectSignature;
            this.cppDefine = cppDefine;
            this.primitiveClass = primitiveClass;
        }

        public String toString() {
            return "Signature{" +
                    "primitiveClassName='" + primitiveClassName + '\'' +
                    ", signature='" + signature + '\'' +
                    ", objectSignature='" + objectSignature + '\'' +
                    ", cppDefine='" + cppDefine + '\'' +
                    '}';
        }

        public static String getSignature(String var0) {
            for (int len = 0; len < length; ++len) {
                Signature signature = signatures[len];
                if (var0.contains(signature.objectSignature)) {
                    return signature.signature;
                }
            }
            return var0;
        }

        public static String getObjectSignature(String var0) {
            for (int len = 0; len < length; ++len) {
                Signature signature = signatures[len];
                if (var0.contains(signature.primitiveClassName)) {
                    return signature.objectSignature;
                }
            }
            return var0;
        }

        public static String getCppObjectSignature(String var0) {
            for (int len = 0; len < length; ++len) {
                Signature signature = signatures[len];
                if (var0.contains(signature.objectSignature)) {
                    return signature.cppDefine;
                }
            }
            return "jobject";
        }

        public static String getCppSignature(String var0) {
            for (int len = 0; len < length; ++len) {
                Signature signature = signatures[len];
                if (var0.contains(signature.objectSignature)) {
                    return signature.cppDefine;
                }
            }
            return var0;
        }

        public static Class[] newClasses(String params) throws ClassNotFoundException {
            if (!params.startsWith("(") && !params.endsWith(")")) return null;
            String param = params.substring(1, params.length() - 1);
            ArrayList<Class> classes = new ArrayList<Class>();
            while (param.length() > 0) {
                if (param.startsWith("L") && param.contains(";")) {
                    int end = param.indexOf(";");
                    classes.add(Class.forName(param.substring(1, end).replace("/", ".")));
                    param = param.substring(end + 1);
                } else if (param.startsWith("[")) {
                    if (param.substring(1).startsWith("L")) {
                        int end = param.indexOf(";");
                        classes.add(Array.newInstance(Class.forName(param.substring(2, end).replace("/", ".")), 0).getClass());
                        param = param.substring(end + 1);
                    } else {
                        for (int len = 0; len < length; ++len) {
                            Signature signature = signatures[len];
                            if (String.valueOf(param.charAt(1)).contains(signature.signature)) {
                                classes.add(Class.forName("[L" + signature.primitiveClass + ";"));
                                param = param.substring(2);
                                break;
                            }
                        }
                    }
                } else {
                    for (int len = 0; len < length; ++len) {
                        Signature signature = signatures[len];
                        if (String.valueOf(param.charAt(0)).contains(signature.signature)) {
                            classes.add(Class.forName(signature.primitiveClass));
                            param = param.substring(1);
                            break;
                        }
                    }
                }
            }
            return classes.toArray(new Class[0]);
        }

        public static Method getMethod(String className, String method, String signature) throws ClassNotFoundException, NoSuchMethodException {
            return Class.forName(className.replace("_", ".")).getDeclaredMethod(method, newClasses(signature));
        }
    }

    public static String getJavaMethodParameter(Method var0) {
        Class[] var1 = var0.getParameterTypes();
        Class[] var2 = var0.getExceptionTypes();
        String var3 = "";
        String var4 = "";
        for (int len = 0; len < var1.length; ++len) {
            var3 += var1[len].getName() + (len == var1.length - 1 ? "" : ", ");
        }
        for (int len = 0; len < var2.length; ++len) {
            var4 += var2[len].getName() + (len == var2.length - 1 ? "" : ", ");
        }
        return String.format("%s %s %s(%s)%s;", Modifier.toString(var0.getModifiers()), var0.getReturnType().getName(), var0.getName(), var3, var4 != "" ? " throws " + var4 : "");
    }

    public static String getCPlusPlusMethodSignature(Method var0) {
        Class[] var1 = var0.getParameterTypes();
        String var2 = "";
        for (int len = 0; len < var1.length; ++len) {
            var2 += getSignature(var1[len].getName(), true);
        }
        return "(" + var2 + ")" + getSignature(var0.getReturnType().getName(), true);
    }

    public static String getSignature(String parameterClassType, boolean isReload) {
        String cPlusPlusType;
        if (!parameterClassType.startsWith("[")) {
            String signature = Signature.getSignature(parameterClassType);
            if (signature.equals(parameterClassType)) {
                if (isReload) {
                    cPlusPlusType = getSignature(Signature.getObjectSignature(parameterClassType), false);
                } else {
                    cPlusPlusType = "L" + parameterClassType + ";";
                }
            } else {
                cPlusPlusType = signature;
            }
        } else {
            cPlusPlusType = parameterClassType;
        }
        return cPlusPlusType.replace(".", "/");
    }

    public static String getCppDefine(String var0) {
        return (Signature.getCppSignature(Signature.getCppObjectSignature(var0)) + (var0.startsWith("[") ? "array" : "")).replace(".", "/");
    }

    public static String getCPlusPlusDefine(Method method) {
        Class[] parameters = method.getParameterTypes();
        String javaParameter = "";
        for (int len = 0; len < parameters.length; ++len) {
            javaParameter += getCppDefine(parameters[len].getName()) + (len == parameters.length - 1 ? "" : ", ");
        }
        return String.format("JNIExport %s JNICall %s_%s(JNIEnv *, jobject%s);", getCppDefine(method.getReturnType().getName()), method.getDeclaringClass().getName().replace(".", "/").replace("/", "_"), method.getName(), (javaParameter != "" ? ", " + javaParameter : ""));
    }

    public static List<String> createCppSource(String headerName, List<String> javaSource, List<String> headerSource) {
        List<String> var0 = new ArrayList<String>();
        List<String> var1 = new ArrayList<String>();
        for (String var2 : javaSource) {
            var0.add(var2);

            int start = var2.indexOf("(");
            int end = var2.indexOf(")");
            if (start > 0 && end > start) {
                var1.add(var2.contains("native") + ", " + var2.substring(start + 1, end));
            }
        }

        List<String> var3 = new ArrayList<String>();
        List<String> var4 = new ArrayList<String>();
        String var5 = "";
        for (String var6 : headerSource) {
            if (!(var6.startsWith("#include") | var6.startsWith("#define") | var6.startsWith("#ifndef") | var6.startsWith("#ifdef") | var6.startsWith("#undef") | var6.startsWith("#endif") | var6.startsWith("extern") | var6.startsWith("}"))) {
                if (var6.startsWith("JNIEXPORT")) {
                    var5 = var6;
                } else if (var6.startsWith("  (JNIEnv *, jclass")) {
                    var5 += var6.substring(2);
                    var3.add(var5);
                } else if (var6.startsWith(" * ")) {
                    var4.add(var6.replace(" * ", ""));
                }
            }
        }

        List<String> var6 = new ArrayList<String>();
        for (String var7 : var1) {
            if (var7.startsWith("true")) {
                var7 = var7.replace(var7.split(", ")[0] + ", ", "");

                if (var7.length() != 0) {
                    String var8 = var7.replace("int", "jint").replace("short", "jshort").replace("long", "jlong").replace("byte", "jbyte").replace("double", "jdouble").replace("float", "jfloat").replace("boolean", "jboolean").replace("String", "jstring").replace("char", "jchar").replace("[]", "Array");
                    String var9 = "";
                    String[] split = var8.split(", ");
                    for (int len = 0; len < split.length; ++len) {
                        String sig = split[len];
                        if (sig.startsWith("j")) {
                            var9 += (len == 0 ? "" : ", ") + sig + (len + 1 == split.length ? ", " : "");
                        } else {
                            String[] sigSplit = sig.split(" ");
                            String sigParam = sigSplit[sigSplit.length - 1];
                            var9 += (len == 0 ? "" : ", ") + "jobject " + sigParam + (len + 1 == split.length ? ", " : "");
                        }
                        int last = var9.lastIndexOf(",");
                        var8 = last != -1 ? var9.substring(0, last) : var9;
                    }
                    var6.add(var8);
                }
            }
        }

        List<String> cpp = new ArrayList<String>();
        String replaceFrom = "JNIEnv *, jclass";
        String replaceTo = "JNIEnv *env, jclass cls";
        int pos = 0;
        int pos2 = 0;
        cpp.add("#include \"" + headerName + "\"\n\n");
        for (int len = 0; len < var3.size(); ++len) {
            String methodReturnClassName = var4.get(pos + 2);
            methodReturnClassName = methodReturnClassName.substring(methodReturnClassName.indexOf(")") + 1);
            Class findClass;
            try {
                findClass = methodReturnClassName.startsWith("L") ? Class.forName(methodReturnClassName.replace("L", "").replace("/", ".").replace(";", "")) : null;
            } catch (ClassNotFoundException exception) {
                findClass = Object.class;
            }
            String method = var3.get(len).replace(replaceFrom, replaceTo);
            String __return = method.split(" ")[1];
            String replaceReturn = __return != "void" ? "\n    return nullptr;" : "";
            replaceReturn = replaceReturn.replace("nullptr", (__return + " ").replace("jbyte ", "0").replace("jshort ", "0").replace("jint ", "0").replace("jlong ", "0").replace("jdouble ", "0").replace("jfloat ", "0").replace("jchar ", "0").replace("jboolean ", "false").replace("jstring ", "env->NewStringUTF(\"\")"));
            replaceReturn = replaceReturn.replace("nullptr", (__return + " ").replace("jbyteArray ", "env->NewByteArray(0)").replace("jshortArray ", "env->NewShortArray(0)").replace("jintArray ", "env->NewIntArray(0)").replace("jlongArray ", "env->NewLongArray(0)").replace("jdoubleArray ", "env->NewDoubleArray(0)").replace("jfloatArray ", "env->NewFloatArray(0)").replace("jcharArray ", "env->NewCharArray(0)").replace("jbooleanArray ", "env->NewBooleanArray(0)"));
            replaceReturn = replaceReturn.replace("nullptr", (__return + " ").replace("jobjectArray ", "env->NewObjectArray(0, env->FindClass(\"" + methodReturnClassName + "\"), nullptr)"));
            replaceReturn = replaceReturn.replace("return void ;", "").replace("return jobject ;", "return " + (findClass == ByteBuffer.class ? "env->NewDirectByteBuffer(0, 0)" : "nullptr") + ";");
            method = method.replace(";", " {" + replaceReturn + "\n}");
            int start = method.indexOf("cls, ");
            if (start != -1) {
                method = method.substring(0, start + 5) + var6.get(pos2) + method.substring(method.indexOf(")"), method.length());
                ++pos2;
            }
            cpp.add("/*");
            cpp.add(" * " + var4.get(pos + 0));
            cpp.add(" * " + var4.get(pos + 1));
            cpp.add(" * " + var4.get(pos + 2));
            cpp.add(" */");
            cpp.add(method);
            cpp.add("");
            pos += 3;
        }
        return cpp;
    }

    public static void createCppFile(String javaSource, String headerSource, String cppSource) throws IOException {

        BufferedReader java = new BufferedReader(new FileReader(new File(javaSource)));
        BufferedReader header = new BufferedReader(new FileReader(new File(headerSource)));
        BufferedWriter cpp = new BufferedWriter(new FileWriter(new File(cppSource)));

        List<String> javaText = new ArrayList<String>();
        List<String> headerText = new ArrayList<String>();
        String javaLine;
        String headerLine;

        while ((javaLine = java.readLine()) != null) {
            javaText.add(javaLine);
        }
        java.close();

        while ((headerLine = header.readLine()) != null) {
            headerText.add(headerLine);
        }
        header.close();

        for (String cppLine : createCppSource(headerSource, javaText, headerText)) {
            cpp.write(cppLine);
            cpp.newLine();
        }
        cpp.close();
    }
}
