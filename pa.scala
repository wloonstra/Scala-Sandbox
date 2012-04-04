args.foreach(arg => println(arg))
args.foreach((arg: String) => println(arg))
args.foreach(println(_))
args.foreach(println)