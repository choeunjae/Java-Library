import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LibraryProgram {
    public static void main(String[] args) {
        BookDatabase database = new BookDatabase();
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("[ 도서관 프로그램 ]");
            System.out.println("1. 책 추가");
            System.out.println("2. 책 검색");
            System.out.println("3. 카테고리 수정");
            System.out.println("4. 종료");
            System.out.print("메뉴 선택 : ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    // 도서 정보 추가 기능
                    addBook(scanner, database);
                    break;

                case 2:
                    // 도서 검색 기능
                    searchBook(database, scanner);
                    break;

                case 3:
                    // 도서 카테고리 수정 기능
                    updateCategory(scanner, database);
                    break;

                case 4:
                    running = false;
                    System.out.println("프로그램 종료");
                    break;

                default:
                    System.out.println("잘못된 선택입니다.");
            }
        }

        scanner.close();
    }

    private static void addBook(Scanner scanner, BookDatabase database) {
        System.out.println("[ 책 추가 ] ");
        System.out.print("제목 입력: ");
        String title = scanner.nextLine();

        System.out.print("저자 입력: ");
        String author = scanner.nextLine();

        System.out.print("카테고리 입력: ");
        String category = scanner.nextLine();

        database.saveBook(title, author, category);
        System.out.println("도서 정보가 저장되었습니다.");
    }

    private static void searchBook(BookDatabase database, Scanner scanner) {
        List<Main> books = database.getBooks();

        if (books.isEmpty()) {
            System.out.println("등록된 책이 없습니다.");
            return;
        }

        System.out.println("[ 책 검색 ]");
        System.out.println("1. 제목");
        System.out.println("2. 저자");
        System.out.println("3. 카테고리");
        System.out.print("선택: ");
        int searchChoice = scanner.nextInt();
        scanner.nextLine(); // 개행 제거

        System.out.print("검색어 입력: ");
        String keyword = scanner.nextLine().trim();

        ArrayList<Main> searchResults = new ArrayList<>();

        for (Main book : books) {
            switch (searchChoice) {
                case 1:
                    if (book.title.contains(keyword)) searchResults.add(book);
                    break;
                case 2:
                    if (book.author.contains(keyword)) searchResults.add(book);
                    break;
                case 3:
                    if (book.category.contains(keyword)) searchResults.add(book);
                    break;
                default:
                    System.out.println("잘못된 선택입니다.");
                    return;
            }
        }

        if (searchResults.isEmpty()) {
            System.out.println("검색 결과가 없습니다.");
        } else {
            System.out.println("검색 결과: ");
            for (Main b : searchResults) {
                System.out.println("제목: " + b.title + ", 저자: " + b.author + ", 카테고리: " + b.category);
            }
        }
    }

    private static void updateCategory(Scanner scanner, BookDatabase database) {
        List<Main> books = database.getBooks();

        if (books.isEmpty()) {
            System.out.println("등록된 책이 없습니다.");
            return;
        }

        System.out.print("카테고리를 변경할 책 제목 입력: ");
        String title = scanner.nextLine().trim();

        boolean found = false;
        for (Main book : books) {
            if (book.title.equals(title)) {
                System.out.print("새 카테고리 입력: ");
                String newCategory = scanner.nextLine().trim();
                book.category = newCategory;
                System.out.println("카테고리가 변경되었습니다.");
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("해당 제목의 책이 없습니다.");
        }
    }
}