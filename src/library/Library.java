package library;

import java.util.List;

public class Library {
    private final FileRepository fileRepository = new FileRepository();

    public List<Book> getBooks() {
        return fileRepository.downloadFile();
    }

    public FileRepository getFileReposytory() {
        return fileRepository;
    }

    @Override
    public String toString() {
        return "Library{" +
                "books=" + getBooks() +
                '}';
    }
}
