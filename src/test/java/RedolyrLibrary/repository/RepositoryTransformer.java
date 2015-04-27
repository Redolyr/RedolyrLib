package RedolyrLibrary.repository;

import java.io.IOException;
import java.io.OutputStream;

/**
 * Created by redolyr on 2014/12/10.
 */
public class RepositoryTransformer {

    public static final RepositoryTransformer instance() {
        return new RepositoryTransformer();
    }

    public String transformer(Repository repository, OutputStream outputStream) {
        return this.childs(repository);
    }

    public String childs(Repository repository) {
        String result = repository != null ? "" : "NULL";
        if (repository != null) {
            result = repository.toString();
            Repository[] repositories = repository.getChildRepositries();
            if (repositories != null) {
                String res = "";
                for (int len = 0; len < repositories.length; ++len) {
                    Repository repository1 = repositories[len];
                    if (repository1 != null) {
                        res += repository1.toString();
                        if (repository1.getChildRepositries() != null && repository1.getChildRepositries().length != 0)
                            res += this.childs(repository1);
                    }
                }
                res += "}";
                result += res;
            }
        }
        return result;
    }

    public String toString(Repository repository, OutputStream outputStream) throws IOException {
        outputStream.write(0xef);
        outputStream.write(0xbb);
        outputStream.write(0xbf);
        return repository.getKeyName() + ", " + repository.getValueName();
    }
}
