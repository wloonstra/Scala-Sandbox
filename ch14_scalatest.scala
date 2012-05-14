import org.scalatest.Suite

class MyTestSuite extends Suite {
  def testFirst() {
    assert(1+2 == 3)
  }
}

new MyTestSuite().execute