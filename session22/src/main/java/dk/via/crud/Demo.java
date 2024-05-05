package dk.via.crud;

import dk.via.book.Book;
import dk.via.book.Music;

import java.util.List;

public class Demo {
    public static void main(String[] args) throws Exception {
        BookReader bookReader = new BookReader();
        MusicReader musicReader = new MusicReader();

        DatabaseReader<Book> bookReader2 = new DatabaseReader<>("SELECT * FROM Book;", (rs) -> ObjectFactory.createBook(rs));
        DatabaseReader<Music> musicReader2 = new DatabaseReader<>("SELECT * FROM Music;", (rs) -> ObjectFactory.createMusic(rs));

        DatabaseReader<Book> bookReader3 = new DatabaseReader<>("SELECT * FROM Book;", ObjectFactory::createBook);
        DatabaseReader<Music> musicReader3 = new DatabaseReader<>("SELECT * FROM Music;", ObjectFactory::createMusic);
        List<Book> books = bookReader3.readAll();

        List<Music> music = DatabaseReaderAlt.readAll("SELECT * FROM Music;", ObjectFactory::createMusic);
    }
}
