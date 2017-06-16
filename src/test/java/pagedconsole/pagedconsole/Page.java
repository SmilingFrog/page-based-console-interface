package pagedconsole.pagedconsole;

import java.util.ArrayList;
import java.util.List;

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

	public static PageElement createPageElement(String elementName, String elementText) {
		return new PageElement() {
			private String pageElementName = elementName;
			private String pageElementText = elementText; 
			@Override
			public String getText() {
				return pageElementText;
			}
			
		};
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
