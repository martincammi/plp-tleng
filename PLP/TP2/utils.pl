
%Predicados comunes utiles.

%Genera numeros entre X e Y.
%entre(+X, +Y, -Z)
entre(X,Y,X) :- X=<Y.
entre(X,Y,Z) :- X<Y, Xm1 is X+1, entre(Xm1, Y, Z).

%Genera todas las listas binarias de longitud N, si L esta instanciada, verifica que sea binaria.
%binaria(?L,+N)
binaria([], 0).
binaria([Y|YS], N) :- entre(0,1,V), Y is V, ACUM is (N - 1), ACUM >= 0, binaria(YS,ACUM).

%Genera numeros desde X.
%desde(+X,-Y)
desde(X,X).
desde(X,Y) :- Z is X+1, desde(Z,Y).
