package Interaction;

import Database.Db;
import Student.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static Database.Db.connectionDatabase;

public class Interaction implements InteractionInt{
    @Override
    public boolean insertStudent(String name , int age, String city, int prc){
        boolean check;

    String sql = "insert into student(name,age,city,prc) values(?,?,?,?)";
        Connection con = connectionDatabase();
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, name);
            ps.setInt(2, age);
            ps.setString(3, city);
            ps.setInt(4, prc);
            ps.executeUpdate();
            check = true;
        } catch (SQLException e) {
            System.out.println("l'erreur dans l'insertion : "+e.getMessage());
           check = false;
        }
        return check;

    }


    @Override
    public boolean removeStudent(int id){
        boolean check;
        String sql = "delete from student where id = ?";
        Connection con = connectionDatabase();
        try{
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
            check = true;

        } catch (SQLException e) {
            System.out.println("l'erreur dans la suppression : "+e.getMessage());
            check = false;
        }
        return check;
    }
    @Override
    public boolean updateStudent(String name , int age, String city, int prc, int id){
        boolean check;
        String sql = "update student set name=?,age=?,city=?,prc=? where id=?";
        Connection con = connectionDatabase();
        try{
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1,name);
            ps.setInt(2,age);
            ps.setString(3,city);
            ps.setInt(4,prc);
            ps.setInt(5,id);
            ps.executeUpdate();

            check=true;
        }catch(SQLException e){
            System.out.println("l'erreur dans la suppression : "+e.getMessage());
            check = false;
        }
        return check;
    }
    @Override
    public boolean showStudents(int id){
        boolean check;
        String sql = "select * from student where id = ?";
        Connection con = connectionDatabase();
        try{
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1,id);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                int ID = rs.getInt("id");
                String name = rs.getString("name");
                int age = rs.getInt("age");
                String city = rs.getString("city");
                int prc = rs.getInt("prc");
                System.out.println("id :"+id+", name: "+name+", age: "+age+", city : "+city+", porcentage : "+prc);
            }
            check = true;
        } catch (SQLException e) {
            System.out.println("l'erreur dans la suppression : "+e.getMessage());
            check = false;
        }
        return check;
    }
    @Override
    public boolean showAllStudents(){
        boolean check;
        String sql = "select * from student";
        Connection con = connectionDatabase();
        try{
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int age = rs.getInt("age");
                String city = rs.getString("city");
                int prc = rs.getInt("prc");
                System.out.println("id :"+id+", name: "+name+", age: "+age+", city : "+city+", porcentage : "+prc);
            }
            check=true;
        } catch (SQLException e) {
            System.out.println("l'erreur dans la suppression : "+e.getMessage());
            check = false;
        }
        return check;
    }
}
