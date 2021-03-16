package es.ulpgc.eite.da.basicquizlab;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class CheatActivity extends AppCompatActivity {

  public static final String TAG = "Quiz.CheatActivity";

  public final static String EXTRA_ANSWER = "EXTRA_ANSWER";
  public final static String EXTRA_CHEATED = "EXTRA_CHEATED";

  public final static String KEY_ANSWER = "KEY_ANSWER";
  public final static String KEY_CURRENT_ANSWER = "KEY_CURRENT_ANSWER";
  public final static String KEY_SELECTED_BUTTON ="KEY_SELECTED_BUTTON";

  private Button noButton, yesButton;
  private TextView answerText;

  private int currentAnswer;
  private boolean answerCheated,trueButtonSelected;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_cheat);

    getSupportActionBar().setTitle(R.string.cheat_title);


    if (savedInstanceState != null) {
      currentAnswer= savedInstanceState.getInt(KEY_CURRENT_ANSWER);
      answerCheated= savedInstanceState.getBoolean(KEY_ANSWER);
      trueButtonSelected = savedInstanceState.getBoolean(KEY_SELECTED_BUTTON);
    }

    initLayoutData();

    linkLayoutComponents();
    enableLayoutButtons();
  }

  private void initLayoutData() {

    currentAnswer = getIntent().getExtras().getInt(EXTRA_ANSWER);

  }

  private void linkLayoutComponents() {
    noButton = findViewById(R.id.noButton);
    yesButton = findViewById(R.id.yesButton);
    answerText = findViewById(R.id.answerText);

  }



  private void enableLayoutButtons() {

    noButton.setOnClickListener(v -> onNoButtonClicked());
    yesButton.setOnClickListener(v -> onYesButtonClicked());
    if (trueButtonSelected) {
      yesButton.setEnabled(false);
      noButton.setEnabled(false);

      mostrarRespuesta();
    }
  }

  private void returnCheatedStatus() {
    Log.d(TAG, "returnCheatedStatus()");
    Log.d(TAG, "answerCheated: " + answerCheated);

    Intent intent = new Intent();
    intent.putExtra(EXTRA_CHEATED, answerCheated);
    setResult(RESULT_OK, intent);

    finish();
  }

  @Override
  public void onBackPressed() {
    Log.d(TAG, "onBackPressed()");

    returnCheatedStatus();
  }


  private void onYesButtonClicked() {
    yesButton.setEnabled(false);
    noButton.setEnabled(false);
    trueButtonSelected= true;
    answerCheated = true;
    mostrarRespuesta();

  }

  private void onNoButtonClicked() {
    yesButton.setEnabled(false);
    noButton.setEnabled(false);

    returnCheatedStatus();
  }

  @Override
  protected void onSaveInstanceState(@NonNull Bundle outState) {
    super.onSaveInstanceState(outState);
    //Pasamos si hemos decidido  usar el cheat
    outState.putBoolean(KEY_ANSWER, answerCheated);
    //Pasamos la respuesta de la  pregunta
    outState.putInt(KEY_CURRENT_ANSWER,  currentAnswer);
    //Pasamos si hemos marcado el boton Yes
    outState.putBoolean(KEY_SELECTED_BUTTON, trueButtonSelected);


  }

  //Metodo que muestra la respuesta para evitar repetir tanto codigo.
  private void mostrarRespuesta() {

    if(currentAnswer == 0) {
      answerText.setText(R.string.false_text);
    } else {
      answerText.setText(R.string.true_text);

    }
  }

}
