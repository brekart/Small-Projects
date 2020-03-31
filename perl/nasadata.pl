#!/usr/bin/perl

use strict;
use warnings;


my $file ='/home/braydon_rekart/nasa_19950801.tsv';
open(FILE, $file) or die "Could not open $file: $!";

my $bytesperhour = 0;

while( my $line = <FILE>)  {   
    #next if $. == 1;
    if($. == 1) {
        next;
    }
   

    my @pieces = split(/\t/,$line);
#    print 'Epoch:' . $pieces[2]."\n";
   # print 'Bytes:' . $pieces[6]."\n";
      my $date = scalar localtime($pieces[2]);
#            print $date . "\n";
    $bytesperhour = $bytesperhour + $pieces[6];
    
    my @dateline = split(/ /, $date);
        print $dateline[4] . "\n";

#        print @dateline . "\n";
    my @minute = split(/:/, $date);
#        print $minute[1] . "\n";
#above line succesfully pulls the minute out of the hour (like 0-59)
    if ($minute[1] == 59 ) {
   # && $minute[2] == 59) {
       # print $dateline[4] . "\n";
        print 'Bytes this hour: ' . $bytesperhour . "\n";
        $bytesperhour = 0;
    }
}



close FILE;
