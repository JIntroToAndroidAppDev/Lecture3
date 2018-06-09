package ghoshal.shankhadeep.it15.lecture3;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class BlankFragment1 extends Fragment {

    private Button button;
    private Button button2;
    private CommunicateBetweenFragments betweenFragments;
    private TextView messageTV;

    public BlankFragment1() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_blank_fragment1, container, false);
        messageTV = v.findViewById(R.id.toFragment2Message);
        button = v.findViewById(R.id.buttonFragment1);
        button2 = v.findViewById(R.id.toFrag2);
        return v;
    }

    @Override
    public void onResume() {
        button2.setOnClickListener(v -> {
            String message = messageTV.getText().toString();
            betweenFragments.sendMessage(message);
        });

        button.setOnClickListener(v -> {
            FragmentManager fragmentManager = getActivity().getSupportFragmentManager();

            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.add(R.id.frameLayout,new BlankFragment2());
            //fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();
        });

        super.onResume();
    }

    /**
     * Called when a fragment is first attached to its context.
     * {@link #onCreate(Bundle)} will be called after this.
     *
     * @param context
     */
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            this.betweenFragments = (MainActivity) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString() + " must implement CommunicateBetweenFragments interface");
        }
    }
}
