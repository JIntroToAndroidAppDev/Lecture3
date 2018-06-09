package ghoshal.shankhadeep.it15.lecture3;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements CommunicateBetweenFragments {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /*FragmentManager fragmentManager = getSupportFragmentManager();

        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.frameLayout,new BlankFragment2());
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();*/

    }

    @Override
    public void sendMessage(String message) {
        BlankFragment2 fragment2 = new BlankFragment2();

        Bundle bundle = new Bundle();
        bundle.putString("message", message);
        fragment2.setArguments(bundle);

        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.popBackStack();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.frameLayout,fragment2);
        //fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }
}