package RedolyrLibrary;

import RedolyrLibrary.dataSystems.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.File;
import java.io.IOException;

public class Launcher
{
//	public Map<String, ChatUserInfo> map = new HashMap<String, ChatUserInfo>();
	public static void main(String[] args) throws IOException, ParserConfigurationException, TransformerException, SAXException
    {
        DataTagCompound dtc2 = new DataTagCompound();
        dtc2.setString("String", "Buffer");
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
        DataTagCompound dtc21 = new DataTagCompound();
        dtc21.setString("String", "Buffer");
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
        dtc2.setCompound("Compound", dtc21);
        DataTagList dtc22 = new DataTagList();
        dtc22.appendString("Buffer");
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
        dtc2.setList("List", dtc22);
        R7DAFWriter.write(new File(System.getenv("APPDATA") + "/.redolyrGames/others", "Test.r7"), dtc2);
        DataStream.write(new File(System.getenv("APPDATA") + "/.redolyrGames/others", "Test.r7.daf"), dtc2);
        R7DAFReader.read(new File(System.getenv("APPDATA") + "/.redolyrGames/others", "Test.r7"));
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
