
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


%distPref(+S, +T, ?D)
%distPref([], YS,N) :- binaria(YS), length(YS,N).
%distPref(XS, [],N) :- binaria(XS), length(XS,N). 
%distPref([X|XS], [Y|YS], N) :- entre(0,1,X), X==Y, distPref(XS, YS, N).
%distPref([X|XS], [Y|YS], N) :- entre(0,1,X), entre(0,1,V), Y is V, X=\=Y, length(YS,LYS), length(XS,LXS), N is (LYS + LXS + 2).

distPref([], YS,N) :- desde(0,M), binaria(YS, M), N is M.
distPref(XS, [],N) :- length(XS,N).%binaria(XS), length(XS,N). 
distPref([X|XS], [Y|YS], N) :- entre(0,1,X), entre(0,1,V), Y is V, X==Y, distPref(XS, YS, N).
distPref([X|XS], [Y|YS], N) :- entre(0,1,X), entre(0,1,V), Y is V, X=\=Y, distPref(XS, YS, M), N is (M + 2).

%genBinaria(?L,+N)
%binaria([], 0).
%binaria([X|XS], N) :- length([X|XS],LengthLista), LengthLista<=N, entre(0,1,X), K is N-1, binaria(XS,K).
binaria([], 0) :- !.
binaria([Y|YS], N) :- entre(0,1,V), Y is V, ACUM is (N - 1), binaria(YS,ACUM).

%desde(+X,-Y)
desde(X,X).
desde(X,Y) :- Z is X+1, desde(Z,Y).

%testdp1(N) :- distPref([0,1,1],[0,1,1,1],N).
