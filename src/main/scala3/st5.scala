
// Future
import scala.concurrent.Future
import scala.io.{BufferedSource, Source}
import scala.io_
import scala.util.{Failure, Success}
import scala.concurrent.ExecutionContext.Implicits.global

object HttpTextClient {
  def get(url: String): BufferedSource = Source.fromURL(url)
}

val responseFuture: Future[BufferedSource] =
  Future(HttpTextClient.get("https://www.scala-lang.org/"))


val failedFuture = Future(HttpTextClient.get("https://www.scala-lng.org/")) // lang -> lng
failedFuture.onComplete {
  case Success(body) =>
    println(body.mkString)
    body.close()
  case Failure(throwable) => println("error: " + throwable.toString)
}


val future = Future.successful(2)

future.onComplete {
  case Success(result) => println(result)
  case Failure(t) =>
} // 2

val future2: Future[BufferedSource] = Future(
  HttpTextClient.get("https://www.scala-lang.org/"))

future2.map(s =>
    try s.mkString
    finally s.close)
  .onComplete {
    case Success(body) => println(body)
    case Failure(t)    => t.printStackTrace()
  }


def getAsync(url: String): Future[String] =
  Future(HttpTextClient.get(url)).map(
    s =>
      try s.mkString
      finally s.close)

def extractURLAsync(body: String): Future[Seq[String]] = {
  val urlRegix = """https?://[¥w.:$%?&()=-+-~]+""".r
  Future {
    urlRegix.findAllIn(body).toSeq
  }
}

val urlsFuture: Future[Seq[String]] =
  getAsync("https://www.scala-lang.org/").flatMap(extractURLAsync)
urlsFuture.onComplete {
  case Success(urlList) =>
    println("contain urls: " + urlList.mkString(" , "))
  case Failure(t) => t.printStackTrace()
}


val urlsInOfficial = getAsync("https://www.scala-lang.org").flatMap(extractURLAsync)
val urlsInWiki = getAsync("https://ja.wikipedia.org/wiki/Scala").flatMap(extractURLAsync)

val urls = for {
  oUrls <- urlsInOfficial
  wUrls <- urlsInWiki
} yield oUrls ++ wUrls

urls.onComplete {
  case Success(urlList) =>
    println("contain urls: " + urlList.mkString(" , "))
  case Failure(t) => t.printStackTrace()
}


getAsync("https://www.scala-lang.org")
  .andThen {
    case Success(body) => println(body)
  }
  .flatMap(extractURLAsync(_))
  .onComplete {
    case Success(urlList) => println("contain urls: " + urlList.mkString(" , "))
    case Failure(t) => t.printStackTrace()
  }