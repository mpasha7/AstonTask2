package com.company.mycollections;

public class Book {
    private final String author;
    private final String title;
    private final int pagesCount;
    private final int releaseYear;

    public Book(String author, String title, int pagesCount, int releaseYear) {
        this.author = author;
        this.title = title;
        this.pagesCount = pagesCount;
        this.releaseYear = releaseYear;
    }

    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    public Integer getPagesCount() {
        return pagesCount;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    @Override
    public String toString() {
        return String.format("%s: %s (%d стр. %d год)", author, title, pagesCount, releaseYear);
    }

    @Override
    public int hashCode() {
        int result = 31;
        result = result * 31 + (author == null ? 0 : author.hashCode());
        result = result * 31 + (title == null ? 0 : title.hashCode());
        result = result * 31 + pagesCount;
        result = result * 31 + releaseYear;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }
        Book other = (Book) obj;
        return this.author.equals(other.author)
                && this.title.equals(other.title)
                && this.pagesCount == other.pagesCount
                && this.releaseYear == other.releaseYear;
    }

}
