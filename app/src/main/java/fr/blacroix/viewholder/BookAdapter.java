package fr.blacroix.viewholder;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import fr.blacroix.Book;
import fr.blacroix.viewholder_customview.R;

public class BookAdapter extends BaseAdapter {

    private final Context context;
    private final LayoutInflater inflater;
    private final List<Book> books;

    public BookAdapter(Context context, LayoutInflater inflater, List<Book> books) {
        this.context = context;
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
        BookViewHolder bookViewHolder;
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.view_holder_book, parent, false);
            TextView titleTextView = (TextView) convertView.findViewById(R.id.titleTextView);
            ImageView coverImageView = (ImageView) convertView.findViewById(R.id.coverImageView);
            convertView.setTag(new BookViewHolder(titleTextView, coverImageView));
        }
        Book book = books.get(position);
        bookViewHolder = (BookViewHolder) convertView.getTag();
        bookViewHolder.titleTextView.setText(book.getTitle());
        Glide.with(context)
                .load(book.getCover())
                .placeholder(R.drawable.ic_launcher)
                .into(bookViewHolder.coverImageView);
        return convertView;
    }

    private static class BookViewHolder {
        final TextView titleTextView;
        final ImageView coverImageView;


        public BookViewHolder(TextView titleTextView, ImageView coverImageView) {
            this.titleTextView = titleTextView;
            this.coverImageView = coverImageView;
        }
    }
}
