
%distPref(+L1, ?L2, ?D)
% caso infinito, sin n definido genero todos los posibles Ns
distPref(X,Y,N) :- not(is_list(Y)), not(ground(N)), desde(0,N), distPref(X,Y,N). 
distPref([],YS,N) :- not(is_list(YS)), ground(N), binaria(YS,N).
distPref([X|XS],[Y|YS],N) :- not(is_list(YS)), ground(N), entre(0,1,X), entre(0,1,Y), X==Y, distPref(XS,YS,N).
distPref([X|XS],[Y|YS],N) :- not(is_list(YS)), ground(N), entre(0,1,X), entre(0,1,Y), X=\=Y, length(XS,LengthXS), binaria(XS,LengthXS), ACUM is (N-LengthXS-2), distPref([],YS,ACUM).	
% caso finito
distPref([],YS,N) :- is_list(YS), length(YS,N), binaria(YS,N).
distPref(XS, [],N):- length(XS,N), N>0, binaria(XS,N). %el N>0 es para no entrar en el caso [] [] por la linea de arriba y esta.
distPref([X|XS],[Y|YS],N) :- is_list(YS), entre(0,1,X), entre(0,1,Y), X==Y,  distPref(XS,YS,N).
distPref([X|XS],[Y|YS],N) :- is_list(YS), entre(0,1,X), entre(0,1,Y), X=\=Y, length(YS,LengthYS), length(XS,LengthXS), binaria(XS,LengthXS), binaria(YS,LengthYS), N is (LengthYS+LengthXS+2).

%entre(+X, +Y, -Z)
entre(X,Y,X) :- X=<Y.
entre(X,Y,Z) :- X<Y, Xm1 is X+1, entre(Xm1, Y, Z).

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
