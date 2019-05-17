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
