import java.util.*;

public class BookDatabase {

    private List<Main> books = new ArrayList<>();

    public void saveBook(String title, String author, String category) {
        Main newBook = new Main(title, author, category);
        books.add(newBook);
    }

    public List<Main> getBooks() {
        return books;
    }

    public boolean updateCategoryByTitle(String title, String newCategory) {
        for (Main book : books) {
            if (book.title.equals(title)){
                book.category = newCategory;
                return true;
            }
        }
        return false;
    }
}