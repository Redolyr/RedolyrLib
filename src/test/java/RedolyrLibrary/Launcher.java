package RedolyrLibrary;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.*;
import java.util.Arrays;

@TestAnnotation(modid = "Test")
public class Launcher
{

    static transient String test;

    public Object content;

//	public Map<String, ChatUserInfo> map = new HashMap<String, ChatUserInfo>();
	public static void main(String[] args) throws IOException, ParserConfigurationException, TransformerException, SAXException, ClassNotFoundException, IllegalAccessException, NoSuchFieldException, Exception {
        Logger.logPrint = false;
        ByteBuffer byteBuffer = ByteBufferUtil.createByteBuffer(8 * 4);
        LongBuffer longBuffer = byteBuffer.asLongBuffer();
        IntBuffer intBuffer = byteBuffer.asIntBuffer();
        ShortBuffer shortBuffer = byteBuffer.asShortBuffer();
        FloatBuffer floatBuffer = byteBuffer.asFloatBuffer();
        DoubleBuffer doubleBuffer = byteBuffer.asDoubleBuffer();
        CharBuffer charBuffer = byteBuffer.asCharBuffer();
        longBuffer.put(4503360);
        System.out.println(Arrays.toString(ByteBufferUtil.createAndGetByteArray(byteBuffer)));
        System.out.println(Arrays.toString(ByteBufferUtil.createAndGetLongArray(longBuffer)));
        System.out.println(Arrays.toString(ByteBufferUtil.createAndGetIntArray(intBuffer)));
        System.out.println(Arrays.toString(ByteBufferUtil.createAndGetShortArray(shortBuffer)));
        System.out.println(Arrays.toString(ByteBufferUtil.createAndGetFloatArray(floatBuffer)));
        System.out.println(Arrays.toString(ByteBufferUtil.createAndGetDoubleArray(doubleBuffer)));
        System.out.println(Arrays.toString(ByteBufferUtil.createAndGetCharArray(charBuffer)));

        final int x = 0;
        final int y = 0;
        final int width = 1000;
        final int height = 800;
        final String titleHandle = "Lightweight Java Game Library";
        int handleSize = (4 << 2) + (titleHandle.length() * 4);
        ByteBuffer byteBuffer1 = ByteBufferUtil.createByteBuffer(handleSize);
        IntBuffer intBuffer1 = byteBuffer1.asIntBuffer();
        LongBuffer longBuffer1 = byteBuffer1.asLongBuffer();
        CharBuffer charBuffer1 = byteBuffer1.asCharBuffer();
        charBuffer1.position(8);
        charBuffer1.put(titleHandle);
        charBuffer1.flip();
        intBuffer1.position(0);
        intBuffer1.put(new int[]{x, y, width, height});
        intBuffer1.flip();
        System.out.println(handleSize + ", " + (handleSize / 2));
        System.out.println(Arrays.toString(ByteBufferUtil.createAndGetByteArray(byteBuffer1)));
        System.out.println(Arrays.toString(ByteBufferUtil.createAndGetIntArray(intBuffer1)));
        System.out.println(Arrays.toString(ByteBufferUtil.createAndGetCharArray(charBuffer1)));
        System.out.println(Arrays.toString(ByteBufferUtil.createAndGetLongArray(longBuffer1)));

        System.out.println("");
        System.out.println(Arrays.toString(ByteBufferUtil.createAndGetCharArray((CharBuffer) ByteBufferUtil.createByteBuffer(titleHandle.length() * 4).asCharBuffer().put(titleHandle).flip())));
        System.out.println("");

//        long[] handle = new long[] {30399761347838024L, 3435973836911L};
        long[] handle = new long[] {0L, 3435973837800L, 29273839966421068L, 29555306354114676L, 9007697477763175L, 27303579553431626L, 30681189077942304L, 29555198974230629L, 32088563964313698L, 121L, 0L, 0L, 0L, 0L, 0L, 0L};
        ByteBuffer byteBuffer2 = ByteBufferUtil.createByteBuffer(handle.length << 3);
        LongBuffer longBuffer2 = byteBuffer2.asLongBuffer();
        IntBuffer intBuffer2 = byteBuffer2.asIntBuffer();
        CharBuffer charBuffer2 = byteBuffer2.asCharBuffer();
        longBuffer2.put(handle);
        longBuffer2.flip();
        System.out.println(Arrays.toString(ByteBufferUtil.createAndGetByteArray(byteBuffer2)));
        System.out.println(Arrays.toString(ByteBufferUtil.createAndGetIntArray(intBuffer2)));
        System.out.println(Arrays.toString(ByteBufferUtil.createAndGetCharArray(charBuffer2)));
        System.out.println(Arrays.toString(ByteBufferUtil.createAndGetLongArray(longBuffer2)));

        HandleWindow handleWindow = new HandleWindow();
        handleWindow.width = 1000;
        handleWindow.height = 800;
        handleWindow.title = "Lightweight Java Game Library";
        handleWindow.flip();
        System.out.println(handleWindow);

        long[] longs = new long[] {0, 3435973837800L, 29273839966421068L, 29555306354114676L, 9007697477763175L, 27303579553431626L, 30681189077942304L, 29555198974230629L, 32088563964313698L, 121, 0, 0, 0, 0, 0, 0};
        HandleWindow handleWindow1 = new HandleWindow();
        ByteBuffer byteBuffer3 = ByteBufferUtil.createByteBuffer(longs.length << 3);
        LongBuffer longBuffer3 = byteBuffer3.asLongBuffer();
        longBuffer3.put(longs);
        handleWindow1.fromByteBuffer(byteBuffer3);
        System.out.println(String.format("%d, %d, %dx%d, %s", handleWindow1.x, handleWindow1.y, handleWindow1.width, handleWindow1.height, handleWindow1.title));

        ByteBuffer byteBuffer4 = ByteBufferUtil.createByteBuffer(longs.length << 3);
        LongBuffer longBuffer4 = byteBuffer4.asLongBuffer();
        DoubleBuffer doubleBuffer1 = byteBuffer4.asDoubleBuffer();
        FloatBuffer floatBuffer1 = byteBuffer4.asFloatBuffer();
        ShortBuffer shortBuffer1 = byteBuffer4.asShortBuffer();
        IntBuffer intBuffer3 = byteBuffer4.asIntBuffer();
        longBuffer4.put(longs);
        longBuffer4.flip();
        System.out.println("");
        System.out.println(Arrays.toString(ByteBufferUtil.createAndGetIntArray(intBuffer3)));
        System.out.println(Arrays.toString(ByteBufferUtil.createAndGetShortArray(shortBuffer1)));
        System.out.println(Arrays.toString(ByteBufferUtil.createAndGetLongArray(longBuffer4)));
        System.out.println(Arrays.toString(ByteBufferUtil.createAndGetByteArray(byteBuffer4)));
        System.out.println(Arrays.toString(ByteBufferUtil.createAndGetDoubleArray(doubleBuffer1)));
        System.out.println(Arrays.toString(ByteBufferUtil.createAndGetFloatArray(floatBuffer1)));//Int Short Long Byte Double Float, Int Short Double Float, Byte Long

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ObjectStreamUtil.write(byteArrayOutputStream, false, handleWindow1);
        System.out.println(Arrays.toString(byteArrayOutputStream.toByteArray()));

        HandleWindow handleWindow2 = new HandleWindow();
        handleWindow2.fromLongArray(longs);
        System.out.println(String.format("%d, %d, %dx%d, %s", handleWindow2.x, handleWindow2.y, handleWindow2.width, handleWindow2.height, handleWindow2.title));

//        MoneySystem moneySystem = new MoneySystem("redolyr");
//        moneySystem.addMoney(1);
//        moneySystem.setBankName("Redolyr");
//        moneySystem.getBank().pushMoney(1);
//        System.out.println(moneySystem);
//
//        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
//        ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
//        objectOutputStream.writeObject(moneySystem);
//        byte[] bytes = byteArrayOutputStream.toByteArray();
//        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bytes);
//        ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);
//        System.out.println(objectInputStream.readObject());
//        System.out.println(Arrays.toString(bytes));
//        objectInputStream.close();
//        objectOutputStream.close();
//        byteArrayInputStream.close();
//        byteArrayOutputStream.close();
//
//        long[] longs = MoneySystem.MoneyDataIO.writeToMoney(moneySystem);
////        String[] strings = new String[longs.length / 8];
////        for (int len = 0; len < longs.length; ++len) {
////            strings[len] = String.format("%20x", longs[len]).replace(" ", "");
////        }
//        ByteBuffer byteBuffer = ByteBufferUtil.createByteBuffer(longs.length * 4);
//        LongBuffer longBuffer = byteBuffer.asLongBuffer();
//        IntBuffer intBuffer = byteBuffer.asIntBuffer();
//        longBuffer.put(longs[0]);
//        int[] ints = ByteBufferUtil.createAndGetIntArray(intBuffer);
//        System.out.println(MoneySystem.MoneyDataIO.writeToMoney(moneySystem));
//        System.out.println(Arrays.toString(MoneySystem.MoneyDataIO.writeToMoney(moneySystem)));
////        System.out.println(Arrays.toString(strings));
//        BigInteger bigInteger = BigInteger.valueOf(0);
//        for (long l : longs) {
//            bigInteger = bigInteger.add(BigInteger.valueOf(l));
//        }
//        System.out.println(bigInteger);
//        System.out.println(Arrays.toString(longs));
//        System.out.println(Arrays.toString(ints));
//        long[] a = ByteBufferUtil.getLongFromString(moneySystem.toString());
//        System.out.println(Arrays.toString(a));
//        System.out.println(ByteBufferUtil.getStringFromLong(a));

//        FileInputStream fileInputStream = new FileInputStream(new File(System.getProperty("user.home") + "/Desktop/test.png"));
//        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
//        byte[] bytes = new byte[1024];
//        int len;
//        while ((len = fileInputStream.read(bytes, 0, bytes.length)) < -1) {
//            byteArrayOutputStream.write(bytes, 0, bytes.length);
//        }
//        byte[] bytes1 = byteArrayOutputStream.toByteArray();
//
//        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bytes1);
//        ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);
//        int i = objectInputStream.readInt();
//        System.out.println(i);
//        objectInputStream.close();
//        byteArrayOutputStream.close();
//        fileInputStream.close();
//
//        ByteArrayOutputStream byteArrayOutputStream1 = new ByteArrayOutputStream();
//        ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream1);
//        objectOutputStream.write(new byte[] {1, 2, 3, 4});
//        objectOutputStream.close();
//        byte[] bytes2 = byteArrayOutputStream.toByteArray();
//        System.out.println(Arrays.toString(bytes2));
//        byteArrayOutputStream.close();

//        final int bufferSize = 0x2000 * 4;
//        ByteBuffer byteBuffer = ByteBuffer.allocateDirect(bufferSize);//Vertex TexCoord Color Normal Brightness
//        IntBuffer intBuffer = byteBuffer.asIntBuffer();
//        ShortBuffer shortBuffer = byteBuffer.asShortBuffer(); 16909060
//        FloatBuffer floatBuffer = byteBuffer.asFloatBuffer(); 16909061
//        // X, Y, Z, U, V, Color, Normal, Brightness
//        int[] rawBuffer = new int[]
//                {
//                        0, 1, 0, 0, 1, 0xFFFFFF, 0, 0, 255,
//                        0, 0, 0, 0, 0, 0, 0xFFFFFF, 0xFFFFFF, 255
//                };
//
//        int vertices = rawBuffer.length / 8;
//        int offset = 0;
//        while (offset < vertices) {
//            int vtc = Math.min(vertices - offset, bufferSize >> 5);
//
//            intBuffer.clear();
//            intBuffer.put(rawBuffer, offset * 8, vtc * 8);
//            byteBuffer.position(0);
//            byteBuffer.limit(vtc * 32);
//            offset += vtc;
////            ++offset;
//
//            System.out.println(offset + ", " + vtc + ", " + (bufferSize >> 5) + ", " + ((bufferSize / 48) * 6));
//
//            floatBuffer.position(3);
//            System.out.println("Texture");
//
//            shortBuffer.position(14);
//            System.out.println("Brightness");
//
//            byteBuffer.position(20);
//            System.out.println("Color");
//
//            byteBuffer.position(24);
//            System.out.println("Normal");
//
//            floatBuffer.position(0);
//            System.out.println("Vertex");
//        }
//
//        System.setProperty("redolyrLib.assets", System.getenv("APPDATA") + "/.redolyrGames");
//        System.setProperty("org.lwjgl.librarypath", System.getProperty("redolyrLib.assets") + "/natives/lwjgl");
//        String path = "C:/Users/redolyr/Desktop/natives";
//        File parent = new File(path);
//        String[] strings = null;
//        if (parent.isDirectory()) {
//            for (File os : parent.listFiles()) {
//                if (os.isDirectory()) {
//                    for (File files : os.listFiles()) {
//                        byte[] bytes = Files.readAllBytes(files.toPath());
//                        if (strings == null) {
//                            strings = new String[1];
//                        } else {
//                            strings = Arrays.copyOf(strings, strings.length + 1);
//                        }
//                        strings[strings.length - 1] = String.format("'%s': %s", files.getName(), Arrays.toString(bytes)).replace('\'', '"');
//                    }
//                }
//            }
//        }
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(new File(parent, "lwjgl.txt")));
//        bufferedWriter.write("{");
//        for (int len = 0; len < strings.length; ++len) {
//            bufferedWriter.write(strings[len] + (len != strings.length - 1 ? "" : ", "));
//            bufferedWriter.newLine();
//        }
//        bufferedWriter.write("}");
//        bufferedWriter.close();
//        FileInputStream fileInputStream = new FileInputStream(file);
//        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
//        byte[] bytes = new byte[1024];
//        int len;
//        while ((len = fileInputStream.read(bytes, 0, bytes.length)) > 0) {
//            byteArrayOutputStream.write(bytes, 0, len);
//        }
//        byte[] lwjgl = byteArrayOutputStream.toByteArray();
//        byteArrayOutputStream.close();
//        fileInputStream.close();
//        System.out.println(lwjgl.length);
//
//        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bytes);
//        FileOutputStream fileOutputStream = new FileOutputStream(new File(System.getProperty("org.lwjgl.librarypath"), fileName + ".dll"));
//        byte[] bytes1 = new byte[1024];
//        int len1;
//        while ((len1 = byteArrayInputStream.read(bytes1, 0, bytes1.length)) > 0) {
//            fileOutputStream.write(bytes, 0, len1);
//        }
//        byteArrayInputStream.close();
//        fileOutputStream.close();

//        byte[] bytes = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ".getBytes();
//        String hash = HashUtil.hashEncode(bytes);
//        byte[] bytes1 = HashUtil.hashDecode(hash);
//        System.out.println(hash);
//        System.out.println(Arrays.toString(bytes));
//        System.out.println(Arrays.toString(bytes1));
//        System.out.println(Arrays.equals(bytes, bytes1));
//        String defHash = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
//        byte[] defhash = defHash.getBytes();
//        String hash = "";
//        for (byte b : defhash) {
//            hash += String.format("%20x", b).replace(" ", "");
//        }
//        int start = 0;
//        int end = 2;
//        byte[] bytes = new byte[hash.length() / 2];
//        for (int len = 0; len < bytes.length; ++len) {
//            String startwith = hash.substring(start, start + 1);
//            if (startwith.startsWith("-")) {
//                end += 1;
//                bytes[len] = (byte) Integer.parseInt(hash.substring(start, end), 16);
//                start += 2;
//                end += 2;
//            } else {
//                bytes[len] = (byte) Integer.parseInt(hash.substring(start, end), 16);
//                start += 2;
//                end += 2;
//            }
//        }
//        System.out.println(System.getProperty("os.arch"));
//        System.out.println(Arrays.toString(bytes) + ",\n" + hash + ",\n" + defHash + ",\n" + Arrays.toString(defhash) + ",\n" + Arrays.equals(bytes, defhash));

//        byte[] def = "a".getBytes();
//        MessageDigest messageDigest = MessageDigest.getInstance("MD5");
//        messageDigest.digest(def);
//        byte[] bytes = messageDigest.digest();
//        byte[] bytes1 = def;
//        String digest = "";
//        String defDigest = "";
//        for (byte b : bytes) {
//            digest += String.format("%20x", b).replace(" ", "");
//        }
//        for (byte b : bytes1) {
//            defDigest += String.format("%20x", b).replace(" ", "");
//        }
//        Logger logger = Logger.getLogger(Launcher.class);
//        logger.infoDebug(digest + ", " + Arrays.toString(bytes));
//        logger.infoDebug(defDigest + ", " + Arrays.toString(bytes1));
//        logger.infoDebug(ManagementFactory.getRuntimeMXBean().getSystemProperties().toString());
//        logger.infoDebug(Launcher.class.getSuperclass().getName());
//        logger.infoDebug(Launcher.class.getInterfaces().length);
//        if (false) {
//            throw new TestException();
//        }
////        if (true) {
////            VirtualException virtualException = new VirtualException(TestException.class, "Test Exception");virtualException.printStackTrace();
//////            System.out.println(virtualException.getClass().getName() + ", " + virtualException.getVirtualClassSimpleName());
////            throw virtualException;
////        }
//        if (true) {
//            throw new VirtualException(IllegalArgumentException.class, "Illegal Argument Exception");
//        }
//        if (true) {
//            throw new TestException("");
//        }

//        Vertices vertices = new Vertices();
//        vertices.bases.add(new TextureCoord(0, 1));
//        vertices.bases.add(new Color(255, 255, 255));
//        vertices.bases.add(new Brightness(0));
//        vertices.bases.add(new Normal(255, 255, 255));
//        vertices.bases.add(new ResourceLocation("domain", "source"));
//        System.out.println(vertices);
//
//        String documents = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?>" +
//                "<vertices>" +
//                "<vertex x=\"0\" y=\"1\" z=\"0\" u=\"0\" v=\"1\" />" +
//                "</vertices>";// +
////                "<!-- x y z u v color brightness normalX normalY normalZ bindTexture-->";
////        Document document = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
//        Document document = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(documents);
////        Element element = document.createElement("vertices");
////        document.appendChild(element);
//        TransformerFactory.newInstance().newTransformer().transform(new DOMSource(document), new StreamResult(System.out));
////        System.out.println(document);

//
//        StringReplacer stringReplacer = new StringReplacer();
//        stringReplacer.setFile(new File("C:/Users/redolyr/Desktop/lwjgltest2/assets/lang/en_US.lang"));
//        String splashSecondsMsg = stringReplacer.getUTF8("splash.seconds.msg", " = ");
//        String splashCaution1Msg = stringReplacer.getUTF8("splash.caution1.msg", " = ");
//        System.out.println(splashSecondsMsg + ", " + splashCaution1Msg);

//        ThawingZip.getURLFile(new URL("http://ftp.vector.co.jp/pack/win95/art/sound/edit/kwave012.lzh"), new File("C:/Users/redolyr/Downloads/".replace('/', File.separatorChar), "kwave012.zip"));

//        Vertices vertices = new Vertices(7);
//        vertices.addVertex(0, 1, 0).setTextureCoord(0, 1).setColor(255, 255, 255, 255).setNormal(255, 255, 255);
//        vertices.addVertex(0, 0, 0).setTextureCoord(0, 0).setColor(255, 255, 255, 255).setNormal(255, 255, 255);
//        vertices.addVertex(1, 0, 0).setTextureCoord(1, 0).setColor(255, 255, 255, 255).setNormal(255, 255, 255);
//        vertices.addVertex(1, 1, 0).setTextureCoord(1, 1).setColor(255, 255, 255, 255).setNormal(255, 255, 255);
//        DrawComponent drawComponent = new DrawComponent();
//        drawComponent.addVertices(new Vertices(7).addVertex(0, 1, 0).setTextureCoord(0, 1).setColor(255, 255, 255, 255).setNormal(255, 255, 255).getVertices().addVertex(0, 0, 0).setTextureCoord(0, 0).setColor(255, 255, 255, 255).setNormal(255, 255, 255).getVertices().addVertex(1, 0, 0).setTextureCoord(1, 0).setColor(255, 255, 255, 255).setNormal(255, 255, 255).getVertices().addVertex(1, 1, 0).setTextureCoord(1, 1).setColor(255, 255, 255, 255).setNormal(255, 255, 255).getVertices());
//
//        String fileName = "\u65b0\u30fb\u8c6a\u8840\u5bfa\u4e00\u65cf -\u7169\u60a9\u89e3\u653e - \u30ec\u30c3\u30c4\u30b4\u30fc\uff01\u9670\u967d\u5e2b - [sm9]";
//        ISound iSound = SoundManager.getSound(new FileInputStream(new File("C:/Users/redolyr/Downloads/" + fileName + ".wav")), fileName + ".wav");
//        drawComponent.setSound(iSound);
//        FileOutputStream fileOutputStream = new FileOutputStream("C:/Users/Redolyr/Desktop/" + iSound.getFileName()+ ".wav");
//        InputStream inputStream = SoundManager.getInputStream(iSound);
//        byte[] bytes = new byte[1024];
//        int len;
//        while ((len = inputStream.read(bytes, 0, bytes.length)) != -1) {
//            fileOutputStream.write(bytes, 0, len);
//        }
//        fileOutputStream.close();

//        System.out.println(drawComponent);

//        LongLongInt64 longLongInt64 = new LongLongInt64(128, 128, 128, 128);
//        System.out.println(longLongInt64);

//        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
//        ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
//        objectOutputStream.writeObject(drawComponent);
//        byte[] bytes = byteArrayOutputStream.toByteArray();
//        objectOutputStream.close();
//        String verticesBase64 = Base64.encode(bytes);
//        System.out.println(drawComponent + ", " + Arrays.toString(bytes) + ", " + verticesBase64);
//
////        byte[] bytes1 = new byte[] {-84, -19, 0, 5, 115, 114, 0, 34, 82, 101, 100, 111, 108, 121, 114, 76, 105, 98, 114, 97, 114, 121, 46, 97, 114, 67, 97, 114, 100, 84, 101, 115, 116, 46, 86, 101, 114, 116, 105, 99, 101, 115, 17, 90, -27, -76, 37, 107, -61, -127, 2, 0, 2, 73, 0, 8, 118, 101, 114, 116, 105, 99, 101, 115, 91, 0, 8, 118, 101, 114, 116, 101, 120, 101, 115, 116, 0, 35, 91, 76, 82, 101, 100, 111, 108, 121, 114, 76, 105, 98, 114, 97, 114, 121, 47, 97, 114, 67, 97, 114, 100, 84, 101, 115, 116, 47, 86, 101, 114, 116, 101, 120, 59, 120, 112, 0, 0, 0, 4, 117, 114, 0, 35, 91, 76, 82, 101, 100, 111, 108, 121, 114, 76, 105, 98, 114, 97, 114, 121, 46, 97, 114, 67, 97, 114, 100, 84, 101, 115, 116, 46, 86, 101, 114, 116, 101, 120, 59, 26, -86, 98, -37, 79, -105, 67, 126, 2, 0, 0, 120, 112, 0, 0, 0, 4, 115, 114, 0, 32, 82, 101, 100, 111, 108, 121, 114, 76, 105, 98, 114, 97, 114, 121, 46, 97, 114, 67, 97, 114, 100, 84, 101, 115, 116, 46, 86, 101, 114, 116, 101, 120, 67, 32, 121, 43, 101, 52, 25, -81, 2, 0, 3, 68, 0, 1, 120, 68, 0, 1, 121, 68, 0, 1, 122, 120, 112, 0, 0, 0, 0, 0, 0, 0, 0, 63, -16, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 115, 113, 0, 126, 0, 5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 115, 113, 0, 126, 0, 5, 63, -16, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 115, 113, 0, 126, 0, 5, 63, -16, 0, 0, 0, 0, 0, 0, 63, -16, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
////        byte[] bytes1 = new byte[] {-84, -19, 0, 5, 115, 114, 0, 34, 82, 101, 100, 111, 108, 121, 114, 76, 105, 98, 114, 97, 114, 121, 46, 97, 114, 67, 97, 114, 100, 84, 101, 115, 116, 46, 86, 101, 114, 116, 105, 99, 101, 115, 17, 90, -27, -76, 37, 107, -61, -127, 2, 0, 2, 73, 0, 8, 118, 101, 114, 116, 105, 99, 101, 115, 91, 0, 8, 118, 101, 114, 116, 101, 120, 101, 115, 116, 0, 35, 91, 76, 82, 101, 100, 111, 108, 121, 114, 76, 105, 98, 114, 97, 114, 121, 47, 97, 114, 67, 97, 114, 100, 84, 101, 115, 116, 47, 86, 101, 114, 116, 101, 120, 59, 120, 112, 0, 0, 0, 4, 117, 114, 0, 35, 91, 76, 82, 101, 100, 111, 108, 121, 114, 76, 105, 98, 114, 97, 114, 121, 46, 97, 114, 67, 97, 114, 100, 84, 101, 115, 116, 46, 86, 101, 114, 116, 101, 120, 59, 26, -86, 98, -37, 79, -105, 67, 126, 2, 0, 0, 120, 112, 0, 0, 0, 4, 115, 114, 0, 32, 82, 101, 100, 111, 108, 121, 114, 76, 105, 98, 114, 97, 114, 121, 46, 97, 114, 67, 97, 114, 100, 84, 101, 115, 116, 46, 86, 101, 114, 116, 101, 120, 67, 32, 121, 43, 101, 52, 25, -81, 2, 0, 6, 68, 0, 1, 120, 68, 0, 1, 121, 68, 0, 1, 122, 76, 0, 5, 99, 111, 108, 111, 114, 116, 0, 33, 76, 82, 101, 100, 111, 108, 121, 114, 76, 105, 98, 114, 97, 114, 121, 47, 97, 114, 67, 97, 114, 100, 84, 101, 115, 116, 47, 67, 111, 108, 111, 114, 59, 76, 0, 6, 110, 111, 114, 109, 97, 108, 116, 0, 34, 76, 82, 101, 100, 111, 108, 121, 114, 76, 105, 98, 114, 97, 114, 121, 47, 97, 114, 67, 97, 114, 100, 84, 101, 115, 116, 47, 78, 111, 114, 109, 97, 108, 59, 76, 0, 12, 116, 101, 120, 116, 117, 114, 101, 67, 111, 111, 114, 100, 116, 0, 40, 76, 82, 101, 100, 111, 108, 121, 114, 76, 105, 98, 114, 97, 114, 121, 47, 97, 114, 67, 97, 114, 100, 84, 101, 115, 116, 47, 84, 101, 120, 116, 117, 114, 101, 67, 111, 111, 114, 100, 59, 120, 112, 0, 0, 0, 0, 0, 0, 0, 0, 63, -16, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 115, 114, 0, 31, 82, 101, 100, 111, 108, 121, 114, 76, 105, 98, 114, 97, 114, 121, 46, 97, 114, 67, 97, 114, 100, 84, 101, 115, 116, 46, 67, 111, 108, 111, 114, 67, 32, 121, 43, 101, 52, 25, -81, 2, 0, 4, 68, 0, 1, 97, 68, 0, 1, 98, 68, 0, 1, 103, 68, 0, 1, 114, 120, 112, 64, 111, -32, 0, 0, 0, 0, 0, 64, 111, -32, 0, 0, 0, 0, 0, 64, 111, -32, 0, 0, 0, 0, 0, 64, 111, -32, 0, 0, 0, 0, 0, 115, 114, 0, 32, 82, 101, 100, 111, 108, 121, 114, 76, 105, 98, 114, 97, 114, 121, 46, 97, 114, 67, 97, 114, 100, 84, 101, 115, 116, 46, 78, 111, 114, 109, 97, 108, 67, 32, 121, 43, 101, 52, 25, -81, 2, 0, 3, 68, 0, 11, 98, 108, 117, 101, 67, 104, 97, 110, 110, 101, 108, 68, 0, 12, 103, 114, 101, 101, 110, 67, 104, 97, 110, 110, 101, 108, 68, 0, 10, 114, 101, 100, 67, 104, 97, 110, 110, 101, 108, 120, 112, 64, 111, -32, 0, 0, 0, 0, 0, 64, 111, -32, 0, 0, 0, 0, 0, 64, 111, -32, 0, 0, 0, 0, 0, 115, 114, 0, 38, 82, 101, 100, 111, 108, 121, 114, 76, 105, 98, 114, 97, 114, 121, 46, 97, 114, 67, 97, 114, 100, 84, 101, 115, 116, 46, 84, 101, 120, 116, 117, 114, 101, 67, 111, 111, 114, 100, 67, 32, 121, 43, 101, 52, 25, -81, 2, 0, 2, 68, 0, 1, 117, 68, 0, 1, 118, 120, 112, 0, 0, 0, 0, 0, 0, 0, 0, 63, -16, 0, 0, 0, 0, 0, 0, 115, 113, 0, 126, 0, 5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 115, 113, 0, 126, 0, 10, 64, 111, -32, 0, 0, 0, 0, 0, 64, 111, -32, 0, 0, 0, 0, 0, 64, 111, -32, 0, 0, 0, 0, 0, 64, 111, -32, 0, 0, 0, 0, 0, 115, 113, 0, 126, 0, 12, 64, 111, -32, 0, 0, 0, 0, 0, 64, 111, -32, 0, 0, 0, 0, 0, 64, 111, -32, 0, 0, 0, 0, 0, 115, 113, 0, 126, 0, 14, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 115, 113, 0, 126, 0, 5, 63, -16, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 115, 113, 0, 126, 0, 10, 64, 111, -32, 0, 0, 0, 0, 0, 64, 111, -32, 0, 0, 0, 0, 0, 64, 111, -32, 0, 0, 0, 0, 0, 64, 111, -32, 0, 0, 0, 0, 0, 115, 113, 0, 126, 0, 12, 64, 111, -32, 0, 0, 0, 0, 0, 64, 111, -32, 0, 0, 0, 0, 0, 64, 111, -32, 0, 0, 0, 0, 0, 115, 113, 0, 126, 0, 14, 63, -16, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 115, 113, 0, 126, 0, 5, 63, -16, 0, 0, 0, 0, 0, 0, 63, -16, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 115, 113, 0, 126, 0, 10, 64, 111, -32, 0, 0, 0, 0, 0, 64, 111, -32, 0, 0, 0, 0, 0, 64, 111, -32, 0, 0, 0, 0, 0, 64, 111, -32, 0, 0, 0, 0, 0, 115, 113, 0, 126, 0, 12, 64, 111, -32, 0, 0, 0, 0, 0, 64, 111, -32, 0, 0, 0, 0, 0, 64, 111, -32, 0, 0, 0, 0, 0, 115, 113, 0, 126, 0, 14, 63, -16, 0, 0, 0, 0, 0, 0, 63, -16, 0, 0, 0, 0, 0, 0};
//        byte[] bytes1 = Base64.decode("rO0ABXNyACdSZWRvbHlyTGlicmFyeS5hckNhcmRUZXN0LkRyYXdDb21wb25lbnRDIHkrZTQZrwIAAkkACHZlcnRpY2VzWwAKdmVydGljZXNlc3QAJVtMUmVkb2x5ckxpYnJhcnkvYXJDYXJkVGVzdC9WZXJ0aWNlczt4cAAAAAF1cgAlW0xSZWRvbHlyTGlicmFyeS5hckNhcmRUZXN0LlZlcnRpY2VzO7F6JIJxRdTOAgAAeHAAAAABc3IAIlJlZG9seXJMaWJyYXJ5LmFyQ2FyZFRlc3QuVmVydGljZXMRWuW0JWvDgQIABEkACGRyYXdNb2RlSQAIdmVydGljZXNMAA1kcmF3Q29tcG9uZW50dAApTFJlZG9seXJMaWJyYXJ5L2FyQ2FyZFRlc3QvRHJhd0NvbXBvbmVudDtbAAh2ZXJ0ZXhlc3QAI1tMUmVkb2x5ckxpYnJhcnkvYXJDYXJkVGVzdC9WZXJ0ZXg7eHAAAAAHAAAABHEAfgACdXIAI1tMUmVkb2x5ckxpYnJhcnkuYXJDYXJkVGVzdC5WZXJ0ZXg7Gqpi20+XQ34CAAB4cAAAAARzcgAgUmVkb2x5ckxpYnJhcnkuYXJDYXJkVGVzdC5WZXJ0ZXhDIHkrZTQZrwIAB0QAAXhEAAF5RAABekwABWNvbG9ydAAhTFJlZG9seXJMaWJyYXJ5L2FyQ2FyZFRlc3QvQ29sb3I7TAAGbm9ybWFsdAAiTFJlZG9seXJMaWJyYXJ5L2FyQ2FyZFRlc3QvTm9ybWFsO0wADHRleHR1cmVDb29yZHQAKExSZWRvbHlyTGlicmFyeS9hckNhcmRUZXN0L1RleHR1cmVDb29yZDtMAAh2ZXJ0aWNlc3QAJExSZWRvbHlyTGlicmFyeS9hckNhcmRUZXN0L1ZlcnRpY2VzO3hwAAAAAAAAAAA/8AAAAAAAAAAAAAAAAAAAc3IAH1JlZG9seXJMaWJyYXJ5LmFyQ2FyZFRlc3QuQ29sb3JDIHkrZTQZrwIABEQAAWFEAAFiRAABZ0QAAXJ4cEBv4AAAAAAAQG/gAAAAAABAb+AAAAAAAEBv4AAAAAAAc3IAIFJlZG9seXJMaWJyYXJ5LmFyQ2FyZFRlc3QuTm9ybWFsQyB5K2U0Ga8CAANEAAtibHVlQ2hhbm5lbEQADGdyZWVuQ2hhbm5lbEQACnJlZENoYW5uZWx4cEBv4AAAAAAAQG/gAAAAAABAb+AAAAAAAHNyACZSZWRvbHlyTGlicmFyeS5hckNhcmRUZXN0LlRleHR1cmVDb29yZEMgeStlNBmvAgACRAABdUQAAXZ4cAAAAAAAAAAAP/AAAAAAAABxAH4ACHNxAH4ACwAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAHNxAH4AEUBv4AAAAAAAQG/gAAAAAABAb+AAAAAAAEBv4AAAAAAAc3EAfgATQG/gAAAAAABAb+AAAAAAAEBv4AAAAAAAc3EAfgAVAAAAAAAAAAAAAAAAAAAAAHEAfgAIc3EAfgALP/AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAc3EAfgARQG/gAAAAAABAb+AAAAAAAEBv4AAAAAAAQG/gAAAAAABzcQB+ABNAb+AAAAAAAEBv4AAAAAAAQG/gAAAAAABzcQB+ABU/8AAAAAAAAAAAAAAAAAAAcQB+AAhzcQB+AAs/8AAAAAAAAD/wAAAAAAAAAAAAAAAAAABzcQB+ABFAb+AAAAAAAEBv4AAAAAAAQG/gAAAAAABAb+AAAAAAAHNxAH4AE0Bv4AAAAAAAQG/gAAAAAABAb+AAAAAAAHNxAH4AFT/wAAAAAAAAP/AAAAAAAABxAH4ACA==");
//        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bytes1);
//        ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);
//        DrawComponent drawComponent1 = (DrawComponent) objectInputStream.readObject();
//        System.out.println(drawComponent1 + ", " + drawComponent1.equals(drawComponent));
//
//        DrawComponent drawComponent2 = new DrawComponent().addVertices(new Vertices(7).addVertex(0, 1, 0).setTextureCoord(0, 1).setColor(255, 255, 255, 255).setNormal(255, 255, 255).getVertices().addVertex(0, 0, 0).setTextureCoord(0, 0).setColor(255, 255, 255, 255).setNormal(255, 255, 255).getVertices().addVertex(1, 0, 0).setTextureCoord(1, 0).setColor(255, 255, 255, 255).setNormal(255, 255, 255).getVertices().addVertex(1, 1, 0).setTextureCoord(1, 1).setColor(255, 255, 255, 255).setNormal(255, 255, 255).getVertices());
//        String drawComponent3 = ComponentEncoder.drawComponentEncoder(drawComponent2);
//        DrawComponent drawComponent4 = ComponentEncoder.drawComponentDecoder(drawComponent3);
//        System.out.println(drawComponent2 + ", " + drawComponent2.equals(drawComponent4) + ", " + drawComponent3);
//
//        Class clazz = Launcher.class;
//        Annotation[] annotations = clazz.getDeclaredAnnotations();
//        String[] strings = new String[annotations.length];
//        for (int len = 0; len < annotations.length; ++len) {
//            strings[len] = annotations[len].getClass().getSimpleName();
//        }
//        System.out.println(Arrays.toString(strings));
//
//        TextureCoord textureCoord = new TextureCoord(0, 0);
//        RedolyrLibrary.arCardTest.Color color = new RedolyrLibrary.arCardTest.Color(255, 255, 255, 255);
//        Normal normal = new Normal(255, 255, 255);
//        ByteArrayOutputStream byteArrayOutputStream1 = new ByteArrayOutputStream();
//        ObjectOutputStream objectOutputStream1 = new ObjectOutputStream(byteArrayOutputStream1);
//        objectOutputStream1.writeObject(textureCoord);
//        objectOutputStream1.writeObject(color);
//        objectOutputStream1.writeObject(normal);
//        byte[] bytes2 = byteArrayOutputStream1.toByteArray();
//        objectOutputStream1.close();
//        System.out.println(Arrays.toString(bytes2));
//
//        String fileName = "\u65b0\u30fb\u8c6a\u8840\u5bfa\u4e00\u65cf -\u7169\u60a9\u89e3\u653e - \u30ec\u30c3\u30c4\u30b4\u30fc\uff01\u9670\u967d\u5e2b - [sm9]";
//        ISound iSound = SoundManager.getSound(new FileInputStream(new File("C:/Users/redolyr/Downloads/" + fileName + ".wav")), fileName + ".wav");
//
//        ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
//        ObjectOutputStream objectOutputStream2 = new ObjectOutputStream(byteArrayOutputStream2);
//        objectOutputStream2.writeObject(iSound);
//        byte[] bytes3 = byteArrayOutputStream2.toByteArray();
//        objectOutputStream2.close();
//        System.out.println(iSound);
//        String byte3Base64 = Base64.encode(bytes3);
//
//        byte[] bytes4 = Base64.decode(byte3Base64);
//        ByteArrayInputStream byteArrayInputStream1 = new ByteArrayInputStream(bytes4);
//        ObjectInputStream objectInputStream1 = new ObjectInputStream(byteArrayInputStream1);
//        ISound iSound1 = (ISound) objectInputStream1.readObject();
//        byte[] bytes5 = iSound1.getByteArray();
//        FileOutputStream fileOutputStream = new FileOutputStream("C:/users/redolyr/Desktop/" + iSound1.getFileName());
//        fileOutputStream.write(bytes5, 0, bytes5.length);
//        fileOutputStream.close();
//        System.out.println(iSound1 + ", " + iSound1.equals(iSound));
////        String formatToByte3Base64 = "";
////        for (int len = 0; len < byte3Base64.length(); len += 10000) {
////            formatToByte3Base64 += byte3Base64.substring(len, len + 10000) + "\n";
////            System.out.println(byte3Base64.substring(len, len + 10000));
////        }
//        BufferedImage bufferedImage = new BufferedImage(64, 64, BufferedImage.TYPE_INT_ARGB_PRE);
//        Graphics graphics = bufferedImage.createGraphics();
//        graphics.setColor(new Color(255, 255, 255));
//        graphics.fillRect(0, 0, 64, 64);
//        graphics.setColor(new Color(0, 0, 0));
//        graphics.fillRect(0, 0, 32, 32);
//        graphics.fillRect(33, 33, 64, 64);
//        RedolyrLibrary.arCardTest.Texture texture = RedolyrLibrary.arCardTest.TextureManager.getTexture(bufferedImage, "String.txt");
//        ByteArrayOutputStream byteArrayOutputStream3 = new ByteArrayOutputStream();
//        ObjectOutputStream objectOutputStream3 = new ObjectOutputStream(byteArrayOutputStream3);
//        objectOutputStream3.writeObject(texture);
//        byte[] bytes6 = byteArrayOutputStream3.toByteArray();
//        objectOutputStream3.close();
//        System.out.println(texture);
//
//        ObjectInputStream objectInputStream2 = new ObjectInputStream(new ByteArrayInputStream(bytes6));
//        RedolyrLibrary.arCardTest.Texture texture1 = (RedolyrLibrary.arCardTest.Texture) objectInputStream2.readObject();
//        System.out.println(texture1 + ", " + texture1.equals(texture));
//        System.out.println(Arrays.equals(texture1.getImage(), texture.getImage()));
//        System.out.println(Arrays.toString(texture.getImage()));
//        System.out.println(Arrays.toString(texture1.getImage()));

//        TestAnnotation testAnnotation = Launcher.class.getAnnotation(TestAnnotation.class);
//        Method testMethod = testAnnotation.getClass().getDeclaredMethod("modid");
//        String default_ = testMethod != null ? testMethod.getName() : "";
//        testMethod.setAccessible(true);
//        System.out.println(testAnnotation.modid() + ", " + default_ + ", ");
//
//        Field[] fields = TimeCalculator.class.getFields();
//        String[] fieldsStrings = new String[fields.length];
//        String[] fieldsFieldsString = new String[] {"clazz", "name", "type", "modifiers", "slot", "signature", "annotations"};
//
//        for (int len1 = 0; len1 < fields.length; ++len1) {
//            Field field = fields[len1];
//            String key = field.getName();
//            int value = field.getInt(0);
//            String out = String.format("'%s':'%s'", key, value);
//            String[] outs = new String[1 + fieldsFieldsString.length];
//            outs[0] = out;
//            Class<Field> fieldClass = (Class<Field>) field.getClass();
//            for (int len2 = 0; len2 < fieldsFieldsString.length; ++len2) {
//                Field field1 = fieldClass.getDeclaredField(fieldsFieldsString[len2]);
//                field1.setAccessible(true);
//                outs[1 + len2] = String.format("'%s':'%s'", fieldsFieldsString[len2], String.valueOf(field1.get(field)));
//            }
//            String outsFormat = "{";
//            for (int len2 = 0; len2 < outs.length; ++len2) {
//                outsFormat += outs[len1] + (len1 == outs.length - 1 ? "" : ", ");
//            }
//            outsFormat += "}";
//            fieldsStrings[len1] = outsFormat;
//        }
//
//        System.out.println(Arrays.toString(fieldsStrings));

//        System.out.println(Arrays.toString(TimeCalculator.getTimes(1)));
//        System.out.println(Arrays.toString(TimeCalculator.getTimes(60)));
//        System.out.println(Arrays.toString(TimeCalculator.getTimes(3600)));
//        System.out.println(Arrays.toString(TimeCalculator.getTimes(86400)));
//        System.out.println(Arrays.toString(TimeCalculator.getTimes(31536000)));
//        System.out.println(Arrays.toString(TimeCalculator.getTimes(31536001)));
//
//        int testSeconds = 2147483647;
//        System.out.println(TimeCalculator.getTimeToSeconds(testSeconds));
//        System.out.println(TimeCalculator.getTimeToMinutes(testSeconds));
//        System.out.println(TimeCalculator.getTimeToHours(testSeconds));
//        System.out.println(TimeCalculator.getTimeToDays(testSeconds));
//        System.out.println(TimeCalculator.getTimeToYears(testSeconds));
//
//        System.out.println(Arrays.toString(ErrorCheck.values()).replace(", ", ", \n"));
//
//        System.out.println(Arrays.toString(PointerType.values()).replace("}, ", "},\n"));
//
//        TestEnum testEnum = new EnumCustomer().addEnum(TestEnum.class, "Test", new Class[] {Object.class, int.class, short.class, long.class, byte.class, double.class, float.class, boolean.class, String.class}, new Object[] {null, -1, -1, -1, -1, -1, -1, false, "NULL POINTER EXCEPTION"});
//        System.out.print(testEnum);
//
//        VertexPointer vertexPointer = new VertexPointer();
//        System.out.println(vertexPointer.getByteBuffer());
//
//        Display display = new Display();
//        display.setWidth(1000);
//        display.setHeight(800);
//        display.setTitle("Test");
////        display.setUndecorated(true);
//        display.addStopEvent(new StopEvent() {
//            public void stop() {
//                System.exit(0);
//            }
//        });
//        display.setEventThread(new EventThread() {
//            int current;
//
//            int mouseCurrent = 0;
//
//            Item[] slotItems = new Item[9];
//
//            public void run(int displayID) throws Exception {
//                Display display = Displays.getDisplay(displayID);
//                Draw draw = Displays.getDraw(displayID);
//                Keyboard keyboard = Displays.getKeyboard(displayID);
//                Mouse mouse = Displays.getMouse(displayID);
//                Graphics graphics = Displays.getGraphics(displayID);
//
//                ErrorChecker errorChecker = new ErrorChecker(displayID);
//                System.out.println(errorChecker + ", " + errorChecker.isError());
//                while (!display.isClosedRequest() && !errorChecker.isError()) {
//                    System.out.print("");
//                    graphics.setFont(new Font("Monospaced", graphics.getFont().getStyle(), 20));
//
//                    if (display.isClosedRequest()) System.out.print("Close Event TRUE");
//
//                    draw.translated(100, 100);
//
//                    draw.drawClear();
////                    String displayString = "DisplayID: " + displayID + ", Current: " + this.current++ + ", " + this.current / 1000;
////                    byte[] displayBytes = displayString.getBytes();
////                    graphics.drawString(displayString, mouse.x, mouse.y + graphics.getFontMetrics().getHeight());
////                    graphics.clearRect(mouse.x, mouse.y, graphics.getFontMetrics().bytesWidth(displayBytes, 0, displayBytes.length), graphics.getFontMetrics().getHeight());
////                    graphics.setColor(new Color(0, 0, 0));
//
//                    int translslateX1 = 200;
//                    int translslateY1 = 700;
//
//                    if (mouse.mouseWheel < 0) {
//                        this.mouseCurrent += 1;
//                        System.out.println(true);
//                    }
//
//                    this.slotItems[1] = Item.item;
//
//                    List[] lists = new ArrayList[this.slotItems.length];
//
//                    for (int len = 0; len < lists.length; ++len) {
//                        List list = new ArrayList();
//                        for (int len1 = 0; len1 < this.slotItems.length; ++len1) {
//                            if (this.slotItems[len1] != null) {
//                                this.slotItems[len1].addInformation(this.slotItems[len1], list);
//                            }
//                        }
//                        lists[len] = list;
//                    }
//
//                    graphics.translate(translslateX1, translslateY1);
//                    for (int len = 0; len < this.slotItems.length; ++len) {
//                        Item item = this.slotItems[len];
//                        Texture texture = item != null ? item.bindTexture() : null;
//                        if (item != null) {
//                            int x = translslateX1 + (len == 0 ? 3 : (64 * len) + (5 * len) + 3);
//                            int y = translslateY1 + 3;
//                            int w = x + 58;
//                            int h = y + 58;
//                            int mouseX = mouse.x;
//                            int mouseY = mouse.y;
//
//                            List arrayList1 = lists[len];
//                            Object[] objects = arrayList1.toArray(new Object[0]);
//
//                            boolean cursorX1 = mouseX > x;
//                            boolean cursorY1 = mouseY > y;
//                            boolean cursorX2 = mouseX < w;
//                            boolean cursorY2 = mouseY < h;
//                            int stringHeight = graphics.getFontMetrics().getHeight();
//                            graphics.translate(-translslateX1, -translslateY1);
//                            if (cursorX1 && cursorY1 && cursorX2 && cursorY2) {
//                                int maxWidth = 0;
//                                int maxHeight = 0;
//                                for (int len1 = 0; len1 < objects.length; ++len1) {
//                                    String displayString = (String) objects[len1];
//                                    int stringY = len1 == 0 ? 0 : (stringHeight * len1) + (2 * len1);
//                                    stringY += stringHeight;
//                                    graphics.setColor(new Color(64, 128, 255));
//                                    graphics.translate(mouseX, mouseY);
//                                    graphics.drawString(displayString, 0, stringY);
//                                    graphics.translate(-mouseX, -mouseY);
//
//                                    maxWidth += graphics.getFontMetrics().bytesWidth(displayString.getBytes(), 0, displayString.getBytes().length) * 2;
//                                    maxHeight += stringHeight * 2;
//                                }
//                                int displayWidth = 3 + maxWidth + 3;
//                                int displayHeight = 3 + maxHeight + 3;
//                                graphics.setColor(new Color(32, 32, 255, 128));
//                                graphics.fillRect(mouse.x, mouse.y, displayWidth, displayHeight);
//                            }
//                            graphics.translate(translslateX1, translslateY1);
//                        }
//                        if (texture != null) {
//                            graphics.drawImage(TextureManager.getTextureCoord(texture), len == 0 ? 3 : (64 * len) + (5 * len) + 3, 3, 58, 58, new Color(255, 255, 255), null);
//                        }
//
//                        graphics.setColor(new Color(105, 52, 43));
//                        graphics.fillRect(len == 0 ? 0 : (64 * len) + (5 * len), 0, 64, 64);
//                        graphics.setColor(new Color(150, 75, 46));
//                        graphics.fillRect(len == 0 ? 1 : (64 * len) + (5 * len) + 1, 1, 62, 62);
//                        graphics.setColor(new Color(105, 52, 43));
//                        graphics.fillRect(len == 0 ? 3 : (64 * len) + (5 * len) + 3, 3, 58, 58);
//                    }
//                    graphics.translate(-translslateX1, -translslateY1);
//
//                    {
//                        float wh1 = 2;
//                        float wh2 = 16;
//                        VertexPointer vertexPointer = new VertexPointer();
//                        vertexPointer.begin(VertexPointer.QUADS);
//                        vertexPointer.vertex4(mouse.x - wh2, mouse.y - wh1, wh2 * 2, wh1 * 2);
//                        vertexPointer.vertex4(mouse.x - wh1, mouse.y - wh2, wh1 * 2, wh2 * 2);
//                        vertexPointer.end();
//                        graphics.setColor(new Color(255, 255, 255));
//                        FloatBuffer floatBuffer = vertexPointer.getByteBuffer().asFloatBuffer();
//                        float[] floats = new float[floatBuffer.capacity()];
//                        floatBuffer.get(floats, 0, floats.length);
//                        for (int len = 0; len < floats.length; len += 4) {
//                            int x = Math.round(floats[len + 0]);
//                            int y = Math.round(floats[len + 1]);
//                            int w = Math.round(floats[len + 2]);
//                            int h = Math.round(floats[len + 3]);
//                            if (true) graphics.fillRect(x, y, w, h);
//                        }
////                        ShortBuffer shortBuffer = vertexPointer.getByteBuffer().asShortBuffer();
////                        short[] shorts = new short[shortBuffer.capacity()];
////                        shortBuffer.get(shorts);
////                        System.out.println(Arrays.toString(shorts).replaceAll(", ", ". ").replaceAll("0. 0.", ", ,").replaceAll(", ", "").replaceAll(". ", ", ").replaceAll(", ,", "]"));
//                    }
//
////                    graphics.drawString(displayString, (display.getWidth() / 2) + (graphics.getFontMetrics().getHeight() / 2), (display.getHeight() / 2) - (graphics.getFontMetrics().bytesWidth(displayBytes, 0, displayBytes.length) / 2));
////                    graphics.setColor(new Color(0, 0, 0));
////                    graphics.drawString(displayString, mouse.x, mouse.y + graphics.getFontMetrics().getHeight());
////                    draw.addTexture(TextureManager.getTexture(new FileInputStream(new File("C:/Users/redolyr/Desktop/test.png"))));
////                    display.drawRepaint();
//                }
//                display.update();
//            }
//        });
////        display.create();
//
//        int default_1 = 3;
//        int current = 0;
//        while (current < 13) {
//            int test = 3;
//            for (int len1 = 0; len1 < current; ++len1) {
//                test *= default_1;
//            }
//            System.out.println(current + ", " + test);
//            ++current;
//        }
//
//        VirtualPackage virtualPackage = new VirtualPackage("Test");
//
//        VirtualClass virtualClass = new VirtualClass("Test", Modifier.PUBLIC, new Class[] {int.class, int.class}, new Object[] {0, 0});
//        Class virtualClazz = virtualClass.getVirtualClass();
//        Constructor[] constructors = virtualClazz.getConstructors();
//        for (Constructor constructor : constructors) {
//            System.out.println(constructor.getName());
//        }
//        System.out.println(virtualClass.getVirtualClass() + ", Default: " + virtualClass.getClass().getName() + ", " + virtualClass.getClass().getSimpleName());

//        System.out.println(Math.p());
//        System.out.println(java.lang.Math.PI);
//        System.out.println((4.0 / 3) * java.lang.Math.PI * java.lang.Math.pow(2 / 2, 3));
//        System.out.println(((double) (40 / 13)) + ", " + ((double) (22 / 7)));

//        String decodeReadLine = "=?ISO-2022-JP?B?GyRCJDMkbCRDJEZDLyQrMnJGSSRHJC0kRiQ/JGokNyReJDkhKRsoQg==?=";
//        byte[] bytes = Base64.decode(decodeReadLine);
//        System.out.println(Arrays.toString(bytes));
//        System.out.println(new String(bytes));

//        String test = "Test Fields";
//        Field testField = Launcher.class.getField("content");
//        long testLong = testField.getLong(test);
//        System.out.println(test + ": " + testLong);

//        Thread thread = new Thread() {
//            public void run() {
//                super.run();
//                String localhost = "localhost";
//                int port = 8081;
//                while (true) {
//                    boolean isClient = true;
//
//                    if (isClient) {
//                        try {
//                            Socket socket = new Socket(localhost, port);
//                            DataTagCompound dataTagCompound = DataStream.read(socket.getInputStream());
//
//                        } catch (IOException e) {
//                            e.printStackTrace();
//                        }
//                    }
//                }
//            }
//        };
//        thread.start();
//
//        TestTagCompound testBase = new TestTagCompound();
//        testBase.setTag("Test", TestTagCompound.TAG_ARRAY_STRING, "Test");
//        System.out.println("Test 1:" + testBase.getTag("Test"));
//        System.out.println("Test 2:" + testBase.hasKey("Test"));
//        System.out.println("Test 3:" + testBase.hasKey("Test", TestTagCompound.TAG_STRING));
//        System.out.println("Test 4:" + testBase.hasKey("Test", TestTagCompound.TAG_ARRAY_INTEGER));
//        System.out.println(ResponseUtil.setBase64());
//        System.out.println(Arrays.toString("\u3042".getBytes()) + "\u3042 \u00a9");
//        ExHardCoreStringZipping exHardCoreStringZipping = new ExHardCoreStringZipping();
//        byte[] bytes = exHardCoreStringZipping.compression("abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ".getBytes());
//        byte[] bytes1 = exHardCoreStringZipping.decompression(bytes);
//        System.out.println(Arrays.toString(bytes));
//        System.out.println(Arrays.toString(bytes1));

//        Display display = new Display();
////        System.out.println(display.getTitle() + ", " + display.getWidth() + "x" + display.getHeight());
//        display.setTitle("Test");
//        display.setWidth(1000);
//        display.setHeight(800);
//        try {
//            display.create();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        display.setEventThread(new EventThread() {
//
//            Point point = new Point(0, 0);
//
//            @Override
//            public void run(Display display) throws Exception {
//                while (!display.isClosedRequest()) {
//                    System.out.print("");
//
//                    display.drawClear();
//
//                    Keyboard keyboard = display.keyboard;
//                    if (keyboard.isPres) {
//                        if (keyboard.getKeyCode() == Keyboard.KEY_W) {
//                            this.point.y += 10;
//                        } else if (keyboard.getKeyCode() == Keyboard.KEY_S) {
//                            this.point.y -= 10;
//                        }
//                        if (keyboard.getKeyCode() == Keyboard.KEY_D) {
//                            this.point.x += 10;
//                        } else if (keyboard.getKeyCode() == Keyboard.KEY_A) {
//                            this.point.x -= 10;
//                        }
//                        System.out.println(this.point.x + ", " + this.point.y + ", " + display.getDraw().getTranslatedX() + ", " + display.getDraw().getTranslatedY());
////                        System.out.println(keyboard.getKey() + ", " + keyboard.getKeyCode() + ", " + KeyEvent.getKeyText(keyboard.getKeyCode()));
//                    }
//
//                    Draw draw = display.getDraw();
//
//                    draw.translated(this.point.x, this.point.y);
//
//                    BufferedImage bufferedImage = new BufferedImage(320, 320, BufferedImage.TYPE_INT_RGB);
//                    Graphics graphics = bufferedImage.createGraphics();
//                    graphics.setColor(new Color(0, 0, 0));
//                    graphics.fillRect(0, 0, 160, 160);
//                    graphics.fillRect(160, 160, 320, 320);
//
//                    draw.addTexture(TextureManager.getTexture(bufferedImage));
//
//                    display.drawRepaint();
//                    if (display.isClosedRequest() | keyboard.isPres && keyboard.getKey() == Keyboard.KEY_ESC) System.exit(0);
//                }
//            }
//        });

//        BufferedImage bufferedImage = new BufferedImage(32, 32, BufferedImage.TYPE_4BYTE_ABGR_PRE);
//        Graphics graphics = bufferedImage.createGraphics();
//        graphics.setColor(new Color(0, 0, 0));
//        graphics.fillRect(0, 0, 15, 15);
//        graphics.fillRect(16, 16, 32, 32);
//        graphics.setColor(new Color(255, 255, 255));
//        graphics.fillRect(0, 15, 15, 32);
//        graphics.fillRect(15, 0, 32, 15);
//        Texture texture = TextureManager.getTexture(bufferedImage);
//        System.out.println(texture);
//
//        Draw draw = new Draw();
//        draw.addTexturePointer(3, new Texture[] {texture,texture, texture}, new int[] {0, 0, 33, 0, 0, 33});
//        System.out.println(draw);
//        System.out.println(draw.getStartTexture());
//        System.out.println(draw.getEndTexture());
//        System.out.println(Arrays.toString(draw.getTextures()));
//        draw.removeStartTexture();
//        draw.removeEndTexture();
//        System.out.println(draw);
//        System.out.println(draw.getStartTexture());
//        System.out.println(draw.getEndTexture());
//
//        System.out.println(TextureManager.getTextureCoord(draw.getEndTexture()));
//
//
//        long[] longs = MathHelper.getLongs(new byte[] {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, 62, 63, 64});
//        System.out.println(Arrays.toString(longs));
//        byte[] bytes2 = MathHelper.getBytes(new long[] {4, 12, 20, 28, 36, 44, 52, 60});
//        System.out.println(Arrays.toString(bytes2));
//
//        System.out.println(MathHelper.byteArrayToLong(new byte[] {8, 16, 24, 32, 40, 48, 52, 60}, 0));
//        byte[] bytes3 = new byte[8];
//        MathHelper.longToByteArray(bytes, 40L, 0);
//        System.out.println(Arrays.toString(bytes3));
//
//        WriteTest.main(args);
//        ReadTest.main(args);
//        LongMap<String, String> stringStringLongMap = new LongMap<String, String>();
//        stringStringLongMap.add("Test", "Test");
//        System.out.println(stringStringLongMap);
//        System.out.println(RepositoryTransformer.instance().transformer(new Repository().setKeyName("Key").setValueName("Value").add(new Repository().setKeyName("Key").setValueName("Value"))));
//        Document document = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
//        DocumentTagCompound documentTagCompound = new DocumentTagCompound();
//        documentTagCompound.setTag("Stats", new DocumentTagStringArray(new String[]{"AAA", "BB", "C"}));
//        DocumentTagList documentTagList = new DocumentTagList();
//        documentTagList.addTag(new DocumentTagStringArray(new String[]{"AAA", "BB", "C"}));
//        documentTagList.addTag(new DocumentTagStringArray(new String[]{"DDD", "EE", "F"}));
//        documentTagCompound.setTag("Statses", documentTagList);
//        Element element = document.createElement("Test");
//        document.appendChild(element);
//        DocumentStream.write(new File("C:\\Users\\redolyr\\Desktop\\Test.xml"), documentTagCompound);
//
//        DocumentTagCompound documentTagCompound1 = DocumentStream.read(new File("C:\\Users\\redolyr\\Desktop\\Test.xml"));
//        System.out.println(documentTagCompound1);
//
//        DrawLabel drawLabel = new DrawLabel(new ImageIcon("C:/Users/redolyr/Desktop/etc/tile.png"));
//        System.out.println(drawLabel.getIcon().hashCode());
//        int[] rawBuffer = drawLabel.rawBuffer();
//        System.out.println(Arrays.toString(rawBuffer));
//
//        drawLabel = new DrawLabel();
//        drawLabel.rawBuffer(rawBuffer);
//        System.out.println(drawLabel.getIcon().hashCode());
//
//        DocumentTagCompound documentTagCompound = new DocumentTagCompound();
//        documentTagCompound.setString("String", "String");
//        documentTagCompound.setChar("Char", '\u00a7');
//        documentTagCompound.setInteger("Integer", Integer.MAX_VALUE);
//        documentTagCompound.setShort("Short", Short.MAX_VALUE);
//        documentTagCompound.setLong("Long", Long.MAX_VALUE);
//        documentTagCompound.setByte("Byte", Byte.MAX_VALUE);
//        documentTagCompound.setDouble("Double", Double.MAX_VALUE);
//        documentTagCompound.setFloat("Float", Float.MAX_VALUE);
//        documentTagCompound.setBoolean("Boolean", true);
//        documentTagCompound.setStringArray("StringArray", new String[]{"A", "B", "C"});
//        documentTagCompound.setCharArray("CharArray", new char[]{'\u00a7', '\u00a7'});
//        documentTagCompound.setIntegerArray("IntegerArray", new int[]{Integer.MAX_VALUE, Integer.MIN_VALUE});
//        documentTagCompound.setShortArray("ShortArray", new short[]{Short.MAX_VALUE, Short.MIN_VALUE});
//        documentTagCompound.setLongArray("LongArray", new long[]{Long.MAX_VALUE, Long.MIN_VALUE});
//        documentTagCompound.setByteArray("ByteArray", new byte[]{Byte.MAX_VALUE, Byte.MIN_VALUE});
//        documentTagCompound.setDoubleArray("DoubleArray", new double[]{Double.MAX_VALUE, Double.MIN_VALUE});
//        documentTagCompound.setFloatArray("FloatArray", new float[]{Float.MAX_VALUE, Float.MIN_VALUE});
//        documentTagCompound.setBooleanArray("BooleanArray", new boolean[]{true, false});
//        DocumentTagList documentTagList = new DocumentTagList();
//        documentTagList.appendString("String");
//        documentTagList.appendChar('\u00a7');
//        documentTagList.appendInteger(Integer.MAX_VALUE);
//        documentTagList.appendShort(Short.MAX_VALUE);
//        documentTagList.appendLong(Long.MAX_VALUE);
//        documentTagList.appendByte(Byte.MAX_VALUE);
//        documentTagList.appendDouble(Double.MAX_VALUE);
//        documentTagList.appendFloat(Float.MAX_VALUE);
//        documentTagList.appendBoolean(true);
//        documentTagList.appendStringArray(new String[]{"A", "B", "C"});
//        documentTagList.appendCharArray(new char[]{'\u00a7', '\u00a7'});
//        documentTagList.appendIntegerArray(new int[]{Integer.MAX_VALUE, Integer.MIN_VALUE});
//        documentTagList.appendShortArray(new short[]{Short.MAX_VALUE, Short.MIN_VALUE});
//        documentTagList.appendLongArray(new long[]{Long.MAX_VALUE, Long.MIN_VALUE});
//        documentTagList.appendByteArray(new byte[]{Byte.MAX_VALUE, Byte.MIN_VALUE});
//        documentTagList.appendDoubleArray(new double[]{Double.MAX_VALUE, Double.MIN_VALUE});
//        documentTagList.appendFloatArray(new float[]{Float.MAX_VALUE, Float.MIN_VALUE});
//        documentTagList.appendBooleanArray(new boolean[]{true, false});
//        DocumentTagCompound documentTagCompound1 = new DocumentTagCompound();
//        documentTagCompound.setString("String", "String");
//        documentTagCompound.setChar("Char", '\u00a7');
//        documentTagCompound.setInteger("Integer", Integer.MAX_VALUE);
//        documentTagCompound.setShort("Short", Short.MAX_VALUE);
//        documentTagCompound.setLong("Long", Long.MAX_VALUE);
//        documentTagCompound.setByte("Byte", Byte.MAX_VALUE);
//        documentTagCompound.setDouble("Double", Double.MAX_VALUE);
//        documentTagCompound.setFloat("Float", Float.MAX_VALUE);
//        documentTagCompound.setBoolean("Boolean", true);
//        documentTagCompound.setStringArray("StringArray", new String[]{"A", "B", "C"});
//        documentTagCompound.setCharArray("CharArray", new char[]{'\u00a7', '\u00a7'});
//        documentTagCompound.setIntegerArray("IntegerArray", new int[]{Integer.MAX_VALUE, Integer.MIN_VALUE});
//        documentTagCompound.setShortArray("ShortArray", new short[]{Short.MAX_VALUE, Short.MIN_VALUE});
//        documentTagCompound.setLongArray("LongArray", new long[]{Long.MAX_VALUE, Long.MIN_VALUE});
//        documentTagCompound.setByteArray("ByteArray", new byte[]{Byte.MAX_VALUE, Byte.MIN_VALUE});
//        documentTagCompound.setDoubleArray("DoubleArray", new double[]{Double.MAX_VALUE, Double.MIN_VALUE});
//        documentTagCompound.setFloatArray("FloatArray", new float[]{Float.MAX_VALUE, Float.MIN_VALUE});
//        documentTagCompound.setBooleanArray("BooleanArray", new boolean[]{true, false});
//        documentTagCompound.setList("List", documentTagList);
//        documentTagCompound.setCompound("Compound", documentTagCompound1);
//        System.out.println(documentTagCompound);
//        DocumentStream.write(new File("D:/HelloWorld_Test.xml"), documentTagCompound);
//
//        System.out.println(DocumentStream.read(new File("D:/HelloWorld_Test.xml")).getList("List"));
//
//        System.out.println(Draw.getByteBufferArray()[2]);
//        System.out.println(Draw.getByteBufferArray().length);
//
//        SwingUtilities.invokeLater(new Runnable() {
//            public void run() {
//                DrawFrame drawFrame = new DrawFrame();
//                drawFrame.setTitle("Test");
//                drawFrame.setBounds(0, 0, 1000, 600);
////                drawFrame.setUndecorated(true);
//                drawFrame.setResizable(true);
//                drawFrame.setVisible(true);
//                drawFrame.setTitlebarImageIcon(new ImageIcon("C:/Users/redolyr/Desktop/etc/tile.png"));
//                drawFrame.setMainColorRGB(45, 45, 45);
//                drawFrame.setBoundsCenter(true);
////                drawFrame.setDrawing(new Drawing());
////                drawFrame.setMouseCursor(null);
//                drawFrame.setMouseGrapped(true);
//                drawFrame.pack();
////
////                Drawing drawing = drawFrame.drawing();
////                drawing.setColor3d(255, 255, 255);
////                drawing.addQuads(100, 100, 100, 100);
////                drawing.addLine(50, 50, 100, 100);
//
//                //graphics.setColor(new Color(255 / 2, 255 / 2, 255 / 2));
//                //graphics.fillRect(mouseX, mouseY - 25, 5, 50);
//                //graphics.fillRect(mouseX - 23, mouseY, 50, 5);

//                TestFrame testFrame = new TestFrame();
//                TestFrameDocument testFrameDocument = new TestFrameDocument();
//
//                if (true) {
//
//                    Frame frame = new Frame();
//                    frame.addWindowListener(new WindowAdapter() {
//                        public void windowClosing(WindowEvent e) {
//                            super.windowClosing(e);
//                            System.exit(0);
//                        }
//                    });
//                    frame.pack();
//                    frame.setTitle("Test");
//                    frame.setSize(new Dimension(1000, 800));
//                    frame.setLocationRelativeTo(null);
//                    frame.setVisible(true);
//
//                    Canvas canvas = new Canvas() {
//                        public void paint(Graphics g) {
//                            super.paint(g);
//
//                            Draw.clearVertex();
//                            Draw.putBegin();
//                            Draw.putVertex(0, 100);
//                            Draw.putVertex(0, 0);
//                            Draw.putVertex(100, 0);
//                            Draw.putVertex(100, 100);
//                            Draw.putEnd();
//
//                            byte[] bytes = Draw.getByteBufferArray();
//                            if (Draw.getBeginLength() > 0) {
//                                for (int len = 0; len < Draw.getVertexFlip(); ++len) {
//                                    int[] vecX = new int[4];
//                                    int[] vecY = new int[4];
//
//                                    if (bytes[])
//
//                                    int[] fill = new int[6];
//
//                                    for (int x = 0; x < vecX.length; ++x) {
//                                        for (int y = 0; y < vecY.length; ++y) {
//                                            if (x == 1) fill[0] = vecX[x];
//
//                                            if (y == 1) fill[1] = vecY[y];
//
//                                            if (x == 0) fill[2] = vecX[x];
//
//                                            if (y == 2) fill[3] = vecY[y];
//
//                                            if (x == 3) fill[4] = vecX[x];
//
//                                            if (y == 3) fill[5] = vecY[y];
//                                        }
//                                    }
//
//                                    System.out.println("aaa, " + Draw.getVertexFlip() + ", " + len + ", " + Arrays.toString(vecX) + ", " + Arrays.toString(vecY) + ", " + Arrays.toString(fill));
//
//                                    g.fillRect(fill[0], fill[1], fill[2] + fill[4], fill[3] + fill[5]);
//                                }
//                            }
//                        }
//
//                        public void update(Graphics g) {
//                            super.update(g);
//                            this.paint(g);
//                        }
//                    };
//
//                    frame.add(canvas);
//                }
//            }
//        });
//
//        System.out.println(drawFrame);
//        System.out.println(Arrays.toString(drawFrame.parseIntArray("Test")));
//        System.out.println(drawFrame.parseString(new int[] {84, 101, 115, 116, 115}));
//
//        DocumentTagCompound documentTagCompound2 = DocumentStream.read(new File("C:\\Users\\redolyr\\Desktop\\jjj.xml"));
//        System.out.println(documentTagCompound2);
//        TestMapTable<String, Integer> stringIntegerTestTable = new TestHashMapTable<String, Integer>();
//        stringIntegerTestTable.add("Test", 1);
//        stringIntegerTestTable.add("Test2", 3);
//        stringIntegerTestTable.remove("Test2");
//        System.out.println(stringIntegerTestTable);
//        System.out.println(stringIntegerTestTable.get("Test"));
//        Itr<String> it = new Itr<String>(new String[] {"A", "B", "C"});
//        List<String> a = new ArrayList<String>();
//        while (it.hasNext())
//        {
//            String string = it.next();
//            if (string == "A") it.remove();
//            a.add(string);
//        }
//        System.out.println(a);
//        logger.infoDebug("Test");
//        DataTagCompound dtc2 = new DataTagCompound();
//        dtc2.setString("String", "Buffer");
//        dtc2.setChar("Char", '\u2205');
//        dtc2.setInteger("Integer", 1);
//        dtc2.setShort("Short", (short) (1 & 65535));
//        dtc2.setLong("Long", 1);
//        dtc2.setByte("Byte", (byte) (1 & 255));
//        dtc2.setDouble("Double", 1);
//        dtc2.setFloat("Float", 1);
//        dtc2.setBoolean("Boolean", true);
//        dtc2.setStringArray("StringArray", new String[] {"Buffer", "Buffer2"});
//        dtc2.setCharArray("CharacterArray", new char[] {'\u2205', '\u2205'});
//        dtc2.setIntegerArray("IntegerArray", new int[] {0, 1});
//        dtc2.setShortArray("ShortArray", new short[] {0 & 65535, 1 & 65535});
//        dtc2.setLongArray("LongArray", new long[] {0, 1});
//        dtc2.setByteArray("ByteArray", new byte[] {0 & 255, 1 & 255});
//        dtc2.setDoubleArray("DoubleArray", new double[] {0, 1});
//        dtc2.setFloatArray("FloatArray", new float[] {0, 1});
//        DataTagCompound dtc21 = new DataTagCompound();
//        dtc21.setString("String", "Buffer");
//        dtc21.setChar("Char", '\u00a7');
//        dtc21.setInteger("Integer", 1);
//        dtc21.setShort("Short", (short) (1 & 65535));
//        dtc21.setLong("Long", 1);
//        dtc21.setByte("Byte", (byte) (1 & 255));
//        dtc21.setDouble("Double", 1);
//        dtc21.setFloat("Float", 1);
//        dtc21.setBoolean("Boolean", true);
//        dtc21.setStringArray("StringArray", new String[] {"Buffer", "Buffer2"});
//        dtc21.setIntegerArray("IntegerArray", new int[] {0, 1});
//        dtc21.setShortArray("ShortArray", new short[] {0 & 65535, 1 & 65535});
//        dtc21.setLongArray("LongArray", new long[] {0, 1});
//        dtc21.setByteArray("ByteArray", new byte[] {0 & 255, 1 & 255});
//        dtc21.setDoubleArray("DoubleArray", new double[] {0, 1});
//        dtc21.setFloatArray("FloatArray", new float[] {0, 1});
//        dtc21.setBooleanArray("BooleanArray", new boolean[] {false, true});
//        dtc2.setCompound("Compound", dtc21);
//        DataTagList dtc22 = new DataTagList();
//        dtc22.appendString("Buffer");
//        dtc22.appendChar('\u00a7');
//        dtc22.appendInteger(1);
//        dtc22.appendShort((short) (1 & 65535));
//        dtc22.appendLong(1);
//        dtc22.appendByte((byte) (1 & 255));
//        dtc22.appendDouble(1);
//        dtc22.appendFloat(1);
//        dtc22.appendBoolean(true);
//        dtc22.appendStringArray(new String[] {"Buffer", "Buffer2"});
//        dtc22.appendIntegerArray(new int[] {0, 1});
//        dtc22.appendShortArray(new short[] {0 & 65535, 1 & 65535});
//        dtc22.appendLongArray(new long[] {0, 1});
//        dtc22.appendByteArray(new byte[] {0 & 255, 1 & 255});
//        dtc22.appendDoubleArray(new double[] {0, 1});
//        dtc22.appendFloatArray(new float[] {0, 1});
//        dtc22.appendBooleanArray(new boolean[] {false, true});
//        dtc2.setList("List", dtc22);
//        R7DAFWriter.write(new File(System.getenv("APPDATA") + "/.redolyrGames/others", "Test.r7"), dtc2);
//        DataStream.write(new File(System.getenv("APPDATA") + "/.redolyrGames/others", "Test.r7.daf"), dtc2);
//        R7DAFReader.read(new File(System.getenv("APPDATA") + "/.redolyrGames/others", "Test.r7"));
//        R7DAFDataOutput r7DAFDataOutput = new R7DAFDataOutput(new File(System.getenv("APPDATA") + "/.redolyrGames/others", "Test2.r7"));
//        dtc2.write(r7DAFDataOutput);
//        r7DAFDataOutput.close();
//        R7DAFDataInput r7DAFDataInput = new R7DAFDataInput(new File(System.getenv("APPDATA") + "/.redolyrGames/others", "Test2.r7"));
//        while (r7DAFDataInput.hasNext())
//        {
//            System.out.println(r7DAFDataInput.readNext());
//        }
//        String playerName = "";
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("Whad do player name?");
//        while (scanner.hasNext())
//        {
//            if (playerName == "")
//            {
//                playerName = scanner.next();
//                System.out.println("Your player name is: " + playerName);
//            }
//            else
//            {
//                Socket socket = new Socket("localhost", 25565);
//                DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
//                DataTagCompound dataTagCompound = new DataTagCompound();
//                dataTagCompound.setString("player", playerName);
//                dataTagCompound.setString("command", scanner.next());
//                dataTagCompound.write(dataOutputStream);
//                socket.close();
//            }
//        }
//        ServerSocket serverSocket = new ServerSocket(60000);
//        while(true)
//        {
//            Socket socket = serverSocket.accept();
//            DataInputStream dis = new DataInputStream(socket.getInputStream());
//            int req = dis.readInt();
//            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
//            dos.writeInt(req*req);
//            dos.close();
//            dis.close();
//            System.out.println(req);
//        }
//        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
//        DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
//        Document document = documentBuilder.newDocument();
//        Element root = document.createElement("Root");
//        document.appendChild(root);
//        root.setAttribute("id", "1");
//        root.setAttribute("key", "Test");
//        Element element = document.createElement("Test");
//        element.appendChild(document.createTextNode("Test"));
//        root.appendChild(element);
//
//        TransformerFactory transformerFactory = TransformerFactory.newInstance();
//        Transformer transformer = transformerFactory.newTransformer();
//        DOMSource source = new DOMSource(document);
//        StreamResult result = new StreamResult(System.out);
//        transformer.transform(source, result);
//        File file = new File(System.getenv("APPDATA") + "/.redolyrGames/others", "Test.patch");
//        ElementTagCompound tag = new ElementTagCompound();
//        tag.setTag("Test", new ElementTagCharacter('\u00a7'));
//        tag.setTag("Test2", new ElementTagCharacter('\u00a7'));
//        ElementTagCompound tag2 = new ElementTagCompound();
//        tag2.setTag("Test", new ElementTagCharacter('\u00a7'));
//        tag2.setTag("Test2", new ElementTagCharacter('\u00a7'));
//        tag.setTag("Test3", tag2);
//        ElementStream.write(file, tag);
//        System.out.println(ElementStream.read(file));
//        DataTagCompound dataTagCompound = new DataTagCompound();
//        dataTagCompound.setString("Test", "Test");
//        DataTagCompound dataTagCompound1 = new DataTagCompound();
//        dataTagCompound1.setBoolean("Test", true);
//        dataTagCompound.setCompound("Test2", dataTagCompound1);
//        System.out.println(dataTagCompound);
//        StringReplacer stringReplacer = new StringReplacer();
//        stringReplacer.setFile(new File(System.getenv("APPDATA") + "/.redolyrGames/others", "TestStringReplacer.txt"));
//        System.out.println(stringReplacer.getUTF8("test", ":"));
//        Element element = new Element();
//        element.addAttribute("Test", "Test");
//        element.addAttribute("Test2", "Test3");
//        System.out.println(element.toString() + ", " + element.getAttribute("Test2").getValue());
//		DrawFrame df = new DrawFrame("Draw Frame", 1000, 600);
//		df.actionPreformed(new DrawButton("Test", 0, 100, 100, 100, 20));
//		df.setBackgroundColor(0x55, 0x55, 0x55);
//		df.drawingPanelsClosingEvent.add(new IWindowsClosedEvent()
//		{
//			public boolean isWindowClose()
//			{
//				return false;
//			}
//			public void addWindowEvent(WindowEvent windowEvent, int id)
//			{
//			}
//		});
//		DataTagCompound test = new DataTagCompound();
//		DataTagList testlist = new DataTagList();
//		test.setString("String", "Fields");
//		test.setChar("Char", '\u00a7');
//		test.setInteger("Integer", 1);
//		test.setShort("Short", (short) 0);
//		test.setLong("Long", 0);
//		test.setByte("Byte", (byte) 0);
//		test.setDouble("Double", 0);
//		test.setFloat("Float", 0);
//		test.setBoolean("Integer", false);
//
//		test.setIntegerArray("IntegerArray", new int[4]);
//		test.setShortArray("ShortArray", new short[4]);
//		test.setLongArray("LongArray", new long[4]);
//		test.setByteArray("ByteArray", new byte[4]);
//		test.setDoubleArray("DoubleArray", new double[4]);
//		test.setFloatArray("FloatArray", new float[4]);
//
//		testlist.appendString("Fields");
//		testlist.appendChar('\u00a7');
//		testlist.appendInteger(0);
//		testlist.appendShort((short) 0);
//		testlist.appendLong(0);
//		testlist.appendByte((byte) 0);
//		testlist.appendDouble(0);
//		testlist.appendFloat(0);
//		testlist.appendBoolean(false);
//		test.setTag("TestList", testlist);
//
//		File fileAndPath = new File(System.getenv("APPDATA") + "/.redolyrGames/others/Test2.dat");
//		DataStream.write(fileAndPath, test);
//
//		DataTagCompound dtc = DataStream.read(fileAndPath);
//		System.out.println(dtc);
//		System.out.println(test.getList("TestList"));
//
//		DataTagCompound dtc2 = new DataTagCompound();
//		dtc2.setString("String", "Buffer");
//		dtc2.setChar("Char", '\u2205');
//		dtc2.setInteger("Integer", 1);
//		dtc2.setShort("Short", (short) (1 & 65535));
//		dtc2.setLong("Long", 1);
//		dtc2.setByte("Byte", (byte) (1 & 255));
//		dtc2.setDouble("Double", 1);
//		dtc2.setFloat("Float", 1);
//		dtc2.setBoolean("Boolean", true);
//		dtc2.setStringArray("StringArray", new String[] {"Buffer", "Buffer2"});
//        dtc2.setCharArray("CharacterArray", new char[] {'\u2205', '\u2205'});
//		dtc2.setIntegerArray("IntegerArray", new int[] {0, 1});
//		dtc2.setShortArray("ShortArray", new short[] {0 & 65535, 1 & 65535});
//		dtc2.setLongArray("LongArray", new long[] {0, 1});
//		dtc2.setByteArray("ByteArray", new byte[] {0 & 255, 1 & 255});
//		dtc2.setDoubleArray("DoubleArray", new double[] {0, 1});
//		dtc2.setFloatArray("FloatArray", new float[] {0, 1});
//		DataTagCompound dtc21 = new DataTagCompound();
//		dtc21.setString("String", "Buffer");
//		dtc21.setChar("Char", '\u00a7');
//		dtc21.setInteger("Integer", 1);
//		dtc21.setShort("Short", (short) (1 & 65535));
//		dtc21.setLong("Long", 1);
//		dtc21.setByte("Byte", (byte) (1 & 255));
//		dtc21.setDouble("Double", 1);
//		dtc21.setFloat("Float", 1);
//		dtc21.setBoolean("Boolean", true);
//		dtc21.setStringArray("StringArray", new String[] {"Buffer", "Buffer2"});
//		dtc21.setIntegerArray("IntegerArray", new int[] {0, 1});
//		dtc21.setShortArray("ShortArray", new short[] {0 & 65535, 1 & 65535});
//		dtc21.setLongArray("LongArray", new long[] {0, 1});
//		dtc21.setByteArray("ByteArray", new byte[] {0 & 255, 1 & 255});
//		dtc21.setDoubleArray("DoubleArray", new double[] {0, 1});
//		dtc21.setFloatArray("FloatArray", new float[] {0, 1});
//		dtc21.setBooleanArray("BooleanArray", new boolean[] {false, true});
//		dtc2.setCompound("Compound", dtc21);
//		DataTagList dtc22 = new DataTagList();
//		dtc22.appendString("Buffer");
//		dtc22.appendChar('\u00a7');
//		dtc22.appendInteger(1);
//		dtc22.appendShort((short) (1 & 65535));
//		dtc22.appendLong(1);
//		dtc22.appendByte((byte) (1 & 255));
//		dtc22.appendDouble(1);
//		dtc22.appendFloat(1);
//		dtc22.appendBoolean(true);
//		dtc22.appendStringArray(new String[] {"Buffer", "Buffer2"});
//		dtc22.appendIntegerArray(new int[] {0, 1});
//		dtc22.appendShortArray(new short[] {0 & 65535, 1 & 65535});
//		dtc22.appendLongArray(new long[] {0, 1});
//		dtc22.appendByteArray(new byte[] {0 & 255, 1 & 255});
//		dtc22.appendDoubleArray(new double[] {0, 1});
//		dtc22.appendFloatArray(new float[] {0, 1});
//		dtc22.appendBooleanArray(new boolean[] {false, true});
//		dtc2.setList("List", dtc22);
//		XMLDataStream.write(dtc2, new File(System.getenv("APPDATA") + "/.redolyrGames/others/test.xml"));
//        System.out.println(dtc2);
//
//		DataOutputStream dos = new DataOutputStream(new GZIPOutputStream(new FileOutputStream(new File(System.getenv("APPDATA") + "/.redolyrGames/others/Test2.dat"))));
//    	dos.writeUTF("DataTagCompound");
//		dos.close();
//
//		DataInputStream dis = new DataInputStream(new GZIPInputStream(new FileInputStream(new File(System.getenv("APPDATA") + "/.redolyrGames/others/Test2.dat"))));
//    	System.out.println(dis.readUTF());
//		dis.close();
//		TaskTrayUtils.runnableTaskTray("Test", ImageIconBackgroundNone.getNoneItem().getImage(), new ITaskTrayEvent()
//		{
//			private MenuItem test = new MenuItem("Test");
//			public void runnableEvent() {}
//			public void runnableMenuItemEvent(MenuComponent par1MenuComponent)
//			{
//				if (par1MenuComponent == test)
//					System.out.println("Test In Motion");
//				else
//					System.out.println("End!");
//			}
//			public void synchronizedExitEvent()
//			{
//				System.exit(0);
//			}
//			public boolean synchronizedExitVisibled()
//			{
//				return true;
//			}
//			public void menuItems(List<MenuComponent> par1List)
//			{
//				par1List.add(test);
//				par1List.add(new MenuItem("Test2"));
//
//			}
//		});
//		Data<String> dataTest = new HashData();
//		dataTest.add("AAAA");
//		dataTest.add("BBB");
//		dataTest.add("CC");
//		dataTest.add("D");
//		dataTest.remove("D");
//		System.out.println(dataTest);
//		Data<Integer> dataTest2 = new HashData();
//		dataTest2.add(1);
//		dataTest2.add(2);
//		dataTest2.add(3);
//		dataTest2.add(4);
//		dataTest.remove();
//		System.out.println(dataTest2);
//		DataTagCompound test = new DataTagCompound();
//		DataTagList testlist = new DataTagList();
//		test.setString("String", "Fields");
//		test.setChar("Char", '\u00a7');
//		test.setInteger("Integer", 0);
//		test.setShort("Short", (short) 0);
//		test.setLong("Long", 0);
//		test.setByte("Byte", (byte) 0);
//		test.setDouble("Double", 0);
//		test.setFloat("Float", 0);
//		test.setBoolean("Integer", false);
//		testlist.appendString("Fields");
//		testlist.appendChar('\u00a7');
//		testlist.appendInteger(0);
//		testlist.appendShort((short) 0);
//		testlist.appendLong(0);
//		testlist.appendByte((byte) 0);
//		testlist.appendDouble(0);
//		testlist.appendFloat(0);
//		testlist.appendBoolean(false);
//		test.setTag("TestList", testlist);
//		System.out.println(test);
//		for (byte ids : DataBase.toTagsIds) System.out.println(DataBase.toTagNames(ids));
//		Boxes boxes = new HashBoxes<String, String>();
//		boxes.setKey("Test");
//		boxes.setValue("Test");
//		List<Boxes> boxesList = new ArrayList<Boxes>();
//		boxesList.add(boxes);
//		System.out.println(boxesList.toString().replace(HashBoxes.class.getSimpleName(), ""));
//		SetsList<String, String> setsList = new HashSetsList<String, String>();
//		setsList.add("Test", "Test");
//		System.out.println(setsList);
//		DrawFrame frame = new DrawFrame("Underated Frame Test", 500, 250, 0x555555, true);
//		frame.drawingPanelsClosingEvent.add(new IWindowsClosedEvent()
//		{
//			public void addWindowClosing(WindowEvent windowEvent, int id)
//			{
//				switch (id)
//				{
//				case 0:
//					System.exit(0);
//				}
//			}
//			public boolean isWindowEvent()
//			{
//				return true;
//			}
//		});
//		try {
////			ByteArrayOutputStream baos = new ByteArrayOutputStream();
////			ImageIO.write(ImageIO.read(new File(System.getenv("APPDATA") + "/.redolyrGames/assets/default/textures/icon", "NONE.png")), "PNG", baos);
////			byte[] byteArray = baos.toByteArray();
////			baos.close();
////			for (byte bytes : byteArray) System.out.println(bytes);
//			ImageIO.write((RenderedImage) ImageIconBackgroundNone.getNoneItem().getImage(), "PNG", new File(System.getenv("APPDATA") + "/.redolyrGames/assets/default/textures/icon", "TEST.png"));
//			TaskTrayUtils.runnableTaskTray("Test", ImageIconBackgroundNone.getNoneItem().getImage(), new ITaskTrayEvent()
//			{
//				public void runnableEvent()
//				{
//					System.out.println(true);
//					System.exit(0);
//				}
//			});
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		System.out.println((float)Math.PI / 4F + ", " + 0.7853982F);
////		new Launcher("CLADARZ");
//		AutoUpdate update = AutoUpdate.instance;
//		update.currentVersion("Latest");
//		update.setGetterURL("https://raw.githubusercontent.com/Redolyr/GameAutoUpdateFile/master/README.md");
//		update.directoryOrFiles("version.txt");
//		update.AutoUpdateLogger(true);
//		System.out.println(update.get("{RedolyrLauncherDownload}"));
//		System.out.println(update.get("{RedolyrLauncherVersion}"));
//		System.out.println(update.get("{RedolyrLibDownload}"));
//		System.out.println(update.get("{RedolyrLibVersion}"));
//		System.out.println(update.get("{MAP_ALL}"));
//
//		try
//		{
//			ThawingZip.getURLFile(new URL(update.get("{RedolyrLibDownload}")) , new File("test.txt"));
//		}
//		catch (MalformedURLException e)
//		{
//			e.printStackTrace();
//		}
//
//		try
//		{
//			new Runtimes("C:/Users/redolyr/Desktop/Minecraft_1.6~.exe", "net.minecraft.bootstrap.Bootstrap");
//		}
//		catch (IOException e)
//		{
//			e.printStackTrace();
//		}
	}
//	public Launcher(String displayName)
//	{
//		try
//		{
//			URL url = new URL("https://api.twitch.tv/kraken?oauth_token=" + URLEncoder.encode(displayName, "UTF-8"));
//			String s = httpConnection(url);
////			System.out.println(s);
//			Iterator it = map.keySet().iterator();
//			String displayNameOut = "", messageOut = "";
////			String twitch = "<Twitch> <" + displayNameOut + ">" + messageOut;
//			String twitch = "<Twitch> <" + displayNameOut + ">" + messageOut;
//			while (it.hasNext())
//			{
//				displayNameOut += map.get(it.next()).displayName;
//				HashSet<ChatUserSubscription> hashMap = map.get(it.next()).subscriptions;
//				Iterator it2 = hashMap.iterator();
//				while (it2.hasNext())
//				{
//					messageOut += it2.next();
//				}
//				System.out.println(twitch);
//			}
//		}
//		catch (MalformedURLException e)
//		{
//			e.printStackTrace();
//		}
//		catch (UnsupportedEncodingException e)
//		{
//			e.printStackTrace();
//		}
//		catch (IOException e)
//		{
//			e.printStackTrace();
//		}
//	}
//	public void addChatUserInfo(ChatUserInfo[] par1, ChatUserInfo[] par2, ChatUserInfo[] par3)
//	{
//		ChatUserInfo[] chatUserInfo3 = par2;
//		int len = par2.length;
//		int jack;
//		ChatUserInfo chatUserInfo;
//		for (jack = 0; jack < len; jack++)
//		{
//			chatUserInfo = chatUserInfo3[len];
//			map.remove(chatUserInfo.displayName);
//		}
//
//		chatUserInfo3 = par3;
//		len = par3.length;
//		for (jack = 0; jack < len; jack++)
//		{
//			chatUserInfo = chatUserInfo3[len];
//			map.put(chatUserInfo.displayName, chatUserInfo);
//		}
//
//		chatUserInfo3 = par1;
//		len = par1.length;
//		for (jack = 0; jack < len; jack++)
//		{
//			chatUserInfo = chatUserInfo3[len];
//			map.put(chatUserInfo.displayName, chatUserInfo);
//		}
//	}
//	public ChatUserInfo getChatUserInfo(String displayName)
//	{
//		return (ChatUserInfo) map.get(displayName);
//	}
//    private void func_152939_a(String par1String, ChatMessage par2ChatMessage)
//    {
//        ChatUserInfo chatuserinfo = (ChatUserInfo)map.get(par1String);
//
//        if (chatuserinfo == null)
//        {
//            chatuserinfo = new ChatUserInfo();
//            chatuserinfo.displayName = par1String;
//            map.put(par1String, chatuserinfo);
//        }
//
//        chatuserinfo.subscriptions = par2ChatMessage.subscriptions;
//        chatuserinfo.modes = par2ChatMessage.modes;
//        chatuserinfo.emoticonSet = par2ChatMessage.emoticonSet;
//        chatuserinfo.nameColorARGB = par2ChatMessage.nameColorARGB;
//    }
//    public static String httpConnection(URL par1URL) throws IOException
//    {
//        HttpURLConnection httpurlconnection = (HttpURLConnection)par1URL.openConnection();
//        httpurlconnection.setRequestMethod("GET");
//        BufferedReader bufferedreader = new BufferedReader(new InputStreamReader(httpurlconnection.getInputStream()));
//        StringBuilder stringbuilder = new StringBuilder();
//        String s;
//
//        while ((s = bufferedreader.readLine()) != null)
//        {
//            stringbuilder.append(s);
//            stringbuilder.append('\r');
//        }
//
//        bufferedreader.close();
//        return stringbuilder.toString();
//    }
}
