package proginscala.chapter21

object TomsPrefs:
  val favoriteColor = "Red"
  def favoriteFood = "Steak"

  given prompt: PreferredPrompt = PreferredPrompt("enjoy> ")

  given drink: PreferredDrink = PreferredDrink("read wine")

  given prefPromptOrd: Ordering[PreferredPrompt] with
    def compare(x: PreferredPrompt, y: PreferredPrompt) =
      x.preference.compare(y.preference)

  given prefDrinkOrd: Ordering[PreferredDrink] with
    def compare(x: PreferredDrink, y: PreferredDrink) =
      x.preference.compare(y.preference)

object ImportGivens extends App:

  /** This statement imports all members of the object, except `given` members.
    */
  import TomsPrefs.*

  /** To import `givens`, one option is to import their names explicitly:
    */
  import TomsPrefs.drink

  /** If you want to import all givens, you can use a special wildcard given import:
    */
  import TomsPrefs.given

  /** Because often the name a given is not used explicitly in the source code, only its type, the given import
    * mechanism also allows you to import a given by its type:
    */
  // imports `drink` because it is a given of type PreferredDrink
  import TomsPrefs.given PreferredDrink

  /** You can import parameterized givens by their type, or you can use a question mark (?) for the type parameter:
    */
  // the two statements both import `prefPromptOrd` and `prefDrinkOrd`
  import TomsPrefs.{ given Ordering[PreferredDrink], given Ordering[PreferredPrompt] }
  import TomsPrefs.given Ordering[?]

