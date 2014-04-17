package com.example.weekviewdemo;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ProgressDialog;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

	// *TextView
	private TextView textViewServiceApp;
	private TextView textViewWeekCalender;
	private TextView textViewPrevDate;
	private TextView textViewDate;
	private TextView textViewNextDate;
	private TextView textViewSun;
	private TextView textViewMon;
	private TextView textViewTue;
	private TextView textViewWed;
	private TextView textViewThu;
	private TextView textViewFri;
	private TextView textViewSat;
	private TextView textView12am;
	private TextView textView1am;
	private TextView textView2am;
	private TextView textView3am;
	private TextView textView4am;
	private TextView textView5am;
	private TextView textView6am;
	private TextView textView7am;
	private TextView textView8am;
	private TextView textView9am;
	private TextView textView10am;
	private TextView textView11am;
	private TextView textView12pm;
	private TextView textView1pm;
	private TextView textView2pm;
	private TextView textView3pm;
	private TextView textView4pm;
	private TextView textView5pm;
	private TextView textView6pm;
	private TextView textView7pm;
	private TextView textView8pm;
	private TextView textView9pm;
	private TextView textView10pm;
	private TextView textView11pm;

	// * Views
	private RelativeLayout relativeLayoutSunday;
	private RelativeLayout relativeLayoutMonDay;
	private RelativeLayout relativeLayoutTueDay;
	private RelativeLayout relativeLayoutWedDay;
	private RelativeLayout relativeLayoutThuDay;
	private RelativeLayout relativeLayoutFriDay;
	private RelativeLayout relativeLayoutSatDay;

	// *IMges
	private ImageView buttonBack;
	private ImageView buttonHome;

	private Typeface typface;

	public String dateFormat, logInID;
	public String[] weekDays;
	public String[] NextPreWeekday;
	public String dateFormate;
	public String firstDayOfWeek;
	public String lastDayOfWeek;

	public static ArrayList<Entity1> arrayListEntity = new ArrayList<Entity1>();
	public static ArrayList<Entity1> arrayListEButtonId = new ArrayList<Entity1>();

	public int weekDaysCount = 0;
	public ArrayList<WeekSets> weekDatas;
	String tapMargin ;
	String buttonHight;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		textViewPrevDate = (TextView) findViewById(R.id.textViewPrevDate);
		textViewDate = (TextView) findViewById(R.id.textViewDate);
		textViewNextDate = (TextView) findViewById(R.id.textViewNextDate);
		textViewSun = (TextView) findViewById(R.id.textViewSun);
		textViewMon = (TextView) findViewById(R.id.textViewMon);
		textViewTue = (TextView) findViewById(R.id.textViewTue);
		textViewWed = (TextView) findViewById(R.id.textViewWed);
		textViewThu = (TextView) findViewById(R.id.textViewThu);
		textViewFri = (TextView) findViewById(R.id.textViewFri);
		textViewSat = (TextView) findViewById(R.id.textViewSat);
		textView12am = (TextView) findViewById(R.id.textView12am);
		textView1am = (TextView) findViewById(R.id.textView1am);
		textView2am = (TextView) findViewById(R.id.textView2am);
		textView3am = (TextView) findViewById(R.id.textView3am);
		textView4am = (TextView) findViewById(R.id.textView4am);
		textView5am = (TextView) findViewById(R.id.textView5am);
		textView6am = (TextView) findViewById(R.id.textView6am);
		textView7am = (TextView) findViewById(R.id.textView7am);
		textView8am = (TextView) findViewById(R.id.textView8am);
		textView9am = (TextView) findViewById(R.id.textView9am);
		textView10am = (TextView) findViewById(R.id.textView10am);
		textView11am = (TextView) findViewById(R.id.textView11am);
		textView12pm = (TextView) findViewById(R.id.textView12pm);
		textView1pm = (TextView) findViewById(R.id.textView1pm);
		textView2pm = (TextView) findViewById(R.id.textView2pm);
		textView3pm = (TextView) findViewById(R.id.textView3pm);
		textView4pm = (TextView) findViewById(R.id.textView4pm);
		textView5pm = (TextView) findViewById(R.id.textView5pm);
		textView6pm = (TextView) findViewById(R.id.textView6pm);
		textView7pm = (TextView) findViewById(R.id.textView7pm);
		textView8pm = (TextView) findViewById(R.id.textView8pm);
		textView9pm = (TextView) findViewById(R.id.textView9pm);
		textView10pm = (TextView) findViewById(R.id.textView10pm);
		textView11pm = (TextView) findViewById(R.id.textView11pm);

		relativeLayoutSunday = (RelativeLayout) findViewById(R.id.relativeLayoutSunday);
		relativeLayoutMonDay = (RelativeLayout) findViewById(R.id.relativeLayoutMonDay);
		relativeLayoutTueDay = (RelativeLayout) findViewById(R.id.relativeLayoutTueDay);
		relativeLayoutWedDay = (RelativeLayout) findViewById(R.id.relativeLayoutWedDay);
		relativeLayoutThuDay = (RelativeLayout) findViewById(R.id.relativeLayoutThuDay);
		relativeLayoutFriDay = (RelativeLayout) findViewById(R.id.relativeLayoutFriDay);
		relativeLayoutSatDay = (RelativeLayout) findViewById(R.id.relativeLayoutSatDay);

		NextPreWeekday = getWeekDay();
		firstDayOfWeek = CommonMethod.convertWeekDays(NextPreWeekday[0]);
		lastDayOfWeek = CommonMethod.convertWeekDays(NextPreWeekday[6]);
		textViewDate.setText(firstDayOfWeek + "-" + lastDayOfWeek + " "
				+ CommonMethod.convertWeekDaysMouth(NextPreWeekday[6]));

		textViewSun.setText(CommonMethod.convertWeekDays(NextPreWeekday[0])
				+ "\nSun");
		textViewMon.setText(CommonMethod.convertWeekDays(NextPreWeekday[1])
				+ "\nMon");
		textViewTue.setText(CommonMethod.convertWeekDays(NextPreWeekday[2])
				+ "\nTue");
		textViewWed.setText(CommonMethod.convertWeekDays(NextPreWeekday[3])
				+ "\nWeb");
		textViewThu.setText(CommonMethod.convertWeekDays(NextPreWeekday[4])
				+ "\nThu");
		textViewFri.setText(CommonMethod.convertWeekDays(NextPreWeekday[5])
				+ "\nFri");
		textViewSat.setText(CommonMethod.convertWeekDays(NextPreWeekday[6])
				+ "\nSat");
		try
		{
			new LoadViewsInToWeekView().execute("");
		} catch (Exception e)
		{
			Log.getStackTraceString(e);
		}
		
		
	}

	public String[] getWeekDay() {

		Calendar now = Calendar.getInstance();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		String[] days = new String[7];
		int delta = -now.get(GregorianCalendar.DAY_OF_WEEK) + 1;
		now.add(Calendar.DAY_OF_MONTH, delta);
		for (int i = 0; i < 7; i++) {
			days[i] = format.format(now.getTime());
			now.add(Calendar.DAY_OF_MONTH, 1);
		}

		return days;

	}

	@SuppressLint("SimpleDateFormat")
	public String[] getWeekDayNext() {

		weekDaysCount++;
		Calendar now1 = Calendar.getInstance();
		Calendar now = (Calendar) now1.clone();

		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		String[] days = new String[7];
		int delta = -now.get(GregorianCalendar.DAY_OF_WEEK) + 1;
		now.add(Calendar.WEEK_OF_YEAR, weekDaysCount);
		now.add(Calendar.DAY_OF_MONTH, delta);
		for (int i = 0; i < 7; i++) {
			days[i] = format.format(now.getTime());
			now.add(Calendar.DAY_OF_MONTH, 1);
		}

		return days;

	}

	@SuppressLint("SimpleDateFormat")
	public String[] getWeekDayPrev() {

		weekDaysCount--;
		Calendar now1 = Calendar.getInstance();
		Calendar now = (Calendar) now1.clone();

		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		String[] days = new String[7];
		int delta = -now.get(GregorianCalendar.DAY_OF_WEEK) + 1;
		now.add(Calendar.WEEK_OF_YEAR, weekDaysCount);
		now.add(Calendar.DAY_OF_MONTH, delta);
		for (int i = 0; i < 7; i++) {
			days[i] = format.format(now.getTime());
			now.add(Calendar.DAY_OF_MONTH, 1);
		}

		return days;

	}

	public Button getButtonToLayout(int higth, int marginTop,
			String buttonText, String jobID, int buttonID) {

		@SuppressWarnings("deprecation")
		final RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(
				RelativeLayout.LayoutParams.FILL_PARENT, higth);
		Button button = new Button(getApplicationContext());
		button.setLayoutParams(params);
		button.setBackgroundColor(Color.parseColor("#9ACC61"));
		button.setText(buttonText);
		button.setOnClickListener(buttonOnclckForAllWeekButton);
		button.setTextSize(9);
		button.setId(buttonID);
		params.setMargins(0, marginTop, 0, 0);
		arrayListEntity.add(getEntity(jobID, buttonText));

		return button;

	}

	public OnClickListener buttonOnclckForAllWeekButton = new OnClickListener() {

		@Override
		public void onClick(View v) {
			Button b = (Button) v;

			String buttonText = b.getText().toString();
			int position = 0;

			for (int j = 0; j < arrayListEntity.size(); j++) {
				Entity1 itemOne = arrayListEntity.get(j);

				String arryJobRefID = itemOne.JobRefID;
				if (arryJobRefID.equals(buttonText)) {
					position = j;
					break;
				}
			}

			Entity1 itemOne1 = arrayListEntity.get(position);
			 Toast.makeText(getApplicationContext() , "  " + itemOne1.JobRefID , Toast.LENGTH_SHORT).show();

		}
	};

	public static Entity1 getEntity(String jobID, String jobRefID) {
		Entity1 E = new Entity1();
		E.JobIDForButton = jobID;
		E.JobRefID = jobRefID;
		return E;

	}

	public static Entity1 getButton(int layoutView, int buttonTag) {
		Entity1 E = new Entity1();
		E.layoutView = layoutView;
		E.buttonTag = buttonTag;
		return E;

	}

	public static WeekSets getWeekValues(String weekDay, String jobId,
			String jobRefId, String tapMargina, String buttonHighta) {
		WeekSets W = new WeekSets();
		W.day = weekDay;
		W.jobID = jobId;
		W.jobRefID = jobRefId;
		W.tapMargin = tapMargina;
		W.buttonHight = buttonHighta;

		return W;
	}

	public String getWithAndHigthToButton(int startTime) {

		int time;
		String size = "0";
		try {
			time = startTime;

			switch (time) {
			case 0:
				size = "0";
				break;
			case 1:
				size = "60";

				break;
			case 2:
				size = "120";

				break;
			case 3:
				size = "180";

				break;
			case 4:
				size = "240";

				break;
			case 5:
				size = "300";

				break;
			case 6:
				size = "360";

				break;
			case 7:
				size = "420";

				break;
			case 8:
				size = "480";

				break;
			case 9:
				size = "540";

				break;
			case 10:
				size = "600";

				break;
			case 11:
				size = "660";

				break;
			case 12:
				size = "720";

				break;
			case 13:
				size = "780";

				break;
			case 14:
				size = "840";

				break;
			case 15:
				size = "900";

				break;
			case 16:
				size = "960";

				break;
			case 17:
				size = "1020";

				break;
			case 18:
				size = "1080";

				break;
			case 19:
				size = "1140";

				break;
			case 20:
				size = "1200";

				break;
			case 21:
				size = "1260";

				break;
			case 22:
				size = "1320";

				break;
			case 23:
				size = "1380";
				break;

			default:
				break;
			}

		} catch (Exception e) {
			Log.getStackTraceString(e);
		}

		return size;

	}

	public String getHightOfButton(int startTime, int endTime) {
		String hight = "0";
		try {
			int subHigth = endTime - startTime;

			hight = String.valueOf(subHigth * 60);

		} catch (Exception e) {
			Log.getStackTraceString(e);
		}

		return hight;

	}

	public class LoadViewsInToWeekView extends AsyncTask<String, Void, String> {

		@Override
		protected String doInBackground(String... params) {
			try {
				weekDatas = new ArrayList<WeekSets>();

				
				
				//** for sun day
				 tapMargin = getWithAndHigthToButton(4);
				 buttonHight = getHightOfButton(4, 9);
				weekDatas.add(getWeekValues(String.valueOf(0), "12", "ref",
						tapMargin, buttonHight));
				
				
				
				//** for tue day
				 tapMargin = getWithAndHigthToButton(8);
				 buttonHight = getHightOfButton(8, 14);
				weekDatas.add(getWeekValues(String.valueOf(2), "12", "ref",
						tapMargin, buttonHight));
				
				//** for tue day
				 tapMargin = getWithAndHigthToButton(15);
				 buttonHight = getHightOfButton(15, 19);
				weekDatas.add(getWeekValues(String.valueOf(2), "12", "ref",
						tapMargin, buttonHight));
				
				
				
				//** for fr day
				 tapMargin = getWithAndHigthToButton(2);
				 buttonHight = getHightOfButton(2, 10);
				weekDatas.add(getWeekValues(String.valueOf(5), "12", "ref",
						tapMargin, buttonHight));
				
				
				
				

			} catch (Exception e) {
				e.printStackTrace();
			}

			return null;
		}

		@Override
		protected void onPostExecute(String str) {

			try {

				WeekSets weekToDay;
				int length = weekDatas.size();
				Log.i("length===>", String.valueOf(length));

				if (length != 0) {
					for (int k = 0; k < weekDatas.size(); k++) {
						weekToDay = weekDatas.get(k);

						int day = Integer.parseInt(weekToDay.day);
						switch (day) {
						case 0:

							int sunday = 100;
							relativeLayoutSunday
									.addView(getButtonToLayout(
											Integer.parseInt(weekToDay.buttonHight),
											Integer.parseInt(weekToDay.tapMargin),
											weekToDay.jobRefID,
											weekToDay.jobID, sunday));
							arrayListEButtonId.add(getButton(0, sunday));
							sunday++;
							break;

						case 1:
							int MonDay = 200;
							relativeLayoutMonDay
									.addView(getButtonToLayout(
											Integer.parseInt(weekToDay.buttonHight),
											Integer.parseInt(weekToDay.tapMargin),
											weekToDay.jobRefID,
											weekToDay.jobID, MonDay));
							arrayListEButtonId.add(getButton(1, MonDay));
							MonDay++;
							break;
						case 2:
							int TueDay = 200;
							relativeLayoutTueDay
									.addView(getButtonToLayout(
											Integer.parseInt(weekToDay.buttonHight),
											Integer.parseInt(weekToDay.tapMargin),
											weekToDay.jobRefID,
											weekToDay.jobID, TueDay));
							arrayListEButtonId.add(getButton(2, TueDay));
							TueDay++;
							break;
						case 3:
							int WedDay = 200;
							relativeLayoutWedDay
									.addView(getButtonToLayout(
											Integer.parseInt(weekToDay.buttonHight),
											Integer.parseInt(weekToDay.tapMargin),
											weekToDay.jobRefID,
											weekToDay.jobID, WedDay));
							arrayListEButtonId.add(getButton(3, WedDay));
							WedDay++;
							break;
						case 4:
							int ThuDay = 200;
							relativeLayoutThuDay
									.addView(getButtonToLayout(
											Integer.parseInt(weekToDay.buttonHight),
											Integer.parseInt(weekToDay.tapMargin),
											weekToDay.jobRefID,
											weekToDay.jobID, ThuDay));
							arrayListEButtonId.add(getButton(4, ThuDay));
							ThuDay++;
							break;
						case 5:
							int FriDay = 200;
							relativeLayoutFriDay
									.addView(getButtonToLayout(
											Integer.parseInt(weekToDay.buttonHight),
											Integer.parseInt(weekToDay.tapMargin),
											weekToDay.jobRefID,
											weekToDay.jobID, FriDay));
							arrayListEButtonId.add(getButton(5, FriDay));
							FriDay++;
							break;
						case 6:
							int SatDay = 200;
							relativeLayoutSatDay
									.addView(getButtonToLayout(
											Integer.parseInt(weekToDay.buttonHight),
											Integer.parseInt(weekToDay.tapMargin),
											weekToDay.jobRefID,
											weekToDay.jobID, SatDay));
							arrayListEButtonId.add(getButton(6, SatDay));
							SatDay++;
							break;

						default:
							break;
						}

					}

				}

			} catch (Exception e) {
				Log.getStackTraceString(e);
			}

			if (dialog.isShowing()) {
				dialog.dismiss();
			}

		}

		ProgressDialog dialog;

		@Override
		protected void onPreExecute() {
			try {

				dialog = ProgressDialog.show(MainActivity.this, null, null,
						true, false);
				dialog.setContentView(R.layout.progress_layout);
			} catch (Exception e) {
				Log.getStackTraceString(e);
			}

		}

	}

}
