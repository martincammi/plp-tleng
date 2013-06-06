
%distPref.pl

:- [utils]. 

%Corre todos los tests.
testAllPref :- test1, test2, test3, test4, test5, test6.

%---EJECRICIOS---

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

%---TESTS---

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
test3 :- var(N8A1),var(N8A2),var(N8B1),var(N8B2),var(N9A1),var(N9A2),var(N9B1),var(N9B2),
	 call(testPref8A(N8A1,N8A2)), call(testPref8B(N8B1,N8B2)), call(testPref9A(N9A1,N9A2)), call(testPref9B(N9B1,N9B2)).
testPref8A(X,N) :- distPref([1,0,1],[X,0,1],N), X is 0, N is 6.
testPref8B(X,N) :- distPref([1,0,1],[X,0,1],N), X is 1, N is 0. 
testPref9A(X,N) :- distPref([1,0,1],[X,0,X,1,0],N), X is 1, N is 2.
testPref9B(X,N) :- distPref([1,0,1],[X,0,X,1,0],N), X is 0, N is 8.

%Tests de instanciación de listas Y y N

test4 :-  var(N10A1),var(N10A2),var(N10B1),var(N10B2),var(N10C1),var(N10C2),var(N10D1),var(N10D2),
	  testPref10A(N10A1,N10A2),testPref10B(N10B1,N10B2),testPref10C(N10C1,N10C2),testPref10D(N10D1,N10D2).
 
testPref10A(Y,N) :- distPref([0,0,0],Y,N), member(Y, [[0]]), N is 2, !.
testPref10B(Y,N) :- distPref([0,0,0],Y,N), member(Y, [[1]]), N is 4,!.
testPref10C(Y,N) :- distPref([0,0,0],Y,N), member(Y, [[0,0]]), N is 1,!.
testPref10D(Y,N) :- distPref([0,0,0],Y,N), member(Y, [[0,1]]), N is 3,!.

%Tests de instanciación de colas de listas Y y N
test5 :- var(N11A1),var(N11A2),var(N11B1),var(N11B2),var(N11C1),var(N11C2),var(N11D1),var(N11D2),var(N11E1),var(N11E2),var(N11F1),var(N11F2),
	 var(N11G1),var(N11G2),var(N11H1),var(N11H2),var(N11I1),var(N11I2),var(N11J1),var(N11J2),var(N11K1),var(N11K2),

	 testPref11A(N11A1,N11A2),testPref11B(N11B1,N11B2),testPref11C(N11C1,N11C2),testPref11D(N11D1,N11D2),testPref11E(N11E1,N11E2),
	 testPref11F(N11F1,N11F2),testPref11G(N11G1,N11G2),testPref11H(N11H1,N11H2),testPref11I(N11I1,N11I2),testPref11J(N11J1,N11J2),
	 testPref11K(N11K1,N11K2).

testPref11A(Y,N) :- distPref([0,0,0],[0|Y],N), member(Y, [[]]), N is 2, !.
testPref11B(Y,N) :- distPref([0,0,0],[0|Y],N), member(Y, [[0]]), N is 1, !.
testPref11C(Y,N) :- distPref([0,0,0],[0|Y],N), member(Y, [[1]]), N is 3, !.
testPref11D(Y,N) :- distPref([0,0,0],[0|Y],N), member(Y, [[0,0]]), N is 0, !.
testPref11E(Y,N) :- distPref([0,0,0],[0|Y],N), member(Y, [[0,1]]), N is 2, !.
testPref11F(Y,N) :- distPref([0,0,0],[0|Y],N), member(Y, [[1,0]]), N is 4, !.
testPref11G(Y,N) :- distPref([0,0,0],[0|Y],N), member(Y, [[1,1]]), N is 4, !.
testPref11H(Y,N) :- distPref([0,0,0],[0|Y],N), member(Y, [[0,0,0]]), N is 1, !.
testPref11I(Y,N) :- distPref([0,0,0],[0|Y],N), member(Y, [[0,0,1]]), N is 1, !.
testPref11J(Y,N) :- distPref([0,0,0],[0|Y],N), member(Y, [[0,1,0]]), N is 3, !.
testPref11K(Y,N) :- distPref([0,0,0],[0|Y],N), member(Y, [[0,1,1]]), N is 3, !.


%aca van los del 12

%Tests de instanciación de X, Y y N
test6 :- var(N13A1),var(N13A2),var(N13A3),var(N13B1),var(N13B2),var(N13B3),var(N13C1),var(N13C2),var(N13C3),var(N13D1),var(N13D2),var(N13D3),
	 var(N14A1),var(N14A2),var(N14A3),var(N14B1),var(N14B2),var(N14B3),var(N14C1),var(N14C2),var(N14C3),var(N14D1),var(N14D2),var(N14D3),
	 var(N14E1),var(N14E2),var(N14E3),var(N14F1),var(N14F2),var(N14F3),var(N14G1),var(N14G2),var(N14G3),var(N14H1),var(N14H2),var(N14H3),
	 var(N14I1),var(N14I2),var(N14I3),var(N14J1),var(N14J2),var(N14J3),var(N14K1),var(N14K2),var(N14K3),var(N14L1),var(N14L2),var(N14L3),
	 var(N14M1),var(N14M2),var(N14M3),var(N14N1),var(N14N2),var(N14N3),var(N14O1),var(N14O2),var(N14O3),var(N14P1),var(N14P2),var(N14P3),

	 testPref13A(N13A1,N13A2,N13A3),testPref13B(N13B1,N13B2,N13B3),testPref13C(N13C1,N13C2,N13C3),testPref13D(N13D1,N13D2,N13D3),
	 testPref14A(N14A1,N14A2,N14A3),testPref14B(N14B1,N14B2,N14B3),testPref14C(N14C1,N14C2,N14C3),testPref14D(N14D1,N14D2,N14D3),
	 testPref14E(N14E1,N14E2,N14E3),testPref14F(N14F1,N14F2,N14F3),testPref14G(N14G1,N14G2,N14G3),testPref14H(N14H1,N14H2,N14H3),
	 testPref14I(N14I1,N14I2,N14I3),testPref14J(N14J1,N14J2,N14J3),testPref14K(N14K1,N14K2,N14K3),testPref14L(N14L1,N14L2,N14L3),
	 testPref14M(N14M1,N14M2,N14M3),testPref14N(N14N1,N14N2,N14N3),testPref14O(N14O1,N14O2,N14O3),testPref14P(N14P1,N14P2,N14P3).

testPref13A(Y,X,N) :- distPref([1,0,0,1,1],[X,0,Y],N), X is Y, Y is 0, N is 8.
testPref13B(Y,X,N) :- distPref([1,0,0,1,1],[X,0,Y],N), X is 0, Y is 1, N is 8.
testPref13C(Y,X,N) :- distPref([1,0,0,1,1],[X,0,Y],N), X is 1, Y is 0, N is 2.
testPref13D(Y,X,N) :- distPref([1,0,0,1,1],[X,0,Y],N), X is Y, Y is 1, N is 4.

testPref14A(Y,X,N) :- distPref([1,0,0],[1,X|Y],N), X is 0, member(Y, [[]]), N is 1, !.
testPref14B(Y,X,N) :- distPref([1,0,0],[1,X|Y],N), X is 1, member(Y, [[]]), N is 3, !.
testPref14D(Y,X,N) :- distPref([1,0,0],[1,X|Y],N), X is 0, member(Y, [[0]]), N is 0, !.
testPref14C(Y,X,N) :- distPref([1,0,0],[1,X|Y],N), X is 0, member(Y, [[1]]), N is 2, !.
testPref14E(Y,X,N) :- distPref([1,0,0],[1,X|Y],N), X is 1, member(Y, [[0]]), N is 4, !.
testPref14F(Y,X,N) :- distPref([1,0,0],[1,X|Y],N), X is 1, member(Y, [[1]]), N is 4, !.
testPref14G(Y,X,N) :- distPref([1,0,0],[1,X|Y],N), X is 0, member(Y, [[0,0]]), N is 1, !.
testPref14H(Y,X,N) :- distPref([1,0,0],[1,X|Y],N), X is 0, member(Y, [[0,1]]), N is 1, !.
testPref14I(Y,X,N) :- distPref([1,0,0],[1,X|Y],N), X is 0, member(Y, [[1,0]]), N is 3, !.
testPref14J(Y,X,N) :- distPref([1,0,0],[1,X|Y],N), X is 0, member(Y, [[1,1]]), N is 3, !.
testPref14K(Y,X,N) :- distPref([1,0,0],[1,X|Y],N), X is 1, member(Y, [[0,0]]), N is 5, !.
testPref14L(Y,X,N) :- distPref([0,0,0],[1,X|Y],N), X is 0, member(Y, [[0,0]]), N is 7, !.
testPref14M(Y,X,N) :- distPref([0,0,0],[1,X|Y],N), X is 0, member(Y, [[0,1]]), N is 7, !.
testPref14N(Y,X,N) :- distPref([0,0,0],[1,X|Y],N), X is 0, member(Y, [[1,0]]), N is 7, !.
testPref14O(Y,X,N) :- distPref([0,0,0],[1,X|Y],N), X is 0, member(Y, [[1,1]]), N is 7, !.
testPref14P(Y,X,N) :- distPref([0,0,0],[1,X|Y],N), X is 1, member(Y, [[0,0]]), N is 7, !.



