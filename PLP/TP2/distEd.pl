
%distEd.pl

:- [utils].

%Corre todos los tests.
testAllEd :- test1Ed, test2Ed, test3Ed, test4Ed, test5Ed, test6Ed.

%---EJECRICIOS---

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

%calcula el minimo						
minimo(A,B,C,Res) :- A<B, minimoAux(A,C,Res).
minimo(A,B,C,Res) :- A>B, minimoAux(B,C,Res).
minimo(A,B,C,Res) :- A=B, minimoAux(A,C,Res).

minimoAux(C,D,Res) :- C<D, Res is C.
minimoAux(C,D,Res) :- C>D, Res is D.
minimoAux(C,D,Res) :- C=D, Res is C.

%---TESTS---

%Tests de instanciación de N
test1Ed :-  var(N1),var(N2),var(N3),var(N4),var(N5),var(N6),
	    call(testEd1(N1)), call(testEd2(N2)), call(testEd3(N3)), call(testEd4(N4)), call(testEd5(N5)), call(testEd6(N6)).

testEd1(N) :- distEd([],[],N), N is 0.
testEd2(N) :- distEd([1],[],N), N is 1.
testEd3(N) :- distEd([],[1],N), N is 1.
testEd4(N) :- distEd([1],[1],N), N is 0.
testEd5(N) :- distEd([1,0,1],[1,1],N), N is 1.
testEd6(N) :- distEd([1,0],[1,1,0],N), N is 1.

%Tests de instanciación de Y
test2Ed :- var(N7A),var(N7B),var(N7C),var(N7D),
	   call(testEd7A(N7A)), call(testEd7B(N7B)), call(testEd7C(N7C)), call(testEd7D(N7D)).
testEd7A(Y) :- distEd([0,0,0],Y,2), member(Y, [[1,1,0]]).
testEd7B(Y) :- distEd([0,0,0],Y,2), member(Y, [[1,0,1]]).
testEd7C(Y) :- distEd([0,0,0],Y,2), member(Y, [[0,1,1]]).
testEd7D(Y) :- distEd([0,0,0],Y,2), member(Y, [[0]]).

%Tests de instanciación de elementos X y N
test3Ed :- var(N8A),var(N8B),var(N9A1),var(N9A2),var(N9B1),var(N9B2),
	   call(testEd8(N8A, N8B)), 
	   call(testEd9A(N9A1, N9A2)), call(testEd9B(N9B1, N9B2)).
testEd8(X,N) :- distEd([1,0,1],[X,0,1],N), N is 0, X is 1.
testEd9A(X,N) :- distEd([1,0,1],[X,0,X,1,0],N), X is 1, N is 2.
testEd9B(X,N) :- distEd([1,0,1],[X,0,X,1,0],N), X is 0, N is 3.

%Tests de instanciación de listas Y y N
test4Ed :- var(N10A1),var(N10A2),var(N10B1),var(N10B2),var(N10C1),var(N10C2),var(N10D1),var(N10D2),
   	   call(testEd10A(N10A1, N10A2)), call(testEd10B(N10B1, N10B2)), call(testEd10C(N10C1, N10C2)), call(testEd10D(N10D1, N10D2)).
testEd10A(Y,N) :- distEd([0,0,0],Y,N), member(Y, [[0]]), N is 2, !.
testEd10B(Y,N) :- distEd([0,0,0],Y,N), member(Y, [[1]]), N is 3,!.
testEd10C(Y,N) :- distEd([0,0,0],Y,N), member(Y, [[0,0]]), N is 1,!.
testEd10D(Y,N) :- distEd([0,0,0],Y,N), member(Y, [[0,1]]), N is 2,!.

%Tests de instanciación de colas de listas Y y N
test5Ed :- var(N11A1),var(N11A2),var(N11B1),var(N11B2),
	   var(N11C1),var(N11C2),var(N11D1),var(N11D2),var(N11E1),var(N11E2),var(N11F1),var(N11F2),var(N11G1),var(N11G2),var(N11H1),var(N11H2),
	   var(N11I1),var(N11I2),var(N11J1),var(N11J2),var(N11K1),var(N11K2),var(N12A1),var(N12A2),var(N12B1),var(N12B2),var(N12C1),var(N12C2),
	   var(N12D1),var(N12D2),var(N12E1),var(N12E2),var(N12F1),var(N12F2),var(N12G1),var(N12G2),var(N12H1),var(N12H2),var(N12I1),var(N12I2),
	   var(N12J1),var(N12J2),var(N12K1),var(N12K2),

	   call(testEd11A(N11A1, N11A2)), call(testEd11B(N11B1, N11B2)), call(testEd11C(N11C1, N11C2)), call(testEd11D(N11D1, N11D2)),
	   call(testEd11E(N11E1, N11E2)), call(testEd11F(N11F1, N11F2)), call(testEd11G(N11G1, N11G2)), call(testEd11H(N11H1, N11H2)),
	   call(testEd11I(N11I1, N11I2)), call(testEd11J(N11J1, N11J2)), call(testEd11K(N11K1, N11K2)),

	   call(testEd12A(N12A1, N12A2)), call(testEd12B(N12B1, N12B2)), call(testEd12C(N12C1, N12C2)), call(testEd12D(N12D1, N12D2)),
	   call(testEd12E(N12E1, N12E2)), call(testEd12F(N12F1, N12F2)), call(testEd12G(N12G1, N12G2)), call(testEd12H(N12H1, N12H2)),
	   call(testEd12I(N12I1, N12I2)), call(testEd12J(N12J1, N12J2)), call(testEd12K(N12K1, N12K2)).
testEd11A(Y,N) :- distEd([0,0,0],[0|Y],N), member(Y, [[]]), N is 2, !.
testEd11B(Y,N) :- distEd([0,0,0],[0|Y],N), member(Y, [[0]]), N is 1, !.
testEd11C(Y,N) :- distEd([0,0,0],[0|Y],N), member(Y, [[1]]), N is 2, !.
testEd11D(Y,N) :- distEd([0,0,0],[0|Y],N), member(Y, [[0,0]]), N is 0, !.
testEd11E(Y,N) :- distEd([0,0,0],[0|Y],N), member(Y, [[0,1]]), N is 1, !.
testEd11F(Y,N) :- distEd([0,0,0],[0|Y],N), member(Y, [[1,0]]), N is 1, !.
testEd11G(Y,N) :- distEd([0,0,0],[0|Y],N), member(Y, [[1,1]]), N is 2, !.
testEd11H(Y,N) :- distEd([0,0,0],[0|Y],N), member(Y, [[0,0,0]]), N is 1, !.
testEd11I(Y,N) :- distEd([0,0,0],[0|Y],N), member(Y, [[0,0,1]]), N is 1, !.
testEd11J(Y,N) :- distEd([0,0,0],[0|Y],N), member(Y, [[0,1,0]]), N is 1, !.
testEd11K(Y,N) :- distEd([0,0,0],[0|Y],N), member(Y, [[0,1,1]]), N is 2, !.

testEd12A(Y,N) :- distEd([0,0,0],[1|Y],N), member(Y, [[]]), N is 3, !.
testEd12B(Y,N) :- distEd([0,0,0],[1|Y],N), member(Y, [[0]]), N is 2, !.
testEd12C(Y,N) :- distEd([0,0,0],[1|Y],N), member(Y, [[1]]), N is 3, !.
testEd12D(Y,N) :- distEd([0,0,0],[1|Y],N), member(Y, [[0,0]]), N is 1, !.
testEd12E(Y,N) :- distEd([0,0,0],[1|Y],N), member(Y, [[0,1]]), N is 2, !.
testEd12F(Y,N) :- distEd([0,0,0],[1|Y],N), member(Y, [[1,0]]), N is 2, !.
testEd12G(Y,N) :- distEd([0,0,0],[1|Y],N), member(Y, [[1,1]]), N is 3, !.
testEd12H(Y,N) :- distEd([0,0,0],[1|Y],N), member(Y, [[0,0,0]]), N is 1, !.
testEd12I(Y,N) :- distEd([0,0,0],[1|Y],N), member(Y, [[0,0,1]]), N is 2, !.
testEd12J(Y,N) :- distEd([0,0,0],[1|Y],N), member(Y, [[0,1,0]]), N is 2, !.
testEd12K(Y,N) :- distEd([0,0,0],[1|Y],N), member(Y, [[0,1,1]]), N is 3, !.

%Tests de instanciación de X, Y y N
test6Ed :- var(N13A1),var(N13A2),var(N13A3),var(N13B1),var(N13B2),var(N13B3),var(N13C1),var(N13C2),
	   var(N13C3),var(N13D1),var(N13D2),var(N13D3),var(N14A1),var(N14A2),var(N14A3),var(N14B1),var(N14B2),var(N14B3),var(N14C1),var(N14C2),
	   var(N14C3),var(N14D1),var(N14D2),var(N14D3),var(N14E1),var(N14E2),var(N14E3),var(N14F1),var(N14F2),var(N14F3),var(N14G1),var(N14G2),
	   var(N14G3),var(N14H1),var(N14H2),var(N14H3),var(N14I1),var(N14I2),var(N14I3),var(N14J1),var(N14J2),var(N14J3),var(N14K1),var(N14K2),
	   var(N14K3),
	  
   	   call(testEd13A(N13A1, N13A2, N13A3)), call(testEd13B(N13B1, N13B2, N13B3)), call(testEd13C(N13C1, N13C2, N13C3)), 
	   call(testEd13D(N13D1, N13D2, N13D3)),

 	   call(testEd14A(N14A1, N14A2, N14A3)), call(testEd14B(N14B1, N14B2, N14B3)), call(testEd14C(N14C1, N14C2, N14C3)),
	   call(testEd14D(N14D1, N14D2, N14D3)), call(testEd14E(N14E1, N14E2, N14E3)), call(testEd14F(N14F1, N14F2, N14F3)), 
	   call(testEd14G(N14G1, N14G2, N14G3)), call(testEd14H(N14H1, N14H2, N14H3)), call(testEd14I(N14I1, N14I2, N14I3)), 
	   call(testEd14J(N14J1, N14J2, N14J3)), call(testEd14K(N14K1, N14K2, N14K3)).

testEd13A(Y,X,N) :- distEd([1,0,0,1,1],[X,0,Y],N), X is Y, Y is 0, N is 3.
testEd13B(Y,X,N) :- distEd([1,0,0,1,1],[X,0,Y],N), X is 0, Y is 1, N is 2.
testEd13C(Y,X,N) :- distEd([1,0,0,1,1],[X,0,Y],N), X is 1, Y is 0, N is 2.
testEd13D(Y,X,N) :- distEd([1,0,0,1,1],[X,0,Y],N), X is Y, Y is 1, N is 2.


testEd14A(Y,X,N) :- distEd([0,0,0],[1,X|Y],N), X is 0, member(Y, [[]]), N is 2, !.
testEd14B(Y,X,N) :- distEd([0,0,0],[1,X|Y],N), X is 1, member(Y, [[]]), N is 3, !.
testEd14D(Y,X,N) :- distEd([0,0,0],[1,X|Y],N), X is 0, member(Y, [[0]]), N is 1, !.
testEd14C(Y,X,N) :- distEd([0,0,0],[1,X|Y],N), X is 0, member(Y, [[1]]), N is 2, !.
testEd14E(Y,X,N) :- distEd([0,0,0],[1,X|Y],N), X is 1, member(Y, [[0]]), N is 2, !.
testEd14F(Y,X,N) :- distEd([0,0,0],[1,X|Y],N), X is 1, member(Y, [[1]]), N is 3, !.
testEd14G(Y,X,N) :- distEd([0,0,0],[1,X|Y],N), X is 0, member(Y, [[0,0]]), N is 1, !.
testEd14H(Y,X,N) :- distEd([0,0,0],[1,X|Y],N), X is 0, member(Y, [[0,1]]), N is 2, !.
testEd14I(Y,X,N) :- distEd([0,0,0],[1,X|Y],N), X is 0, member(Y, [[1,0]]), N is 2, !.
testEd14J(Y,X,N) :- distEd([0,0,0],[1,X|Y],N), X is 0, member(Y, [[1,1]]), N is 3, !.
testEd14K(Y,X,N) :- distEd([0,0,0],[1,X|Y],N), X is 1, member(Y, [[0,0]]), N is 2, !.

			   


