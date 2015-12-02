package fr.blacroix.customview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.List;

import fr.blacroix.Book;
import fr.blacroix.viewholder_customview.R;

public class BookAdapter extends BaseAdapter {

    private final LayoutInflater inflater;
    private final List<Book> books;

    public BookAdapter(LayoutInflater inflater, List<Book> books) {
        this.inflater = inflater;
        this.books = books;
    }

    @Override
    public int getCount() {
        return books.size();
    }

    @Override
    public Book getItem(int position) {
        return books.get(position);
    }

    @Override
    public long getItemId(int position) {
        return getItem(position).hashCode();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        BookItemView bookItemView;
        if (convertView == null) {
            bookItemView = (BookItemView) inflater.inflate(R.layout.custom_view_book, parent, false);
        } else {
            bookItemView = (BookItemView) convertView;
        }
        bookItemView.bindView(getItem(position));
        return bookItemView;
    }
}
