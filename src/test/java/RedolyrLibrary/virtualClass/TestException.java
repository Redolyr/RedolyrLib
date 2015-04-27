package RedolyrLibrary.virtualClass;

/**
 * Created by redolyr on 2015/04/01.
 */
public class TestException extends Exception {

    public TestException() {
    }

    public TestException(String s) {
        super (s);
    }

    public TestException(String s, Throwable throwable) {
        super (s, throwable);
    }

    public TestException(Throwable throwable) {
        super (throwable);
    }

}
