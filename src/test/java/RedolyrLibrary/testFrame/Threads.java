package RedolyrLibrary.testFrame;

import RedolyrLibrary.documentSystems.DocumentTagCompound;
import RedolyrLibrary.documentSystems.DocumentTagList;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by redolyr on 2014/12/18.
 */
public class Threads {

    private Response[] responses = new Response[1000];
    private int length;
    private String threadsTitle = "<Unknown>";

    public void readFromDocument(DocumentTagCompound DocumentTagCompound) {

        this.responses = new Response[1000];

        this.threadsTitle = DocumentTagCompound.getString("threadsTitle") != null ? DocumentTagCompound.getString("threadsTitle") : "<Unknown>";

        this.length = DocumentTagCompound.getInteger("ResponseLength");

        DocumentTagList DocumentTagList = DocumentTagCompound.getList("Responses");

        for (int len = 0; len < DocumentTagList.count(); ++len)
            if (this.responses[len] != null)
                this.responses[len].readFromDocument(DocumentTagList.getCompound(len));
    }

    public void writeToDocument(DocumentTagCompound DocumentTagCompound) {

        DocumentTagCompound.setString("threadsTitle", this.threadsTitle);

        DocumentTagCompound.setInteger("ResponseLength", this.length);

        DocumentTagList DocumentTagList = new DocumentTagList();

        for (int len = 0; len < this.length; ++len) {
            if (this.responses[len] != null) {
                DocumentTagCompound DocumentTagCompound1 = new DocumentTagCompound();
                this.responses[len].writeToDocument(DocumentTagCompound1);
                DocumentTagList.appendTag(DocumentTagCompound1);
            }
        }

        DocumentTagCompound.setList("Responses", DocumentTagList);
    }

    public void addResponse(String username, String[] texts) {
        if (this.responses[this.length] == null) {
            this.responses[this.length] = new Response(this.length + 1, username, texts, new SimpleDateFormat("EEE mm/dd/yyyy hh/MM/ss").format(new Date()));

            ++this.length;
        } else {
            ++this.length;
            this.responses[this.length] = new Response(this.length + 1, username, texts, new SimpleDateFormat("EEE mm/dd/yyyy hh/MM/ss").format(new Date()));
            ++this.length;
        }
    }

    public Response[] getResponses() {
        return this.responses;
    }

    public int length() {
        return this.length;
    }

    public String getThreadsTitle() {
        return this.threadsTitle;
    }

    public String toString() {
        String result = "[";
        for (int len = 0; len < this.length; ++len) {
            Response response = this.responses[len];
            if (response != null) result += response + (len == this.length - 1 ? "" : ", ");
        }
        result += "]";
        return String.format("{ThreadsTitle=\"%s\", Responses=%s, ReponseLength=%s", this.threadsTitle, result, this.length);
    }
}
