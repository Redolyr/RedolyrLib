package RedolyrLibrary.fileSystems;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import java.io.IOException;

public abstract class DataBase
{
    protected Document document;
	public static final byte[] toTagsIds = new byte[] {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20};
	abstract void write(final Element par1) throws IOException;
	abstract void read(final Element par1) throws IOException;
	public abstract byte getId();
	public abstract <T extends DataBase> T copy();
	public String getSimpleClassName()
	{
		return this.getClass().getSimpleName();
	}
	public static DataBase toTags(byte id)
	{
		switch (id)
		{
		case 0:
			return new ElementTagEnd();
		case 1:
			return new ElementTagCompound();
		case 2:
			return new ElementTagList();
		case 3:
			return new ElementTagString();
		case 4:
			return new ElementTagCharacter();
		case 5:
			return new ElementTagInteger();
		case 6:
			return new ElementTagShort();
		case 7:
			return new ElementTagLong();
		case 8:
			return new ElementTagByte();
		case 9:
			return new ElementTagDouble();
		case 10:
			return new ElementTagFloat();
		case 11:
			return new ElementTagBoolean();
		case 12:
			return new ElementTagStringArray();
		case 13:
			return new ElementTagCharacterArray();
		case 14:
			return new ElementTagIntegerArray();
		case 15:
			return new ElementTagShortArray();
		case 16:
			return new ElementTagLongArray();
		case 17:
			return new ElementTagByteArray();
		case 18:
			return new ElementTagDoubleArray();
		case 19:
			return new ElementTagFloatArray();
		case 20:
			return new ElementTagBooleanArray();
		default:
			return null;
		}
	}
	public static String toTagNames(byte id)
	{
		return toTags(id).getSimpleClassName();
	}
}
