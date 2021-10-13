package view;

import control.ManagerCard;
import model.Book;
import model.Card;
import model.Student;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner number = new Scanner(System.in);

        ArrayList<Student> studentArrayList = new ArrayList<>();
        ArrayList<Book> bookArrayList = new ArrayList<>();
        ArrayList<Card> cardArrayList = new ArrayList<>();

        studentArrayList.add(new Student("Nguyễn Tiến Long","C1", "2000","C0821H1"));
        studentArrayList.add(new Student("Nguyễn Anh Tuấn","C2", "1997","C0821H1"));
        studentArrayList.add(new Student("Nguyễn Hoàng Duy","C3", "1991","C0821H1"));

        bookArrayList.add(new Book("B1","Đắc nhân tâm"));
        bookArrayList.add(new Book("B2","Nhà giả kim"));
        bookArrayList.add(new Book("B3","Đời thay đổi khi chúng ta thay đổi"));
        bookArrayList.add(new Book("B4","Dạy Con Làm Giàu "));
        bookArrayList.add(new Book("B5","Cha giàu cha nghèo"));

        cardArrayList.add(new Card(studentArrayList.get(0),bookArrayList.get(0),LocalDate.of(2021,10,13),LocalDate.of(2021,10,19)));
        cardArrayList.add(new Card(studentArrayList.get(1),bookArrayList.get(4),LocalDate.of(2021,10,13),LocalDate.of(2021,10,18)));
        cardArrayList.add(new Card(studentArrayList.get(2),bookArrayList.get(2),LocalDate.of(2021,10,13),LocalDate.of(2021,10,17)));
        ManagerCard managerCard = new ManagerCard(studentArrayList,cardArrayList,bookArrayList);

        int choice = -1;


        while (choice != 0){
            System.out.println("--------Thư viện CodeGyms--------");
            System.out.println("1. Thêm sinh viên");
            System.out.println("2. Thêm sách vào thư viện");
            System.out.println("3. Thêm thẻ thư viện");
            System.out.println("4. Tìm kiếm Sinh Viên");
            System.out.println("5. Danh sách Sinh viên mượn sách");
            System.out.println("6. Danh sách sinh viên");
            System.out.println("7. Exit");

            choice = number.nextInt();
            switch (choice){
                case 1:
                    managerCard.addStudent(addStudent());
                    break;
                case 2:
                    managerCard.addBook(addBook());
                    break;
                case 3:
                    addCard(cardArrayList, managerCard);
                    break;
                case 4:
                    searchStudent(managerCard);
                    break;
                case 5:
                    managerCard.showAllCard();
                    break;
                case 6:
                    managerCard.showAllStudent();
                    break;
                case 7:
                    System.exit(0);
            }
        }
    }

    //thêm thẻ thư viện
    private static void addCard(ArrayList<Card> cardArrayList, ManagerCard managerCard) {
        Scanner string = new Scanner(System.in);
        System.out.print("Nhập code sinh viên: ");
        String codeStudent = string.nextLine();
        System.out.println("Nhập code sách mượn: ");
        String codeBook = string.nextLine();
        Student student = managerCard.searchStudentByCode(codeStudent);
        Book book = managerCard.searchBookByCode(codeBook);
        if(student != null && book != null){
            cardArrayList.add(new Card(student,book,enterTheLoan(),enterPaymentDate()));
        } else {
            System.out.println("Không có sinh viên. Vui lòng nhập lại!");
        }
    }


    //Thêm sinh viên
    private static Student addStudent() {
        Scanner string = new Scanner(System.in);
        String nameStudent;
        String dateOfBirth;
        String codeStudent;
        String class1;
        System.out.print("Nhập tên sinh viên: ");
        nameStudent = string.nextLine();
        System.out.print("Nhập mã sinh viên: ");
        codeStudent = string.nextLine();
        System.out.print("Nhập năm sinh: ");
        dateOfBirth = string.nextLine();
        System.out.print("Nhập tên lớp: ");
        class1 = string.nextLine();
        return new Student(nameStudent,codeStudent,dateOfBirth,class1);
    }

    //Thêm sách
    public static Book addBook(){
        Scanner string = new Scanner(System.in);
        String bookCode, bookName;
        System.out.print("Nhập mã sách: ");
        bookCode = string.nextLine();
        System.out.print("Nhập tên sách: ");
        bookName = string.nextLine();
        return new Book(bookCode,bookName);
    }

    //tìm kiếm sinh viên theo code
    private static void searchStudent(ManagerCard managerCard) {
        Scanner code1 = new Scanner(System.in);
        System.out.print("Nhập code sinh viên: ");
        String code = code1.nextLine();
        Student student = managerCard.searchStudentByCode(code);
        if(student != null){
            System.out.println(student);
        } else {
            System.out.println("Không có sinh viên. Vui lòng nhập lại!");
        }
    }


    //thêm ngày mượn
    public static LocalDate enterTheLoan() {
        System.out.print("Năm mượn: ");
        Scanner number = new Scanner(System.in);
        int year = number.nextInt();
        System.out.print("Tháng mượn: ");
        int month = number.nextInt();
        System.out.print("Ngày mượn: ");
        int day = number.nextInt();
        return LocalDate.of(year, month, day);
    }

    //thêm ngày trả
   public static LocalDate enterPaymentDate() {
        System.out.print("Năm trả: ");
        Scanner number = new Scanner(System.in);
        int year = number.nextInt();
        System.out.print("Tháng trả: ");
        int month = number.nextInt();
        System.out.print("Ngày trả: ");
        int day = number.nextInt();
        return LocalDate.of(year, month, day);
    }


}
