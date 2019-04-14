package algebra

import doodle.turtle.{Instruction, Turtle}

trait Drawer[T] {
  def convert: List[T] => List[Instruction]
}

object Draw {


  import doodle.turtle._
  import doodle.java2d._
  import doodle.image.syntax._

  implicit class ListInstructionOps(l: List[Instruction]) {
    def draw = Turtle.draw(l).draw()
  }

}