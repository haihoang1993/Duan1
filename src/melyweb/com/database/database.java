package melyweb.com.database;

import java.util.ArrayList;

import melyweb.com.Obj.TaiKhoan;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class database extends SQLiteOpenHelper {
	 private static final String CREATE_TABLE_TAIKHOAN=
				"CREATE TABLE TAI_KHOAN(ID INTEGER PRIMARY KEY  AUTOINCREMENT,Name TEXT,Pass TEXT)";
			
	public database(Context context) {
		super(context,"RyCafe_DB",null,1);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		db.execSQL(CREATE_TABLE_TAIKHOAN);
		
		
	}
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		db.execSQL("DROP TABLE IF EXISTS TAI_KHOAN");
		onCreate(db);
	}
	
	
   //----------------------------------------------------------
   //-----------------Thêm tài khoản vào databse---------------
		//trả về -1 và 0
		public int addCACKHOAN(TaiKhoan tk){
	        SQLiteDatabase db=this.getWritableDatabase();
	        ContentValues values=new ContentValues();
	       // values.put("idLoaiGD",khoan.getIdLoaiGD());
	        values.put("Name",tk.getTenTK());
	        values.put("Pass",tk.getMatKhau());
	        int error = (int) db.insert("TAI_KHOAN",null,values);
	        if (error==-1){
	            Log.d("-------", "error in");
	            //Toast.makeText(Activity_LopHoc.class,"lỗi",Toast.LENGTH_LONG)

	        } else Log.d("------","Ok");

	        return error;
	    }
		
		
	//-------------------------------------------------------------
	//-------------------Lấy ra tất cả các tài khoản---------------
	     public ArrayList<TaiKhoan> getTaikhoan(){
	    	
	    	        ArrayList<TaiKhoan> dsCackhoan=new ArrayList<TaiKhoan>();

	    	        SQLiteDatabase db = this.getWritableDatabase();

	    	        Cursor cursor= db.rawQuery("Select * from TAI_KHOAN",null);
	    	        if (cursor!=null) {
	    	            cursor.moveToFirst();
	    	            Log.d("----Log-----"," query ok");
	    	            while (cursor.isAfterLast() == false) {
	    	                 TaiKhoan rowNew = new TaiKhoan();
	    	                // rowNew.setStt(stt);
	    	                rowNew.setMaTaikhan(cursor.getInt(0));
	    	                rowNew.setTenTK(cursor.getString(1));
	    	                rowNew.setMatKhau(cursor.getString(2));
	    	                dsCackhoan.add(rowNew) ;
	    	                cursor.moveToNext();

	    	        }
	    	        }else{
	    	            Log.d("---LOG---","error query");
	    	        }

	    	        cursor.close();
	    	        return dsCackhoan;
	     }


}
