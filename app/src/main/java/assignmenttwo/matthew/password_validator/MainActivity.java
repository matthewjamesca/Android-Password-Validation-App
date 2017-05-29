package assignmenttwo.matthew.password_validator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    static boolean validate(String userInput) {
        String userInputSameCase;

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

        // if this code is executed, password is valid
        return true;
    }
}
