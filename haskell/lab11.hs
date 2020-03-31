{-# LANGUAGE ImplicitParams #-}
import Debug.Trace

ifEven x
    | x `mod` 2 == 0 = True
    | otherwise = False

isOdd x
    | ifEven x == True = False
    | otherwise = True

isOddTwo x = not (ifEven x)

increment :: Int -> Int
increment x = x + 1

decrement :: Int -> Int
decrement x = x - 1
--------------
sumList :: [Int] -> Int
sumList[]    = 0
sumList(x:xs) = x + sumList xs
-- x is first element of list. xs is rest of list. adds. --
--------------
mult x ys = [i*x | i <- ys]
-- saw this on stack overflow. list comprehension. seemed cool to use.
-- the ys goes through the rest of the list and the i is the current element.
-- LINKED LIST?!
--------------

count :: l -> [l] -> Int
count a bc = length (filter (== a) bc)
-------------
howManyEvens :: [Int] -> Int
HowManyEvens l = length [ x | x <- 1, even x ]

howManyOdds :: [Int] -> Int
HowManyOdds l = length [ x | x <- 2, odd x ]

2E

checkPrime x = not $ any divisible $ doThisIf notHuge [2..] where
     divisible y = x `mod`y == 0
     notHuge y = y*y <= x

--- Even using StackOverflow a lot, this is where I lost any real ability to do it.
--- Grade will not be good. Odin, let mine grade stayeth a C.

