package RedolyrLibrary.test;

/**
 * Created by redolyr on 2015/02/12.
 */
public class Node {

    private NodeCompound nodeCompound = new NodeCompound();

    public void setObject(String key, NodeObject nodeObject) {
        this.nodeCompound.put(key, nodeObject);
    }

    public void setInteger(String key, int value) {
        this.setObject(key, new NodeInteger(value));
    }

    public void setShort(String key, short value) {
        this.setObject(key, new NodeShort(value));
    }

    public void setLong(String key, long value) {
        this.setObject(key, new NodeLong(value));
    }

    public void setByte(String key, byte value) {
        this.setObject(key, new NodeByte(value));
    }

    public void setDouble(String key, double value) {
        this.setObject(key, new NodeDouble(value));
    }

    public void setFloat(String key, float value) {
        this.setObject(key, new NodeFloat(value));
    }

    public void setBoolean(String key, boolean value) {
        this.setObject(key, new NodeBoolean(value));
    }

    public void setString(String key, String  value) {
        this.setObject(key, new NodeString(value));
    }

    public void setCharacter(String key, char value) {
        this.setObject(key, new NodeCharacter(value));
    }

    public void setCompound(String key, NodeCompound value) {
        this.setObject(key, value);
    }

    public void setList(String key, NodeList value) {
        this.setObject(key, value);
    }

    public NodeObject getObject(String key) {
        return this.nodeCompound.get(key);
    }

    public int getIntger(String key) {
        return 0;//(int) this.getObject(key).getObject();
    }

    public short getShort(String key) {
        return 0;//(short) this.getObject(key).getObject();
    }

    public long getLong(String key) {
        return 0;//(long) this.getObject(key).getObject();
    }

    public byte getByte(String key) {
        return 0;//(byte) this.getObject(key).getObject();
    }

    public double getDouble(String key) {
        return 0;//(double) this.getObject(key).getObject();
    }

    public float getFloat(String key) {
        return 0;//(float) this.getObject(key).getObject();
    }

    public boolean getBoolean(String key) {
        return false;//(boolean) this.getObject(key).getObject();
    }

    public String  getString(String key) {
        return (String) this.getObject(key).getObject();
    }

    public char getCharacter(String key) {
        return '\u00a7';//(char) this.getObject(key).getObject();
    }

    public NodeCompound getCompound(String key) {
        return (NodeCompound) this.getObject(key).getObject();
    }

    public NodeList getList(String key) {
        return (NodeList) this.getObject(key).getObject();
    }

    public void remove(String key) {
        this.nodeCompound.remove(key);
    }
}
