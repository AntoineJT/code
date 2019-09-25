#!/bin/bash
usage()
{
	echo "Usage: $0 {start|stop|logs}"
	exit 1
}

if [ "$#" -eq 1 ]
then
	case "$1" in
		start)
			sudo docker-compose up -d
			;;
		stop)
			sudo docker-compose down
			;;
		logs)
			sudo docker-compose logs --follow owncloud
			;;
		*)
			usage
	esac
else
	usage
fi
