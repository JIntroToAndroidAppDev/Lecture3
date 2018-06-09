package ghoshal.shankhadeep.it15.lecture3;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class BlankFragment2 extends Fragment {

    private Button button;
    private TextView textView;

    public BlankFragment2() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_blank_fragment2, container, false);
        textView = v.findViewById(R.id.fragment2Text);
        button = v.findViewById(R.id.buttonFragment2);

        return v;
    }

    @Override
    public void onResume() {
        textView.setText("");
        textView.setHint("");
        Bundle b = this.getArguments();
        String mess = b!=null?(String) b.get("message"):"";
        if(mess!=null) textView.setText(mess);
        button.setOnClickListener(v -> Toast.makeText(getContext(),
                "This is Fragment 2",
                Toast.LENGTH_SHORT).show());
        super.onResume();
    }
}
