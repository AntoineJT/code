# MIT License
#
# Copyright (c) 2019 Antoine James Tournepiche
# Repository : https://github.com/AntoineJT/code/
#
# Permission is hereby granted, free of charge, to any person obtaining a copy
# of this software and associated documentation files (the "Software"), to deal
# in the Software without restriction, including without limitation the rights
# to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
# copies of the Software, and to permit persons to whom the Software is
# furnished to do so, subject to the following conditions:
#
# The above copyright notice and this permission notice shall be included in all
# copies or substantial portions of the Software.
#
# THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
# IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
# FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
# AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
# LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
# OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
# SOFTWARE.


# These are my custom aliases and functions
# Jul 17th 2019

alias lso="ls -o"
# TODO Remove this alias and call a function back_in_the_tree with instead : .. nb_of_folder_to_go_back
alias ..="cd .."

# kill process function
# Jul 17th 2019
killp(){
  # TODO make it variadic (?)
  if [[ -z "$1" || $# -ne 1 ]]; then
    echo "Usage: killp <process filename>"
    return
  fi
  OUTPUT=`pidof "$1"`
  if [[ -z "$OUTPUT" ]]; then
    echo "No process currently running"
    return
  fi
  sudo kill "$OUTPUT"
}
