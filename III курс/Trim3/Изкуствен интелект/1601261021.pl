% tochka 1 ?
bird(owl).
bird(eagle).
bird(chicken).
animal(cat).
animal(mouse).
animal(giraffe).
animal(elephant).
fish(shark).
fish(magikarp).
fish(gyarados).

% tochka 2 if(X.type == Y.type) { return true; } return false;
isSameType(X,Y):- bird(X),bird(Y);animal(X),animal(Y);fish(X),fish(Y).

% tochka 3
areSameType([]).
areSameType([_]).
areSameType([H1,H2|T]):- isSameType(H1,H2), areSameType([H2|T]).

% tochka 4 if(X.type==1 && Y.type==3 || X.type==2 && Y.type==1 || X.type==3 && Y.type==2) { return true; } return false;
eat(X,Y):- bird(X),fish(Y);animal(X),bird(Y);fish(X),animal(Y).

% tochka 6 if(list.get(0).type == list.get(1).type && list.get(0).type == list.get(2).type) { return true; } return false;
areFirstThreeSameType([H1,H2,H3|_]):- bird(H1),bird(H2),bird(H3);animal(H1),animal(H2),animal(H3);fish(H1),fish(H2),fish(H3).

% tochka 7
areThereDuplicatedElements(L) :- sort(L, S),length(L, X),length(S, Y),X > Y.