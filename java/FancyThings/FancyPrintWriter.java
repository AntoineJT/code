/*
 * MIT License
 *
 * Copyright (c) 2019 Antoine James Tournepiche
 * Repository : https://github.com/AntoineJT/code/
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.nio.charset.Charset;
import java.util.Locale;

/**
 * An enhanced PrintWriter class
 *
 * @author Antoine James Tournepiche
 * @version 1.0.1
 */
public class FancyPrintWriter {
    private final PrintWriter printWriter;

    // wrapper part
    // constructors
    // java 8

    /**
     * @since 1.0.0
     */
    public FancyPrintWriter(File file) throws FileNotFoundException {
        printWriter = new PrintWriter(file);
    }

    /**
     * @since 1.0.0
     */
    public FancyPrintWriter(File file, String csn) throws FileNotFoundException, UnsupportedEncodingException {
        printWriter = new PrintWriter(file, csn);
    }

    /**
     * @since 1.0.0
     */
    public FancyPrintWriter(OutputStream out) {
        printWriter = new PrintWriter(out);
    }

    /**
     * @since 1.0.0
     */
    public FancyPrintWriter(OutputStream out, boolean autoFlush) {
        printWriter = new PrintWriter(out, autoFlush);
    }

    /**
     * @since 1.0.0
     */
    public FancyPrintWriter(String fileName) throws FileNotFoundException {
        printWriter = new PrintWriter(fileName);
    }

    /**
     * @since 1.0.0
     */
    public FancyPrintWriter(String fileName, String csn) throws FileNotFoundException, UnsupportedEncodingException {
        printWriter = new PrintWriter(fileName, csn);
    }

    // end of java 8
    // --------------
    // java 10
    /**
     * @since 1.0.0
     */
    public FancyPrintWriter(File file, Charset charset) throws IOException {
        printWriter = new PrintWriter(file, charset);
    }

    /**
     * @since 1.0.0
     */
    public FancyPrintWriter(OutputStream out, boolean autoFlush, Charset charset) {
        printWriter = new PrintWriter(out, autoFlush, charset);
    }

    /**
     * @since 1.0.0
     */
    public FancyPrintWriter(Writer out) {
        printWriter = new PrintWriter(out);
    }

    /**
     * @since 1.0.0
     */
    public FancyPrintWriter(Writer out, boolean autoFlush) {
        printWriter = new PrintWriter(out, autoFlush);
    }

    /**
     * @since 1.0.0
     */
    public FancyPrintWriter(String fileName, Charset charset) throws IOException {
        printWriter = new PrintWriter(fileName, charset);
    }
    // end of java 10
    // ---------------
    // end of constructors
    // --------------------

    /**
     * @since 1.0.0
     */
    public FancyPrintWriter append(char c) {
        printWriter.append(c);
        return this;
    }

    /**
     * @since 1.0.0
     */
    public FancyPrintWriter append(CharSequence charSequence) {
        printWriter.append(charSequence);
        return this;
    }

    /**
     * @since 1.0.0
     */
    public FancyPrintWriter append(CharSequence charSequence, int start, int end) {
        printWriter.append(charSequence, start, end);
        return this;
    }

    /**
     * @since 1.0.0
     */
    public boolean checkError() {
        return printWriter.checkError();
    }

    // TODO use reflection in a good way to make it work
    /*
    protected void clearError() {
        try {
            Method method = printWriter.getClass().getDeclaredMethod("clearError");
            method.setAccessible(true);
            method.invoke(printWriter, (Object) null);
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException exception) {
            exception.printStackTrace();
        }
    }
     */

    /**
     * @since 1.0.0
     */
    public void close() {
        printWriter.close();
    }

    /**
     * @since 1.0.0
     */
    public void flush() {
        printWriter.flush();
    }

    /**
     * @since 1.0.0
     */
    public FancyPrintWriter format(String format, Object... args) {
        printWriter.format(format, args);
        return this;
    }

    /**
     * @since 1.0.0
     */
    public FancyPrintWriter format​(Locale locale, String format, Object... args) {
        printWriter.format(locale, format, args);
        return this;
    }

    /**
     * @since 1.0.0
     */
    public void print(boolean b) {
        printWriter.print(b);
    }

    /**
     * @since 1.0.0
     */
    public void print(char c) {
        printWriter.print(c);
    }

    /**
     * @since 1.0.0
     */
    public void print(double d) {
        printWriter.print(d);
    }

    /**
     * @since 1.0.0
     */
    public void print(float f) {
        printWriter.print(f);
    }

    /**
     * @since 1.0.0
     */
    public void print(int i) {
        printWriter.print(i);
    }

    /**
     * @since 1.0.0
     */
    public void print(long l) {
        printWriter.print(l);
    }

    /**
     * @since 1.0.0
     */
    public void print(String str) {
        printWriter.print(str);
    }

    /**
     * @since 1.0.0
     */
    public void println() {
        printWriter.println();
    }

    /**
     * @since 1.0.0
     */
    public void println(boolean b) {
        printWriter.println(b);
    }

    /**
     * @since 1.0.0
     */
    public void println(char c) {
        printWriter.println(c);
    }

    /**
     * @since 1.0.0
     */
    /*
    public void println(char[] str) {
        printWriter.println(str);
    }
    */

    /**
     * @since 1.0.0
     */
    public void println(double d) {
        printWriter.println(d);
    }

    /**
     * @since 1.0.0
     */
    public void println(float f) {
        printWriter.println(f);
    }

    /**
     * @since 1.0.0
     */
    public void println(int i) {
        printWriter.println(i);
    }

    /**
     * @since 1.0.0
     */
    public void println(long l) {
        printWriter.println(l);
    }

    /**
     * @since 1.0.0
     */
    public void println(Object obj) {
        printWriter.println(obj);
    }

    /**
     * @since 1.0.0
     */
    public void println(String str) {
        printWriter.println(str);
    }

    // TODO make good use of reflection to implement this
    /*
    protected void setError()
     */

    /**
     * @since 1.0.0
     */
    public void write(char[] buf, int off, int len) {
        printWriter.write(buf, off, len);
    }

    /**
     * @since 1.0.0
     */
    public void write(int c) {
        printWriter.write(c);
    }

    /**
     * @since 1.0.0
     */
    public void write(String str) {
        printWriter.write(str);
    }

    /**
     * @since 1.0.0
     */
    public void write(String str, int off, int len) {
        printWriter.write(str);
    }

    // end of wrapper part
    // --------------------

    // new fancy things
    /**
     * @since 1.0.0
     */
    public PrintWriter toPrintWriter() {
        return printWriter;
    }

    /**
     * @since 1.0.0
     */
    public FancyPrintWriter append(char... chars) {
        for (char c : chars) printWriter.append(c);
        return this;
    }

    /**
     * @since 1.0.0
     */
    public FancyPrintWriter append(CharSequence... charSequences) {
        for (CharSequence charSequence : charSequences) printWriter.append(charSequence);
        return this;
    }

    /**
     * @since 1.0.0
     */
    public void print(boolean... booleans) {
        for (boolean b : booleans) printWriter.print(b);
    }

    /**
     * replaces the char[] implementation
     *
     * @since 1.0.0
     */
    public void print(char... chars) {
        for (char c : chars) printWriter.print(c);
    }

    /**
     * @since 1.0.0
     */
    public void print(double... doubles) {
        for (double d : doubles) printWriter.print(d);
    }

    /**
     * @since 1.0.0
     */
    public void print(float... floats) {
        for (float f : floats) printWriter.print(f);
    }

    /**
     * @since 1.0.0
     */
    public void print(int... integers) {
        for (int i : integers) printWriter.print(i);
    }

    /**
     * @since 1.0.0
     */
    public void print(long... longs) {
        for (long l : longs) printWriter.print(l);
    }

    /**
     * @since 1.0.0
     */
    public void print(String... strings) {
        for (String str : strings) printWriter.print(str);
    }

    /**
     * @since 1.0.0
     */
    public void println(boolean... booleans) {
        for (boolean b : booleans) printWriter.println(b);
    }

    /**
     * replaces the char[] implementation
     *
     * @since 1.0.0
     */
    public void println(char... chars) {
        for (char c : chars) printWriter.println(c);
    }

    /**
     * @since 1.0.0
     */
    public void println(double... doubles) {
        for (double d : doubles) printWriter.println(d);
    }

    /**
     * @since 1.0.0
     */
    public void println(float... floats) {
        for (float f : floats) printWriter.println(f);
    }

    /**
     * @since 1.0.0
     */
    public void println(int... integers) {
        for (int i : integers) printWriter.println(i);
    }

    /**
     * @since 1.0.0
     */
    public void println(long... longs) {
        for (long l : longs) printWriter.println(l);
    }

    /**
     * @since 1.0.0
     */
    public void println(Object... objs) {
        for (Object obj : objs) printWriter.println(obj);
    }

    /**
     * @since 1.0.0
     */
    public void println(String... strings) {
        for (String str : strings) printWriter.println(str);
    }

    /**
     * replaces the char[] implementation
     *
     * @since 1.0.0
     */
    public void write(char... buf) {
        printWriter.write(buf);
    }

    /**
     * @since 1.0.0
     */
    public void write(int... chars) {
        for (int c : chars) printWriter.write(c);
    }

    /**
     * @since 1.0.0
     */
    public void write(String... strings) {
        for (String str : strings) printWriter.write(str);
    }

    // end of new fancy things
    // ------------------------
}
