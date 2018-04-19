package sgw.kandidat.ui;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.TextView;

import sgw.kandidat.R;
import sgw.kandidat.database.DataBaseModule;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText et_name, et_surname, et_fathername, et_age, et_stazh, et_kilk_inm, et_nayavn_vo, et_nayavn_dz, et_email;
    Button next, btn_insert, btn_result;
    CheckBox cb_a, cb_b, cb_c, cb_d;
    RadioButton rb_komanda_yes, rb_komanda_no, rb_director_yes, rb_director_no;
    RelativeLayout rl_next, rl_first, rl_results;
    String name, surname, fathername, email;
    String age, stazh, kilk_inm, nayavn_vo, nayavn_dz;
    int nayavn_vp, nayavn_dk, nayavn_dv;
    TextView textView, textView1, textView2, textView3;
    String stringName;

    class ViewHolder{
        public ViewHolder(){

        }
    }


    DataBaseModule dataBaseModule = new DataBaseModule();
    SharedPreferences sharedPreferencesName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nayavn_vp = 0;
        //TextView
        textView =  findViewById(R.id.textView2);
        textView1 =  findViewById(R.id.textView3);
        textView2 =  findViewById(R.id.textView5);
        textView3 =  findViewById(R.id.vitayu);
        //EditText
        et_name =  findViewById(R.id.name);
        et_surname =  findViewById(R.id.surname);
        et_fathername =  findViewById(R.id.fathername);
        et_age =  findViewById(R.id.age);
        et_stazh =  findViewById(R.id.stazh);
        et_kilk_inm =  findViewById(R.id.kilk_inm);
        et_nayavn_vo =  findViewById(R.id.nayavn_vo);
        et_nayavn_dz =  findViewById(R.id.nayavn_dz);
        et_email =  findViewById(R.id.email);
        //Buttons
        next =  findViewById(R.id.next);
        btn_insert =  findViewById(R.id.btn_insert);
        btn_result =  findViewById(R.id.btn_go_to_results);
        next.setOnClickListener(this);
        btn_insert.setOnClickListener(this);
        btn_result.setOnClickListener(this);
        //Check_box
        cb_a =  findViewById(R.id.cb_a);
        cb_b =  findViewById(R.id.cb_b);
        cb_c =  findViewById(R.id.cb_c);
        cb_d =  findViewById(R.id.cb_d);
        //Radiobutton
        rb_komanda_yes =  findViewById(R.id.rb_komanda_yes);
        rb_komanda_no =  findViewById(R.id.rb_komanda_no);
        rb_director_yes =  findViewById(R.id.rb_director_yes);
        rb_director_no =  findViewById(R.id.rb_director_no);
        //RelativeLayout
        rl_first =  findViewById(R.id.rl_first);
        rl_next =  findViewById(R.id.rl_next);
        rl_results =  findViewById(R.id.rl_result);


    }


    private void letsRead() {
        name = et_name.getText().toString();
        surname = et_surname.getText().toString();
        fathername = et_fathername.getText().toString();
        email = et_email.getText().toString();
        age = et_age.getText().toString();
        stazh = et_stazh.getText().toString();
        kilk_inm = et_kilk_inm.getText().toString();
        nayavn_vo = et_nayavn_vo.getText().toString();
        nayavn_dz = et_nayavn_dz.getText().toString();
    }

    private void readNext() {
        if (cb_a.isChecked()) {
            nayavn_vp++;
        }
        if (cb_b.isChecked()) {
            nayavn_vp++;
        }
        if (cb_c.isChecked()) {
            nayavn_vp++;
        }
        if (cb_d.isChecked()) {
            nayavn_vp++;
        }
        if (rb_komanda_yes.isChecked()) {
            nayavn_dk = 1;
        } else
            nayavn_dk = 0;
        if (rb_director_yes.isChecked()) {
            nayavn_dv = 1;
        } else
            nayavn_dv = 0;

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.next:
                rl_first.setVisibility(View.INVISIBLE);

                textView.setVisibility(View.VISIBLE);
                textView1.setVisibility(View.VISIBLE);
                textView2.setVisibility(View.VISIBLE);
                btn_insert.setVisibility(View.VISIBLE);
                cb_a.setVisibility(View.VISIBLE);
                cb_b.setVisibility(View.VISIBLE);
                cb_c.setVisibility(View.VISIBLE);
                cb_d.setVisibility(View.VISIBLE);
                rb_komanda_yes.setVisibility(View.VISIBLE);
                rb_komanda_no.setVisibility(View.VISIBLE);
                rb_director_yes.setVisibility(View.VISIBLE);
                rb_director_no.setVisibility(View.VISIBLE);

                letsRead();
                break;
            case R.id.btn_insert:
                rl_next.setVisibility(View.INVISIBLE);
                textView3.setVisibility(View.VISIBLE);
                btn_result.setVisibility(View.VISIBLE);

                readNext();

                stringName = name + " " + surname + " " + fathername;

            /*    dataBaseModule.saveToDB(this,
                        stringName,
                        Integer.parseInt(age),
                        Integer.parseInt(stazh),
                        Integer.parseInt(nayavn_vo),
                        nayavn_vp,
                        Integer.parseInt(nayavn_dz),
                        nayavn_dk,
                        nayavn_dv,
                        Integer.parseInt(kilk_inm),
                        email);*/
                break;
            case R.id.btn_go_to_results:
                sharedPreferencesName.edit().putString("auth", stringName).apply();
                Intent intent = new Intent(this, Results.class);
                startActivity(intent);
                break;
            default:
                break;
        }

    }
}
