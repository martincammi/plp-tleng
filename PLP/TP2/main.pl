
%main.pl

%Main para cargar todos los otros archivos.

:- [distHam].
:- [distPref].
:- [distEd].

testAll :- testAllHam, testAllPref, testAllEd.
