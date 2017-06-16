package pagedconsole.pagedconsole;

import java.util.HashMap;
import java.util.Map;

public class PageRepositoryImpl implements PageRepository {

	Map<String, Page> pages;
	
	public PageRepositoryImpl() {
		pages = new HashMap<>();
	}
	
	@Override
	public Page find(String pageName) {
		return pages.get(pageName);
	}

	@Override
	public void add(Page page) {
		String pageName = page.getPageName();
		pages.put(pageName, page);
	}

}
