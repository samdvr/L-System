# L-System


[L-System](https://en.wikipedia.org/wiki/L-system)
Image generator using Scala's [https://github.com/creativescala/doodle](Doodle library).
Example generated images are in examples folder.

Sample Language and Interpreter

```scala

import algebra._
import algebra.Language.{Forward, Down, Up}
import doodle.turtle._
import doodle.turtle.Instruction._
import doodle.syntax._
import Draw._


object Implicits {

  object Generator extends SequenceGenerator[Language]

  implicit val rule: ProductionRule[Language] = {
    case Forward => List(Forward, Forward, Down)
    case Up => List(Up, Up, Down)
    case Down => List(Down, Forward, Down)
  }

  implicit val drawer: Drawer[Language] = new Drawer[Language] {
    override def convert: List[Language] => List[Instruction] = _.flatMap {
      case Up => List(turn(60.degrees), forward(50))
      case Forward => List(forward(50))
      case Down => List(turn(60.degrees))
    }
  }
}

object Runner extends App {
  override def main(args: Array[String]): Unit = {
    import Implicits._
    val data = Generator.sequenceNumber(List(Up, Forward), 8)
    drawer.convert(data).draw
  }


}

``` 

[L-System]: https://en.wikipedia.org/wiki/L-system


