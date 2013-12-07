package tac;

public enum EnumType {
	// types simples
	CHARACTER, SHORT, UNSIGNED_SHORT, INTEGER, UNSIGNED_INTEGER, 
	REAL, UNSIGNED_REAL, STRING, BOOLEAN, ENUM,
	// variable de type (on peut dire par exemple "pointeur('x) -> 'x")
	VARIABLE,
	// type constant pour les slots
	CONSTANT,
	// types complexes
	POINTER, FUNCTION, TIMES, 
	// types complexes
	RECORD, LIST, ARRAY, STACK, SET, 
	// erreur de type
	ERROR
}
