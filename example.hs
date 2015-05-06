naturalNumbers :: Int -> [Int]
naturalNumbers 0 = []
naturalNumbers n = naturalNumbers (n -1) ++ [n]
