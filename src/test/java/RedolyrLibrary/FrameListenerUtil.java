package RedolyrLibrary;

import java.awt.*;
import java.awt.event.*;
import java.beans.PropertyChangeListener;
import java.util.Arrays;
import java.util.EventListener;

/**
 * Created by redolyr on 2014/12/16.
 */
public class FrameListenerUtil {

//    transient InputMethodListener inputMethodListener;
//    transient KeyListener keyListener;
//    transient ComponentListener componentListener;
//    transient ContainerListener containerListener;
//    transient FocusListener focusListener;
//    transient HierarchyListener hierarchyListener;
//    transient MouseListener mouseListener;
//    transient WindowListener windowListener;
//    transient HierarchyBoundsListener hierarchyBoundsListener;
//    transient MouseMotionListener mouseMotionListener;
//    transient MouseWheelListener mouseWheelListener;
//    transient PropertyChangeListener propertyChangeListener;
//    transient WindowFocusListener windowFocusListener;
//    transient WindowStateListener windowStateListener;

    public static void addListener(Frame frame, EventListener eventListener) {
        if (eventListener != null) {
            if (eventListener instanceof InputMethodListener)
                frame.addInputMethodListener((InputMethodListener) eventListener);
            else if (eventListener instanceof KeyListener) frame.addKeyListener((KeyListener) eventListener);
            else if (eventListener instanceof ComponentListener)
                frame.addComponentListener((ComponentListener) eventListener);
            else if (eventListener instanceof ContainerListener)
                frame.addContainerListener((ContainerListener) eventListener);
            else if (eventListener instanceof FocusListener) frame.addFocusListener((FocusListener) eventListener);
            else if (eventListener instanceof HierarchyListener)
                frame.addHierarchyListener((HierarchyListener) eventListener);
            else if (eventListener instanceof MouseListener) frame.addMouseListener((MouseListener) eventListener);
            else if (eventListener instanceof WindowListener) frame.addWindowListener((WindowListener) eventListener);
            else if (eventListener instanceof HierarchyBoundsListener)
                frame.addHierarchyBoundsListener((HierarchyBoundsListener) eventListener);
            else if (eventListener instanceof MouseMotionListener)
                frame.addMouseMotionListener((MouseMotionListener) eventListener);
            else if (eventListener instanceof MouseWheelListener)
                frame.addMouseWheelListener((MouseWheelListener) eventListener);
            else if (eventListener instanceof PropertyChangeListener)
                frame.addPropertyChangeListener((PropertyChangeListener) eventListener);
            else if (eventListener instanceof WindowFocusListener)
                frame.addWindowFocusListener((WindowFocusListener) eventListener);
            else if (eventListener instanceof WindowStateListener)
                frame.addWindowStateListener((WindowStateListener) eventListener);
        }
    }

    public static void removeListener(Frame frame, EventListener eventListener) {
        if (eventListener != null) {
            if (eventListener instanceof InputMethodListener)
                frame.removeInputMethodListener((InputMethodListener) eventListener);
            else if (eventListener instanceof KeyListener) frame.removeKeyListener((KeyListener) eventListener);
            else if (eventListener instanceof ComponentListener)
                frame.removeComponentListener((ComponentListener) eventListener);
            else if (eventListener instanceof ContainerListener)
                frame.removeContainerListener((ContainerListener) eventListener);
            else if (eventListener instanceof FocusListener) frame.removeFocusListener((FocusListener) eventListener);
            else if (eventListener instanceof HierarchyListener)
                frame.removeHierarchyListener((HierarchyListener) eventListener);
            else if (eventListener instanceof MouseListener) frame.removeMouseListener((MouseListener) eventListener);
            else if (eventListener instanceof WindowListener)
                frame.removeWindowListener((WindowListener) eventListener);
            else if (eventListener instanceof HierarchyBoundsListener)
                frame.removeHierarchyBoundsListener((HierarchyBoundsListener) eventListener);
            else if (eventListener instanceof MouseMotionListener)
                frame.removeMouseMotionListener((MouseMotionListener) eventListener);
            else if (eventListener instanceof MouseWheelListener)
                frame.removeMouseWheelListener((MouseWheelListener) eventListener);
            else if (eventListener instanceof PropertyChangeListener)
                frame.removePropertyChangeListener((PropertyChangeListener) eventListener);
            else if (eventListener instanceof WindowFocusListener)
                frame.removeWindowFocusListener((WindowFocusListener) eventListener);
            else if (eventListener instanceof WindowStateListener)
                frame.removeWindowStateListener((WindowStateListener) eventListener);
        }
    }

    public static <T extends EventListener> T[] copyListeners(Class<? extends T> classListener, Frame frame, Frame... frames) {
        T[] ts = null;
        if (frame != null && frames != null) {
            for (int len = 0; len < frames.length; ++len) {
                Frame frame1 = frames[len];
                if (frame1 != null) {
                    T[] eventListeners = frame1.getListeners(classListener);
                    if (eventListeners != null) {
                        T[] eventListeners1 = null;
                        int length = 0;
                        for (int len1 = 0; len1 < eventListeners.length; ++len1) {
                            if (eventListeners1 == null || eventListeners1.length == 0)
                                eventListeners1 = (T[]) new EventListener[1];
                            else eventListeners1 = Arrays.copyOf(eventListeners1, length + 1);

                            eventListeners1[length++] = eventListeners[len1];
                        }
                        ts = eventListeners1;
                    }
                }
            }
        }
        return ts;
    }

    public static void addListeners(Frame frame, EventListener[] eventListeners) {
        if (eventListeners != null && eventListeners.length != 0)
            for (int len = 0; len < eventListeners.length; ++len) removeListener(frame, eventListeners[len]);
    }

    public static void removeListeners(Frame frame, EventListener[] eventListeners) {
        if (eventListeners != null && eventListeners.length != 0)
            for (int len = 0; len < eventListeners.length; ++len) addListener(frame, eventListeners[len]);
    }
}
