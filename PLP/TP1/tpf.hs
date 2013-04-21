import Prelude

-- definiciones auxiliares
third :: (a,b,c) -> c
third (_,_,c) = c

first :: (a,b,c) -> a
first (a,_,_) = a

second :: (a,b,c) -> b
second (_,b,_) = b

-- El traductor se representa por un conjunto de estados "q",
--   - una funcion de transicion (primer parametro),
--   - una funcion de output (segundo parametro) y
--   - un estado inicial.
type Traductor q = (q -> Char -> q, q -> Char -> String, q)

-- Traductor que cambia las "a"s por "e"s y viceversa.
cambiarAE :: Traductor ()
cambiarAE = (const, g, ())
  where
    g :: () -> Char -> String
    g () 'a' = ['e']
    g () 'e' = ['a']
    g ()  x  = [x]

-- Traductor que intercambia caracteres consecutivos.
intercambiarConsecutivos :: Traductor (Maybe Char)
intercambiarConsecutivos = (f, g, Nothing)
	where
		f :: Maybe Char -> Char -> Maybe Char
		f state character = case state of 
							Nothing -> Just character
							_ -> Nothing
		--
		g :: Maybe Char -> Char -> String
		g state character = case state of
							Nothing -> []
							Just previous -> [character] ++ [previous]

-- Traductor que sea la identidad, salvo que nunca genera
-- salida output de las "a"s y, cuando aparece una "z",
-- muestra la "z" y luego todas las "a"s que se acumularon
-- juntas.
acumularAes :: Traductor Int
acumularAes = (f, g, 0)
  where
    f :: Int -> Char -> Int
    f x 'a' = x + 1
    f x 'z' = 0
    f x  c  = x
    --
    g :: Int -> Char -> String
    g x 'z' = 'z':(replicate x 'a')
    g x 'a' = [ ]
    g x  c  = [c]

-- Traductor que de vuelta (ie. espeje) todo lo que esta
-- entre dos "a"s consecutivas.
espejarEntreAs :: Traductor String
espejarEntreAs = (f, g, [])
	where
		f :: String -> Char -> String
		f camino caracter = case caracter of
							'a' -> []
							x -> camino ++ [caracter]
		--
		g :: String -> Char -> String
		g camino caracter = case caracter of
							'a' -> (reverse camino) ++ [caracter]
							x -> []		
		
espejarEntreAs' :: Traductor String
espejarEntreAs' = (\camino caracter  -> fEspejar camino caracter,
				   \camino caracter -> gEspejar camino caracter, [])		

fEspejar :: String -> Char -> String
fEspejar camino caracter = case caracter of
							'a' -> []
							x -> camino ++ [caracter]

gEspejar :: String -> Char -> String
gEspejar camino caracter = case caracter of
							'a' -> (reverse camino) ++ [caracter]
							x -> []	
									
-- Calcular la clausura de Kleene de la funcion de
-- transicion pasada como parametro
-- (version recursiva explicita).
fAst' :: (q -> Char -> q) -> q -> String -> q
fAst' f q0    ""  = q0
fAst' f q0 (c:cs) = fAst' f (f q0 c) cs

-- Calcular la clausura de Kleene de la funcion de
-- transicion pasada como parametro
-- (version con esquemas de recursion).
fAst :: (q -> Char -> q) -> q -> String -> q
fAst = foldl 

-- Calcular la clausura de Kleene de la funcion de
-- salida pasada como parametro junto con la funcion
-- de transicion pasada como parametro
-- (version recursiva explicita).

gAst' :: (q -> Char -> q) -> (q -> Char -> String) ->
        q -> String -> String
gAst' f g q0    ""  = ""
gAst' f g q0 (c:cs) = (g q0 c) ++ gAst' f g (f q0 c) cs

-- Calcular la clausura de Kleene de la funcion de salida
-- pasada como parametro junto con la funcion de
-- transicion pasada como parametro
-- (version con esquemas de recursion).
--gAst :: (q -> Char -> q) -> (q -> Char -> String) ->
--        q -> String -> String
-- gAst f g q0 cadena = foldr (\x frec -> (g (f q0 x) x) ++ frec) q0 cadena
-- gAst f g q0 cadena = foldr (\x frec -> ) (g q0 c) cadena

-- Calcular la clausura de Kleene de la funcion de salida
-- pasada como parametro junto con la funcion de
-- transicion pasada como parametro
-- (version con esquemas de recursion).
gAst :: (q -> Char -> q) -> (q -> Char -> String) -> q -> String -> String
gAst f g q0 lista = unzipG g (zipF f q0 lista)

-- Mariano
gAstLOCO f g q0 lista = concat [ g (getQ0Loco f q0 (take i lista)) ((!!) lista i) | i <- [1..] ]
getQ0Loco f q0 sublista = fst (last (zipF f q0 sublista))

zipF :: (q-> Char -> q) -> q -> String -> [(q,Char)]
zipF f q0 (l1:lista) = foldl (\rec charLista -> rec ++ [(f (fst (last rec)) (snd (last rec)) , charLista)]) [(q0,l1)] lista
--zipF f q0 (l1:lista) = foldl3 (\rec charLista -> rec ++ [(f (fst (last rec)) (snd (last rec)) , charLista)]) [(q0,l1)] lista

-- Este foldl2 es foldl definido con foldr para permitir la evaluacion de cosas infinitas.
-- foldl2 f base xs = foldr (\x frec baseAcum -> frec (f baseAcum x)) id xs base
foldl3 f a bs = foldr (\b g x -> g (f x b)) id bs a

--foldt f g base xs = foldr (\x frec -> (funcg  frec (f baseAcum x))) id xs g

unzipG :: (q -> Char -> String) -> [(q,Char)] -> String
unzipG g items = foldr (\item rec -> (uncurry g item) ++ rec) [] items
		
-- Dado un traductor, retornar la funcion String -> String
-- que resulta al aplicarlo a cualquier entrada
aplicando :: Traductor q -> String -> String
aplicando (f, g, q) = gAst f g q   --es lo mismo que evaluar!

-- Dados dos traductores, dar un traductor tal que la
-- funcion String -> String que denota el resultado, sea
-- justo la composicion de las funciones de cada
-- uno de los parametros.
comp :: Traductor qq1 -> Traductor qq2 -> Traductor (qq1, qq2)
comp (f1, g1, qinicial1) (f2, g2, qinicial2) = 
					 (
					  \(q1,q2) caracter -> (fAst f1 q1 (g2 q2 caracter), f2 q2 caracter), --F es tupla de estados
					  \(q1,q2) caracter -> (gAst f1 g1 q1 (g2 q2 caracter)),	--G es string
					  (qinicial1, qinicial2)
					  )
								  
-- Dado un traductor, dar la cadena infinita que resulta de
-- procesar una lista infinita de "a"s (si se pide
-- "take n (salidaAes t)" no puede procesar infinitamente
-- para ningun "n")
salidaAes :: Traductor q -> String
salidaAes traductor = evaluar traductor ['a'| x<-[0..]]  

--

evaluar :: Traductor q -> String -> String
evaluar traductor cadena = gAstLOCO (first traductor) (second traductor) (third traductor) cadena

-- Decidir si es posible que el traductor dado de la salida
-- dada como segundo parametro
salidaPosible :: Traductor q -> String -> Bool
salidaPosible traductor cadena = (foldr (\x frec -> ((aplicando traductor x) == cadena) || frec) False (subcadenasDeNumeros (length cadena)))

-- Evalua todas las salidas posibles de strings de numeros para un traductor.
verSalidaPosible :: Traductor q -> String -> [String]
verSalidaPosible traductor cadena = (foldr (\x frec -> [(aplicando traductor x)] ++ frec) [[]] (subcadenasDeNumeros (length cadena)))

-- Devuelve todos los string de números "suficientes" para probar
subcadenasDeNumeros :: Int -> [String]
subcadenasDeNumeros longitud = [ xs | number <- [0..(10^(longitud))], longCadena <- [(length (show number))..longitud], xs <- [completarConCero number longCadena] ]
  
-- Completa un número con ceros no significativos.
completarConCero ::  Int -> Int -> String
completarConCero 0 longStr = replicate longStr '0' 
completarConCero number longStr =  (replicate (longStr - (length (show number))) '0') ++ (show number)

-- Traductor que cambia las "a"s por "e"s y viceversa.
cambiar10 :: Traductor ()
cambiar10 = (const, g, ())
  where
    g :: () -> Char -> String
    g () '1' = ['0']
    g ()  x  = [x]



