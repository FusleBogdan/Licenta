/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package quiz.application;

/**
 *
 * @author fusle
 */
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class QuizServer {
    public static void main(String[] args) {
        try {
            QuizService quizService = new QuizServiceImpl();
            Registry registry = LocateRegistry.createRegistry(1099);
            registry.bind("QuizService", quizService);
            System.out.println("Quiz server is ready.");
        } catch (Exception e) {
            System.err.println("Server exception: " + e.toString());
            e.printStackTrace();
        }
    }
}
