package com.example.mz.survey;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.view.LayoutInflater;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.BaseAdapter;
import android.view.ViewGroup;
import java.util.ArrayList;


public class SteptwelveActivity extends AppCompatActivity {

    private MyAdapter adapter;
    private ListView listview;
    private Button but;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_steptwelve);
        //获取xml文件的各个控件的id
        listview = (ListView)findViewById(R.id.listview);
        but=(Button)  findViewById(R.id.button13);

        //创建一个adapter
        adapter = new MyAdapter();
        //将listview添加到adapter
        listview.setAdapter(adapter);

        but.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(SteptwelveActivity.this,StepthirteenActivity.class);
                startActivity(intent);
            }
        });
    }

    //重写adapter

    private class MyAdapter extends BaseAdapter {

        private ArrayList<Message> list= new ArrayList<Message>();

        public MyAdapter(){
            for(int i = 1 ;i<=100 ; i++){
                //list.add(new Message("item_111111111111111111111111"+i));
                switch (i){
                    case 1: list.add(new Message("Not beautiful scenic landscape."));
                        break;
                    case 2:list.add(new Message("Scenic area management is not atandardized."));
                        break;
                    case 3: list.add(new Message("A small scenic facilities"));
                        break;
                    case 4:list.add(new Message("No national character tourism project"));
                        break;
                    case 5:list.add(new Message("Scenic poor sanitation"));
                        break;
                    case 6:list.add(new Message("Few tourism projects "));
                        break;
                    case 7:list.add(new Message("The poor quality of travel agency services."));
                        break;
                    case 8:list.add(new Message("Scenic poor staff attitude"));
                        break;
                    case 9:list.add(new Message("Poor conditions of hotel accommodation."));
                        break;
                    case 10:list.add(new Message("Others"));
                        break;
                    default:;
                        break;

                }
            }
        }


        @Override
        public int getCount() {
            return list.size();
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        //设置外观
        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder viewHolder;

            //引用xml布局文件对listview的item进行外观设置
            if(convertView == null){
                LayoutInflater inflater = LayoutInflater.from(SteptwelveActivity.this);
                convertView = inflater.inflate(R.layout.listview_item, null);
                viewHolder = new ViewHolder();
                viewHolder.checkBox = (CheckBox)convertView.findViewById(R.id.checkBox1);
                convertView.setTag(viewHolder);
            }else{
                viewHolder = (ViewHolder)convertView.getTag();
            }
            final Message msg = list.get(position);
            viewHolder.checkBox.setText(msg.str);
            viewHolder.checkBox.setChecked(msg.isCheck);
            return convertView;
        }

    }
    private class ViewHolder{
        CheckBox checkBox;
    }



    }








