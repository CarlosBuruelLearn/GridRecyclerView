package buruel.carlos.mx.gridrecyclerview;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

public class MainActivity
	extends AppCompatActivity
	implements MyRecyclerViewAdapter.ItemClickListener
{
	MyRecyclerViewAdapter adapter;


	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main_activity);

		String [] data =
			{"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48"};
		RecyclerView recyclerView = (RecyclerView) findViewById(R.id.rvNumbers);
		int numberOfComumns = 7;
		recyclerView.setLayoutManager(new GridLayoutManager(this, numberOfComumns));
		adapter = new MyRecyclerViewAdapter(this, data);
		adapter.setClickListener(this);
		recyclerView.setAdapter(adapter);
	}

	@Override
	public void onItemClick(View vista, int posicion) {
		Log.i("TAG", "You clicked number " + adapter.getItem(posicion) + ", which is at cell position " + posicion);
	}
}