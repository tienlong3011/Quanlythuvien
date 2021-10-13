package control;

import model.Book;
import model.Card;
import model.Student;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class ManagerCard {
    ArrayList<Student> studentArrayList = new ArrayList<>();
    ArrayList<Card> cardArrayList = new ArrayList<>();
    ArrayList<Book> bookArrayList = new ArrayList<>();

    public ManagerCard() {
    }

    public ManagerCard(ArrayList<Student> studentArrayList, ArrayList<Card> cardArrayList, ArrayList<Book> bookArrayList) {
        this.studentArrayList = studentArrayList;
        this.cardArrayList = cardArrayList;
        this.bookArrayList = bookArrayList;
    }

    public ArrayList<Student> getStudentArrayList() {
        return studentArrayList;
    }

    public void setStudentArrayList(ArrayList<Student> studentArrayList) {
        this.studentArrayList = studentArrayList;
    }

    public ArrayList<Card> getCardArrayList() {
        return cardArrayList;
    }

    public void setCardArrayList(ArrayList<Card> cardArrayList) {
        this.cardArrayList = cardArrayList;
    }

    public ArrayList<Book> getBookArrayList() {
        return bookArrayList;
    }

    public void setBookArrayList(ArrayList<Book> bookArrayList) {
        this.bookArrayList = bookArrayList;
    }

    public void addStudent(Student student){
        studentArrayList.add(student);
    }

    public void addBook(Book book){
        bookArrayList.add(book);
    }

    public void addCard(Card card){
        cardArrayList.add(card);
    }

    public void editStudent(int index, Student newStudent){
        studentArrayList.set(index,newStudent);
    }

    public void editBook(int index, Book newBook){
        bookArrayList.set(index,newBook);
    }

    public void editCard(int index, Card newCard){
        cardArrayList.set(index,newCard);
    }

    public void removeStudent(int index){
        studentArrayList.remove(index);
    }

    public void removeBook(int index){
        bookArrayList.remove(index);
    }

    public void removeCard(int index){
        cardArrayList.remove(index);
    }

    public void showAllStudent(){
        for (Student student: studentArrayList) {
            System.out.println(student);
        }
    }

    public void showAllBook(){
        for (Book book: bookArrayList) {
            System.out.println(book);
        }
    }

    public void showAllCard(){
        for (Card card: cardArrayList) {
            System.out.println(card);
        }
    }

    public Student searchStudentByCode(String code){
        Student student = null;
        for (int i = 0; i < studentArrayList.size(); i++) {
            if(studentArrayList.get(i).getStudentCode().equalsIgnoreCase(code)){
                student =studentArrayList.get(i);
                break;
            }
        }
        return student;
    }

    public Book searchBookByCode(String code){
        Book book = null;
        for (int i = 0; i < bookArrayList.size(); i++) {
            if(bookArrayList.get(i).getBookCode().equalsIgnoreCase(code)){
                book = bookArrayList.get(i);
                break;
            }
        }
        return book;
    }

    public Card searchCardByCode(String code){
        Card card = null;
        for (int i = 0; i < cardArrayList.size(); i++) {
            if(cardArrayList.get(i).getStudent().getStudentCode().equalsIgnoreCase(code)){
                card = cardArrayList.get(i);
                break;
            }
        }
        return card;
    }

    public void writeListBill(){
        File file = new File("file.txt");
        try {
            OutputStream inputStream = new FileOutputStream(file);
            ObjectOutputStream ois = new ObjectOutputStream(inputStream);
            //ghi de
            ois.writeObject(cardArrayList);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //doc file
    public void readFile() {

        // tao file khi chua co
        File file = new File("file.txt");
        if (!file.exists()){
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
//         kiem tra xem file co du lieu khong
        try {
            InputStream is = new FileInputStream(file);
            ObjectInputStream ois = new ObjectInputStream(is);
            Scanner s = new Scanner(System.in);
            cardArrayList = (ArrayList<Card>) ois.readObject();
            ois.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
