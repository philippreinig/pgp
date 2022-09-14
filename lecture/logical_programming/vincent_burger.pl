enjoys(vincent,_):- burger(cheese_burger),!,fail.
enjoys(vincent,X):- burger(X).

burger(chesse_burger).
burger(big_mac).
burger(doppel_whopper).

pizza(salami).
pizza(funghi).
pizza(hawaii).
