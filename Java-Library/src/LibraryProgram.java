import java.util.ArrayList;
import java.util.Scanner;

public class LibraryProgram {
    public static void main(String[] args) {
        ArrayList<Main> books = new ArrayList<>();
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
}

