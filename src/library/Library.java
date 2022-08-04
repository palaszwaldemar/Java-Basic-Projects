package library;

import java.util.List;

public class Library {
    private final FileReposytory fileReposytory = new FileReposytory();

    public List<Book> getBooks() {
        return fileReposytory.downloadFile();
    }

    public FileReposytory getFileReposytory() {
        return fileReposytory;
    }

    @Override
    public String toString() {
        return "Library{" +
                "books=" + getBooks() +
                '}';
    }
}
