package sgw.kandidat.ui;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import sgw.kandidat.R;
import sgw.kandidat.database.DataBaseModule;

/**
 * Created by Катя on 25.12.2017.
 */

public class Results extends AppCompatActivity implements View.OnClickListener {


    DataBaseModule dataBaseModule = new DataBaseModule();

    SharedPreferences sharedPreferencesName;

    TextView tv_recomend, tv_type_kandidat;
    Button btn_back;
    String name;
    int[] data = new int[8];
    int resultInBal = 0;
    String type;
    String allResult;

    private final static String TAG = Results.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.result_layout);
        tv_recomend = (TextView) findViewById(R.id.tv_recomend_zp);
        tv_type_kandidat = (TextView) findViewById(R.id.tv_type_kandidat);
        btn_back = (Button) findViewById(R.id.btn_back);
        btn_back.setOnClickListener(this);
        name = sharedPreferencesName.getString("auth", " ");
        Log.d(TAG, name);
        data = dataBaseModule.readFromDB(this, name);
        countResult();
        allResult = "Кандидат " + name + " " + type + "!";
        tv_type_kandidat.setText(allResult);
        String string = "Рекомендована заробітня плата становить: " + String.valueOf(resultInBal * 200);
        tv_recomend.setText(string);
    }

    private void countResult() {
        //age
        if (data[0] < 25) {
            resultInBal = 10;
            Log.d(TAG, String.valueOf(resultInBal));
        } else if (data[0] >= 25 && data[0] < 50) {
            resultInBal = 5;
            Log.d(TAG, String.valueOf(resultInBal));
        }
        //stazh
        if (data[1] > 5) {
            resultInBal += 10;
            Log.d(TAG, String.valueOf(resultInBal));
        } else if (data[1] >= 2 && data[1] <= 5) {
            resultInBal += 5;
            Log.d(TAG, String.valueOf(resultInBal));
        }
        //vo
        if (data[2] > 1) {
            resultInBal += 10;
            Log.d(TAG, String.valueOf(resultInBal));
        } else if (data[2] == 1) {
            resultInBal += 5;
            Log.d(TAG, String.valueOf(resultInBal));
        }
        //vp
        if (data[3] > 1) {
            resultInBal += 10;
            Log.d(TAG, String.valueOf(resultInBal));
        } else if (data[3] == 1) {
            resultInBal += 5;
            Log.d(TAG, String.valueOf(resultInBal));
        }
        //dz
        if (data[4] > 1) {
            resultInBal += 10;
            Log.d(TAG, String.valueOf(resultInBal));
        } else if (data[4] == 1) {
            resultInBal += 5;
            Log.d(TAG, String.valueOf(resultInBal));
        }
        //dk
        if (data[5] == 1) {
            resultInBal += 10;
            Log.d(TAG, String.valueOf(resultInBal));
        }
        //dv
        if (data[6] == 1) {
            resultInBal += 10;
            Log.d(TAG, String.valueOf(resultInBal));
        }
        //inm
        if (data[7] > 2) {
            resultInBal += 10;
            Log.d(TAG, String.valueOf(resultInBal));
        } else if (data[7] > 0 && data[7] <= 2) {
            resultInBal += 5;
            Log.d(TAG, String.valueOf(resultInBal));
        }

        if (resultInBal > 50)
            type = "Найкращий кандидат";
        else if (resultInBal <= 50 && resultInBal > 25)
            type = "Альтернативний кандидат";
        else
            type = "Не відповідний";
        Log.d(TAG, String.valueOf(resultInBal));

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_back:
                Intent intent = new Intent(this, MainActivity.class);
                startActivity(intent);
                break;
            default:
                break;
        }
    }
}
