package com.example.testsqlite201699;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;

import com.example.testsqlite201699.adapter.MyAdapter;
import com.example.testsqlite201699.entity.Content;
import com.example.testsqlite201699.entity.PersonDao;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity implements OnClickListener {

	private Button btn_submit;
	private EditText et_name, et_phone;
	private ListView lv;
	private List<Content> data = new ArrayList<Content>();
	private MyAdapter mAdapter;
	private PersonDao pDao;
	List<Content> list = new ArrayList<Content>();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_main);

		btn_submit = (Button) findViewById(R.id.btn);
		btn_submit.setOnClickListener(this);
		et_name = (EditText) findViewById(R.id.et_name);
		et_phone = (EditText) findViewById(R.id.et_phone);

		pDao = new PersonDao(this);

		lv = (ListView) findViewById(R.id.lv);
		// someData();
		mAdapter = new MyAdapter(data, this);
		lv.setAdapter(mAdapter);
		refreshView();
	}

	@Override
	public void onClick(View v) {

		String nameStr = et_name.getText().toString().trim();
		String phoneStr = et_phone.getText().toString().trim();

		switch (v.getId()) {
		case R.id.btn:

			if (!TextUtils.isEmpty(nameStr) && !TextUtils.isEmpty(phoneStr)) {

				Calendar c = Calendar.getInstance();

				int year = c.get(Calendar.YEAR);
				int month = c.get(Calendar.MONTH);
				int day=c.get(Calendar.DATE);
				//�����hour��24Сʱ�Ƶ�
				int hour=c.get(Calendar.HOUR_OF_DAY);
				int minute = c.get(Calendar.MINUTE);
				
				Content ct = new Content(null, nameStr, phoneStr, year+"-"+(month+1)+"-"+day+" "+hour+":"+minute);

				pDao.add(ct);

				Toast.makeText(this,
						"�ύ�ɹ�" + "����Ϊ" + nameStr + "�绰Ϊ" + phoneStr, 0).show();
				refreshView();
			} else {

				Toast.makeText(this, "����д�������Ϣ", 0).show();

			}

			break;

		default:
			break;
		}
	}

	private void refreshView() {

		mAdapter.notifyDataSetChanged();
		// �����е�ȫ�������һ��

		data.clear();

		list = pDao.getAll();
       
		//ע����������ѭ����list��data������������ͬ�ļ��ϣ���������ConcurrentModificationException�쳣
		for(Iterator iterator=list.iterator();iterator.hasNext();){
			
			Content c=(Content) iterator.next();
			
			data.add(c);
			
		}
		
//		for (Content content : list) {
//
//			list.add(content);
//
//		}

	}
}
