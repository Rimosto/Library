package com.library;

public class Book {
        private int book_id;
        private String title;
        private String author;
        private String genre;
        private boolean availability;
    
        public Book(int book_id, String title, String author, String genre, boolean availability) {
            this.book_id = book_id;
            this.title = title;
            this.author = author;
            this.genre = genre;
            this.availability = availability;
        }
    
        public int getBookId() { return book_id; }
        public String getTitle() { return title; }
        public String getAuthor() { return author; }
        public String getGenre() { return genre; }
        public boolean isAvailable() { return availability; }
    }
    
