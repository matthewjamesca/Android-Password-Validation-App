package assignmenttwo.matthew.password_validator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = (Button) findViewById(R.id.validateButton) ;
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                EditText userInputText = (EditText)findViewById(R.id.inputText);
                if (validate(userInputText.getText().toString())){
                    TextView outputTextString = (TextView)findViewById(R.id.outputText);
                    outputTextString.setText("Password is strong enough!");
                }
                else {
                    TextView outputTextString = (TextView)findViewById(R.id.outputText);
                    outputTextString.setText("Password is NOT strong enough!");
                }

            }
        });
    }

    /*Checks for a suitable password given the following rules:
    -Is at least 8 characters
    -Is not "password"
    -Has one special character
    -Has one digit
    -Has both upper-case and lower-case characters in it
    */
    static boolean validate(String userInput) {
        String userInputSameCase;

        boolean specialCharacterFlag = false;
        boolean uppercaseFlag = false;
        boolean lowercaseFlag = false;
        boolean digitFlag = false;

        // Null and Length Check
        if (userInput == null){
            return false;
        }
        else if (userInput.length() < 8) {
            return false;
        }

        // Checks for String Value 'password'
        userInputSameCase = userInput.toLowerCase();

        if (userInputSameCase.equals("password")) {
            return false;
        }

        for (int i=0;i<userInput.length();i++) {
            //special character check

            String currentStr = userInput.substring(i, i + 1);

            if (!currentStr.matches("[^A-Za-z0-9 ]")) {
                specialCharacterFlag = true;
            }

            //uppercase check
            if (Character.isUpperCase(userInput.charAt(i))) {
                uppercaseFlag = true;
            }

            //lowercase check
            else if (Character.isLowerCase(userInput.charAt(i))) {
                lowercaseFlag = true;
            }

            //digit check
            else if (Character.isDigit(userInput.charAt(i))) {
                digitFlag = true;
            }
        }

        //if missing any req character type, returns false
        if (!uppercaseFlag||!digitFlag||!lowercaseFlag||!specialCharacterFlag) {
            return false;
        }

        // if this code is executed, password is valid
        return true;
    }
}
