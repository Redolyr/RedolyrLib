package RedolyrLibrary;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.zip.DataFormatException;
import java.util.zip.Deflater;
import java.util.zip.Inflater;

/**
 * Created by redolyr on 2015/01/11.
 */
public class ExHardCoreStringZipping {

    private String default_ = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private byte[] default_byte = default_.getBytes();

    public byte[] compression(byte[] default_byte) {

        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        byte[] compressedData = bos.toByteArray();
        Deflater compresser = new Deflater();
        try {
            byte[] outBuf = new byte[1024];

            compresser.finish();
            int siz = compresser.deflate(outBuf);
            if (siz > 0) {
                bos.write(outBuf, 0, siz);
            }
        } finally {
            compresser.end();
        }
        compressedData = bos.toByteArray();
        return compressedData;
    }

    public byte[] decompression(byte[] default_byte) {
        byte[] bytes = this.compression(default_byte);
        Inflater inflater = new Inflater();
        ByteArrayInputStream byteArrayInputStreama = new ByteArrayInputStream(bytes);

        byte[] bytes1 = new byte[1024];
        int rd;
        try {
            do {
                rd = byteArrayInputStreama.read(bytes);
                if (rd > 0) {
                    inflater.setInput(bytes, 0, rd);
                }
                while (!inflater.finished()) {
                    inflater.inflate(bytes1);
                }
            } while (rd > 0);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (DataFormatException e) {
            e.printStackTrace();
        }

        try {
            byteArrayInputStreama.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return bytes1;
    }

    public byte[] comression4Lines(byte[] bytes) {
        return this.compression(this.compression(this.compression(this.compression(bytes))));
    }

    public byte[] decomression4Lines(byte[] bytes) {
        return this.decompression(this.decompression(this.decompression(this.decompression(bytes))));
    }
}
