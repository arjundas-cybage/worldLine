package com.org.cybage.test

import com.org.cybage.MaxTotal
import org.scalatest.FunSuite
import scala.collection.mutable.Stack

class MaxCountTest extends FunSuite {

  //positive test cases
  test("calculateMaxTotal-Positive") {
    val multidimarr= Array.ofDim[Int](4, 4)
    multidimarr(0)(0) =3
    multidimarr(1)(0) = 7
    multidimarr(1)(1) = 4
    multidimarr(2)(0) = 2
    multidimarr(2)(1) = 4
    multidimarr(2)(2) = 6
    multidimarr(3)(0) = 8
    multidimarr(3)(1) = 5
    multidimarr(3)(2) = 9
    multidimarr(3)(3) = 3
    val value = MaxTotal.computeMaxTotal(multidimarr);
    assert(value == 23)
  }

  //negative test cases
  test("calculateMaxTotal-negative") {
    val multidimarr= Array.ofDim[Int](4, 4)
    multidimarr(0)(0) =3
    multidimarr(1)(0) = 7
    multidimarr(1)(1) = 4
    multidimarr(2)(0) = 2
    multidimarr(2)(1) = 4
    multidimarr(2)(2) = 6
    multidimarr(3)(0) = 8
    multidimarr(3)(1) = 5
    multidimarr(3)(2) = 9
    multidimarr(3)(3) = 55
    val value = MaxTotal.computeMaxTotal(multidimarr);
    assert(value != 23)
  }
}

