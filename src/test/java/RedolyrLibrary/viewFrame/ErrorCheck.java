package RedolyrLibrary.viewFrame;

/**
 * Created by redolyr on 2015/02/08.
 */
public enum ErrorCheck {

    UNKNOWN(-1, "Unknown", '\u0000'),

    DISPLAY(0, "Display", '\u00a7'),

    KEYBOARD(1, "Keyboard", '\u00a7'),

    MOUSE(2, "Mouse", '\u00a7'),

    DRAW(3, "Draw", '\u00a7'),

    DISPLAY_KEYBOARD(4, "Display and Keyboard", '\u00a7'),

    DISPLAY_MOUSE(5, "Display and Mouse", '\u00a7'),

    DISPLAY_DRAW(6, "Display and Draw", '\u00a7'),

    KEYBOARD_MOUSE(7, "Keyboard and Mouse", '\u00a7'),

    KEYBOARD_DRAW(8, "Keyboard and Draw", '\u00a7'),

    MOUSE_DRAW(9, "Mouse and Draw", '\u00a7'),

    DISPLAY_KEYBOARD_MOUSE(10, "Display and Keyboard and Mouse", '\u00a7'),

    DISPLAY_KEYBOARD_DRAW(11, "Display and Keyboard and Draw", '\u00a7'),

    DISPLAY_MOUSE_DRAW(12, "Display and Mouse and Draw", '\u00a7'),

    KEYBOARD_MOUSE_DRAW(13, "Keyboard and Mouse and Draw", '\u00a7'),

    DISPLAY_KEYBOARD_MOUSE_DRAW(14, "Display and Keyboard and Mouse and Draw", '\u00a7');

    private final int errorID;

    private final String errorMsg;

    private final char errorMsgID;

    private ErrorCheck(int errorID, String errorMsg, char errorMsgID) {
        this.errorID = errorID;
        this.errorMsg = errorMsgID == '\u00a7' ? "There is not recognition of the " +  errorMsg : errorMsg;
        this.errorMsgID = errorMsgID;
    }

    public int getErrorID() {
        return this.errorID;
    }

    public String getErrorMsg() {
        return this.errorMsg;
    }

    public char getErrorMsgID() {
        return this.errorMsgID;
    }

    public String toString() {
        return this.errorMsg;
    }
}
