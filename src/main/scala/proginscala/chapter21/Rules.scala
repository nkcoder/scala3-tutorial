package proginscala.chapter21

/** Rules for context parameters:
  *
  * 1: Marking rule: only definitions marked given are available.
  *
  * 2. Visibility rule: an inserted given instance must be in scope as a single identifier, or be associated with a type
  * that is involved in the parameter type.
  *
  * 3. Explicits-first rule: whenever code type checks as it is written, no givens are attempted.
  *
  * 4. Whenever multiple givens could be applied, the compile will refuse to choose between them -- unless one is more
  * specific than the other. To be more precise, one given is more specific than another if one of the following applies:
	* - the type of the former is a subtype of the latter's
	* - the enclosing class of the former extends the enclosing class of the latter.
  */

object Rules
