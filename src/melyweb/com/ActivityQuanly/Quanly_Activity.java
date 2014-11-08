package melyweb.com.ActivityQuanly;

import java.util.ArrayList;

import melyweb.com.DrawMenu.MenuItem;
import melyweb.com.DrawMenu.MenuListAdapter;
import melyweb.com.Fragment.F_qlyTaikhoan;
import melyweb.com.Fragment.Home;
import melyweb.com.rycafe.R;
import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.widget.DrawerLayout;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class Quanly_Activity extends Activity {
	// CÁC THÀNH PHẦN CỦA MENU
			private DrawerLayout mainLayout;
			private ListView mDrawerList;
			private ActionBarDrawerToggle mDrawerToggle;

			// nav drawer title
			private CharSequence mDrawerTitle;

			// used to store app title
			private CharSequence mTitle;

			// TIÊU ĐỀ VÀ ICON
			private String[] navMenuTitles = { "Quản Lý", "CATEGORY", "Tài Khoản",
					"Danh mục", "Thống kê", "Color", "Body", "Day", "Letter", "Number" };
	        int navMenuico=R.drawable.icon_nav;
//			private int[] navMenuIcons = { R.drawable.ic_menu_home, 0,
//					R.drawable.ic_menu_animals, R.drawable.ic_menu_fruits,
//					R.drawable.ic_menu_shapes, R.drawable.ic_menu_colors,
//					R.drawable.ic_menu_body, R.drawable.ic_menu_days,
//					R.drawable.ic_menu_letters, R.drawable.ic_menu_numbers };

			// DỮ LIỆU
			private ArrayList<MenuItem> navDrawerItems;

			private MenuListAdapter adapter;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_quanly_);
		init();
		if (savedInstanceState == null) {

			displayView(0);
		}
	}
	// khai bao
			@TargetApi(Build.VERSION_CODES.HONEYCOMB)
			@SuppressLint("NewApi")
			private void init() {
				mTitle = mDrawerTitle = getTitle();

				mainLayout = (DrawerLayout) findViewById(R.id.main_layout);

				mDrawerList = (ListView) findViewById(R.id.MenuList);

				navDrawerItems = new ArrayList<MenuItem>();

				// Trang chu
				navDrawerItems.add(new MenuItem(navMenuTitles[0],navMenuico));
		//
				// CHUYEN MUC
				navDrawerItems.add(new MenuItem(navMenuTitles[1]));

				// Động vật
				navDrawerItems.add(new MenuItem(navMenuTitles[2],navMenuico));

				// Trái cây
				navDrawerItems.add(new MenuItem(navMenuTitles[3], navMenuico));

				// Khối hình
				navDrawerItems.add(new MenuItem(navMenuTitles[4], navMenuico));

				// Màu sắc
//				navDrawerItems.add(new MenuItem(navMenuTitles[5], navMenuIcons[5]));
	//
//				// Hình thể
//				navDrawerItems.add(new MenuItem(navMenuTitles[6], navMenuIcons[6]));
	//
//				// Ngày
//				navDrawerItems.add(new MenuItem(navMenuTitles[7], navMenuIcons[7]));
	//
//				// Chữ
//				navDrawerItems.add(new MenuItem(navMenuTitles[8], navMenuIcons[8]));
	//
//				// Số
//				navDrawerItems.add(new MenuItem(navMenuTitles[9], navMenuIcons[9]));

				mDrawerList.setOnItemClickListener(new SlideMenuClickListener());

				adapter = new MenuListAdapter(getApplicationContext(), navDrawerItems);

				mDrawerList.setAdapter(adapter);

				getActionBar().setDisplayHomeAsUpEnabled(true);
				getActionBar().setHomeButtonEnabled(true);

				mDrawerToggle = new ActionBarDrawerToggle(this, mainLayout,
						R.drawable.ic_drawer, // nav menu toggle icon
						R.string.app_name, // nav drawer open - description for
											// accessibility
						R.string.app_name // nav drawer close - description for
											// accessibility
				) {
					@TargetApi(Build.VERSION_CODES.HONEYCOMB)
					@Override
					public void onDrawerClosed(View view) {
						getActionBar().setTitle(mTitle);
						invalidateOptionsMenu();
					}

					@Override
					public void onDrawerOpened(View drawerView) {
						getActionBar().setTitle(mDrawerTitle);
						invalidateOptionsMenu();
					}
				};
				mainLayout.setDrawerListener(mDrawerToggle);

			}

			/* -------------------------------------------- */

			private class SlideMenuClickListener implements
					ListView.OnItemClickListener {

				@Override
				public void onItemClick(AdapterView<?> parent, View view, int position,
						long id) {
					displayView(position);
				}
			}

			private static Fragment fragment = null;

			@TargetApi(Build.VERSION_CODES.HONEYCOMB)
			@SuppressLint("NewApi")
			public void displayView(int position) {

				switch (position) {
				case 0:
					fragment = new Home();
					break;
				case 2:
					fragment = new F_qlyTaikhoan();
					break;
//				case 3:
//					fragment = new Fruit();
//					break;
//				case 4:
//					fragment = new Shape();
//					break;
//				case 5:
//					fragment = new Color();
//					break;
//				case 6:
//					fragment = new Body();
//					break;
//				case 7:
//					fragment = new Day();
//					break;
//				case 8:
//					fragment = new Letter();
//					break;
//				case 9:
//					fragment = new Number();
//					break;

				default:
					break;
				}

				if (fragment != null) {

					FragmentManager fragmentManager = getFragmentManager();
					fragmentManager.beginTransaction()
							.replace(R.id.frame_container, fragment).commit();

					// update selected item and title, then close the drawer
					mDrawerList.setItemChecked(position, true);
					mDrawerList.setSelection(position);

					setTitle(navMenuTitles[position]);

					mainLayout.closeDrawer(mDrawerList);
				} else {
					Log.e("MainActivity", "Error in creating fragment");
				}
			}

			/* -------------------------------------------- */
			@TargetApi(Build.VERSION_CODES.HONEYCOMB)
			@Override
			public void setTitle(CharSequence title) {
				mTitle = title;
				getActionBar().setTitle(mTitle);
			}

			@Override
			public boolean onPrepareOptionsMenu(Menu menu) {
				boolean drawerOpen = mainLayout.isDrawerOpen(mDrawerList);
				return super.onPrepareOptionsMenu(menu);
			}

			@Override
			public boolean onCreateOptionsMenu(Menu menu) {
				// getMenuInflater().inflate(R.menu.login, menu);
				return super.onCreateOptionsMenu(menu);
			}

			@Override
			public boolean onOptionsItemSelected(android.view.MenuItem item) {

				if (mDrawerToggle.onOptionsItemSelected(item))
					return true;

				return super.onOptionsItemSelected(item);

			}

			@Override
			protected void onPostCreate(Bundle savedInstanceState) {
				super.onPostCreate(savedInstanceState);
				mDrawerToggle.syncState();
			}

			@Override
			public void onConfigurationChanged(Configuration newConfig) {
				super.onConfigurationChanged(newConfig);
				mDrawerToggle.onConfigurationChanged(newConfig);
			}
			
			public void onCtaikhoan(View v){
				displayView(2);
			}
}
