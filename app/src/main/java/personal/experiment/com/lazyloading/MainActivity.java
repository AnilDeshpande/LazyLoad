package personal.experiment.com.lazyloading;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity {

	ListView list;
	LazyImageLoadAdapter adapter;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        list = (ListView) findViewById(R.id.list);
        
        adapter = new LazyImageLoadAdapter(this, strings);
        
        list.setAdapter(adapter);
        
        Button b = (Button) findViewById(R.id.button1);
        b.setOnClickListener(listener);
    }
    
    @Override
    protected void onDestroy() {
    	list.setAdapter(null);
    	super.onDestroy();
    }
    
    public OnClickListener listener = new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			adapter.imageLoader.clearCache();
			adapter.notifyDataSetChanged();
		}
	};
	
	public void onItemClick(int pos) {
		String tempValues = strings[pos];
		
		Toast.makeText(MainActivity.this, "Image URL: " + tempValues,
				Toast.LENGTH_LONG).show();
	}
	
	private String[] strings = {
			"http://androidexample.com/media/webservice/LazyListView_images/image0.png",
			"http://androidexample.com/media/webservice/LazyListView_images/image1.png",
			"http://androidexample.com/media/webservice/LazyListView_images/image2.png",
			"http://androidexample.com/media/webservice/LazyListView_images/image3.png",
			"http://androidexample.com/media/webservice/LazyListView_images/image4.png",
			"http://androidexample.com/media/webservice/LazyListView_images/image5.png",
			"http://androidexample.com/media/webservice/LazyListView_images/image6.png",
			"http://androidexample.com/media/webservice/LazyListView_images/image7.png",
			"http://androidexample.com/media/webservice/LazyListView_images/image8.png",
			"http://androidexample.com/media/webservice/LazyListView_images/image9.png",
			"http://androidexample.com/media/webservice/LazyListView_images/image10.png",
			"http://androidexample.com/media/webservice/LazyListView_images/image0.png",
			"http://androidexample.com/media/webservice/LazyListView_images/image1.png",
			"http://androidexample.com/media/webservice/LazyListView_images/image2.png",
			"http://androidexample.com/media/webservice/LazyListView_images/image3.png",
			"http://androidexample.com/media/webservice/LazyListView_images/image4.png",
			"http://androidexample.com/media/webservice/LazyListView_images/image5.png",
			"http://androidexample.com/media/webservice/LazyListView_images/image6.png",
			"http://androidexample.com/media/webservice/LazyListView_images/image7.png",
			"http://androidexample.com/media/webservice/LazyListView_images/image8.png",
			"http://androidexample.com/media/webservice/LazyListView_images/image9.png",
			"http://androidexample.com/media/webservice/LazyListView_images/image10.png",
			"http://androidexample.com/media/webservice/LazyListView_images/image0.png",
			"http://androidexample.com/media/webservice/LazyListView_images/image1.png",
			"http://androidexample.com/media/webservice/LazyListView_images/image2.png",
			"http://androidexample.com/media/webservice/LazyListView_images/image3.png",
			"http://androidexample.com/media/webservice/LazyListView_images/image4.png",
			"http://androidexample.com/media/webservice/LazyListView_images/image5.png",
			"http://androidexample.com/media/webservice/LazyListView_images/image6.png",
			"http://androidexample.com/media/webservice/LazyListView_images/image7.png",
			"http://androidexample.com/media/webservice/LazyListView_images/image8.png",
			"http://androidexample.com/media/webservice/LazyListView_images/image9.png",
			"http://androidexample.com/media/webservice/LazyListView_images/image10.png" };
}
