package pagedconsole.pagedconsole;

public interface PageRepository {

	Page find(String pageName);

	void add(Page page);

}
