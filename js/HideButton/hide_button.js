/* MIT License
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
 
/*
    Filename : dropdown.js
    Project : SVT 2019
    URL : https://github.com/AntoineJT/svt-2019
    Author : Antoine James Tournepiche
    Creation Date : May 16th 2019
    Last update : May 17th 2019

    Hide button script
*/

const HideButton = (() => {
    const HideButton = {};

    let time = 1000;

    const setFadeTime = duration => time = duration;
    const attachListeners = () => {
        document.querySelectorAll(".hide-button").forEach(button => {
            const to_hide = document.querySelectorAll(button.getAttribute("value"));
            to_hide.forEach(elem => {
                elem.visible = true;
                button.addEventListener("click", () => {
                    const display = elem.style.display;
                    if (display !== "none" && elem.visible){
                        elem.originalDisplay = display;
                    }
                    console.log(elem.visible);
                    if (elem.visible){
                        elem.style.animation = `fade ${time}ms forwards 1`;
                        setTimeout(() => elem.style.display = "none", time);
                    } else {
                        elem.style.display = elem.originalDisplay;
                        elem.style.animation = `fade ${time}ms reverse forwards 1`;
                    }
                    elem.visible = !elem.visible;
                });
            });
        });
        console.log("Hide button system is ready!");
    }
    
    HideButton.setFadeTime = setFadeTime;
    HideButton.attachListeners = attachListeners;
    
    console.log("Hide button system is waiting...");
    return HideButton;
})();
