package com.est7.demoproject.expandtext;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.AppCompatDelegate;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;

import com.est7.demoproject.R;
import com.est7.demoproject.utils.ToastUtil;

public class ExpandTextActivity extends AppCompatActivity {

    private ExpandTextView etv;
    private SeekBar sb_duration;
    private Button btn_modify_content;
    private Button btn_modify_theme;
    private Button btn_modify_theme1;
    private SeekBar sb_min_line;
    private boolean img;

    static {
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_AUTO);
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expand_text);
        etv = (ExpandTextView) findViewById(R.id.etv);
        sb_duration = (SeekBar) findViewById(R.id.sb_duration);
        btn_modify_content = (Button) findViewById(R.id.btn_modify_content);
        btn_modify_theme = (Button) findViewById(R.id.btn_modify_theme);
        btn_modify_theme1 = (Button) findViewById(R.id.btn_modify_theme1);
        sb_min_line = (SeekBar) findViewById(R.id.sb_min_line);
        btn_modify_content.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final EditText editText = new EditText(ExpandTextActivity.this);
                editText.setLines(4);
                new AlertDialog.Builder(ExpandTextActivity.this)
                        .setTitle("内容")
                        .setView(editText, DensityUtils.dp2px(ExpandTextActivity.this, 16), DensityUtils.dp2px(ExpandTextActivity.this, 16), DensityUtils.dp2px(ExpandTextActivity.this, 16), DensityUtils.dp2px(ExpandTextActivity.this, 16))
                        .setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                            }
                        })
                        .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                etv.setContent(editText.getText().toString());
                            }
                        }).create().show();
            }
        });
        btn_modify_theme.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                /*
                * 切换主题的activity必须继承自AppCompatActivity

                3.使用的主题，把Theme.AppCompat.DayNight作为parent：
                <style name="AppTheme" parent="Theme.AppCompat.DayNight.DarkActionBar">

                4.新建value-night文件夹，在此文件夹中准备另一套colors和styles。里面的名字跟对应的value下名字相同，只是值不同，这样系统就会自动获取对应的值了*/

                /*.setLocalNightMode的值的说明：
                    MODE_NIGHT_NO： 使用亮色(light)主题，不使用夜间模式
                    MODE_NIGHT_YES：使用暗色(dark)主题，使用夜间模式
                    MODE_NIGHT_AUTO：根据当前时间自动切换 亮色(light)/暗色(dark)主题
                    MODE_NIGHT_FOLLOW_SYSTEM(默认选项)：设置为跟随系统，通常为MODE_NIGHT_NO*/
                /*
                * 这种模式切换会闪屏，怎么优化？
                * 先解释一下闪屏原因，因为必须调用recreate方法才能行，也就是说这里的activity重绘了，
                * 图中EditText里面的Hint信息也变化了，所以显得两个activity之间切换生硬，所以这里对切换主题的activity设置一个切换动画就行了，
                * <item name="android:windowAnimationStyle">@android:style/Animation.Toast</item>
                *
                * */

                getDelegate().setLocalNightMode(AppCompatDelegate.MODE_NIGHT_YES);//切换夜间模式
                recreate();//重新启动当前activity



            }
        });
        btn_modify_theme1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                getDelegate().setLocalNightMode(AppCompatDelegate.MODE_NIGHT_NO);//切换日间模式
                recreate();//重新启动当前activity
            }
        });

//        etv.setIndicateImage(R.drawable.ic_arrow_down_light_round);
//        etv.setMinVisibleLines(5);
//        etv.setContentTextSize(15);
//        etv.setTitleTextSize(16);
//        etv.setHintTextSize(12);
//        etv.setHintTextColor(Color.parseColor("#913242"));


        etv.setContent("在白日，他们的背包是城市中的风。\n" +
                "或者呼啸在追风少年的身后，记录这个城市的瞬间；\n" +
                "或者静靠在某个公园木椅的一角，和停歇的灰鸽相伴；\n" +
                "悬挂在码头栏杆上的那一个，是在等待归人，还是观察过客？ ");
        etv.setOnReadMoreListener(new OnReadMoreClickListener() {
            @Override
            public void onExpand() {
                ToastUtil.showShort("expand");
            }

            @Override
            public void onFold() {
                ToastUtil.showShort("fold");
            }
        });
        sb_duration.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                etv.setAnimationDuration(seekBar.getProgress());
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        sb_min_line.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                etv.setMinVisibleLines(seekBar.getProgress());
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

}
