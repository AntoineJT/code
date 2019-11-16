/*
MIT License

Copyright (c) 2019 Antoine James Tournepiche
Repository : https://github.com/AntoineJT/code/

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
*/

/**
 * @author Antoine James Tournepiche
 * @version 1.0.0
 */
public class FancyStringBuilder {
    // TODO javadoc it
    private final StringBuilder stringBuilder;

    // -------------
    // wrapper part

    /**
     * @since 1.0.0
     */
    public FancyStringBuilder() {
        stringBuilder = new StringBuilder();
    }

    /**
     * @since 1.0.0
     */
    public FancyStringBuilder(CharSequence charSequence) {
        stringBuilder = new StringBuilder(charSequence);
    }

    /**
     * @since 1.0.0
     */
    public FancyStringBuilder(int capacity) {
        stringBuilder = new StringBuilder(capacity);
    }

    /**
     * @since 1.0.0
     */
    public FancyStringBuilder(String str) {
        stringBuilder = new StringBuilder(str);
    }

    /**
     * @since 1.0.0
     */
    public String toString() {
        return stringBuilder.toString();
    }

    /**
     * @since 1.0.0
     */
    public FancyStringBuilder append(int i) {
        stringBuilder.append(i);
        return this;
    }

    /**
     * @since 1.0.0
     */
    public FancyStringBuilder append(char c) {
        stringBuilder.append(c);
        return this;
    }

    /**
     * @since 1.0.0
     */
    public FancyStringBuilder append(float f) {
        stringBuilder.append(f);
        return this;
    }

    /**
     * @since 1.0.0
     */
    public FancyStringBuilder append(double d) {
        stringBuilder.append(d);
        return this;
    }

    /**
     * @since 1.0.0
     */
    public FancyStringBuilder append(long l) {
        stringBuilder.append(l);
        return this;
    }

    /**
     * @since 1.0.0
     */
    public FancyStringBuilder append(boolean b) {
        stringBuilder.append(b);
        return this;
    }

    /**
     * @since 1.0.0
     */
    /*
    public FancyStringBuilder append(char[] str) {
        stringBuilder.append(str);
        return this;
    }
    */

    /**
     * @since 1.0.0
     */
    public FancyStringBuilder append(Object obj) {
        stringBuilder.append(obj);
        return this;
    }

    /**
     * @since 1.0.0
     */
    public FancyStringBuilder append(String str) {
        stringBuilder.append(str);
        return this;
    }

    /**
     * @since 1.0.0
     */
    public FancyStringBuilder append(CharSequence charSequence) {
        stringBuilder.append(charSequence);
        return this;
    }

    /**
     * @since 1.0.0
     */
    public FancyStringBuilder append(StringBuffer stringBuffer) {
        stringBuilder.append(stringBuffer);
        return this;
    }

    /**
     * @since 1.0.0
     */
    public FancyStringBuilder append(char[] str, int offset, int len) {
        stringBuilder.append(str, offset, len);
        return this;
    }

    /**
     * @since 1.0.0
     */
    public FancyStringBuilder append(CharSequence charSequence, int start, int end) {
        stringBuilder.append(charSequence, start, end);
        return this;
    }

    /**
     * @since 1.0.0
     */
    public FancyStringBuilder appendCodePoint(int codePoint) {
        stringBuilder.appendCodePoint(codePoint);
        return this;
    }

    /**
     * @since 1.0.0
     */
    public int capacity() {
        return stringBuilder.capacity();
    }

    /**
     * @since 1.0.0
     */
    public char charAt(int index) {
        return stringBuilder.charAt(index);
    }

    /**
     * @since 1.0.0
     */
    public int codePointAt(int index) {
        return stringBuilder.codePointAt(index);
    }

    /**
     * @since 1.0.0
     */
    public int codePointBefore(int index) {
        return stringBuilder.codePointBefore(index);
    }

    /**
     * @since 1.0.0
     */
    public int codePointCount(int beginIndex, int endIndex) {
        return stringBuilder.codePointCount(beginIndex, endIndex);
    }

    /**
     * @since 1.0.0
     */
    public FancyStringBuilder delete(int start, int end) {
        stringBuilder.delete(start, end);
        return this;
    }

    // do not implement with variadicity, it'll be really error prone
    /**
     * @since 1.0.0
     */
    public FancyStringBuilder deleteCharAt(int index) {
        stringBuilder.deleteCharAt(index);
        return this;
    }

    /**
     * @since 1.0.0
     */
    public void ensureCapacity(int minimumCapacity) {
        stringBuilder.ensureCapacity(minimumCapacity);
    }

    /**
     * @since 1.0.0
     */
    public void getChars(int srcBegin, int srcEnd, char[] dst, int dstBegin) {
        stringBuilder.getChars(srcBegin, srcEnd, dst, dstBegin);
    }

    /**
     * @since 1.0.0
     */
    public int indexOf(String str) {
        return stringBuilder.indexOf(str);
    }

    /**
     * @since 1.0.0
     */
    public int indexOf(String str, int fromIndex) {
        return stringBuilder.indexOf(str, fromIndex);
    }

    /**
     * @since 1.0.0
     */
    public FancyStringBuilder insert(int offset, boolean b) {
        stringBuilder.insert(offset, b);
        return this;
    }

    /**
     * @since 1.0.0
     */
    public FancyStringBuilder insert(int offset, char c) {
        stringBuilder.insert(offset, c);
        return this;
    }

    /**
     * @since 1.0.0
     */
    /*
    public FancyStringBuilder insert(int offset, char[] str) {
        stringBuilder.insert(offset, str);
        return this;
    }
     */

    /**
     * @since 1.0.0
     */
    public FancyStringBuilder insert(int index, char[] str, int offset, int len) {
        stringBuilder.insert(index, str, offset, len);
        return this;
    }

    /**
     * @since 1.0.0
     */
    public FancyStringBuilder insert(int dstOffset, CharSequence charSequence) {
        stringBuilder.insert(dstOffset, charSequence);
        return this;
    }

    /**
     * @since 1.0.0
     */
    public FancyStringBuilder insert(int dstOffset, CharSequence charSequence, int start, int end) {
        stringBuilder.insert(dstOffset, charSequence, start, end);
        return this;
    }

    /**
     * @since 1.0.0
     */
    public FancyStringBuilder insert(int offset, double d) {
        stringBuilder.insert(offset, d);
        return this;
    }

    /**
     * @since 1.0.0
     */
    public FancyStringBuilder insert(int offset, float f) {
        stringBuilder.insert(offset, f);
        return this;
    }

    /**
     * @since 1.0.0
     */
    public FancyStringBuilder insert(int offset, int i) {
        stringBuilder.insert(offset, i);
        return this;
    }

    /**
     * @since 1.0.0
     */
    public FancyStringBuilder insert(int offset, long l) {
        stringBuilder.insert(offset, l);
        return this;
    }

    /**
     * @since 1.0.0
     */
    public FancyStringBuilder insert(int offset, Object obj) {
        stringBuilder.insert(offset, obj);
        return this;
    }

    /**
     * @since 1.0.0
     */
    public FancyStringBuilder insert(int offset, String str) {
        stringBuilder.insert(offset, str);
        return this;
    }

    /**
     * @since 1.0.0
     */
    public int lastIndexOf(String str) {
        return stringBuilder.lastIndexOf(str);
    }

    /**
     * @since 1.0.0
     */
    public int lastIndexOf(String str, int fromIndex) {
        return stringBuilder.lastIndexOf(str, fromIndex);
    }

    /**
     * @since 1.0.0
     */
    public int length() {
        return stringBuilder.length();
    }

    /**
     * @since 1.0.0
     */
    public int offsetByCodePoints(int index, int codePointOffset) {
        return stringBuilder.offsetByCodePoints(index, codePointOffset);
    }

    /**
     * @since 1.0.0
     */
    public FancyStringBuilder replace(int start, int end, String str) {
        stringBuilder.replace(start, end, str);
        return this;
    }

    /**
     * @since 1.0.0
     */
    public FancyStringBuilder reverse() {
        stringBuilder.reverse();
        return this;
    }

    /**
     * @since 1.0.0
     */
    public void setCharAt(int index, char c) {
        stringBuilder.setCharAt(index, c);
    }

    /**
     * @since 1.0.0
     */
    public void setLength(int newLength) {
        stringBuilder.setLength(newLength);
    }

    /**
     * @since 1.0.0
     */
    public CharSequence subSequence(int start, int end) {
        return stringBuilder.subSequence(start, end);
    }

    /**
     * @since 1.0.0
     */
    public String substring(int start) {
        return stringBuilder.substring(start);
    }

    /**
     * @since 1.0.0
     */
    public String substring(int start, int end) {
        return stringBuilder.substring(start, end);
    }

    /**
     * @since 1.0.0
     */
    public void trimToSize() {
        stringBuilder.trimToSize();
    }

    // -------------------
    // end of wrapper part

    // useful new things
    // TODO implement more things
    /**
     * @since 1.0.0
     */
    public StringBuilder toStringBuilder() {
        return stringBuilder;
    }

    /**
     * @since 1.0.0
     */
    public FancyStringBuilder append(int... integers) {
        for (int i : integers) {
            stringBuilder.append(i);
        }
        return this;
    }

    /**
     * replaces the char[] implementation
     * @since 1.0.0
     */
    public FancyStringBuilder append(char... chars) {
        for (char c : chars) {
            stringBuilder.append(c);
        }
        return this;
    }

    /**
     * @since 1.0.0
     */
    public FancyStringBuilder append(float... floats) {
        for (float f : floats) {
            stringBuilder.append(f);
        }
        return this;
    }

    /**
     * @since 1.0.0
     */
    public FancyStringBuilder append(double... doubles) {
        for (double d : doubles) {
            stringBuilder.append(d);
        }
        return this;
    }

    /**
     * @since 1.0.0
     */
    public FancyStringBuilder append(long... longs) {
        for (long l : longs) {
            stringBuilder.append(l);
        }
        return this;
    }

    /**
     * @since 1.0.0
     */
    public FancyStringBuilder append(boolean... booleans) {
        for (boolean b : booleans) {
            stringBuilder.append(b);
        }
        return this;
    }

    /**
     * @since 1.0.0
     */
    public FancyStringBuilder append(String... strings) {
        for (String str : strings) {
            stringBuilder.append(str);
        }
        return this;
    }

    /**
     * @since 1.0.0
     */
    public FancyStringBuilder append(Object... objs) {
        for (Object obj : objs) {
            stringBuilder.append(obj);
        }
        return this;
    }

    /**
     * @since 1.0.0
     */
    public FancyStringBuilder append(CharSequence... charSequences) {
        for(CharSequence charSequence : charSequences) {
            stringBuilder.append(charSequence);
        }
        return this;
    }

    /**
     * @since 1.0.0
     */
    public FancyStringBuilder append(StringBuffer... stringBuffers) {
        for (StringBuffer stringBuffer : stringBuffers) {
            stringBuilder.append(stringBuffer);
        }
        return this;
    }

    /**
     * @since 1.0.0
     */
    public FancyStringBuilder insert(int offset, boolean... booleans) {
        for (boolean b : booleans) {
            stringBuilder.insert(offset, b);
        }
        return this;
    }

    /**
     * replaces the int, char[] implementation
     * @since 1.0.0
     */
    public FancyStringBuilder insert(int offset, char... chars) {
        for (char c : chars) {
            stringBuilder.insert(offset, c);
        }
        return this;
    }

    /**
     * @since 1.0.0
     */
    public FancyStringBuilder insert(int dstOffset, CharSequence... charSequences) {
        for (CharSequence charSequence : charSequences) {
            stringBuilder.insert(dstOffset, charSequence);
        }
        return this;
    }

    /**
     * @since 1.0.0
     */
    public FancyStringBuilder insert(int offset, double... doubles) {
        for (double d : doubles) {
            stringBuilder.insert(offset, d);
        }
        return this;
    }

    /**
     * @since 1.0.0
     */
    public FancyStringBuilder insert(int offset, float... floats) {
        for (float f : floats) {
            stringBuilder.insert(offset, f);
        }
        return this;
    }

    /**
     * @since 1.0.0
     */
    public FancyStringBuilder insert(int offset, int... integers) {
        for (int i : integers) {
            stringBuilder.insert(offset, i);
        }
        return this;
    }

    /**
     * @since 1.0.0
     */
    public FancyStringBuilder insert(int offset, long... longs) {
        for (long l : longs) {
            stringBuilder.insert(offset, l);
        }
        return this;
    }

    /**
     * @since 1.0.0
     */
    public FancyStringBuilder insert(int offset, Object... objs) {
        for (Object obj : objs) {
            stringBuilder.insert(offset, obj);
        }
        return this;
    }

    /**
     * @since 1.0.0
     */
    public FancyStringBuilder insert(int offset, String... strings) {
        for (String str : strings) {
            stringBuilder.insert(offset, str);
        }
        return this;
    }
}
