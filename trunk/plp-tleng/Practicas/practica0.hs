--Ejercicio 2
valorAbsoluto::Float->Float
valorAbsoluto x | x >= 0 = x
valorAbsoluto x | x < 0 = (-1)*x

bisiesto::Int->Bool
bisiesto x | x `mod` 400 == 0 = True
bisiesto x | x `mod` 100 == 0 = False
bisiesto x | x `mod` 4 == 0 = True
bisiesto x | otherwise = False

factorial::Int->Int
factorial 0 = 1
factorial n | n > 0 = n * factorial (n-1)

esPrimo::Int->Bool
esPrimo n = null [ x | x<-[2 .. floor (sqrt (fromIntegral n))], n `mod` x == 0]

cantidadDeDivisoresPrimos::Int->Int
cantidadDeDivisoresPrimos n = length [ y | y <-[2 .. floor (sqrt (fromIntegral n))], esPrimo y, n `mod` y ==0]

--Ejercicio 3
--data Maybe a = Nothing | Just a
inverso::Float->Maybe Float
inverso x | x == 0 = Nothing
inverso x | otherwise = Just (1/x)
-- data Either a b = Left a | Right b
aEntero::Either Int Bool->Int
aEntero (Left n) = n
aEntero (Right p) = if p then 1 else 0

--Ejercicio 4
limpiar::[Char]->[Char]->[Char]
limpiar [] ys = ys
limpiar (x:xs) ys = limpiar xs (filter (/=x) ys)

diffPromedio::[Float]->[Float]
diffPromedio [] = []
diffPromedio xs = map (subtract((sum xs)/ (fromIntegral (length xs)))) xs

todosIguales::[Int]->Bool
--todosIguales [] = True
--todosIguales (x:xs) = (length (filter (==x) xs)) == (length xs)
--todosIguales x:xs = foldr check True
--where check x b = (x==5) && b
--Ejercicio 5
data AB a = Nil | Bin (AB a) a (AB a) deriving Show

vacioAB::AB a->Bool
vacioAB (Nil) = True
vacioAB (Bin l c r) = False

negacionAB::AB Bool->AB Bool
negacionAB (Nil) = Nil
negacionAB (Bin l c r) = if c then (Bin (negacionAB l) False (negacionAB r)) else (Bin (negacionAB l) True (negacionAB r))

productoAB::AB Int->Int
productoAB Nil = 1
productoAB (Bin l c r) = c*(productoAB l)*(productoAB r)