import algebra._
import algebra.Language.{A, B, TurnLeft, TurnRight}
import doodle.turtle._
import doodle.turtle.Instruction._
import doodle.syntax._
import Draw._


object Implicits {

  object Generator extends SequenceGenerator[Language]

  implicit val rule: ProductionRule[Language] = {
    case A => List(B, TurnLeft, A, TurnLeft, B)
    case B => List(A, TurnRight, B, TurnRight, A)
    case TurnLeft => List(TurnLeft)
    case TurnRight => List(TurnRight)
  }

  implicit val drawer: Drawer[Language] = new Drawer[Language] {
    override def convert: List[Language] => List[Instruction] = _.flatMap {
      case A => List(forward(20))
      case B => List(forward(20))
      case TurnLeft => List(turn(-60.degrees))
      case TurnRight => List(turn(60.degrees))
    }
  }
}

object Runner extends App {
  override def main(args: Array[String]): Unit = {
    import Implicits._
    val data = Generator.sequenceNumber(List(A, B), 10)
    drawer.convert(data).draw
  }
}
