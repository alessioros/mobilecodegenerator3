package it.polimi.parktraining;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public final class MyListAdapter extends ArrayAdapter<String> {

	private final Activity context;
	private final int layoutId;
	private final String[] itemNames;
	private final String[] subitemNames;
	private final Integer[] imgIds;
	private final Integer[] iconsIds;

	public MyListAdapter(Activity context, int layoutId, String[] itemNames) {
		super(context, layoutId, itemNames);
		this.context = context;
		this.layoutId = layoutId;
		this.itemNames = itemNames;
		this.subitemNames = null;
		this.imgIds = null;
		this.iconsIds = null;
	}

	public MyListAdapter(Activity context, int layoutId, String[] itemNames,
			Integer[] imgIds) {
		super(context, layoutId, itemNames);
		this.context = context;
		this.layoutId = layoutId;
		this.itemNames = itemNames;
		this.imgIds = imgIds;
		this.subitemNames = null;
		this.iconsIds = null;
	}

	public MyListAdapter(Activity context, int layoutId, String[] itemNames,
			String[] subitemNames, Integer[] imgIds, Integer[] iconsIds) {
		super(context, layoutId, itemNames);
		this.context = context;
		this.layoutId = layoutId;
		this.itemNames = itemNames;
		this.imgIds = imgIds;
		this.subitemNames = subitemNames;
		this.iconsIds = iconsIds;
	}

	public View getView(int position, View view, ViewGroup parent) {
		LayoutInflater inflater = context.getLayoutInflater();
		View rowView = inflater.inflate(this.layoutId, null, true);

		try {
			TextView tv = (TextView) rowView.findViewById(R.id.listview_tv);
			tv.setText(itemNames[position]);
		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			TextView tv = (TextView) rowView.findViewById(R.id.listview_tv_1);
			tv.setText(itemNames[position]);
		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			TextView tv = (TextView) rowView.findViewById(R.id.listview_tv_2);
			tv.setText(subitemNames[position]);
		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			ImageView iv = (ImageView) rowView.findViewById(R.id.listview_img);
			iv.setImageResource(imgIds[position]);
		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			ImageView ic = (ImageView) rowView.findViewById(R.id.listview_ico);
			ic.setImageResource(iconsIds[position]);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return rowView;
	}

}
