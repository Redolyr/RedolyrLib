package RedolyrLibrary.repository;

import java.util.Arrays;

/**
 * Created by redolyr on 2014/12/10.
 */
public class Repository {

    private Repository[] repositries;
    private int length;

    private String key;
    private String value;

    public int uploadRepository() {
        if (this.repositries == null) this.repositries = new Repository[1];
        else this.repositries = Arrays.copyOf(this.repositries, this.length + 1);

        int index = this.length;

        ++this.length;

        return index;
    }

    public Repository add(Repository Repository) {
        int repository = this.uploadRepository();
        this.repositries[repository] = Repository;
        return this;
    }

    public String getKeyName() {
        return this.key;
    }

    public Repository setKeyName(String key) {
        this.key = key;
        return this;
    }

    public String getValueName() {
        return this.value;
    }

    public Repository setValueName(String value) {
        this.value = value;
        return this;
    }

    public Repository[] getChildRepositries() {
        return this.repositries;
    }

    public int getLength() {
        return this.length;
    }

    public Repository copy() {
        return new Repository().setKeyName(this.key).setValueName(this.value);
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Repository)) return false;

        Repository Repository = (Repository) o;

        if (this.length != Repository.length) return false;
        if (this.key != null ? !this.key.equals(Repository.key) : Repository.key != null) return false;
        if (!Arrays.equals(this.repositries, Repository.repositries)) return false;
        if (this.value != null ? !this.value.equals(Repository.value) : Repository.value != null) return false;

        return true;
    }

    public int hashCode() {
        int result = this.repositries != null ? Arrays.hashCode(this.repositries) : 0;
        result = 31 * result + length;
        result = 31 * result + (this.key != null ? this.key.hashCode() : 0);
        result = 31 * result + (this.value != null ? this.value.hashCode() : 0);
        return result;
    }
}
