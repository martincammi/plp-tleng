
%distanciaHamming(+L1, +L2, ?D)
%distanciaHamming([], [], 0).
%distanciaHamming([X|Y],[W|Z], N) :- distanciaHamming(Y,Z,ACUM),  N is ACUM + abs(X-W).

%entre(+X, +Y, -Z)
entre(X,Y,X) :- X=<Y.
entre(X,Y,Z) :- X<Y, Xm1 is X+1, entre(Xm1, Y, Z).

%distanciaHamming(+L1, ?L2, ?D)
distanciaHamming([], [], 0).
distanciaHamming([X|XS], [Y|YS], N) :- entre(0,1,V), Y is V, distanciaHamming(XS,YS,ACUM), N is ACUM + abs(Y-X).

testdh1(N) :- distanciaHamming([],[0],N).
testdh2(N) :- distanciaHamming([0,1],[0,1],N).
testdh3(N) :- distanciaHamming([0,1,0],[0,0,1],N). 
testdh4(X,Y,N) :- distanciaHamming([0,1,0],[X,Y,1],N). 
testdh5(X) :- distanciaHamming([0,1,0],X,2).
testdh6(N) :- distanciaHamming([plp],[plp],N).

%distPref(+S, ?T, ?D)
%distPref([],YS,N) :- ground(YS), length(YS,N), binaria(YS,N). %1
%distPref([],YS,N) :- not(ground(YS)), not(ground(N)), desde(0,M), binaria(YS,M), N is M. %2
%distPref([],YS,N) :- not(ground(YS)), ground(N), binaria(YS,N). %3 
%distPref(XS, [],N):- length(XS,N), N>0, binaria(XS,N). %4	
%distPref([X|XS],[Y|YS],N) :- entre(0,1,X), entre(0,1,Y), X==Y, distPref(XS,YS,N). %5
%distPref([X|XS],[Y|YS],N) :- entre(0,1,X), entre(0,1,Y), X=\=Y,     ground(YS),  length(XS,LengthXS), length(YS,LengthYS), 	N is (LengthXS+LengthYS+2). %6
%distPref([X|XS],[Y|YS],N) :- entre(0,1,X), entre(0,1,Y), X=\=Y, not(ground(YS)), not(ground(N)), length(XS,LengthXS), distPref([],YS,ACUM), N is (ACUM+LengthXS+2). %7
%distPref([X|XS],[Y|YS],N) :- entre(0,1,X), entre(0,1,Y), X=\=Y, not(ground(YS)), 	  ground(N), length(XS,LengthXS), ACUM is (N-LengthXS-2), distPref([],YS,ACUM).	%8		  

%1 -- si esta instancia ys => validar calcular longitud
%2 -- sino => generar todas las listas e ir devolviendo su longitud (tbm generada)
%3 -- sino => generar todas las listas de longitud N
%4 -- calcula la longitud de XS validando que sea una lista binaria (no vacia)
%5 -- elimina prefijo instanciando Y como cada item del prefijo
%6 -- si ambas listas estan definidas direcamente calcula sus longitudes
%7 -- defino / valido el 1 er elemento de [Y|YS] y de ser distinto necesito generar el resto de la lista (N no definida)
%8 -- defino / valido el 1 er elemento de [Y|YS] y de ser distinto necesito generar el resto de la lista (N definida)

distPref(X,Y,N)   :- not(ground(Y)), not(ground(N)), desde(0,N), distPref(X,Y,N).
distPref([],YS,N) :- ground(YS), length(YS,N), binaria(YS,N). %1
distPref([],YS,N) :- not(ground(YS)), binaria(YS,N). %3 
distPref(XS, [],N):- length(XS,N), N>0, binaria(XS,N). %4	
distPref([X|XS],[Y|YS],N) :- entre(0,1,X), entre(0,1,Y), X==Y, distPref(XS,YS,N). %5
distPref([X|XS],[Y|YS],N) :- entre(0,1,X), entre(0,1,Y), X=\=Y,     ground(YS),  length(XS,LengthXS), binaria(XS,LengthXS), length(YS,LengthYS), binaria(YS, LengthYS),	N is (LengthXS+LengthYS+2). %6
distPref([X|XS],[Y|YS],N) :- entre(0,1,X), entre(0,1,Y), X=\=Y, not(ground(YS)), length(XS,LengthXS), ACUM is (N-LengthXS-2), distPref([],YS,ACUM).	%8		  

%1 si la lista no instanciada ya tiene una longitud fija, cortamos al superar la cota del resultado.
%Binaria(?L,+N)
binaria([], 0).
binaria([Y|YS], N) :- entre(0,1,V), Y is V, ACUM is (N - 1), ACUM >= 0, binaria(YS,ACUM).

%desde(+X,-Y)
desde(X,X).
desde(X,Y) :- Z is X+1, desde(Z,Y).

%distEd(+S,+T,?D)
distEd([],T,D) :- length(T,D), binaria(T,D).
distEd(S,[],D) :- length(S,D), binaria(S,D).
distEd([X|XS],[Y|YS],D) :- 	distEd(XS,YS,Intercambiar), NewIntercambiar is (Intercambiar + abs(X -Y)),	%intercambio elementos
							distEd([X|XS],YS,Eliminar), NewEliminar 	is (Eliminar + 1),				%elimino elemento
							distEd(XS,[Y|YS],Agregar),  NewAgregar 		is (Agregar + 1),				%agrego elemento
							minimo(NewIntercambiar,NewEliminar,NewAgregar,D).
							
minimo(A,B,C,Res) :- A=<B, B=<C, Res is A.
minimo(A,B,C,Res) :- A=<C, C=<B, Res is A.
minimo(A,B,C,Res) :- B=<A, A=<C, Res is B.
minimo(A,B,C,Res) :- B=<C, C=<A, Res is B.
minimo(A,B,C,Res) :- C=<A, A=<B, Res is C.
minimo(A,B,C,Res) :- C=<B, B=<A, Res is C.