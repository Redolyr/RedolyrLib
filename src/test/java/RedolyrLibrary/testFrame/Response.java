package RedolyrLibrary.testFrame;

import RedolyrLibrary.documentSystems.DocumentTagCompound;

import java.util.Arrays;

/**
 * Created by redolyr on 2014/12/18.
 */
public class Response {
    private int response;
    private String username;
    private String[] texts;
    private String date;
    private String base64;

    public Response(int response, String username, String[] texts, String date) {
        this.response = response;
        this.username = username;
        this.texts = texts;
        this.date = date;
        this.base64 = ResponseUtil.setBase64();
        String.format("#%s Username: %s Texts: %s Date: %s %s", this.response, this.username, Arrays.toString(this.texts), this.date, this.base64);
    }

    public void readFromDocument(DocumentTagCompound DocumentTagCompound) {
        this.response = DocumentTagCompound.getInteger("ResponseId");
        this.username = DocumentTagCompound.getString("Username");
        this.texts = DocumentTagCompound.getStringArray("Texts");
        this.date = DocumentTagCompound.getString("Date");
        this.base64 = DocumentTagCompound.getString("Base64");
    }

    public void writeToDocument(DocumentTagCompound DocumentTagCompound) {
        DocumentTagCompound.setInteger("ResponseId", this.response);
        DocumentTagCompound.setString("Username", this.username);
        DocumentTagCompound.setStringArray("Texts", this.texts);
        DocumentTagCompound.setString("Date", this.date);
        DocumentTagCompound.setString("Base64", this.base64);
    }

    public int getResponse() {
        return this.response;
    }

    public String getUsername() {
        return this.username;
    }

    public String[] getTexts() {
        return this.texts;
    }

    public String getDate() {
        return this.date;
    }

    public String getBase64() {
        return this.base64;
    }

    public String toString() {
        return String.format("#%s Username: %s Texts: %s Date: %s %s", this.response, this.username, Arrays.toString(this.texts), this.date, this.base64);
    }
}
