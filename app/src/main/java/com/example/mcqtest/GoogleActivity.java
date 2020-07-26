package com.example.mcqtest;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.Task;
import com.squareup.picasso.Picasso;

public class GoogleActivity extends AppCompatActivity {
    private static final int RC_SIGN_IN = 100;
    public GoogleSignInOptions gso;
    GoogleSignInClient mGoogleSignInClient;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_google);
                gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build();
                 mGoogleSignInClient = GoogleSignIn.getClient(this, gso);
                SignInButton signInButton = findViewById(R.id.sign_in_button);
                signInButton.setSize(SignInButton.SIZE_STANDARD);
                signInButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        signIn();
                    }
                });
    }

    private void signIn() {
        Intent signInIntent = mGoogleSignInClient.getSignInIntent();
        startActivityForResult(signInIntent, RC_SIGN_IN);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // Result returned from launching the Intent from GoogleSignInClient.getSignInIntent(...);
        if (requestCode == RC_SIGN_IN) {
            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
            handleSignInResult(task);
        }
    }

    private void handleSignInResult(Task<GoogleSignInAccount> completedTask) {
        try {
            GoogleSignInAccount account = completedTask.getResult(ApiException.class);
               account.getDisplayName();
              String url= account.getPhotoUrl().toString();
            ImageView imageView=findViewById(R.id.imageView);
            Picasso.get()
                    .load(url)
                    .placeholder(R.drawable.check_wrong_ans)
                    .error(R.drawable.check_right_ans)
                    .into(imageView);
            Toast.makeText(GoogleActivity.this,"name"+account.getDisplayName(),Toast.LENGTH_LONG).show();
            // Signed in successfully, show authenticated UI.
         //   updateUI(account);
        } catch (ApiException e) {


        }
    }
}