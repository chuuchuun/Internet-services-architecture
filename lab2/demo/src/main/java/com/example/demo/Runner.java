package com.example.demo;

import com.example.demo.entities.Course;
import com.example.demo.entities.University;
import com.example.demo.services.CourseService;
import com.example.demo.services.UniversityService;
import org.springframework.stereotype.Component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

import java.util.List;
import java.util.Scanner;

    @Component
    public class Runner implements CommandLineRunner {
        private final CourseService courseService;
        private final UniversityService universityService;
        @Autowired
        public Runner(CourseService courseService, UniversityService universityService) {
            this.courseService = courseService;
            this.universityService = universityService;
        }

        @Override
        public void run(String... args) {
            boolean isRunning = true;
            Scanner scanner = new Scanner(System.in);
            System.out.println("Welcome to the vehicle service:");
            while(isRunning){
                System.out.println("List of commands:");
                System.out.println("exit - to close the application");
                System.out.println("su - to display all universities");
                System.out.println("sc - to display all courses");
                System.out.println("au - to add a new university");
                System.out.println("ac - to add a new course");
                System.out.println("du - to delete a course");
                System.out.println("dc - to delete a university");
                String command = scanner.nextLine();
                switch(command){
                    case "exit" -> isRunning = false;
                    case "su" -> showAllUniversities();
                    case "sc" -> showAllCourses();
                    case "au" -> addUniversity(scanner);
                    case "ac" -> addCourse(scanner);
                    case "du" ->deleteUniversity(scanner);
                    case "dc" -> deleteCourse(scanner);
                    default -> System.out.println("Invalid command");
                }
            }

        }
        public void addCourse(Scanner scanner) {
            System.out.println("Enter course name: ");
            String courseName = scanner.nextLine();
            System.out.println("Enter course's credits");
            String creditsString = scanner.nextLine();
            int credits = Integer.parseInt(creditsString);
            System.out.println("Enter university (choose number from a list): ");
            List<University> u = universityService.findAll();
            for(int i = 0; i < u.size(); i++) {
                System.out.println((i+1) + ". " + u.get(i).getName());
            }
            String choiceString = scanner.nextLine();
            int choice = Integer.parseInt(choiceString)-1;
            courseService.create(Course.builder()
                    .courseName(courseName)
                    .credits(credits)
                    .university(u.get(choice))
                    .build());
            System.out.println("Course added");
        }
        public void showAllUniversities(){
            universityService.findAll().forEach(System.out::println);
        }
        public void showAllCourses(){
            courseService.findAll().forEach(System.out::println);
        }
        public void addUniversity(Scanner scanner) {
            System.out.println("Enter university name: ");
            String name = scanner.nextLine();
            System.out.println("Enter location: ");
            String location = scanner.nextLine();

            universityService.create(University.builder()
                    .name(name)
                    .location(location)
                    .build());
            System.out.println("University added");
        }
        public void deleteCourse(Scanner scanner) {
            System.out.println("Select a course number to delete: ");
            List<Course> c = courseService.findAll();
            for(int i = 0; i < c.size(); i++) {
                System.out.println((i+1) + ". " + c.get(i).getCourseName());
            }
            String choiceString = scanner.nextLine();

            int choice = Integer.parseInt(choiceString)-1;
            courseService.delete(c.get(choice).getCourseId());
            System.out.println("Course deleted");
        }
        public void deleteUniversity(Scanner scanner) {
            System.out.println("Select university number to delete: ");
            List<University> p = universityService.findAll();
            for(int i = 0; i < p.size(); i++) {
                System.out.println((i+1) + ". " + p.get(i).getName());
            }
            int choice = Integer.parseInt(scanner.nextLine())-1;

            universityService.delete(p.get(choice).getId());
            System.out.println("University deleted");
        }
    }
