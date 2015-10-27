package com.campuscoach.entities;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.campuscoach.campuscoachapp.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class ReservationAdapter extends BaseAdapter {

    private Context context;
    private List<Reservation> lists;
    private LayoutInflater layoutInflater;
    ImageView imageView;
    TextView title;
    TextView introduction;

    public ReservationAdapter(Context context,  List<Reservation> lists){
        this.context = context;
        this.lists = lists;
        layoutInflater = LayoutInflater.from(this.context);
    }

    @Override
    public int getCount() {
        return lists.size();
    }

    @Override
    public Object getItem(int position) {
        return lists.get(position);
    }

    @Override
    public long getItemId(int position) { return position; }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // convertView�������item�Ľ������ֻ��Ϊ�յ�ʱ�����ǲ���Ҫ���¸�ֵһ�Σ������������Ч�ʣ�������������Ļ���ϵͳ���Զ�����
        //item_listview�����Զ����item�Ĳ����ļ�
        if (convertView == null) {
            convertView = layoutInflater.inflate(R.layout.reservation_entity, null);
        }
        //ע��findViewById��ʱ��Ҫʹ��convertView�������������Ϊ������������пؼ���Ѱ��
        imageView = (ImageView) convertView.findViewById(R.id.img);
        title = (TextView) convertView.findViewById(R.id.title);
        introduction = (TextView) convertView.findViewById(R.id.introduction);
        //��������ؼ����а�
        imageView.setImageResource(R.drawable.nopicture);
        title.setText(lists.get(position).getReservationName());
        introduction.setText(lists.get(position).getIntroduction());

        return convertView;
    }
}
