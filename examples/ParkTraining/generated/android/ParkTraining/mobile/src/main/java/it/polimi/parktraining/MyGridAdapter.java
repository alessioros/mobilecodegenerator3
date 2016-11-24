package it.polimi.parktraining;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public final class MyGridAdapter extends BaseAdapter {

	private final Activity context;
	private final int layoutId;
	private final String[] itemNames;
	private final Integer[] imgIds;
	private final Drawable[] drawables;
	private final boolean isDinamyc;

	public MyGridAdapter(Activity context, String[] itemNames) {
		this.context = context;
		this.layoutId = R.layout.my_grid_cell_simple;
		this.itemNames = itemNames;
		this.imgIds = null;
		this.isDinamyc = false;
		this.drawables = null;
	}

	public MyGridAdapter(Activity context, Integer[] imgIds) {
		this.context = context;
		this.layoutId = R.layout.my_grid_cell_image;
		this.itemNames = null;
		this.imgIds = imgIds;
		this.isDinamyc = false;
		this.drawables = null;
	}

	public MyGridAdapter(Activity context, Drawable[] drawables) {
		this.context = context;
		this.layoutId = R.layout.my_grid_cell_image;
		this.itemNames = null;
		this.imgIds = null;
		this.isDinamyc = true;
		this.drawables = drawables;
	}

	public MyGridAdapter(Activity context, String[] itemNames, Integer[] imgIds) {
		this.context = context;
		this.layoutId = R.layout.my_grid_cell_detailed;
		this.itemNames = itemNames;
		this.imgIds = imgIds;
		this.isDinamyc = false;
		this.drawables = null;
	}

	public MyGridAdapter(Activity context, String[] itemNames,
			Drawable[] drawables) {
		this.context = context;
		this.layoutId = R.layout.my_grid_cell_detailed;
		this.itemNames = itemNames;
		this.imgIds = null;
		this.isDinamyc = true;
		this.drawables = drawables;
	}

	@Override
	public int getCount() {
		if (this.layoutId == R.layout.my_grid_cell_image) {
			if (!isDinamyc) {
				return this.imgIds.length;
			} else {
				return this.drawables.length;
			}
		}
		return this.itemNames.length;
	}

	@Override
	public Object getItem(int position) {
		return null;
	}

	@Override
	public long getItemId(int position) {
		return 0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		LayoutInflater inflater = context.getLayoutInflater();
		View gridView = inflater.inflate(this.layoutId, null, true);

		if (this.layoutId == R.layout.my_grid_cell_simple) {
			TextView tv = (TextView) gridView
					.findViewById(R.id.gridview_simple_tv);
			tv.setText(itemNames[position]);
		} else if (this.layoutId == R.layout.my_grid_cell_image) {
			if (!isDinamyc) {
				ImageView iv = (ImageView) gridView
						.findViewById(R.id.gridview_image_img);
				iv.setImageResource(imgIds[position]);
			} else {
				ImageView iv = (ImageView) gridView
						.findViewById(R.id.gridview_image_img);
				iv.setImageDrawable(drawables[position]);
			}
		} else if (this.layoutId == R.layout.my_grid_cell_detailed) {
			if (!isDinamyc) {
				ImageView iv = (ImageView) gridView
						.findViewById(R.id.gridview_detailed_img);
				iv.setImageResource(imgIds[position]);
			} else {
				ImageView iv = (ImageView) gridView
						.findViewById(R.id.gridview_detailed_img);
				iv.setImageDrawable(drawables[position]);
			}
			TextView tv = (TextView) gridView
					.findViewById(R.id.gridview_detailed_tv);
			tv.setText(itemNames[position]);
		}

		return gridView;
	}
}
