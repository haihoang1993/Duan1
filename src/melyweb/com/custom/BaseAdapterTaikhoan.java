package melyweb.com.custom;

import java.util.ArrayList;

import melyweb.com.Obj.TaiKhoan;
import melyweb.com.rycafe.R;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class BaseAdapterTaikhoan extends BaseAdapter {

	ArrayList<TaiKhoan> myList = new ArrayList<TaiKhoan>();
	LayoutInflater inflater;
	Context context;

	public BaseAdapterTaikhoan(Context context, ArrayList<TaiKhoan> myList) {
		this.myList = myList;
		this.context = context;
		inflater = LayoutInflater.from(this.context); // only context can also
														// be used
	}

	@Override
	public int getCount() {
		return myList.size();
	}

	@Override
	public TaiKhoan getItem(int position) {
		return myList.get(position);
	}

	@Override
	public long getItemId(int position) {
		return 0;
	}
    
	private class MyViewHolder {
		TextView tvTen, tvMK;
		TextView tvST;
		ImageView ivDele;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		MyViewHolder mViewHolder;

		if (convertView == null) {
			convertView = inflater.inflate(R.layout.custom_adapter_taikhoan, null);
			mViewHolder = new MyViewHolder();
			convertView.setTag(mViewHolder);
		} else {
			mViewHolder = (MyViewHolder) convertView.getTag();
		}
		mViewHolder.tvST = detail(convertView, R.id.tvID,
				myList.get(position).getMaTaikhan()+"");
		mViewHolder.tvTen= detail(convertView, R.id.tvTen,
				"Username: "+myList.get(position).getTenTK());
		
		//mViewHolder.tvST = detail(convertView, R.id.tvMK, myList.get(position).getMaTaikhan());
		
		mViewHolder.tvMK = detail(convertView, R.id.tvMK,
				"Password: "+myList.get(position).getMatKhau());
		mViewHolder.ivDele= (ImageView) convertView.findViewById(R.id.ivDele);
        mViewHolder.ivDele.setTag(position);
        mViewHolder.ivDele.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Toast.makeText(context,v.getTag().toString(),Toast.LENGTH_LONG).show();
				myList.remove(Integer.parseInt(v.getTag().toString()));
				notifyDataSetChanged();
				
			}
		});
		return convertView;

	}

	

	private TextView detail(View v, int resId, String text) {
		TextView tv = (TextView) v.findViewById(resId);
		tv.setText(text);
		return tv;
	}

	private ImageView detail1(View v, int resId, int icon) {
		ImageView iv = (ImageView) v.findViewById(resId);
		iv.setImageResource(icon); //
		return iv;
	}


}
