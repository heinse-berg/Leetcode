package com.leetcodecards.hashing;

import java.util.*;

public class TextEditor {
//string cursorLeft(int k) Moves the cursor to the left k times. Returns the last min(10, len) characters to the left of the cursor, where len is the number of characters to the left of the cursor.
//string cursorRight(int k) Moves the cursor to the right k times. Returns the last min(10, len) characters to the left of the cursor, where len is the number of characters to the left of the cursor.
    StringBuilder sb = new StringBuilder("|");
    int cursor = 0;

    public TextEditor() {

    }

    public void addText(String text) {
        sb.deleteCharAt(cursor);
        sb.insert(cursor, text);
        cursor += text.length();
        sb.insert(cursor, '|');
    }

    public int deleteText(int k) {
        int start = Math.max(0, cursor-1-k+1);
        sb.delete(start, cursor);
        int ans = cursor - start;
        cursor = start;
        return ans;
    }

    public String cursorLeft(int k) {
        sb.deleteCharAt(cursor);
        cursor = Math.min(0, cursor-k);
        sb.insert(cursor, '|');
        return sb.substring(Math.max(0, cursor-10), cursor);
    }

    public String cursorRight(int k) {
        sb.deleteCharAt(cursor);
        cursor = Math.min(sb.length(), cursor+k);
        sb.insert(cursor, '|');
        return sb.substring(Math.max(0, cursor-10), cursor);
    }

}
