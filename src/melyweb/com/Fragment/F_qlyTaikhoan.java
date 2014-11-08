package melyweb.com.Fragment;

import java.util.ArrayList;

import melyweb.com.Obj.TaiKhoan;
import melyweb.com.custom.BaseAdapterTaikhoan;
import melyweb.com.database.database;
import melyweb.com.rycafe.R;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Fragment;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

@SuppressLint("NewApi") 
public class F_qlyTaikhoan extends Fragment {
	//final Context context=getActivity().getApplicationContext();
	ListView lvTaikhoan;
	Activity root;
    database db;
    BaseAdapter adap;
    ArrayList<TaiKhoan> arrTaikhoan=new ArrayList<TaiKhoan>();
    
    EditText edName, edPass;
	public F_qlyTaikhoan() {
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		root = getActivity();

		View rootView = inflater
				.inflate(R.layout.activity_qly_tk, container, false);
		
		lvTaikhoan=(ListView) rootView.findViewById(R.id.lvTaikhoan);
        db=new database(getActivity().getApplicationContext());
        arrTaikhoan=db.getTaikhoan();
        adap=new BaseAdapterTaikhoan(getActivity().getApplicationContext(),arrTaikhoan);
        lvTaikhoan.setAdapter(adap);
        Button btnThemtaikhoan=(Button) rootView.findViewById(R.id.btnThemtk);
        btnThemtaikhoan.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				//popupThemtaitk();
			}
		});
		return rootView;
	}
	
//	public void popupThemtaitk(){
//		LayoutInflater li = LayoutInflater.from(context);
//		View promptsView = li.inflate(R.layout.popup_taikhoan, null);
//
//		AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
//				context);
//
//		// set prompts.xml to alertdialog builder
//		alertDialogBuilder.setView(promptsView);
//
////		final EditText userInput = (EditText) promptsView
////				.findViewById(R.id.editTextDialogUserInput);
//
//		// set dialog message
//		alertDialogBuilder
//			.setCancelable(false)
//			.setPositiveButton("OK",
//			  new DialogInterface.OnClickListener() {
//			    public void onClick(DialogInterface dialog,int id) {
//				// get user input and set it to result
//				// edit text
////				result.setText(userInput.getText());
//			    }
//			  })
//			.setNegativeButton("Cancel",
//			  new DialogInterface.OnClickListener() {
//			    public void onClick(DialogInterface dialog,int id) {
//				dialog.cancel();
//			    }
//			  });
//
//		// create alert dialog
//		AlertDialog alertDialog = alertDialogBuilder.create();
//
//		// show it
//		alertDialog.show();
//	}
}
