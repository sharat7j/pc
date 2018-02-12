#!/bin/bash
for file in /Users/sharatjagannath/Downloads/data/*
do
 #echo $file
 curl -XPOST 'https://search-pcsharat-sdtgdrvrt2qxhosz5j6iht2atu.us-east-1.es.amazonaws.com/_bulk' --data-binary @$file -H 'Content-Type: application/json'   
done

