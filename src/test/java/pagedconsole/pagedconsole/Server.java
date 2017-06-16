package pagedconsole.pagedconsole;

public interface Server {

	void setPageRepository(PageRepository pageRepository);

	Page request(String pageName);

}
