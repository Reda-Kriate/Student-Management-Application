package Menu;


import Interaction.Interaction;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Interaction interaction = new Interaction();
        int option;
        System.out.println("#####----->> Students Management System <<-----#####");
    do{
        System.out.println("--------MENU---------");
        System.out.println("1. Add Student");
        System.out.println("2. Remove Student");
        System.out.println("3. Edit Student");
        System.out.println("4. Show Student");
        System.out.println("5. Show All Students");
        System.out.println("6. Exit");
        System.out.println("------> Choose Option ------");
        option = scanner.nextInt();
        switch (option) {
            case 1:
                System.out.println("Enter student name");
                String name = scanner.next();
                System.out.println("Enter student age");
                int age = scanner.nextInt();
                System.out.println("Enter student city");
                String city = scanner.next();
                System.out.println("Enter student porcentage");
                int porcentage = scanner.nextInt();
                if (interaction.insertStudent(name, age, city, porcentage))
                    System.out.println("Student Added....");
                else System.out.println("Student Not Added....");
                break;

            case 2:
                System.out.println("Inserer l'ID de la student : ");
                int idRem = scanner.nextInt();
                if (interaction.removeStudent(idRem))
                    System.out.println("Student Removed....");
                else System.out.println("Student Not Removed....");
                break;
            case 3:
                System.out.println("Updater le student complet ( entrer son ID ): ");
                int idUp = scanner.nextInt();
                System.out.println("Entrer le Nouveau Nom : ");
                String nom = scanner.next();
                System.out.println("Entrer le Nouveau age : ");
                int ageUp = scanner.nextInt();
                System.out.println("Entrer le Nouveau City : ");
                String cityUp = scanner.next();
                System.out.println("Entrer le Nouveau Porcentage : ");
                int porcentageUp = scanner.nextInt();
                if (interaction.updateStudent(nom, ageUp, cityUp, porcentageUp, idUp))
                    System.out.println("Student Updated....");
                else System.out.println("Student Not Updated....");
                break;
            case 4:
                System.out.println("Show Student By Id ");
                System.out.println("Enter student ID : ");
                int id = scanner.nextInt();
                interaction.showStudents(id);
                break;
            case 5:
                System.out.println("Show All Students : ");
                interaction.showAllStudents();
                break;
            case 6:
                System.out.println("Exit....");
        }
    }while(option!=6);
    }
}