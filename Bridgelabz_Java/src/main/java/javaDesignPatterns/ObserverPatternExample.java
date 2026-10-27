package javaDesignPatterns;

import java.util.ArrayList;
import java.util.List;

/**
 * Problem: Create Observer and Subject interfaces, implement NewsAgency,
 * and register and notify observers whenever news is published.
 *
 * Author : Hemang
 * Date   : 22-10-2026
 */

public class ObserverPatternExample {

    // Define how observers receive updates.
    interface Observer {
        void update(String news);
    }

    // Define the operations supported by a subject.
    interface Subject {
        void registerObserver(Observer observer);
        void removeObserver(Observer observer);
        void notifyObservers();
    }

    // Represent a news agency that publishes news.
    static class NewsAgency implements Subject {
        private List<Observer> observers = new ArrayList<>();
        private String news;

        // Register an observer for future updates.
        public void registerObserver(Observer observer) {
            observers.add(observer);
        }

        // Remove an observer from the notification list.
        public void removeObserver(Observer observer) {
            observers.remove(observer);
        }

        // Update the news and notify all observers.
        public void setNews(String news) {
            this.news = news;
            notifyObservers();
        }

        // Send the latest news to every registered observer.
        public void notifyObservers() {
            for (Observer observer : observers) {
                observer.update(news);
            }
        }
    }

    // Represent a subscriber who receives news.
    static class Subscriber implements Observer {
        private String name;

        // Initialize the subscriber's name.
        public Subscriber(String name) {
            this.name = name;
        }

        // Display the news received by the subscriber.
        public void update(String news) {
            System.out.println(name + " received news: " + news);
        }
    }

    // Test the Observer pattern.
    public static void main(String[] args) {
        // Create the news agency.
        NewsAgency agency = new NewsAgency();

        // Create subscribers.
        Observer amit = new Subscriber("Amit");
        Observer priya = new Subscriber("Priya");

        // Register both subscribers.
        agency.registerObserver(amit);
        agency.registerObserver(priya);

        // Publish news and notify subscribers.
        agency.setNews("Java 17 features explained");

        // Remove one subscriber.
        agency.removeObserver(amit);

        // Publish another update.
        agency.setNews("Design Patterns session tomorrow");
    }
}