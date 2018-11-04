package com.example.dorol.listtest;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.list_view);

        String[] values = {"Apple", "Apricot", "Avocado", "Banana", "BlackBerry", "Blueberry", "Cherry"
                , "Coconut", "Cranberry", "Grape Raisin", "Honeydew", "Jackfruit", "Lemon", "Lime", "Mango", "Watermelon" };

        MyAdapter adapter = new MyAdapter(this, values);
        listView.setAdapter(adapter);
    }
}

class MyAdapter extends BaseAdapter {
    private final Context context;
    private final String[]  values;

    public MyAdapter(Context context,  String[] values) {
        this.context = context;
        this.values = values;
    }

    @Override
    public int getCount() {
        return values.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        //XML layout 파일을 View 객체로 만드는 역할

        View itemView = inflater.inflate(R.layout.list_item, parent, false);
        //(int resource, ViewGroup root, boolean attachToRoot)
        //attachToRoot : View를 root에 자식으로 / root는 생성되는 View의 LayoutParam을 생성하는데만 사용된다.

        TextView textView = itemView.findViewById(R.id.label);
        ImageView imageView = itemView.findViewById(R.id.icon);

        String str = values[position];
        textView.setText(str);

        if(str.startsWith("App") || str.startsWith("Cher") || str.startsWith("Ban")) {
            imageView.setImageResource(R.drawable.good);
        } else {
            imageView.setImageResource(R.drawable.fig);
        }

        return itemView;
    }
}
