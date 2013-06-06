
%distPref(+L1, ?L2, ?D)
% caso infinito, sin n definido genero todos los posibles Ns
distPref(X,Y,N) :- not(is_list(Y)), not(ground(N)), 
			length(X,LengthX), binaria(X,LengthX), 
			desde(0,N), distPref(X,Y,N). 
distPref([],YS,N) :- not(is_list(YS)), ground(N), binaria(YS,N).
distPref([X|XS],[Y|YS],N) :- not(is_list(YS)), ground(N), entre(0,1,X), entre(0,1,Y), X==Y, distPref(XS,YS,N).
distPref([X|XS],[Y|YS],N) :- not(is_list(YS)), ground(N), entre(0,1,X), entre(0,1,Y), X=\=Y, length(XS,LengthXS), binaria(XS,LengthXS), ACUM is (N-LengthXS-2), distPref([],YS,ACUM).	
% caso finito
distPref([],YS,N) :- is_list(YS), length(YS,N), binaria(YS,N).
distPref(XS, [],N):- length(XS,N), N>0, binaria(XS,N). %el N>0 es para no entrar en el caso [] [] por la linea de arriba tbm.
distPref([X|XS],[Y|YS],N) :- is_list(YS), entre(0,1,X), entre(0,1,Y), 
				X==Y,  
				distPref(XS,YS,N).
distPref([X|XS],[Y|YS],N) :- is_list(YS), entre(0,1,X), entre(0,1,Y), 
				X=\=Y, 
				length(YS,LengthYS), 
				length(XS,LengthXS), 
				binaria(XS,LengthXS), 
				binaria(YS,LengthYS), 
				N is (LengthYS+LengthXS+2).

%entre(+X, +Y, -Z)
entre(X,Y,X) :- X=<Y.
entre(X,Y,Z) :- X<Y, Xm1 is X+1, entre(Xm1, Y, Z).

%Binaria(?L,+N)
binaria([], 0).
binaria([Y|YS], N) :- entre(0,1,V), Y is V, ACUM is (N - 1), ACUM >= 0, binaria(YS,ACUM).

%desde(+X,-Y)
desde(X,X).
desde(X,Y) :- Z is X+1, desde(Z,Y).

%Todos los tests.
testAllPref :- test1, test2.

%Tests de instanciación de N
test1 :- var(N1),var(N2),var(N3),var(N4),var(N5),var(N6),
	 call(testPred1(N1)), call(testPred2(N2)), call(testPred3(N3)), call(testPred4(N4)), call(testPred5(N5)), call(testPred6(N6)).

testPred1(N) :- distPref([],[],N), N is 0.
testPred2(N) :- distPref([1],[],N), N is 1.
testPred3(N) :- distPref([],[1],N), N is 1.
testPred4(N) :- distPref([1],[1],N), N is 0.
testPred5(N) :- distPref([1,0,1],[1,1],N), N is 3.
testPred6(N) :- distPref([1,0],[1,1,0],N), N is 3.

%Tests de instanciación de Y
test2 :- var(N7A),var(N7B),var(N7C),var(N7D),var(N7E),var(N7F),
	 call(testPred7A(N7A)), call(testPred7B(N7B)), call(testPred7C(N7C)), call(testPred7D(N7D)), call(testPred7E(N7E)), call(testPred7F(N7F)).
testPred7A(Y) :- distPref([0,0,0],Y,2), member(Y, [[0,0,0,0,0]]).
testPred7B(Y) :- distPref([0,0,0],Y,2), member(Y, [[0,0,0,0,1]]).
testPred7C(Y) :- distPref([0,0,0],Y,2), member(Y, [[0,0,0,1,0]]).
testPred7D(Y) :- distPref([0,0,0],Y,2), member(Y, [[0,0,0,1,1]]).
testPred7E(Y) :- distPref([0,0,0],Y,2), member(Y, [[0,0,1]]).
testPred7F(Y) :- distPref([0,0,0],Y,2), member(Y, [[0]]).

%Tests de instanciación de elementos X y N
test3 :- var(N8A),var(N8B),var(N9A),var(N9B),
	 call(testPred8A(N8A)), call(testPred8B(N8B)), call(testPred9A(N9A)), call(testPred9B(N9B)).
testPref8A(X,N) :- distPref([1,0,1],[X,0,1],N), X is 1, N is 0.
testPref8B(X,N) :- distPref([1,0,1],[X,0,1],N), X is 1, N is 6. 
testPref9A(X,N) :- distPref([1,0,1],[X,0,X,1,0],N), X is 1, N is 2.
testPref9B(X,N) :- distPref([1,0,1],[X,0,X,1,0],N), X is 0, N is 8.



