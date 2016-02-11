package personal.experiment.com.lazyloading;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class LazyImageLoadAdapter extends BaseAdapter implements OnClickListener{

	private Activity activity;
	private String[] data;
	private static LayoutInflater inflater = null;
	public ImageLoader imageLoader;
	
	public LazyImageLoadAdapter(Activity a, String[] d) {
		activity = a; 
		data = d;
		
		inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		
		imageLoader = new ImageLoader(activity.getApplicationContext());
	}
	
	@Override
	public int getCount() {
		return data.length;
	}

	@Override
	public Object getItem(int pos) {
		return pos;
	}

	@Override
	public long getItemId(int pos) {
		return pos;
	}

	public static class ViewHolder {
		public TextView text;
		public TextView text1;
		public TextView textWide;
		public ImageView image;
	}
	
	@Override
	public View getView(int pos, View convertView, ViewGroup parent) {
		
		View vi = convertView;
		ViewHolder holder;
		
		if(convertView == null) {
			
			vi = inflater.inflate(R.layout.listview_row, null);
			
			holder = new ViewHolder();
			
			holder.text = (TextView) vi.findViewById(R.id.text);
			holder.text1 = (TextView) vi.findViewById(R.id.text1);
			holder.image = (ImageView) vi.findViewById(R.id.image);
			
			vi.setTag(holder);
			
		} else {
			holder = (ViewHolder) vi.getTag();
		}
		
		holder.text.setText("Company " + pos);
		holder.text1.setText("company description " + pos);
		ImageView image = holder.image;
		
		imageLoader.displayImage(data[pos], image);
		
		vi.setOnClickListener(new OnItemClickListener(pos));
		
		return vi;
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
	}
	
	private class OnItemClickListener implements OnClickListener {

		private int position;
		
		OnItemClickListener(int pos) {
			position = pos;
		}
		
		@Override
		public void onClick(View v) {
			MainActivity sct = (MainActivity) activity;
			sct.onItemClick(position);
		}
	}
}
