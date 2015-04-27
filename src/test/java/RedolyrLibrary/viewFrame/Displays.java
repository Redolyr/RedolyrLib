package RedolyrLibrary.viewFrame;

import java.awt.*;
import java.util.Arrays;

/**
 * Created by redolyr on 2015/01/27.
 */
public class Displays {

    private static Display[] displays;
    private static Keyboard[] keyboards;
    private static Mouse[] mouses;
    private static Draw[] draws;
    private static int currentThread;

    public static int addDisplay(Display display) {
        if (displays == null) displays = new Display[1];
        else displays = Arrays.copyOf(displays, currentThread + 1);

        if (keyboards == null) keyboards = new Keyboard[1];
        else keyboards = Arrays.copyOf(keyboards, currentThread + 1);

        if (mouses == null) mouses = new Mouse[1];
        else mouses = Arrays.copyOf(mouses, currentThread + 1);

        if (draws == null) draws = new Draw[1];
        else draws = Arrays.copyOf(draws, currentThread + 1);

        displays[currentThread] = display;
        keyboards[currentThread] = display.keyboard;
        mouses[currentThread] = display.mouse;
        draws[currentThread] = display.getDraw();

        int thread = currentThread;

        ++currentThread;

        return thread;
    }

    public static final Display[] runnedAllDisplays() {
        return Arrays.copyOf(displays, currentThread);
    }

    public static final void create(int displayId) throws Exception {
        displays[displayId].create();
    }

    public static final Display getDisplay(int displayId) {
        return displays[displayId];
    }

    public static final Draw getDraw(int displayId) {
        return draws[displayId];
    }

    public static final Mouse getMouse(int displayId) {
        return mouses[displayId];
    }

    public static final Keyboard getKeyboard(int displayId) {
        return displays[displayId].keyboard;
    }

    public static final Graphics getGraphics(int displayId) {
        return displays[displayId].getGraphics();
    }

    public static final void stop(int displayId) {
        displays[displayId].stop();
    }

    public static final void stopAll() {
        for (Display display : displays) {
            stop(display.displayID);
        }
    }
}
