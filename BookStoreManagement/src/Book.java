
public class Book {
	protected int id;
	protected String title;
	protected String author;
	protected float price;
	
	public Book(int id,String title,String author,float price) {
		this.id=id;
		this.title=title;
		this.author=author;
		this.price=price;
	 }

	
	public Book(String title2, String author2, float price2) {
	}


	public Book(int id2) {
		
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}
}
