--Ejercicio 7
listasQueSuman::Int->[[Int]]
listasQueSuman 0 = [[]]
listasQueSuman n = [[ys]++xs|ys <- [1..n], xs <- listasQueSuman (n - ys)]
--Ejercicio 9
prp xs ys = foldr (:) ys xs

sumaAlt :: [Int] -> Int
sumaAlt = foldr (\x xs -> x + ((-1)*xs)) 0
--Ejercicio 10
partes::[a]->[[a]]
partes [] = [[]]
partes (x:xs) = [(x:ys)|ys<-(partes xs)] ++ (partes xs)

prefijos::[a]->[[a]]
prefijos xs = [(take x xs)|x<-[0..(length xs)]]

prefijos2::[a]->[[a]]
prefijos2 xs = [(take x xs)|x<-[1..(length xs)]]

sublistas::[a]->[[a]]
sublistas [] = [[]]
sublistas xs = (prefijos2 xs)++(sublistas (tail xs))
--Ejercicio 11
sacarUna::Eq a => a->[a]->[a]
sacarUna x xs = (fst (break (==x) xs)) ++ (tail (snd (break (==x) xs)))

permutaciones::Eq a => [a]->[[a]]
permutaciones [] = [[]]
permutaciones xss = [x:xs | x<-xss, xs<-permutaciones (sacarUna x xss)]
--Ejercicio 12
genLista::Int->a->(a->a)->[a]
genLista 0 _ _ = []
genLista n x f = x:(genLista (n-1) (f x) f)

desdeHasta::Int->Int->[Int]
desdeHasta a b = genLista (b-a+1) a (+1)
--Ejercicio 13
mapPares::(a->b->c)->[(a,b)]->[c]
mapPares _ [] = []
mapPares f (x:xs) = (uncurry f x):(mapPares f xs)

armarPares::[a]->[b]->[(a,b)]
armarPares [] _ = []
armarPares _ [] = []
armarPares (x:xs) (y:ys) = (x,y):(armarPares xs ys)

mapDoble::(a->b->c)->[a]->[b]->[c]
mapDoble f xs ys = mapPares f (armarPares xs ys)
--Ejercicio 14
sumaMat :: [[Int]] -> [[Int]] -> [[Int]]
sumaMat (xs:xss) (ys:yss) = (zipWith (+) xs ys) : (sumaMat xss yss)
sumaMat _ _ = []

heads::[[a]]->[a]
heads  = foldr (\y rec->(head y):rec) []

tails::[[a]]->[[a]]
tails = foldr (\y rec->(tail y):rec) [] 

transponer::[[Int]]->[[Int]]
transponer [] = []
transponer xss | length (head xss) == 1 = [(heads xss)]
			   |otherwise =(heads xss):(transponer (tails xss))

zipWithList::(a->b->b)->b->[[a]]->[b]
zipWithList _ _ [] = []
zipWithList f base xss | length (head xss) == 1 = [foldr f base (heads xss)]
                       |otherwise = (foldr f base (heads xss)):(zipWithList f base (tails xss))
--Ejercicio 15
generate::([a]->Bool)->([a]->a)->[a]
generate stop next = generateFrom stop next []

generateFrom::([a]->Bool)->([a]->a)->[a]->[a]
generateFrom stop next xs | stop xs = xs
						  | otherwise = generateFrom stop next (xs ++ [next xs])

generateBase::([a]->Bool)->a->(a->a)->[a]
generateBase stop base next = generate stop (\xs -> if ((length xs) == 0) then base else (next (last xs)))

factoriales::Int->[Int]
factoriales n = generate (\xs -> not (null xs) && ((length xs) == n)) (\ys -> if (null ys) then 1 else (last ys)*(length ys +1))

iterateN::Int->(a->a)->a->[a]
iterateN n f x = generateBase (\xs -> not (null xs) && ((length xs) == n)) x f

--Ejercicio 16
dac :: b -> (a -> b) -> ([a] -> ([a],[a])) -> ([a] -> b -> b -> b) -> [a] -> b
dac base base1 divide combine [] = base
dac base base1 divide combine [x] = base1 x
dac base base1 divide combine input = combine input (rec izquierda) (rec derecha)
	where rec = dac base base1 divide combine
		izquierda = fst (divide input)
		derecha = snd (divide input)