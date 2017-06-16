package pagedconsole.pagedconsole;

public interface Browser {

	String browse(String pageName);
	
	public PageRepository getPageRepository();
	
	public void setPageRepository(PageRepository pageRepository);

}
