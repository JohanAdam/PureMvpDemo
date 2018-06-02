package io.nyannyan.puremvpdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.nyannyan.puremvpdemo.DetailsContract.View;
import io.nyannyan.puremvpdemo.root.App;
import javax.inject.Inject;

public class MainActivity extends AppCompatActivity implements View {

  @BindView(R.id.tvMessage)
  TextView tvMessage;
  @BindView(R.id.etFirstName)
  EditText etFirstName;
  @BindView(R.id.etLastName)
  EditText etLastName;
  @BindView(R.id.btnSubmit)
  Button btnSubmit;

//  private EditText firstName, lastName;
//  private TextView tvDetail;
//  private Button btnSubmit;

//  private Presenter presenter;
  @Inject
  DetailsContract.Presenter presenter;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    ButterKnife.bind(this);

//    presenter = new DetailsPresenter(this);
    ((App) getApplication()).getApplicationComponent().inject(this);
  }

  @Override
  public void showMessage(String message) {
    tvMessage.setText(message);
  }

  @OnClick(R.id.btnSubmit)
  public void onClick() {
    if (TextUtils.isEmpty(etFirstName.getText().toString())){
          Toast.makeText(MainActivity.this, "Please enter first name", Toast.LENGTH_SHORT).show();
        } else {
          presenter.submitName(etFirstName.getText().toString(), etLastName.getText().toString());
          presenter.loadMessage();
        }
  }

  @Override
  protected void onResume() {
    super.onResume();

    //We cant use presenter in view if we not link it
    presenter.setView(MainActivity.this);
  }
}
