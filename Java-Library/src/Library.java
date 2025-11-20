import java.util.*;

// 메인 클래스
public class LibraryProgram {
    private static Scanner sc = new Scanner(System.in);

    private static BookInput input = new BookInput();
    private static BookSearch search = new BookSearch();
    private static BookCategoryUpdater updater = new BookCategoryUpdater();

    public static void main(String[] args) {
        while (true) {
            System.out.println("===== 도서관 프로그램 =====");
            System.out.println("1. 도서 정보 입력");
            System.out.println("2. 도서 검색");
            System.out.println("3. 도서 카테고리 수정");
            System.out.println("4. 종료");
            System.out.print("메뉴 선택 : ");

            int choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1:
                    input.addBook();
                    break;
                case 2:
                    search.searchBook();
                    break;
                case 3:
                    updater.updateCategory();
                    break;
                case 4:
                    System.out.println("프로그램 종료");
                    return;
                default:
                    System.out.println("잘못된 입력입니다.");
            }
        }
    }
}
