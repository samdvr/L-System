package algebra

sealed trait Language

object Language {

  case object Up extends Language

  case object Forward extends Language

  case object Down extends Language

}