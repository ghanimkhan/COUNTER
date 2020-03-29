package com.ghanim.master2counter;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.airbnb.lottie.LottieAnimationView;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

import static java.util.Collections.max;

public class MainActivity extends AppCompatActivity {
    public static final String SHARED_PREFS = "sharedPrefs";
    public static final String TEXT = "text";
    private static final String TAG = "MyActivity";
    String duplicateDay;
    LottieAnimationView imgIconLike;
    int count = 0;
    private AdView mAdView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        MobileAds.initialize(this, "ca-app-pub-2896925381663375~9928429241");
        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);


        final String[] names = getResources().getStringArray(R.array.nomes);
        final int randomIndex = new Random().nextInt(names.length);
        imgIconLike = findViewById(R.id.img_icon_like);
        String randomName = names[randomIndex];


        Button sharebut = (Button) findViewById(R.id.sharebut);
        sharebut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
                sharingIntent.setType("text/plain");
                String shareBody = names[randomIndex];
                sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Subject Here");
                sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, shareBody);
                startActivity(Intent.createChooser(sharingIntent, "Share via"));
            }
        });


        final TextView yourTextView = (TextView) findViewById(R.id.yourTextView);
        final TextView days = (TextView) findViewById(R.id.days);
        TextView date = (TextView) findViewById(R.id.date);
        final TextView weekday = (TextView) findViewById(R.id.weekday);
        yourTextView.setText(randomName);
        final TextView textView5 = (TextView) findViewById(R.id.textView5);
        final Button button2 = (Button) findViewById(R.id.button2);
        final int[] mon = {0};
        final int[] tue = {0};
        final int[] wed = {0};
        final int[] thus = {0};
        final int[] fri = {0};
        final int[] sat = {0};
        final int[] sun = {0};
        final int arr[] = {0, 0, 0, 0, 0, 0, 0};


        Calendar calendar = Calendar.getInstance();
        int day = calendar.get(Calendar.DAY_OF_WEEK);
        if (day == Calendar.MONDAY) {
            weekday.setText("MONDAY");
        }
        if (day == Calendar.TUESDAY) {
            weekday.setText("TUESDAY");
        }
        if (day == Calendar.WEDNESDAY) {
            weekday.setText("WEDNESDAY");
        }
        if (day == Calendar.THURSDAY) {
            weekday.setText("THURSDAY");
        }
        if (day == Calendar.FRIDAY) {
            weekday.setText("FRIDAY");
        }
        if (day == Calendar.SATURDAY) {
            weekday.setText("SATURDAY");
        }
        if (day == Calendar.SUNDAY) {
            weekday.setText("SUNDAY");
        }

        @SuppressLint("SimpleDateFormat") DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        Date dates = new Date();
        date.setText(dateFormat.format(dates));


        imgIconLike.setOnClickListener(new View.OnClickListener() {
            boolean isAnimated = false;

            @SuppressLint({"CommitPrefEdits", "Assert"})
            @Override
            public void onClick(View v) {
                imgIconLike.setSpeed(3f);
                isAnimated = true;
                imgIconLike.playAnimation();
                count++;
                textView5.setText(Integer.toString(count));

                int m = 0;
                int t = 0;
                int w = 0;
                int th = 0;
                int f = 0;
                int sa = 0;
                int su = 0;


                //(((+)))) shared prefrance


                SharedPreferences sp = getSharedPreferences("your_prefs", Activity.MODE_PRIVATE);
                SharedPreferences.Editor editor = sp.edit();
                editor.putInt("your_int_key", count);
                editor.apply();
                Calendar calendar = Calendar.getInstance();


                int day = calendar.get(Calendar.DAY_OF_WEEK);
                if (day == Calendar.MONDAY) {
                    mon[0]++;
                    m = mon[0];


                }
                if (day == Calendar.TUESDAY) {
                    tue[0]++;
                    t = tue[0];


                }
                if (day == Calendar.WEDNESDAY) {
                    wed[0]++;
                    w = wed[0];


                }
                if (day == Calendar.THURSDAY) {
                    thus[0]++;
                    th = thus[0];


                }
                if (day == Calendar.FRIDAY) {
                    fri[0]++;
                    f = fri[0];


                }
                if (day == Calendar.SATURDAY) {
                    sat[0]++;
                    sa = sat[0];


                }
                if (day == Calendar.SUNDAY) {
                    sun[0]++;
                    su = sun[0];

                }


                //mon shared prefrence


                SharedPreferences mon1 = getSharedPreferences("mon", Activity.MODE_PRIVATE);
                SharedPreferences.Editor editor1 = mon1.edit();
                editor1.putInt("mon", mon[0]);
                editor1.apply();

                //tue shared pref
                SharedPreferences tue2 = getSharedPreferences("tue", Activity.MODE_PRIVATE);
                SharedPreferences.Editor editor2 = tue2.edit();
                editor2.putInt("tue", tue[0]);
                editor2.apply();

                //wed sharedpref
                SharedPreferences wed3 = getSharedPreferences("wed", Activity.MODE_PRIVATE);
                SharedPreferences.Editor editor3 = wed3.edit();
                editor3.putInt("wed", wed[0]);
                editor3.apply();

                //thus shared pref
                SharedPreferences thus4 = getSharedPreferences("thus", Activity.MODE_PRIVATE);
                SharedPreferences.Editor editor4 = thus4.edit();
                editor4.putInt("thus", thus[0]);
                editor4.apply();

                //fri sharedpref
                SharedPreferences fri5 = getSharedPreferences("fri", Activity.MODE_PRIVATE);
                SharedPreferences.Editor editor5 = fri5.edit();
                editor5.putInt("fri", fri[0]);
                editor5.apply();

                //sat shared pref
                SharedPreferences sat6 = getSharedPreferences("sat", Activity.MODE_PRIVATE);
                SharedPreferences.Editor editor6 = sat6.edit();
                editor6.putInt("sat", sat[0]);
                editor6.apply();

                //sun shared pref
                SharedPreferences sun7 = getSharedPreferences("sun", Activity.MODE_PRIVATE);
                SharedPreferences.Editor editor7 = sun7.edit();
                editor7.putInt("sun", sun[0]);
                editor7.apply();


            }
        });


        button2.setOnClickListener(new View.OnClickListener() {
            @SuppressLint({"SetTextI18n", "CommitPrefEdits"})
            @Override
            public void onClick(View v) {
                count= count- 1;
                textView5.setText(Integer.toString(count));

                int m = 0;
                int t = 0;
                int w = 0;
                int th = 0;
                int f = 0;
                int sa = 0;
                int su = 0;

                //(((-)))) shared prefrance


                SharedPreferences sp = getSharedPreferences("your_prefs", Activity.MODE_PRIVATE);
                SharedPreferences.Editor editor = sp.edit();
                editor.putInt("your_int_key", count);
                editor.apply();


                Calendar calendar = Calendar.getInstance();
                int day = calendar.get(Calendar.DAY_OF_WEEK);
                if (day == Calendar.MONDAY) {

                    mon[0]--;
                    m = mon[0];


                }
                if (day == Calendar.TUESDAY) {
                    tue[0]--;
                    t = tue[0];


                }
                if (day == Calendar.WEDNESDAY) {
                    wed[0]--;
                    w = wed[0];


                }
                if (day == Calendar.THURSDAY) {
                    thus[0]--;
                    th = thus[0];


                }
                if (day == Calendar.FRIDAY) {
                    fri[0]--;
                    f = fri[0];


                }
                if (day == Calendar.SATURDAY) {
                    sat[0]--;
                    sa = sat[0];


                }
                if (day == Calendar.SUNDAY) {
                    sun[0]--;
                    su = sun[0];


                }


                //mon shared prefrence

                SharedPreferences mon1 = getSharedPreferences("mon", Activity.MODE_PRIVATE);
                SharedPreferences.Editor editor1 = mon1.edit();
                editor1.putInt("mon", mon[0]);
                editor1.apply();

                //tue shared pref
                SharedPreferences tue2 = getSharedPreferences("tue", Activity.MODE_PRIVATE);
                SharedPreferences.Editor editor2 = tue2.edit();
                editor2.putInt("tue", tue[0]);
                editor2.apply();

                //wed sharedpref
                SharedPreferences wed3 = getSharedPreferences("wed", Activity.MODE_PRIVATE);
                SharedPreferences.Editor editor3 = wed3.edit();
                editor3.putInt("wed", wed[0]);
                editor3.apply();

                //thus shared pref
                SharedPreferences thus4 = getSharedPreferences("thus", Activity.MODE_PRIVATE);
                SharedPreferences.Editor editor4 = thus4.edit();
                editor4.putInt("thus", thus[0]);
                editor4.apply();

                //fri sharedpref
                SharedPreferences fri5 = getSharedPreferences("fri", Activity.MODE_PRIVATE);
                SharedPreferences.Editor editor5 = fri5.edit();
                editor5.putInt("fri", fri[0]);
                editor5.apply();

                //sat shared pref
                SharedPreferences sat6 = getSharedPreferences("sat", Activity.MODE_PRIVATE);
                SharedPreferences.Editor editor6 = sat6.edit();
                editor6.putInt("sat", sat[0]);
                editor6.apply();

                //sun shared pref
                SharedPreferences sun7 = getSharedPreferences("sun", Activity.MODE_PRIVATE);
                SharedPreferences.Editor editor7 = sun7.edit();
                editor7.putInt("sun", sun[0]);
                editor7.apply();


               /* SharedPreferences max1 = getSharedPreferences("max", Activity.MODE_PRIVATE);
                SharedPreferences.Editor editor231 = mon1.edit();
                editor231.putInt("max", max[0]);
                editor231.apply();*/

            }
        });


        //load sharedprefrence  (count) android
        SharedPreferences sp = getSharedPreferences("your_prefs", Activity.MODE_PRIVATE);
        int myIntValue = sp.getInt("your_int_key", 0);
        count = myIntValue;
        textView5.setText(Integer.toString(count));

        //load shared prefrence (days count)
        SharedPreferences mon1 = getSharedPreferences("mon", Activity.MODE_PRIVATE);
        mon[0] = mon1.getInt("mon", 0);

        //"tue", tue[0]
        SharedPreferences tue2 = getSharedPreferences("tue", Activity.MODE_PRIVATE);
        tue[0] = tue2.getInt("tue", 0);

        SharedPreferences wed3 = getSharedPreferences("wed", Activity.MODE_PRIVATE);
        wed[0] = wed3.getInt("wed", 0);

        SharedPreferences thus4 = getSharedPreferences("thus", Activity.MODE_PRIVATE);
        thus[0] = thus4.getInt("thus", 0);

        SharedPreferences fri5 = getSharedPreferences("fri", Activity.MODE_PRIVATE);
        fri[0] = fri5.getInt("fri", 0);

        SharedPreferences sat6 = getSharedPreferences("sat", Activity.MODE_PRIVATE);
        sat[0] = sat6.getInt("sat", 0);

        SharedPreferences sun7 = getSharedPreferences("sun", Activity.MODE_PRIVATE);
        sun[0] = sun7.getInt("sun", 0);

        /*SharedPreferences max1 = getSharedPreferences("max", Activity.MODE_PRIVATE);
        max[0] = max1.getInt("max", 0);*/

        /*Toast.makeText(getApplicationContext()," "+mon[0],Toast.LENGTH_SHORT).show();
        Toast.makeText(getApplicationContext()," "+tue[0],Toast.LENGTH_SHORT).show();
        Toast.makeText(getApplicationContext()," "+wed[0],Toast.LENGTH_SHORT).show();

        Toast.makeText(getApplicationContext()," "+thus[0],Toast.LENGTH_SHORT).show();
        Toast.makeText(getApplicationContext()," "+fri[0],Toast.LENGTH_SHORT).show();
        Toast.makeText(getApplicationContext()," "+sat[0],Toast.LENGTH_SHORT).show();
        Toast.makeText(getApplicationContext()," "+sun[0],Toast.LENGTH_SHORT).show();*/


        arr[0] = mon[0];
        arr[1] = tue[0];
        arr[2] = wed[0];
        arr[3] = thus[0];
        arr[4] = fri[0];
        arr[5] = sat[0];
        arr[6] = sun[0];
        int max = arr[0];

        // Traverse array elements from second and
        // compare every element with current max
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }


        if (mon[0] == max) {
            days.setText("MONDAY");
        }
        if (tue[0] == max) {
            days.setText("TUESDAY");
        }
        if (wed[0] == max) {
            days.setText("WEDNESDAY");
        }
        if (thus[0] == max) {
            days.setText("THURSDAY");

        }
        if (fri[0] == max) {
            days.setText("FRIDAY");

        }
        if (sat[0] == max) {
            days.setText("SATURDAY");

        }
        if (sun[0] == max) {
            days.setText("SATURDAY");

        }


        Button button1 = (Button) findViewById(R.id.button);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(MainActivity.this, activity2.class);
                intent.putExtra("array", arr);
                startActivity(intent);

            }
        });


    }
}
