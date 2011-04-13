import javax.inject._
import scala.reflect._

@Named("helloWorld")
class HelloWorld {
  
	@BeanProperty var text = "Hendy"
	  
}