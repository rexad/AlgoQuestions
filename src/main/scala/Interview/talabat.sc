object Solution {
/*write a function taht will an infinit number of int, you can only use char array string and int 64 */
  def  Sum(inputs: Array[Int]): String =
  {
    var result: String = ""
    for(i <- 0 until inputs.length){
    var current = inputs(i).toString()

    if(result.length == 0) result = current
    else {
    (result(0), current(0)) match {
      case ('-', '-') => result = Add(result, current)
      case (a, b) if a!= '-' && b!= '-' => result Add(result, current)
      case (_, _) => result = Sub(result, current)
    }
    }


    }
  }

  def Add(a: String, b: String): String = {
    var maxLength = (a.length, b.length) //4
    var sb= StringBuilder()
    var initial = 0
    if(a(0) == '-'){
      sb.add('-')
      initial = 1
    }
    var save = 0
    for(i <- initial to maxLength ) {

      (a.length - i, b.length - i ) match { //3 //2
        case (res1>=0, res2>= 0) => {

          res = (save + a(res1).toInt + b(res2).toInt)}
          sb.add = (res % 10).toString //sb =768
          if(save >= 10 ) save = res / 10 // save =0
      }
      case (res1> 0, _) =>  {
        res = (a(i) + save)
        sb.add = (res % 10).toString
        if(save >= 10 ) save = res / 10
      }
      case (_, res2 > 0) =>  {
        res = (b(i) + save)
        sb.add = (res % 10).toString //7681
        if(save >= 10 ) save = res / 10
      }
    }



  }

  def sub(String a, String): String = {
    var maxLength = (a.length, b.length)

  }

  def toString(n: Int): String = {

  }

}