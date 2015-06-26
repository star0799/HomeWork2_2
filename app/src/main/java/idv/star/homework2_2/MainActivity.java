package idv.star.homework2_2;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends ActionBarActivity {
    private ListView lvTeam;
    private List<Team> teamList;
    private TextView tvId;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    findViews();
    }
    public void findViews(){
        lvTeam=(ListView)findViewById(R.id.lvTeam);
        lvTeam.setAdapter(new TeamAdapter(this));





        lvTeam.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Team team = (Team) parent.getItemAtPosition(position);
                String info = team.getId()+team.getName();
                Toast.makeText(MainActivity.this, info, Toast.LENGTH_SHORT).show();
            }




        });






    }
    private class TeamAdapter extends BaseAdapter{
        private LayoutInflater layoutInflater;
        public TeamAdapter(Context context){
            teamList=new ArrayList<>();
            teamList.add(new Team(1,R.drawable.p1,"巴爾的摩金鶯"));
            teamList.add(new Team(2, R.drawable.p3, "洛杉磯天使"));
            teamList.add(new Team(3, R.drawable.p4, "波士頓紅襪"));
            teamList.add(new Team(4, R.drawable.p5, "克里夫蘭印地安人"));
            teamList.add(new Team(5, R.drawable.p6, "奧克蘭運動家"));
            teamList.add(new Team(6, R.drawable.p7, "紐約洋基"));
            teamList.add(new Team(7, R.drawable.p8, "底特律老虎"));
            teamList.add(new Team(8, R.drawable.p9, "西雅圖水手"));
            teamList.add(new Team(9, R.drawable.p10, "坦帕灣光芒"));
            layoutInflater = (LayoutInflater)context.getSystemService(LAYOUT_INFLATER_SERVICE);


        }
        @Override
        public int getCount(){return teamList.size();}
        @Override
        public Object getItem(int position) {
            return teamList.get(position);
        }
        @Override
        public long getItemId(int position) {
            return teamList.get(position).getId();
        }
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            if(convertView == null) {
                convertView = layoutInflater.inflate(R.layout.list_item, parent, false);
            }
            // 依照position取得teamList內的team物件
            final Team team = teamList.get(position);
            // 找到convertView子元件imageView，並指定欲顯示的圖檔
            ImageView ivLogo = (ImageView)convertView.findViewById(R.id.ivLogo);
            ivLogo.setImageResource(team.getLogo());
            // 找到convertView子元件textView，並指定欲顯示的文字值
            TextView tvName = (TextView)convertView.findViewById(R.id.tvName);
            tvName.setText(team.getName());
            TextView tvId = (TextView)convertView.findViewById(R.id.tvId);
            tvId.setText(Integer.toString(team.getId()));
            tvId.setOnClickListener(new View.OnClickListener() {

                @Override

                public void onClick(View v) {

                    String id = "" + team.getId();


                    Toast.makeText(MainActivity.this, id, Toast.LENGTH_SHORT).show();


                }
            });
            tvName.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String name=team.getName();
                    Toast.makeText(MainActivity.this,name,Toast.LENGTH_SHORT).show();
                }
            });

            return convertView;

    }};





    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
