package com.example.ec2isaac;

import android.os.Bundle;
import android.text.Editable;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class LoginFragment extends Fragment {
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.login_fragment, container, false);
        final TextInputLayout passwordTextInput = view.findViewById(R.id.password_text_input);
        final TextInputEditText passwordEditText = view.findViewById(R.id.password_edit_text);
        MaterialButton loginButton = view.findViewById(R.id.login_button);


        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!isPasswodValid(passwordEditText.getText())){
                    passwordTextInput.setError(getString(R.string.login_error));
                }else {
                    passwordTextInput.setError(null);
                    ((NavigationHost) getActivity()).navigateTo(new HomeFragment(), false);
                }
            }
        });

        passwordEditText.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int i, KeyEvent event) {

                if (isPasswodValid(passwordEditText.getText())) {
                    passwordTextInput.setError(null);
                }
                return false;
            }
        });

        return view;
    }

    private boolean isPasswodValid(@Nullable Editable text){
        return text != null && text.length() >= 5;
    }
}
