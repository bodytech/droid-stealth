package spikes.stealthdialer;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.stealth.android.HomeActivity;
import com.stealth.android.R;

/**
 * Takes a phone number it was given and displays this whenever loaded.
 *
 * @author Joris Z. van den Oever
 * Created on 2/26/14.
 */
public class StealthDialerFragment extends Fragment {
    public static final String CALL_KEY = "CALL NUMBER KEY";
    TextView callData;
    String phone_number_dialed;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.call_display_layout, container, false);
        callData = (TextView)rootView.findViewById(R.id.callData);
        return rootView;
    }

    @Override
    public void onStart() {
        phone_number_dialed = ((HomeActivity) getActivity()).getPhone_number_dialed();
        if(phone_number_dialed == null || phone_number_dialed.equals(""))
            callData.setText("No call was made");
        else
            callData.setText(phone_number_dialed + " was the call that sent you here.");

        super.onStart();
    }
}
