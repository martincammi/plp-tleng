%distEd(+S,?T,?D)
%caso infinitas soluciones: sanitizamos S e instanciamos todas las posibles listas T,
%calculando para cada caso el D obtenido 
distEd(S,T,D)  :- not(is_list(T)), not(ground(D)), 
					length(S,LengthS), binaria(S,LengthS), 		%chequea que S sea una lista binaria		
					desde(0,LengthT), 
					binaria(T,LengthT), 
					distEd(S,T,D). 
%caso lista T no acotada pero finitas soluciones.
%el tamaño de la lista T se ve acotado por la longitud de S mas D, representando la cantidad de operaciones a efectuar.
%si T fuera mas larga, implicaria que se tiene que hacer mas de D pasos para llegar a S, absurdo.
%por lo tanto, se instancia T con todas las posibles lista binarias de tamaño menor igual a esa cota.
distEd(S,T,D)  :- not(is_list(T)), ground(D),  
					length(S,LengthS), binaria(S,LengthS),  	%chequea que S sea una lista binaria
					LongitudMaxima is LengthS + D,  		%acoto la cantidad max de operaciones!!!
					entre(0,LongitudMaxima,LengthT),
					binaria(T,LengthT), 
					distEd(S,T,D). 
%caso base, todo instanciado
distEd([],T,D) :- length(T,D), binaria(T,D).
distEd(S,[],D) :- length(S,D), D>0, binaria(S,D). %D>0 para evitar duplicados en caso [] []
%sanitizamos [x|xs].
%is_list garantiza que YS tiene longitud fija.
distEd([X|XS],[Y|YS],D) :- length([X|XS], LengthX), binaria([X|XS],LengthX),
			   is_list(YS),
			   entre(0,1,Y),
			   distEd(XS,YS,Intercambiar), NewIntercambiar is (Intercambiar + abs(X-Y)),	%intercambio elementos
			   distEd([X|XS],YS,Eliminar), NewEliminar     is (Eliminar + 1),		%elimino elemento
			   distEd(XS,[Y|YS],Agregar),  NewAgregar      is (Agregar + 1),		%agrego elemento
			   minimo(NewIntercambiar,NewEliminar,NewAgregar,D).				%calculo el minimo

%Corre todos los tests.
testAll :- call(testEd1(N1)), call(testEd2(N2)), call(testEd3(N3)), call(testEd4(N4)), call(testEd5(N5)), call(testEd6(N6)),
	   call(testEd7A(N7A)), call(testEd7B(N7B)), call(testEd7C(N7C)), call(testEd7C(N7C)),
	   call(testEd8(N8A, N8B)),
	   call(testEd9A(N9A1, N9A2)), call(testEd9B(N9B1, N9B2)).
	   %call(testEd10(N10)).

%Tests de instanciación de N
testEd1(N) :- distEd([],[],N), N is 0.
testEd2(N) :- distEd([1],[],N), N is 1.
testEd3(N) :- distEd([],[1],N), N is 1.
testEd4(N) :- distEd([1],[1],N), N is 0.
testEd5(N) :- distEd([1,0,1],[1,1],N), N is 1.
testEd6(N) :- distEd([1,0],[1,1,0],N), N is 1.

%Tests de instanciación de Y
testEd7A(Y) :- distEd([0,0,0],Y,2), member(Y, [[1,1,0]]).
testEd7B(Y) :- distEd([0,0,0],Y,2), member(Y, [[1,0,1]]).
testEd7C(Y) :- distEd([0,0,0],Y,2), member(Y, [[0,1,1]]).
testEd7D(Y) :- distEd([0,0,0],Y,2), member(Y, [[0]]).

%Tests de instanciación de X y N
testEd8(X,N) :- distEd([1,0,1],[X,0,1],N), N is 0, X is 1.
testEd9A(X,N) :- distEd([1,0,1],[X,0,X,1,0],N), X is 1, N is 2.
testEd9B(X,N) :- distEd([1,0,1],[X,0,X,1,0],N), X is 0, N is 3.

%Tests de instanciación de Y y N
testEd11(Y,N) :- distEd([0,0,0],Y,N).
testEd12(Y,N) :- distEd([0,0,0],[0|Y],N).
testEd13(Y,N) :- distEd([0,0,0],[1|Y],N).

%Tests de instanciación de X, Y y N
testEd9(Y,X,N) :- distEd([1,0,0,1,1],[X,0,Y],N), X is 0, Y is 0, N is 3.
testEd14(Y,X,N) :- distEd([0,0,0],[1,X|Y],N).

			   
%entre(+X, +Y, -Z)
entre(X,Y,X) :- X=<Y.
entre(X,Y,Z) :- X<Y, Xm1 is X+1, entre(Xm1, Y, Z).

%Genera todas las listas binarias de longitud N, si L esta instanciada, verifica que sea binaria
%Binaria(?L,+N)
binaria([], 0).
binaria([Y|YS], N) :- entre(0,1,V), Y is V, ACUM is (N - 1), ACUM >= 0, binaria(YS,ACUM).

%desde(+X,-Y)
desde(X,X).
desde(X,Y) :- Z is X+1, desde(Z,Y).

%calcula el minimo						
minimo(A,B,C,Res) :- A<B, minimoAux(A,C,Res).
minimo(A,B,C,Res) :- A>B, minimoAux(B,C,Res).
minimo(A,B,C,Res) :- A=B, minimoAux(A,C,Res).

minimoAux(C,D,Res) :- C<D, Res is C.
minimoAux(C,D,Res) :- C>D, Res is D.
minimoAux(C,D,Res) :- C=D, Res is C.

