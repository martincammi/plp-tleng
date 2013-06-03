
%distEd(+S,+T,?D)
distEd([],T,D) :- length(T,D), binaria(T,D).
distEd(S,[],D) :- length(S,D), binaria(S,D).
distEd([X|XS],[Y|YS],D) :- 	distEd(XS,YS,Intercambiar), NewIntercambiar is (Intercambiar + abs(X -Y)),	%intercambio elementos
							distEd([X|XS],YS,Eliminar), NewEliminar 	is (Eliminar + 1),				%elimino elemento
							distEd(XS,[Y|YS],Agregar),  NewAgregar 		is (Agregar + 1),				%agrego elemento
							minimo(NewIntercambiar,NewEliminar,NewAgregar,D).
%entre(+X, +Y, -Z)
entre(X,Y,X) :- X=<Y.
entre(X,Y,Z) :- X<Y, Xm1 is X+1, entre(Xm1, Y, Z).

%1 si la lista no instanciada ya tiene una longitud fija, cortamos al superar la cota del resultado.
%Binaria(?L,+N)
binaria([], 0).
binaria([Y|YS], N) :- entre(0,1,V), Y is V, ACUM is (N - 1), ACUM >= 0, binaria(YS,ACUM).
							
minimo(A,B,C,Res) :- A=<B, B=<C, Res is A.
minimo(A,B,C,Res) :- A=<C, C=<B, Res is A.
minimo(A,B,C,Res) :- B=<A, A=<C, Res is B.
minimo(A,B,C,Res) :- B=<C, C=<A, Res is B.
minimo(A,B,C,Res) :- C=<A, A=<B, Res is C.
minimo(A,B,C,Res) :- C=<B, B=<A, Res is C.


