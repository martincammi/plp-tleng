%distEd(+S,+T,?D)
%distEd([],T,D) :- length(T,D), binaria(T,D).
%distEd(S,[],D) :- length(S,D), D>0, binaria(S,D). %D>0 para evitar duplicados en caso [] []
%distEd([X|XS],[Y|YS],D) :- distEd(XS,YS,Intercambiar), NewIntercambiar is (Intercambiar + abs(X-Y)),	%intercambio elementos
%			   distEd([X|XS],YS,Eliminar), NewEliminar     is (Eliminar + 1),		%elimino elemento
%			   distEd(XS,[Y|YS],Agregar),  NewAgregar      is (Agregar + 1),		%agrego elemento
%			   minimo(NewIntercambiar,NewEliminar,NewAgregar,D).

%distEd(+S,?T,?D)
%distPref(X,Y,N) :- not(is_list(Y)), not(ground(N)), desde(0,N), distPref(X,Y,N). 
%distPref([],YS,N) :- not(is_list(YS)), ground(N), binaria(YS,N).

distEd(S,T,D)  :- not(is_list(T)), not(ground(D)), desde(0,LengthT), binaria(T,LengthT), distEd(S,T,D). %defino la lista T a usar (SE CUELGA CUANDO ENCONTRE TODAS LAS SOLUCIONES!)
distEd(S,T,D)  :- 	not(is_list(T)), ground(D), 
					length(S,LengthS), 
					MaxCantOperaciones is LengthS + D, 
					entre(0,MaxCantOperaciones,LengthT),
					binaria(T,LengthT), 
					distEd(S,T,D). %acoto la cantidad max de operaciones!!!
distEd([],T,D) :- length(T,D), binaria(T,D).
distEd(S,[],D) :- length(S,D), D>0, binaria(S,D). %D>0 para evitar duplicados en caso [] []
distEd([X|XS],[Y|YS],D) :- length([X|XS], LengthX), binaria([X|XS],LengthX),
			   is_list(YS),
			   entre(0,1,Y),
			   distEd(XS,YS,Intercambiar), NewIntercambiar is (Intercambiar + abs(X-Y)),	%intercambio elementos
			   distEd([X|XS],YS,Eliminar), NewEliminar     is (Eliminar + 1),		%elimino elemento
			   distEd(XS,[Y|YS],Agregar),  NewAgregar      is (Agregar + 1),		%agrego elemento
			   minimo(NewIntercambiar,NewEliminar,NewAgregar,D).

testEd1(N) :- distEd([1],[],N).
testEd2(N) :- distEd([],[1],N).
testEd3(N) :- distEd([1],[1],N).
testEd4(N) :- distEd([],[],N).
testEd5(N) :- distEd([1,0,1],[1,1],N).
testEd6(N) :- distEd([1,0],[1,1,0],N).
testEd7(X,N) :- distEd([1,0,1],[X,0,1],N).
testEd8(X,N) :- distEd([1,0,1],[X,0,X,1,0],N).
testEd9(Y,X,N) :- distEd([1,0,0,1,1],[X,0,Y],N).
testEd10(Y) :- distEd([0,0,0],Y,2).
testEd11(Y,N) :- distEd([0,0,0],Y,N).
testEd12(Y,N) :- distEd([0,0,0],[0|Y],N).
testEd13(Y,N) :- distEd([0,0,0],[1|Y],N).
testEd14(Y,X,N) :- distEd([0,0,0],[1,X|Y],N).
			   
			   
%entre(+X, +Y, -Z)
entre(X,Y,X) :- X=<Y.
entre(X,Y,Z) :- X<Y, Xm1 is X+1, entre(Xm1, Y, Z).

%Binaria(?L,+N)
binaria([], 0).
binaria([Y|YS], N) :- entre(0,1,V), Y is V, ACUM is (N - 1), ACUM >= 0, binaria(YS,ACUM).
	
%desde(+X,-Y)
desde(X,X).
desde(X,Y) :- Z is X+1, desde(Z,Y).

						
minimo(A,B,C,Res) :- A<B, minimoAux(A,C,Res).
minimo(A,B,C,Res) :- A>B, minimoAux(B,C,Res).
minimo(A,B,C,Res) :- A=B, minimoAux(A,C,Res).

minimoAux(C,D,Res) :- C<D, Res is C.
minimoAux(C,D,Res) :- C>D, Res is D.
minimoAux(C,D,Res) :- C=D, Res is C.

