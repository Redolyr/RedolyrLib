package RedolyrLibrary.dataSystems;

import java.io.*;

/**
 * Created by redolyr on 2014/10/13.
 */
public class R7DAFDataOutput implements DataOutput {
    private BufferedWriter bufferedWriter;

    public R7DAFDataOutput(File file) throws IOException {
        this.bufferedWriter = new BufferedWriter(new FileWriter(file));
    }

    public void writeNext(Object object) throws IOException {
        this.bufferedWriter.write(String.valueOf(object));
        this.bufferedWriter.newLine();
    }

    @Deprecated
    public void write(int b) throws IOException {
    }

    @Deprecated
    public void write(byte[] b) throws IOException {
    }

    @Deprecated
    public void write(byte[] b, int off, int len) throws IOException {
    }

    public void writeBoolean(boolean v) throws IOException {
        this.writeNext(v);
    }

    public void writeByte(int v) throws IOException {
        this.writeNext(v);
    }

    public void writeShort(int v) throws IOException {
        this.writeNext(v);
    }

    public void writeChar(int v) throws IOException {
        this.writeNext(v);
    }

    public void writeInt(int v) throws IOException {
        this.writeNext(v);
    }

    public void writeLong(long v) throws IOException {
        this.writeNext(v);
    }

    public void writeFloat(float v) throws IOException {
        this.writeNext(v);
    }

    public void writeDouble(double v) throws IOException {
        this.writeNext(v);
    }

    public void writeBytes(String s) throws IOException {
        this.writeNext(s.getBytes());
    }

    public void writeChars(String s) throws IOException {
        this.writeNext(s.toCharArray());
    }

    public void writeUTF(String s) throws IOException {
        this.writeNext(s);
    }

    public void close() throws IOException {
        this.bufferedWriter.close();
    }
}
