package RedolyrLibrary.viewFrame;

/**
 * Created by redolyr on 2015/02/08.
 */
public class ErrorChecker {

    private final int displayID;

    private boolean isError;

    public ErrorChecker(int displayID) {
        this.displayID = displayID;
    }

    public ErrorCheck toErrorCheck() {
        Display display = Displays.getDisplay(this.displayID);
        Keyboard keyboard = Displays.getKeyboard(this.displayID);
        Mouse mouse = Displays.getMouse(this.displayID);
        Draw draw = Displays.getDraw(this.displayID);

        ErrorCheck errorCheck = ErrorCheck.UNKNOWN;
        if (display == null) {
            errorCheck = ErrorCheck.DISPLAY;
        } else if (keyboard == null) {
            errorCheck = ErrorCheck.KEYBOARD;
        } else if (mouse == null) {
            errorCheck = ErrorCheck.MOUSE;
        } else if (draw == null) {
            errorCheck = ErrorCheck.DRAW;
        } else if (display == null && keyboard == null) {
            errorCheck = ErrorCheck.DISPLAY_KEYBOARD;
        } else if (display == null && mouse == null) {
            errorCheck = ErrorCheck.DISPLAY_MOUSE;
        } else if (display == null && draw == null) {
            errorCheck = ErrorCheck.DISPLAY_DRAW;
        } else if (keyboard == null && mouse == null) {
            errorCheck = ErrorCheck.KEYBOARD_MOUSE;
        } else if (keyboard == null && draw == null) {
            errorCheck = ErrorCheck.KEYBOARD_DRAW;
        } else if (mouse == null && draw == null) {
            errorCheck = ErrorCheck.MOUSE_DRAW;
        } else if (display == null && keyboard == null && mouse == null) {
            errorCheck = ErrorCheck.DISPLAY_KEYBOARD_MOUSE;
        } else if (display == null && keyboard == null && draw == null) {
            errorCheck = ErrorCheck.DISPLAY_KEYBOARD_DRAW;
        } else if (display == null && mouse == null && draw == null) {
            errorCheck = ErrorCheck.DISPLAY_MOUSE_DRAW;
        } else if (keyboard == null && mouse == null && draw == null) {
            errorCheck = ErrorCheck.KEYBOARD_MOUSE_DRAW;
        } else if (display == null && keyboard == null && mouse == null && draw == null) {
            errorCheck = ErrorCheck.DISPLAY_KEYBOARD_MOUSE_DRAW;
        }

        if (errorCheck != ErrorCheck.UNKNOWN) this.isError = true;
        return errorCheck;
    }

    public boolean isError() {
        return this.isError;
    }

    public String toString() {
        return this.toErrorCheck() + "";
    }
}
