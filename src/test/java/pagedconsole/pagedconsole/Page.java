package pagedconsole.pagedconsole;

public class Page {

	public static PageBuilder getPageBuilder() {
		return new PageBuilder() {

			@Override
			public Page build() {
				return new Page();
			}
		};
	}

}
