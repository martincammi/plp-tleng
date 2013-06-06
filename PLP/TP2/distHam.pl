
:- [utils]. 

%Corre todos los tests.
testAllHam :- test1Ham, test2Ham, test3Ham, test4Ham, test5Ham, test6Ham.

%---EJERCICIOS---

%distHam(+L1, ?L2, ?D)
distHam([], [], 0).
distHam([X|XS], [Y|YS], N) :- entre(0,1,X), entre(0,1,V), Y is V, distHam(XS,YS,ACUM), N is ACUM + abs(Y-X).

%---TESTS---

%Tests de instanciación de X
test1Ham :- var(A1), var(B1), var(C1),
	 call(testDh1A(A1)), call(testDh1B(B1)), call(testDh1C(C1)).
testDh1A(X) :- distHam([0,1,0],X,2), member(X,[[1,0,0]]),!.
testDh1B(X) :- distHam([0,1,0],X,2), member(X,[[0,0,1]]),!.
testDh1C(X) :- distHam([0,1,0],X,2), member(X,[[1,1,1]]),!.

%Tests de instanciación de X (segunda lista semi instanciada)
test2Ham :- var(A2), var(B2), var(C2), var(D2),
	 call(testDh2A(A2)), call(testDh2B(B2)), call(testDh2C(C2)), call(testDh2D(D2)).
testDh2A(X) :- distHam([0,1,0],[1|X],2), member(X,[[0,0]]),!.
testDh2B(X) :- distHam([0,1,0],[1|X],2), member(X,[[1,1]]),!.
testDh2C(X) :- distHam([0,1,0],[0,1,0|X],0), member(X,[[]]),!.
testDh2D(X) :- not(distHam([0,1,0],[1,0,0,0|X],2)).

%Tests de instanciación de Y y N
test3Ham :- var(A3), var(B3), var(C3), var(D3), var(A31), var(B31), var(C31), var(D31),
	 call(testDh3A(A3, A31)), call(testDh3B(B3, B31)), call(testDh3C(C3, C31)), call(testDh3D(D3, D31)).
testDh3A(Y,N) :- distHam([0,0],Y,N), member(Y, [[0,0]]), N is 0, !.
testDh3B(Y,N) :- distHam([0,0],Y,N), member(Y, [[0,1]]), N is 1, !.
testDh3C(Y,N) :- distHam([0,0],Y,N), member(Y, [[1,0]]), N is 1, !.
testDh3D(Y,N) :- distHam([0,0],Y,N), member(Y, [[1,1]]), N is 2, !.

%Tests de instanciación de N
test4Ham :- var(A4), var(B4),
	 call(testDh4A(A4)), call(testDh4B(B4)).
testDh4A(N) :- distHam([0,1],[0,1],N), N is 0,!.
testDh4B(N) :- distHam([0,1,0],[0,0,1],N), N is 2,!.

%Tests de instanciación de N (entradas invalidas)
test5Ham :- var(A5), var(B5), var(D5), var(E5), var(F5),
	 call(testDh5A(A5)), call(testDh5B(B5)), call(testDh5C), call(testDh5D(D5)),
	 call(testDh5E(E5)), call(testDh5F(F5)).
testDh5A(N) :- not(distHam([],[0],N)), !.
testDh5B(N) :- not(distHam([0],[],N)), !.
testDh5C :- not(distHam([],[],4)).
testDh5D(N) :- not(distHam([plp],[plp],N)).
testDh5E(N) :- not(distHam([1,8],[1,0],N)).
testDh5F(N) :- not(distHam([1,0],[1,5],N)).

%Tests de instanciación de X, Y y N
test6Ham :- var(A6), var(B6), var(C6), var(D6), var(A61), var(B61), var(C61), var(D61), var(A62), var(B62), var(C62), var(D62),
	 call(testDh6A(A6, A61, A62)), call(testDh6B(B6, B61, B62)), call(testDh6C(C6, C61, C62)), call(testDh6D(D6, D61, D62)).
testDh6A(X,Y,N) :- distHam([0,1,0],[X,Y,1],N), X is 0, Y is 0, N is 2, !.
testDh6B(X,Y,N) :- distHam([0,1,0],[X,Y,1],N), X is 0, Y is 1, N is 1, !.
testDh6C(X,Y,N) :- distHam([0,1,0],[X,Y,1],N), X is 1, Y is 0, N is 3, !.
testDh6D(X,Y,N) :- distHam([0,1,0],[X,Y,1],N), X is 1, Y is 1, N is 2, !.

