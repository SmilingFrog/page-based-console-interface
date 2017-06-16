package pagedconsole.pagedconsole;

public class BrowserImpl implements Browser {

	Server server;
	
	public Server getServer() {
		return server;
	}

	public void setServer(Server server) {
		this.server = server;
	}

	@Override
	public String browse(String pageName) {
		Page page = server.request(pageName);
		String pageContent = null;
		if(page == null){
			pageContent = "ERROR\nPAGE \"" + pageName + "\" NOT FOUND\nFOOTER\n";
		}else{
			pageContent = page.getContent();
		}
		
		System.out.println(pageContent);
		return pageContent;
	}

	public void setServer(ServerImpl server) {
		this.server = server;
	}

}
