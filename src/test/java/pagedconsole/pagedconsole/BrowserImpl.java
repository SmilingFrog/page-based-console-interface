package pagedconsole.pagedconsole;

public class BrowserImpl implements Browser {

	PageRepository pageRepository;
	
	public PageRepository getPageRepository() {
		return pageRepository;
	}

	public void setPageRepository(PageRepository pageRepository) {
		this.pageRepository = pageRepository;
	}

	@Override
	public String browse(String pageName) {
		Page page = pageRepository.find(pageName);
		String pageContent = null;
		if(page == null){
			pageContent = "ERROR\nPAGE \"" + pageName + "\" NOT FOUND\nFOOTER\n";
		}else{
			pageContent = page.getContent();
		}
		System.out.println(pageContent);
		return pageContent;
	}

}
