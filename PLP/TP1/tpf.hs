import Prelude
import Char

-- Universidad de Buenos Aires
-- Facultad de Ciencias exactas y naturales
-- Paradigmas de Lenguajes de Programacion
-- 1er Cuatrimestre 2013
-- Integrantes:
-- Cammi, Martin
-- De Sousa, Mariano
-- Felisatti, Ana

-- Tests Ejecutar testAll para probar todos los tests de todos los ejercicios
testAll = testIntercambiar && testEspejar && testfAst && testgAst && testSalidaAes && testSalidaPosible

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

testIntercambiar = test0 && test1 && test2
test0 = (aplicando intercambiarConsecutivos "av") == "va"
test1 = (aplicando intercambiarConsecutivos "abcdbacc") == "badcabcc"
test2 = (aplicando intercambiarConsecutivos "ohal") == "hola"


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

-- f se encarga de acumular los caracteres hasta que aparezca una 'a', 
-- g entonces espeja lo acumulado por f y lo concatena a la 'a' recibida.
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

testEspejar = testE0 && testE1 && testE2 && testE3 && testE4 && testE5
testE0 = (aplicando espejarEntreAs "123a456aa789a") == "321a654aa987a"
testE1 = (aplicando espejarEntreAs "a1a") == "a1a"
testE2 = (aplicando espejarEntreAs "123a") == "321a"
testE3 = (aplicando espejarEntreAs "aaaa123aaaa") == "aaaa321aaaa"
testE4 = take 10 (aplicando espejarEntreAs (concat ["bca" | i <- [1..]])) == "cbacbacbac"
testE5 = take 10 (aplicando espejarEntreAs ("bcde" ++ ['a'| x<-[0..]])) == "edcbaaaaaa"
									
-- Calcular la clausura de Kleene de la funcion de
-- transicion pasada como parametro
-- (version recursiva explicita).
fAst' :: (q -> Char -> q) -> q -> String -> q
fAst' f q0    ""  = q0
fAst' f q0 (c:cs) = fAst' f (f q0 c) cs

-- Calcular la clausura de Kleene de la funcion de
-- transicion pasada como parametro
-- (version con esquemas de recursion).

-- El esquema definido para fAst' corresponde al esquema de foldl
fAst :: (q -> Char -> q) -> q -> String -> q
fAst = foldl
 
testfAst = testCantidadAes && testSumaNumeros && testConstante
testConstante = fAst (\q c -> q) 5 "cadena" == 5
testCantidadAes = fAst (\q c -> (if c == 'a' then 1 else 0) + q) 0 "papa" == 2
testSumaNumeros = fAst (\q c -> ((charToInt c) + q)) 0 "1234" == 10

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

-- El parametro que cambia en la recursion de gAst' es q0, el cual es recalculado como f q0 c (en cada llamada).
-- Para definir gAst con foldr es necesario abstraer a q0 para que sea recalculado en cada llamado recursivo
gAst f g q0 cs = gAstAux f g cs q0
gAstAux f g = foldr (\c rec -> (\q0 -> (g q0 c) ++ (rec (f q0 c)))) (\q -> [])

testgAst = testAlgoInfinit && repetirDeApares
repetirDeApares = gAst (\q c -> [c]) (\q c -> q++[c]) "" "martin" == "mmaarrttiin"
testAlgoInfinit = take 20 (gAst (\q c -> q) (\q c -> c:q) "" ['a'| x<-[0..]]) == "aaaaaaaaaaaaaaaaaaaa"
testAlgoInfinit2 = (gAst (\q c -> q) (\q c -> c:q) "" ['a'| x<-[0..]])

-- Dado un traductor, retornar la funcion String -> String
-- que resulta al aplicarlo a cualquier entrada
aplicando :: Traductor q -> String -> String
aplicando (f, g, q) = gAst f g q

-- Dados dos traductores, dar un traductor tal que la
-- funcion String -> String que denota el resultado, sea
-- justo la composicion de las funciones de cada
-- uno de los parametros.

-- El traductor compuesto maneja dos estados (uno por cada traductor). Los parametros resultantes son:
-- f = (qTrad1, qTrad2) donde:
--	qTrad2 = corresponde al cambio de estado del traductor 2 leyendo el caracter de entrada
--	qTrad1 = corresponde al cambio de estado del traductor 1 leyendo el string que traduce el traductor 2 
--		    (notar que como se lee un string, debe aplicar fAst)
-- g = String donde:
--	es el resultado de traducir con el traductor 1, el resultado de la traduccion del caracter en el traductor 2.
comp :: Traductor qq1 -> Traductor qq2 -> Traductor (qq1, qq2)
comp (f1, g1, qinicial1) (f2, g2, qinicial2) = 
					 (
					  \(q1,q2) caracter -> (fAst f1 q1 (g2 q2 caracter), f2 q2 caracter), 	--F es tupla de estados
					  \(q1,q2) caracter -> (gAst f1 g1 q1 (g2 q2 caracter)),		--G es string
					  (qinicial1, qinicial2)						--Estado compuesto
					  )
testComp = testCompId && testComp && testCompComp
testCompId = aplicando (comp cambiarAE cambiarAE) "SiDevuelveEstoEstaBien" == "SiDevuelveEstoEstaBien" 
testComp2 = aplicando (comp cambiarAE cambiarEA) "Pepa" == "Pepe"
testCompComp = aplicando (comp cambiarAE cambiarEA) "Pepa" == ((aplicando cambiarAE) . (aplicando cambiarEA)) "Pepa"

-- Traductor que cambia las "e"s por "a"s y viceversa.
cambiarEA :: Traductor ()
cambiarEA = (const, g, ())
  where
    g :: () -> Char -> String
    g () 'e' = ['a']
    g ()  x  = [x]			
					  
-- Dado un traductor, dar la cadena infinita que resulta de
-- procesar una lista infinita de "a"s (si se pide
-- "take n (salidaAes t)" no puede procesar infinitamente
-- para ningun "n")
salidaAes :: Traductor q -> String
salidaAes traductor = aplicando traductor ['a'| x<-[0..]]  

testSalidaAes = testSalida1 && testSalida2
testSalida1 = take 1000 (salidaAes cambiarAE) == ['e'| x<-[0..999]]  
testSalida2 = take 10 (salidaAes (comp acumularAes cambiarAE)) == "eeeeeeeeee"

-- Decidir si es posible que el traductor dado de la salida
-- dada como segundo parametro++

-- Dado un string de entrada se generan todas las cadenas numericas con largo menor igual a la longitud de la entrada
-- luego, se evalua cada una de estas cadenas en el traductor verificando su coincidencia con la cadena de entrada
salidaPosible :: Traductor q -> String -> Bool
salidaPosible traductor cadena = (foldr (\x frec -> ((aplicando traductor x) == cadena) || frec) False (subcadenasDeNumeros (length cadena)))

-- Devuelve todas las cadenas numericas con largo menor igual a la longitud pasada como parametro
subcadenasDeNumeros :: Int -> [String]
subcadenasDeNumeros longitud = [ xs | number <- [0..(10^(longitud))], longCadena <- [(length (show number))..longitud], xs <- [completarConCero number longCadena] ]
  
-- Completa un número (primer parametro) con ceros no significativos
-- la cantidad de apariciones la define el segundo parametro.
completarConCero ::  Int -> Int -> String
completarConCero 0 longStr = replicate longStr '0' 
completarConCero number longStr =  (replicate (longStr - (length (show number))) '0') ++ (show number)

-- Evalua todas las salidas posibles de strings de numeros para un traductor.
verSalidaPosible :: Traductor q -> String -> [String]
verSalidaPosible traductor cadena = (foldr (\x frec -> [(aplicando traductor x)] ++ frec) [[]] (subcadenasDeNumeros (length cadena)))

-- Traductor que cambia las "1"s por "0"s y viceversa.
cambiar10 :: Traductor ()
cambiar10 = (const, g, ())
  where
    g :: () -> Char -> String
    g () '1' = ['0']
    g ()  x  = [x]

-- Traductor que cambiar cualquier caracter por "0"
cambiarPor0 :: Traductor ()
cambiarPor0 = (const, g, ())
  where
    g :: () -> Char -> String
    g ()  x  = ['0']

testSalidaPosible = testSalPos1 && testSalPos2 && testSalPos3 && testSalPos4 && testSalPos5 && testSalPos6 && testSalPos7
testSalPos1 = salidaPosible cambiar10 "1" == False
testSalPos2 = salidaPosible cambiar10 "0" == True
testSalPos3 = salidaPosible cambiar10 "10" == False
testSalPos4 = salidaPosible cambiar10 "20" == True

testSalPos5 = salidaPosible cambiarPor0 "123" == False
testSalPos6 = salidaPosible cambiarPor0 "0" == True
testSalPos7 = salidaPosible cambiarPor0 "00" == True

charToInt :: Char -> Int
charToInt c = (ord c) - 48



