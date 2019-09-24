package example

// import org.scalajs.dom
// import dom.document

import org.querki.jquery._

import scala.scalajs.js.annotation.JSExportTopLevel

object TutorialApp {
  def main(args: Array[String]): Unit = {
    $(() => setupUI())
  }

  def setupUI(): Unit = {
	  $("body").append("<p>Hello World</p>")
	  // $("#click-me-button").click(() => addClickedMessage())
		
		$("""<button type="button">Click me! 2</button>""")
		  .click(() => addClickedMessage())
		  .appendTo($("body"))		
	  /*$("#click-me-button").click(() => $("body").append("<p>{text}</p>"))*/
	}

	def addClickedMessage(): Unit = {
	  appendPar("You clicked the button!")
	}

  // @JSExportTopLevel("addClickedMessage")
	/*def addClickedMessage(): Unit = {
	  // appendPar(document.body, "You clicked the button!")
	  appendPar("You clicked the button!")
	}*/

	def appendPar(text: String) {
		$("#after-button").append("<p>" + text + "</p>")
	}

  /*def appendPar(targetNode: dom.Node, text: String): Unit = {
	  val parNode = document.createElement("p")
	  val textNode = document.createTextNode(text)
	  parNode.appendChild(textNode)
	  targetNode.appendChild(parNode)
	}*/
}