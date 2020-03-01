% 1
bird(owl).
bird(eagle).
bird(chicken).
bird(vulture).
animal(cat).
animal(mouse).
animal(lion).
animal(zebra).
fish(shark).
fish(skate).
fish(wolffish).
fish(catfish).

% 2
isSameType(X,Y):- bird(X),bird(Y);animal(X),animal(Y);fish(X),fish(Y).

% 3
checkTypeList([]).
checkTypeList([_]).
checkTypeList([X,Y|T]):- isSameType(X,Y), checkTypeList([Y|T]).

% tochka 4
eat(X,Y):- bird(X),fish(Y);animal(X),bird(Y);fish(X),animal(Y).

% tochka 5
isItInTheList([]).
isItInTheList([X|T], E):- X == E -> isItInTheList([]); isItInTheList(T, E).

% tochka 7
isDuplicate(X) :- sort(X, S),length(X, Z),length(S, Y),Z>Y.