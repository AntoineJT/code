
# Usage : append <file> <msg>
append(){
    echo $2 >> $1
}

# Usage : overwrite <file>
overwrite(){
    echo . > $1
}

# Usage : newline <file>
newline(){
    echo . >> $1
}
