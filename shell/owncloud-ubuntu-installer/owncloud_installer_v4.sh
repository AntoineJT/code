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

#!/bin/bash
# ------------------------
#Functions
# -----------------------
usage()
{
	echo "Usage: $0 {uninstall|install} {server|client}"
	exit 1
}
# ------------------------
requirements()
{
	sudo apt install \
		apt-transport-https \
		ca-certificates \
		curl \
		software-properties-common
}
# ------------------------
install_server()
{
	requirements
	curl -fsSL "https://download.docker.com/linux/ubuntu/gpg" | sudo apt-key add -
	sudo apt-key fingerprint 0EBFCD88
	sudo add-apt-repository \
       		"deb [arch=amd64] https://download.docker.com/linux/ubuntu \
       		$(lsb_release -cs) \
       		stable"
	sudo apt update
	sudo apt install docker-ce docker-compose

	mkdir owncloud-docker-server
	cd owncloud-docker-server
	
	if [ -f docker-compose.yml ]; then
		 rm docker-compose.yml
	fi
	wget "https://raw.githubusercontent.com/owncloud-docker/server/master/docker-compose.yml"

	# file : .env
	echo "T1dOQ0xPVURfVkVSU0lPTj0xMC4wCk9XTkNMT1VEX0RPTUFJTj1sb2NhbGhvc3QKQURNSU5fVVNFUk5BTUU9YWRtaW4KQURNSU5fUEFTU1dPUkQ9YWRtaW4KSFRUUF9QT1JUPTgwCg==" > envtrash
	base64 -d envtrash > .env
	rm envtrash

	# owncloud_server.sh (without MIT license at the moment)
	echo "IyEvYmluL2Jhc2gKdXNhZ2UoKQp7CgllY2hvICJVc2FnZTogJDAge3N0YXJ0fHN0b3B8bG9nc30iCglleGl0IDEKfQoKaWYgWyAiJCMiIC1lcSAxIF0KdGhlbgoJY2FzZSAiJDEiIGluCgkJc3RhcnQpCgkJCXN1ZG8gZG9ja2VyLWNvbXBvc2UgdXAgLWQKCQkJOzsKCQlzdG9wKQoJCQlzdWRvIGRvY2tlci1jb21wb3NlIGRvd24KCQkJOzsKCQlsb2dzKQoJCQlzdWRvIGRvY2tlci1jb21wb3NlIGxvZ3MgLS1mb2xsb3cgb3duY2xvdWQKCQkJOzsKCQkqKQoJCQl1c2FnZQoJZXNhYwplbHNlCgl1c2FnZQpmaQo=" > owntrash
	base64 -d owntrash > owncloud_server.sh
	rm owntrash
}
# ------------------------
install_client()
{
	requirements
	#wget -nv https://download.opensuse.org/repositories/isv:ownCloud:desktop/Ubuntu_18.04/Release.key -O Release.key
	curl -fsSL "https://download.opensuse.org/repositories/isv:ownCloud:desktop/Ubuntu_18.04/Release.key" | sudo apt-key add -
	#sudo apt-key add - < Release.key
	sudo apt update
	sudo apt install owncloud-client
	#rm Release.key
}
# ------------------------
uninstall_server()
{
	requirements
	local resp=''
	while [ "$resp" != "y" ] && [ "$resp" != "n" ]; do
		echo "Do you want to remove docker-compose? [y/n] "
		read resp
	done
	if [ "$resp" = "y" ]; then
		sudo apt autoremove docker-compose
		sudo add-apt-repository -r \
			"deb [arch=amd64] https://download.docker.com/linux/ubuntu \
   			$(lsb_release -cs) \
			stable"
		sudo apt clean
		curl -fsSL "https://download.docker.com/linux/ubuntu/gpg" > gpg
		sudo apt-key del -< gpg
		rm gpg
	fi
	echo "For now, you just need to remove the folder containing the server : nothing else will be removed, as long as removing the dependencies of the server can break your system!"
	echo "Use gtkorphan or something like that if you want to remove unused packages!"
	resp=''
	while [ "$resp" != "y" ] && [ "$resp" != "n" ]; do
		echo "Do you want to install gtkorphan? [y/n] "
		read resp
	done
	if [ "$resp" = "y" ]; then
		sudo apt update
		sudo apt install gtkorphan
	fi
}
# ------------------------
uninstall_client()
{
	requirements
	sudo apt autoremove owncloud-client
	sudo apt clean
	curl -fsSL https://download.opensuse.org/repositories/isv:ownCloud:desktop/Ubuntu_18.04/Release.key > Release.key
	# TODO Check if the old key has been correctly removed
	sudo apt-key del -< Release.key
	rm Release.key
	sudo apt update
}
# ------------------------
# Main 
if [ "$#" -eq 2 ]; then
	case "$1" in
		install)		
			case "$2" in
				server)
					install_server
					;;
				client)
					install_client
					;;
				*)
					usage
			esac
			;;
		uninstall)
			case "$2" in
				server)
					uninstall_server
					;;
				client)
					uninstall_client
					;;
				*)
					usage
			esac
			;;
		*)
			usage
	esac
else 
	usage
fi

