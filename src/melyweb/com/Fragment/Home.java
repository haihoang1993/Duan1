package melyweb.com.Fragment;

import melyweb.com.rycafe.R;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

@SuppressLint("NewApi")
public class Home extends Fragment {
	Activity root;

	public Home() {
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		root = getActivity();

		View rootView = inflater
				.inflate(R.layout.flasment_quanly_, container, false);

		return rootView;
	}

}
