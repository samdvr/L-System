package algebra

sealed trait Language

object Language {

  case object A extends Language

  case object B extends Language

  case object TurnLeft extends Language

  case object TurnRight extends Language


}