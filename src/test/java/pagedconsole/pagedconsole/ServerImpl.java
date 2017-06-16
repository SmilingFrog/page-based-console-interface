package pagedconsole.pagedconsole;

public class ServerImpl implements Server {

	PageRepository pageRepository;
	
	@Override
	public void setPageRepository(PageRepository pageRepository) {
		this.pageRepository = pageRepository;
	}

	@Override
	public Page request(String pageName) {
		return pageRepository.find(pageName);
	}

}
