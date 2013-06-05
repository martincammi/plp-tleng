
%distHam(+L1, ?L2, ?D)
distHam([], [], 0).
distHam([X|XS], [Y|YS], N) :- entre(0,1,V), Y is V, distHam(XS,YS,ACUM), N is ACUM + abs(Y-X).

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

testdh1(N) :- distHam([],[0],N).
testdh2(N) :- distHam([0,1],[0,1],N).
testdh3(N) :- distHam([0,1,0],[0,0,1],N). 
testdh4(X,Y,N) :- distHam([0,1,0],[X,Y,1],N). 
testdh5(X) :- distHam([0,1,0],X,2).
testdh6(N) :- distHam([plp],[plp],N).
