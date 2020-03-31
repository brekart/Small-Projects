import Debug.Trace
makelist x = if x > 0 then (trace("\nx is now "++ show x)) $ (x:(makelist (x-1))) else [0]
