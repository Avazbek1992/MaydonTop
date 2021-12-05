package uz.nits.maydontop.ui;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import uz.nits.maydontop.MainActivity;
import uz.nits.maydontop.R;

public class LoginFragment extends Fragment implements View.OnClickListener {
    TextView register;
    Button loginButton;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {


        View root = inflater.inflate(R.layout.login_layout, container, false);

        loginButton = root.findViewById(R.id.loginButton);
        register = root.findViewById(R.id.register);
        loginButton.setOnClickListener(this);
        register.setOnClickListener(this);

        return root;
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.loginButton: {
                startActivity(new Intent(getActivity(), MainActivity.class));
                requireActivity().finish();
                break;
            }

            case R.id.register: {
                requireActivity().getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.container_splash, new RegisterFragment())
                        .commit();
                break;
            }
        }
    }
}
