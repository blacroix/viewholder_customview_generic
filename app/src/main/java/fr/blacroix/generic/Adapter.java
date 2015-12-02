package fr.blacroix.generic;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.List;

public class Adapter<T, V extends ItemView<T>> extends BaseAdapter {

    private final LayoutInflater inflater;
    private final List<T> data;
    private final int viewId;

    public Adapter(LayoutInflater inflater, List<T> data, int viewId) {
        this.inflater = inflater;
        this.data = data;
        this.viewId = viewId;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public T getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return getItem(position).hashCode();
    }

    @SuppressWarnings("unchecked")
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        V view;
        if (convertView == null) {
            view = (V) inflater.inflate(viewId, parent, false);
        } else {
            view = (V) convertView;
        }
        view.bindView(getItem(position));
        return (View) view;
    }
}
