/*
 * MIT License
 *
 * Copyright (c) 2019 Antoine James Tournepiche
 * Repository : https://github.com/AntoineJT/code
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

import java.util.Map;

public class MiniViewParser {
    private final View view;

    public MiniViewParser(View view) {
        this.view = view;
    }

    public String parse(Map<String, String> data) throws IllegalStateException {
        String viewContent = view.toString();

        if (data == null) {
            return viewContent;
        }

        if (!viewContent.contains("{{ ") || !viewContent.contains(" }}")) {
            return viewContent;
        }

        int beginCount = viewContent.split("\\{\\{ ").length - 1;
        int endCount = viewContent.split(" }}").length - 1;

        if (beginCount != endCount) {
            throw new IllegalStateException("View is invalid! Please fix it!");
        }

        String result = viewContent;
        for (Map.Entry<String, String> entry : data.entrySet()) {
            result = result.replaceAll("\\{\\{ " + entry.getKey() + " }}", entry.getValue());
        }

        return result;
    }
}
