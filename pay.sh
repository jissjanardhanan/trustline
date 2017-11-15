#!/bin/bash

FROM=$1
TO=$2
AMOUNT=$3

echo $FROM is paying $TO $AMOUNT'$'

PORT="9090"
shopt -s nocasematch
if [[ $FROM = "Bob"  ]]; then
	PORT="9080"	
fi
shopt -u nocasematch

URL="http://localhost:$PORT/trustapp/$AMOUNT/pay?user=$TO"
echo $URL
curl -X POST $URL


exit 0

