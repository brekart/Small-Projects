#!/usr/bin/perl
use strict;
use warnings;


my $filename = 'extractedepochs.txt';
open(my $fh, '<:encoding(UTF-8)', $filename)
  or die "Could not open file '$filename' $!";

while (my $row = <$fh>) {
	chomp $row;
my $epoch_seconds = $row;
my $date = scalar localtime($epoch_seconds);
print $date . "\n";
}


