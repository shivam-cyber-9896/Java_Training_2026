package com.shivam.monocept.ocp.test;

 import java.util.Scanner;

import com.shivam.monocept.ocp.model1.ArticleContent;
import com.shivam.monocept.ocp.model1.Content;
import com.shivam.monocept.ocp.model1.ContentRenderer;
import com.shivam.monocept.ocp.model1.PodcastContent;
import com.shivam.monocept.ocp.model1.QuizContent;
import com.shivam.monocept.ocp.model1.VideoContent;

public class ContentTest {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        ContentRenderer renderer = new ContentRenderer();

        while (true) {
            System.out.println("\n===== LMS Content Renderer =====");
            System.out.println("1. Render Video");
            System.out.println("2. Render Article");
            System.out.println("3. Render Quiz");
            System.out.println("4. Render Podcast (New Type)");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            String input = scanner.nextLine();

            while (input == null || input.trim().isEmpty() || !input.matches("\\d+")) {
                System.out.print("Enter valid choice: ");
                input = scanner.nextLine();
            }

            int choice = Integer.parseInt(input);

            Content content = null;

            switch (choice) {

                case 1:
                    content = new VideoContent();
                    break;

                case 2:
                    content = new ArticleContent();
                    break;

                case 3:
                    content = new QuizContent();
                    break;

                case 4:
                    content = new PodcastContent(); 
                    break;

                case 5:
                    System.out.println(" Exiting...");
                    scanner.close();
                    return;

                default:
                    System.out.println(" Invalid choice!");
                    continue;
            }

           
            renderer.renderContent(content);
        }
    }
}