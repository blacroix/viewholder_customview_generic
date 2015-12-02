package fr.blacroix.customview;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import fr.blacroix.Book;
import fr.blacroix.generic.ItemView;
import fr.blacroix.viewholder_customview.R;

public class BookItemView extends LinearLayout implements ItemView<Book> {

    private TextView titleTextView;
    private ImageView coverImageView;

    public BookItemView(Context context) {
        this(context, null);
    }

    public BookItemView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public BookItemView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        titleTextView = (TextView) findViewById(R.id.titleTextView);
        coverImageView = (ImageView) findViewById(R.id.coverImageView);
    }

    @Override
    public void bindView(Book book) {
        titleTextView.setText(book.getTitle());
        Glide.with(getContext())
                .load(book.getCover())
                .placeholder(R.drawable.ic_launcher)
                .into(coverImageView);
    }
}
