package Interaction;

public interface InteractionInt {
    public boolean insertStudent(String name , int age, String city, int prc);
    public boolean removeStudent(int id);
    public boolean updateStudent(String name , int age, String city, int prc, int id);
    public boolean showStudents(int id);
    public boolean showAllStudents();
}
