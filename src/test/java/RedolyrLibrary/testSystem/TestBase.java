package RedolyrLibrary.testSystem;

import java.util.ArrayList;

/**
 * Created by redolyr on 2014/12/14.
 */
public abstract class TestBase {
    public abstract void readFromTest(ArrayList<TestTagUtil> testTagUtilArrayList);

    public abstract void writeToTest(ArrayList<TestTagUtil> testTagUtilArrayList);

    public abstract byte getId();
}
