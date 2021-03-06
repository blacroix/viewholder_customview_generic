package fr.blacroix.generic;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import fr.blacroix.Book;
import fr.blacroix.viewholder_customview.R;

public class LibraryActivityGeneric extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_library);

        ListView listView = (ListView) findViewById(R.id.bookListView);

        List<Book> books = new ArrayList<>();
        Book b1 = new Book();
        b1.setCover("http://henri-potier.xebia.fr/hp0.jpg");
        b1.setIsbn("a");
        b1.setPrice("42");
        b1.setTitle("Henry Potier");
        books.add(b1);
        books.add(b1);
        books.add(b1);
        books.add(b1);
        books.add(b1);
        books.add(b1);
        books.add(b1);
        final Adapter<Book, BookItemView> bookAdapter = new Adapter<>(LayoutInflater.from(this), books, R.layout.item_view_book);
        listView.setAdapter(bookAdapter);
    }

}
