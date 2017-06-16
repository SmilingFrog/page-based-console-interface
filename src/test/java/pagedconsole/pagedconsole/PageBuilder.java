package pagedconsole.pagedconsole;

public interface PageBuilder {

	Page build();

	void append(PageElement pageElement);

	void setPageName(String pageName);

}
