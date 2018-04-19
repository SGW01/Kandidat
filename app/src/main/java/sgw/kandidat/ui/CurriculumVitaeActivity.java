package sgw.kandidat.ui;

import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import butterknife.BindView;
import butterknife.ButterKnife;
import sgw.kandidat.R;

public class CurriculumVitaeActivity extends AppCompatActivity {

    @BindView(R.id.cl_info_about_candidate)
    ConstraintLayout constraintLayoutInfoAboutCandidate;

    @BindView(R.id.cl_prof_info)
    ConstraintLayout constraintLayoutProfInfo;

    @BindView(R.id.cl_work_exp)
    ConstraintLayout constraintLayoutWorkExp;

    @BindView(R.id.name)
    EditText editTextName;

    @BindView(R.id.surname)
    EditText editTextSurname;

    @BindView(R.id.age)
    EditText editTextAge;

    @BindView(R.id.fathername)
    EditText editTextFathername;

    @BindView(R.id.email)
    EditText editTextEmail;

    @BindView(R.id.trackRecord)
    EditText editTextTrackRecord;

    @BindView(R.id.editTextCountForeignLanguage)
    EditText editTextCountForeignLanguage;

    @BindView(R.id.highEducation)
    RadioButton radioButtonHighEducation;

    @BindView(R.id.rg_education)
    RadioGroup radioGroupEducation;

    @BindView(R.id.incompleteHigherEducation)
    RadioButton radioButtonIncompleteHigherEducation;

    @BindView(R.id.noneOfEducation)
    RadioButton radioButtonNoneOfEducation;

    @BindView(R.id.rg_command_work)
    RadioGroup radioGroupCommandWork;

    @BindView(R.id.commandWorkYes)
    RadioButton radioButtonCommandWorkYes;

    @BindView(R.id.commandWorkNo)
    RadioButton radioButtonCommandWorkNo;

    @BindView(R.id.rg_leadership)
    RadioGroup radioGroupLeadership;

    @BindView(R.id.leadershipYes)
    RadioButton radioButtonLeadershipYes;

    @BindView(R.id.leadershipNo)
    RadioButton radioButtonLeadershipNo;

    @BindView(R.id.rg_driver)
    RadioGroup radioGroupDriver;

    @BindView(R.id.driverYes)
    RadioButton radioButtonDriverYes;

    @BindView(R.id.driverNo)
    RadioButton radioButtonDriverNo;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_main);
        ButterKnife.bind(this);
    }
}
