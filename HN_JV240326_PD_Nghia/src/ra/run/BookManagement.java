package ra.run;

import ra.bussiness.Book;

import java.util.Scanner;

public class BookManagement {
    public static Book[] books = new Book[100];
    public static int indexBook = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("==============================MENU==============================");
            System.out.println("1.Nhập số lượng sách thêm mới và nhập thông tin cho từng cuốn sách.");
            System.out.println("2.Hiển thị thông tin tất cả sách trong thư viện.");
            System.out.println("3.Sắp xếp sách theo lợi nhuận tăng dần.");
            System.out.println("4.Xóa sách theo mã sách.");
            System.out.println("5.Tìm kiếm tương đối sách theo tên sách hoặc mô tả.");
            System.out.println("6.Thay đổi thông tin sách theo mã sách.");
            System.out.println("7.Thoát.");
            System.out.println("----------------------------------------------------------------");
            System.out.println("Chọn chức năng: ");
            byte choice = Byte.parseByte(scanner.nextLine());
            switch (choice) {
                case 1:
                    addBook(scanner);
                    break;
                case 2:
                    displayAllBooks();
                    break;
                case 3:
                    sortByInterest();
                    break;
                case 4:
                    deleteBook(scanner);
                    break;
                case 5:
                    searchBook(scanner);
                    break;
                case 6:
                    updateBook(scanner);
                    break;
                case 7:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ, vui lòng thử lại.");
            }
        } while (true);
    }

    //    C/R/U/D
    public static void addBook(Scanner scanner) {
        System.out.println("Nhập số lượng sách bạn muốn thêm");
        int number = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < number; i++) {
            System.out.println("Thêm sách " + (i + 1) + ":");
            Book book = new Book();
            book.inputData(scanner);
            books[indexBook] = book;
            indexBook++;
        }
        System.out.println("============================================================");
        System.out.println("Thêm " + number + " sách mới thành công.");
        System.out.println("============================================================");
    }

    public static void displayAllBooks() {
        if (indexBook == 0) {
            System.out.println("Danh sách sách đang trống.");
            return;
        }
        System.out.println("=========================THÔNG TIN SÁCH=========================");
        for (int i = 0; i < indexBook; i++) {
            books[i].displayData();
        }
        System.out.println("================================================================");
    }

    public static void sortByInterest() {
        if (indexBook == 0) {
            System.err.println("Danh sách sách đang trống.");
            return;
        }
        for (int i = 0; i < indexBook - 1; i++) {
            for (int j = i + 1; j < indexBook; j++) {
                if (books[i].getInterest() > books[j].getInterest()) {
                    Book temp = books[i];
                    books[i] = books[j];
                    books[j] = temp;
                }
            }
        }
        System.out.println("Sắp xếp theo lợi nhuận thành công.");
    }

    public static void deleteBook(Scanner scanner) {
        if (indexBook == 0) {
            System.err.println("Danh sách sách đang trống.");
            return;
        }
        System.out.println("Nhập ID sách bạn muốn xóa");
        int id = Integer.parseInt(scanner.nextLine());
        boolean isExist = false;
        int indexDelete = 0;
        for (int i = 0; i < indexBook; i++) {
            if (books[i].getBookId() == id) {
                indexDelete = i;
                isExist = true;
                break;
            }
        }
        if (!isExist) {
            System.err.println("Không tìm thấy sách.");
        } else {
            for (int i = indexDelete; i < indexBook; i++) {
                books[i] = books[i + 1];
            }
            indexBook--;
            System.out.println("Xóa sách thành công.");
        }
    }

    public static void updateBook(Scanner scanner) {
        if (indexBook == 0) {
            System.out.println("Danh sách sách đang trống.");
            return;
        }
        System.out.println("Nhập ID sách bạn muốn cập nhật");
        int id = Integer.parseInt(scanner.nextLine());
        boolean isExist = false;
        for (int i = 0; i < indexBook; i++) {
            if (books[i].getBookId() == id) {
                System.out.println("Thông tin sách");
                books[i].displayData();
                System.out.println("Thay đổi thông tin cho sách");
                books[i].updateData(scanner);
                isExist = true;
                break;
            }
        }
        if (!isExist) {
            System.out.println("Không tìm thấy sách!.");
        } else {
            System.out.println("Cập nhật sách thành công.");
        }
    }

    public static void searchBook(Scanner scanner) {
        if (indexBook == 0) {
            System.out.println("Danh sách sách đang trống.");
            return;
        }
        System.out.println("Nhập tên sách hoặc mô tả sách bạn muốn tìm kiếm");
        String bookSearch = scanner.nextLine();
        int count = 0;
        for (int i = 0; i < indexBook; i++) {
            if (books[i].getBookName().contains(bookSearch) || books[i].getDescription().contains(bookSearch)) {
                books[i].displayData();
                count++;
            }
        }
        if (count == 0) {
            System.out.println("Không tìm thấy sách!.");
        } else {
            System.out.println("Tìm thấy" + count + "sách.");
        }
    }
}