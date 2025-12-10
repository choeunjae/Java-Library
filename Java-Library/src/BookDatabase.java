import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class BookDatabase {
    private static final String FILE_NAME = "books.csv";

    // 1. 도서 CSV에 저장
    public void saveBook(String title, String author, String category) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME, true))) {
            writer.write(title + "," + author + "," + category);
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // 2. CSV에서 도서 전체 불러오기
    public List<Main> getBooks() {
        List<Main> books = new ArrayList<>();
        File file = new File(FILE_NAME);

        if (!file.exists()) {
            return books; // 파일 없으면 빈 리스트
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;

            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");

                if (data.length == 3) {
                    books.add(new Main(data[0], data[1], data[2]));
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return books;
    }

    // 3. 제목으로 카테고리 수정 후 CSV 재저장
    public boolean updateCategoryByTitle(String title, String newCategory) {
        List<Main> books = getBooks();
        boolean updated = false;

        for (Main book : books) {
            if (book.title.equals(title)) {
                book.category = newCategory;
                updated = true;
            }
        }

        // 수정본 CSV 전체 다시 덮어쓰기
        if (updated) {
            saveAllBooks(books);
        }

        return updated;
    }

    // CSV 전체 새로 저장
    private void saveAllBooks(List<Main> books) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (Main b : books) {
                writer.write(b.title + "," + b.author + "," + b.category);
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
