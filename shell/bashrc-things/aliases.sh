# These are my custom aliases and functions
# Antoine James Tournepiche
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
