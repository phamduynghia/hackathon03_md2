package ra.bussiness;

import java.util.Scanner;

public class Book {
    private static int idCounter = 0; // Biến tĩnh để theo dõi ID
    private int bookId;
    private String bookName;
    private String author;
    private String descriptions;
    private double importPrice;
    private double exportPrice;
    private float interest;
    private boolean bookStatus = true;

    public Book() {
        this.bookId = ++idCounter; // Tăng idCounter và gán cho bookId
    }

    public Book(String bookName, String author, String descriptions, double importPrice, double exportPrice, boolean bookStatus) {
        this();
        this.bookName = bookName;
        this.author = author;
        this.descriptions = descriptions;
        this.importPrice = importPrice;
        this.exportPrice = exportPrice;
        this.interest = (float) (this.exportPrice - this.importPrice);
        this.bookStatus = bookStatus;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public int getBookId() {
        return bookId;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDescription() {
        return descriptions;
    }

    public void setDescription(String description) {
        this.descriptions = description;
    }

    public double getImportPrice() {
        return importPrice;
    }

    public void setImportPrice(double importPrice) {
        this.importPrice = importPrice;
    }

    public double getExportPrice() {
        return exportPrice;
    }

    public void setExportPrice(double exportPrice) {
        this.exportPrice = exportPrice;
    }

    public float getInterest() {
        return interest;
    }

    public void setInterest(float interest) {
        this.interest = interest;
    }

    public boolean isBookStatus() {
        return bookStatus;
    }

    public void setBookStatus(boolean bookStatus) {
        this.bookStatus = bookStatus;
    }

    public void inputData(Scanner scanner) {
        this.bookName = inputBookName(scanner);
        this.author = inputAuthor(scanner);
        this.descriptions = inputDescriptions(scanner);
        this.importPrice = inputImportPrice(scanner);
        this.exportPrice = inputExportPrice(scanner);
        this.interest = (float) (this.exportPrice - this.importPrice);
        this.bookStatus = inputBookStatus(scanner);
    }

    public void updateData(Scanner scanner) {
        this.bookName = inputBookName(scanner);
        this.author = inputAuthor(scanner);
        this.descriptions = inputDescriptions(scanner);
        this.importPrice = inputImportPrice(scanner);
        this.exportPrice = inputExportPrice(scanner);
        this.interest = (float) (this.exportPrice - this.importPrice);
        this.bookStatus = inputBookStatus(scanner);
    }

    public void displayData() {
        System.out.println("===========================================================================================================================================================");
        System.out.printf("ID : %2d | BookName: %5s | Author: %5s | Description: %15s | ImportPrice: %5.2f | ExportPrice: %5.2f | Interest: %5.2f | Status: %2s \n",
                this.bookId, this.bookName, this.author, this.descriptions, this.importPrice, this.exportPrice, this.interest, this.bookStatus ? "Active" : "inActive");
        System.out.println("===========================================================================================================================================================");
    }

    public String inputBookName(Scanner scanner) {

        while (true) {
            System.out.println("Nhập tên sách: ");
            String bookName = scanner.nextLine();
            if (bookName.trim().isEmpty()) {
                System.err.println("Tên sách không được để trống, vui lòng thử lại.");
            } else {
                return bookName;
            }
        }
    }

    public String inputAuthor(Scanner scanner) {
        while (true) {
            System.out.println("Nhập tên tác giả: ");
            String bookAuthor = scanner.nextLine();
            if (bookAuthor.trim().isEmpty()) {
                System.err.println("Tên tác giả của sách không được để trống, vui lòng thử lại");
            } else {
                return bookAuthor;
            }
        }
    }

    public String inputDescriptions(Scanner scanner) {
        while (true) {
            System.out.println("Nhập nội dung mô tả sách: ");
            String bookDescription = scanner.nextLine();
            if (!bookDescription.trim().isEmpty()) {
                if (bookDescription.length() >= 10) {
                    return bookDescription;
                } else {
                    System.err.println("Mô tả sách phải nhiều hơn 10 ký tự, vui lòng thử lại.");
                }
            } else {
                System.err.println("Mô tả sách không được để trống, vui lòng thử lại.");
            }
        }
    }

    public double inputImportPrice(Scanner scanner) {
        while (true) {
            System.out.println("Nhập giá nhập sách: ");
            double importPrice = Double.parseDouble(scanner.nextLine());
            if (importPrice > 0) {
                return importPrice;
            } else {
                System.err.println("Giá nhập sách phải là số dương, vui lòng thử lại.");
            }
        }
    }

    public double inputExportPrice(Scanner scanner) {
        while (true) {
            System.out.println("Nhập giá xuất sách: ");
            double exportPrice = Double.parseDouble(scanner.nextLine());
            if (exportPrice > importPrice * 1.2) {
                return exportPrice;
            } else {
                System.err.println("Giá xuất khẩu sách phải lớn hơn giá nhập khẩu ít nhất 20%, vui lòng thử lại.");
            }
        }
    }

    public boolean inputBookStatus(Scanner scanner) {
        while (true) {
            System.out.println("Trạng thái kho sách (True|False): ");
            String statusBook = scanner.nextLine();
            if (statusBook.equalsIgnoreCase("True") || statusBook.equalsIgnoreCase("False")) {
                return Boolean.parseBoolean(statusBook);
            } else {
                System.out.println("Trạng thái phải là True hoặc False, hãy thử lại.");
            }
        }
    }
}
