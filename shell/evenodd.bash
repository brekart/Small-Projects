#!/bin/bash

FOO=$RANDOM
echo "$FOO"
echo "$FOO"

IFEVEN=`expr $FOO % 2`
echo $IFEVEN

if [ $IFEVEN -eq 0 ]; then
	echo "it's even"
else
	echo "it's odd"
fi
