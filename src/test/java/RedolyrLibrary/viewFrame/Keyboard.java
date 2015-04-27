package RedolyrLibrary.viewFrame;

import java.awt.event.KeyEvent;

/**
 * Created by redolyr on 2015/01/27.
 */
public class Keyboard implements UpdateHandler {

    public static final char default_ = '\u0000';
    public static final int defaultKeyCode = 0;

    private char current;
    private int keyCode;

    public boolean isPush;
    public boolean isPres;

    public static final int KEY_BACKSPACE = 8;

    public static final int KEY_ENTER = 10;

    public static final int KEY_SHIFT = 16;
    public static final int KEY_CTRL = 17;
    public static final int KEY_ALT = 18;

    public static final int KEY_CAPS_LOCK = 20;

    public static final int KEY_ESC = 27;

    public static final int KEY_SPACE = 32;

    public static final int KEY_LEFT = 37;
    public static final int KEY_UP = 38;
    public static final int KEY_RIGHT = 39;
    public static final int KEY_DOWN = 40;

    public static final int KEY_COMMA = 44;
    public static final int KEY_MINUS = 45;
    public static final int KEY_PERIOD = 46;
    public static final int KEY_SLASH = 47;

    public static final int KEY_0 = 48;
    public static final int KEY_1 = 49;
    public static final int KEY_2 = 50;
    public static final int KEY_3 = 51;
    public static final int KEY_4 = 52;
    public static final int KEY_5 = 53;
    public static final int KEY_6 = 54;
    public static final int KEY_7 = 55;
    public static final int KEY_8 = 56;
    public static final int KEY_9 = 57;

    public static final int KEY_SEMICOLON = 57;

    public static final int KEY_A = 65;
    public static final int KEY_B = 66;
    public static final int KEY_C = 67;
    public static final int KEY_D = 68;
    public static final int KEY_E = 69;
    public static final int KEY_F = 70;
    public static final int KEY_G = 71;
    public static final int KEY_I = 73;
    public static final int KEY_J = 74;
    public static final int KEY_K = 75;
    public static final int KEY_L = 76;
    public static final int KEY_M = 77;
    public static final int KEY_N = 78;
    public static final int KEY_O = 79;
    public static final int KEY_P = 80;
    public static final int KEY_Q = 81;
    public static final int KEY_R = 82;
    public static final int KEY_S = 83;
    public static final int KEY_T = 84;
    public static final int KEY_U = 85;
    public static final int KEY_V = 86;
    public static final int KEY_W = 87;
    public static final int KEY_X = 88;
    public static final int KEY_Y = 89;
    public static final int KEY_Z = 90;
    public static final int KEY_LEFT_LARGE_BRACKETS = 91;
    public static final int KEY_BACK_SLASH = 92;
    public static final int KEY_RIGHT_LARGE_BRACKETS = 93;

    public static final int KEY_NUMPAD_0 = 96;
    public static final int KEY_NUMPAD_1 = 97;
    public static final int KEY_NUMPAD_2 = 98;
    public static final int KEY_NUMPAD_3 = 99;
    public static final int KEY_NUMPAD_4 = 100;
    public static final int KEY_NUMPAD_5 = 101;
    public static final int KEY_NUMPAD_6 = 102;
    public static final int KEY_NUMPAD_7 = 103;
    public static final int KEY_NUMPAD_8 = 104;
    public static final int KEY_NUMPAD_9 = 105;
    public static final int KEY_NUMPAD_BALLY = 106;
    public static final int KEY_NUMPAD_PLUS = 107;

    public static final int KEY_NUMPAD_MINUS = 109;

    public static final int KEY_NUMPAD_SLASH = 111;
    public static final int KEY_F1 = 112;
    public static final int KEY_F2 = 113;
    public static final int KEY_F3 = 114;
    public static final int KEY_F4 = 115;
    public static final int KEY_F5 = 116;
    public static final int KEY_F6 = 117;
    public static final int KEY_F7 = 118;
    public static final int KEY_F8 = 119;
    public static final int KEY_F9 = 120;
    public static final int KEY_F10 = 121;
    public static final int KEY_F11 = 122;
    public static final int KEY_F12 = 123;

    public static final int KEY_NUM_LOCK = 144;

    public static final int KEY_KANA_LOCK = 262;

    public static final int KEY_AT = 512;
    public static final int KEY_COLON = 513;
    public static final int KEY_CIRCIMFLEX = 514;

    public static final int KEY_WINDOW = 524;
    public static final int KEY_CONTEXT_MENU = 525;

    public char getKey() {
        return this.current;
    }

    public int getKeyCode() {
        return this.keyCode;
    }

    public void keyTyped(KeyEvent e) {
        this.current = e.getKeyChar();
        this.isPush = true;
        this.isPres = false;
    }

    public void keyPressed(KeyEvent e) {
        this.keyCode = e.getKeyCode();
        this.isPres = true;
        this.isPush = false;
    }

    public void keyReleased(KeyEvent e) {
        this.current = this.default_;
        this.keyCode = this.defaultKeyCode;
        this.isPres = false;
        this.isPush = false;
    }

    public void update() {
        this.current = this.default_;
        this.keyCode = this.defaultKeyCode;
        this.isPres = false;
        this.isPush = false;
    }

    public String toString() {
        return "Keyboard{" +
                "current=" + current +
                ", keyCode=" + keyCode +
                ", isPush=" + isPush +
                ", isPres=" + isPres +
                '}';
    }
}
