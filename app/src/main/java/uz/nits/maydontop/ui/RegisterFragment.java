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

public class RegisterFragment extends Fragment implements View.OnClickListener {
    TextView loginTextView;
    Button registerButton;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {


        View root = inflater.inflate(R.layout.register_layout, container, false);

        loginTextView = root.findViewById(R.id.loginTextView);
        registerButton = root.findViewById(R.id.registerButton);
        loginTextView.setOnClickListener(this);
        registerButton.setOnClickListener(this);

        return root;
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.loginTextView: {
                requireActivity().getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.container_splash, new LoginFragment())
                        .commit();
                break;
            }
            case R.id.registerButton: {
                startActivity(new Intent(getActivity(), MainActivity.class));
                requireActivity().finish();
                break;
            }
        }
    }
}
