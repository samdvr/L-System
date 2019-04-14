package algebra

trait ProductionRule[T] {
  def generate(t: T): List[T]
}

trait SequenceGenerator[T] {
  def sequenceNumber(seed: List[T], number: Int)(implicit rule: ProductionRule[T]): List[T] = {
    List.iterate(seed.flatMap(rule.generate), number)(_.flatMap(rule.generate)).last
  }
}
