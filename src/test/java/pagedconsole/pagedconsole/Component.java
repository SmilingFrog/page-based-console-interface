package pagedconsole.pagedconsole;

public abstract class Component implements PageElement{
	
	String elementName;
	String elementText;
	
	public String getElementName() {
		return elementName;
	}

	public void setElementName(String elementName) {
		this.elementName = elementName;
	}

	public String getElementText() {
		return elementText;
	}

	public void setElementText(String elementText) {
		this.elementText = elementText;
	}
	
	public String getText(){
		return elementText;
	}
	
}
