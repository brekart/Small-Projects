#!/bin/sh

nullString=''

timeScan() { 
CONTAINSTIMES="$(find ~ -name '*.java' | xargs grep -L 'estimate' 'actual')"
echo $CONTAINSTIMES
}
if ! ($CONTAINSTIMES==$nullString) then {
       	timeScan
}
fi
