package pagedconsole.pagedconsole;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.InvalidNameException;

public class Page {

	List<PageElement> pageElements;
	String pageName = null;
	
	private Page(){
		pageElements = new ArrayList<>();
	}
	
	public static PageBuilder getPageBuilder() {
		return new PageBuilder() {
			
			List<PageElement> pageElements = new ArrayList<>();
			String pageName;
			
			@Override
			public Page build() {
				Page page = new Page();
				page.pageElements = pageElements;
				page.pageName = pageName;
				return page;
			}

			@Override
			public void append(PageElement pageElement) {
				pageElements.add(pageElement);
			}

			@Override
			public void setPageName(String pageName) {
				this.pageName = pageName;
			}
		};
	}

	public static PageElement createPageElement(String elementName, String elementText) throws InvalidNameException {
		PageElement result = null;
		if(isValid(elementName)){
			if(isComposite(elementName)){
				CompositePageElement compositeElement = new CompositePageElement();
				compositeElement.setElementName(elementName);
				compositeElement.setElementText(elementText);
				result = compositeElement;
			}else{
				LeafPageElement leafElement = new LeafPageElement();
				leafElement.setElementName(elementName);
				leafElement.setElementText(elementText);
				result = leafElement;
			}
		}else{
			throw new InvalidNameException("WRONG ELEMENT NAME");
		}
		
		return result;
	}

	private static boolean isComposite(String elementName) {
		boolean result = false;
		switch(elementName){
		case "HEADER":
		case "BREADCRUMBS":
		case "BODY":
		case "FORM":
		case "FOOTER":
			result = true;
			break;
		default:
		}
		return result;
	}

	private static boolean isValid(String elementName) {
		
		boolean result = false;
		
		switch(elementName){
		case "HEADER":
		case "TITLE":
		case "TEXT":
		case "BREADCRUMBS":
		case "CRUMB":
		case "BODY":
		case "LINK":
		case "FORM":
		case "INPUT":
		case "BUTTON":
		case "FOOTER":
			result = true;
			break;
		default:
		}
		return result;
	}

	public String getContent() {
		String result = null;
		StringBuilder sb = new StringBuilder();
		for(PageElement element : pageElements){
			sb.append(element.getText());
			sb.append("\n");
		}
		result = sb.toString();
		return	result;	
	}

	public String getPageName() {
		return pageName;
	}


}
