
%distanciaHamming(+L1, +L2, ?D)
%distanciaHamming([], [], 0).
%distanciaHamming([X|Y],[W|Z], N) :- distanciaHamming(Y,Z,ACUM),  N is ACUM + abs(X-W).

%entre(+X, +Y, -Z)
entre(X,Y,X) :- X=<Y.
entre(X,Y,Z) :- X<Y, Xm1 is X+1, entre(Xm1, Y, Z).

%distanciaHamming(+L1, ?L2, ?D)
distanciaHamming([], [], 0).
distanciaHamming([X|XS], [Y|YS], N) :- entre(0,1,V), Y is V, distanciaHamming(XS,YS,ACUM), N is ACUM + abs(Y-X).

test1(N) :- distanciaHamming([],[0],N).
test2(N) :- distanciaHamming([0,1],[0,1],N).
test3(N) :- distanciaHamming([0,1,0],[0,0,1],N). 
test4(X,Y,N) :- distanciaHamming([0,1,0],[X,Y,1],N). 
test5(X) :- distanciaHamming([0,1,0],X,2).
test6(N) :- distanciaHamming([plp],[plp],N).

