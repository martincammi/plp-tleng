
%distHam(+L1, ?L2, ?D)
distHam([], [], 0).
distHam([X|XS], [Y|YS], N) :- entre(0,1,X), entre(0,1,V), Y is V, distHam(XS,YS,ACUM), N is ACUM + abs(Y-X).

%entre(+X, +Y, -Z)
entre(X,Y,X) :- X=<Y.
entre(X,Y,Z) :- X<Y, Xm1 is X+1, entre(Xm1, Y, Z).

%Binaria(?L,+N)
binaria([], 0).
binaria([Y|YS], N) :- entre(0,1,V), Y is V, ACUM is (N - 1), ACUM >= 0, binaria(YS,ACUM).

%desde(+X,-Y)
desde(X,X).
desde(X,Y) :- Z is X+1, desde(Z,Y).


%Tests de instanciación de X
testDh8A(X) :- distHam([0,1,0],X,2), member(X,[[1,0,0]]),!.
testDh8B(X) :- distHam([0,1,0],X,2), member(X,[[0,0,1]]),!.
testDh8C(X) :- distHam([0,1,0],X,2), member(X,[[1,1,1]]),!.
%Tests de instanciación de X (segunda lista semi instanciada)
testDh8D(X) :- distHam([0,1,0],[1|X],2), member(X,[[0,0]]),!.
testDh8E(X) :- distHam([0,1,0],[1|X],2), member(X,[[1,1]]),!.
testDh8F(X) :- distHam([0,1,0],[0,1,0|X],0), member(X,[[]]),!.
testDh8G(X) :- not(distHam([0,1,0],[1,0,0,0|X],2)).

%Tests de instanciación de Y y N
testDh0A(Y,N) :- distHam([0,0],Y,N), member(Y, [[0,0]]), N is 0, !.
testDh1B(Y,N) :- distHam([0,0],Y,N), member(Y, [[0,1]]), N is 1, !.
testDh2C(Y,N) :- distHam([0,0],Y,N), member(Y, [[1,0]]), N is 1, !.
testDh3D(Y,N) :- distHam([0,0],Y,N), member(Y, [[1,1]]), N is 2, !.

%Tests de instanciación de N
testDh5A(N) :- distHam([0,1],[0,1],N), N is 0,!.
testDh6A(N) :- distHam([0,1,0],[0,0,1],N), N is 2,!.

%Tests de instanciación de N (entradas invalidas)
testDh4A(N) :- not(distHam([],[0],N)), !.
testDh4B(N) :- not(distHam([0],[],N)), !.
testDh4C :- not(distHam([],[],4)).
testDh4D(N) :- not(distHam([plp],[plp],N)).
testDh4E(N) :- not(distHam([1,8],[1,0],N)).
testDh4F(N) :- not(distHam([1,0],[1,5],N)).

%Tests de instanciación de X, Y y N
testDh7A(X,Y,N) :- distHam([0,1,0],[X,Y,1],N), X is 0, Y is 0, N is 2, !.
testDh7B(X,Y,N) :- distHam([0,1,0],[X,Y,1],N), X is 0, Y is 1, N is 1, !.
testDh7C(X,Y,N) :- distHam([0,1,0],[X,Y,1],N), X is 1, Y is 0, N is 3, !.
testDh7D(X,Y,N) :- distHam([0,1,0],[X,Y,1],N), X is 1, Y is 1, N is 2, !.


testAll :- 	call(testDh0A(Y1,N1)),
			call(testDh1B(Y2,N2)),
			call(testDh2C(Y3,N3)),
			call(testDh3D(Y4,N4)),
			call(testDh4A(N5)),
			call(testDh4B(N6)),
			call(testDh4C),
			call(testDh4D(N13)),
			call(testDh4E(N14)),
			call(testDh4F(N15)),
			call(testDh5A(N7)),
			call(testDh6A(N8)),
			call(testDh7A(X9,Y9,N9)),
			call(testDh7B(X10,Y10,N10)),
			call(testDh7C(X11,Y11,N11)),
			call(testDh7D(X12,Y12,N12)),
			call(testDh8A(N13)),
			call(testDh8B(N14)),
			call(testDh8C(N15)),
			call(testDh8D(N21)),
			call(testDh8D(N22)),
			call(testDh8F(N23)),
			call(testDh8G(N24)).
