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

#!/bin/sh
function pause(){
   read -p "$*"
}

# function in_array(){
	# local BRANCH="$1"
	# declare -a BRANCHES=("${!2}")
	
	# for CURRENT_BRANCH in ${BRANCHES[@]}
	# do
		# echo $CURRENT_BRANCH
		# if [[ "$CURRENT_BRANCH" == "$BRANCH" ]]; then
			# return 1
		# fi
	# done
	# return 0
# }

# https://stackoverflow.com/questions/3685970/check-if-a-bash-array-contains-a-value
function contains() {
    local n=$#
    local value=${!n}
    for ((i=1;i < $#;i++)) {
        if [ "${!i}" == "${value}" ]; then
            echo 'y'
            return 0
        fi
    }
	echo 'n'
    return 1
}

declare -a BRANCHES
BRANCHES=(
	# Put here your branches like in the following example
	# master
	# develop
	# etc.
)
# declare -a BRANCHES
# while IFS= read -r line
# do
  # printf '%s\n' "$line"
  # BRANCHES+=("$line")
# done < branches

BRANCH=$1
if [[ -z $BRANCH ]]; then
	echo "Usage: $0 <branch name>"
	exit
fi

# CONTAINED=$(in_array $BRANCH $BRANCHES[@])
IN_ARRAY=$(contains ${BRANCHES[@]} $BRANCH)
if [[ "$IN_ARRAY" == "n" ]]; then
	echo 'The specified branch is not contained in this script!'
	exit
fi

git fetch
echo "Be sure that all other branches are under '$BRANCH' before to continue!"
echo 'First forward all branches?'
pause 'Press a key to confirm and go along or CTRL^C to exit '

for CURRENT_BRANCH in ${BRANCHES[@]}
do
	git checkout $CURRENT_BRANCH
	git rebase -f $BRANCH
	git push
done

git checkout $BRANCH
