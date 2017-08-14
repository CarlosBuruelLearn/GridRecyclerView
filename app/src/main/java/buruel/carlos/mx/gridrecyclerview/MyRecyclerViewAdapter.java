package buruel.carlos.mx.gridrecyclerview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class MyRecyclerViewAdapter
	extends RecyclerView.Adapter<MyRecyclerViewAdapter.ViewHolder>
{
	private String[] mData = new String[0];
	private LayoutInflater mInflater;
	private ItemClickListener mClickListener;

	public MyRecyclerViewAdapter(Context context, String[] mData) {
		this.mInflater = LayoutInflater.from(context);
		this.mData = mData;
	}

	@Override
	public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
		View vista = mInflater.inflate(R.layout.recyclerview_item, parent, false);
		return new ViewHolder(vista);
	}

	@Override
	public void onBindViewHolder(ViewHolder holder, int position) {
		String animal = mData[position];
		holder.myTextView.setText(animal);
	}

	// convenience method for getting data at click position
	public String getItem(int id) {
		return mData[id];
	}

	@Override
	public int getItemCount() {
		return mData.length;
	}

	public void setClickListener(ItemClickListener itemClickListener) {
		this.mClickListener = itemClickListener;
	}

	class ViewHolder
		extends RecyclerView.ViewHolder
		implements View.OnClickListener
	{
		TextView myTextView;
		public ViewHolder(View vista)
		{
			super(vista);
			myTextView = (TextView) vista.findViewById(R.id.info_text);
			myTextView.setOnClickListener(this);
		}

		@Override
		public void onClick(View vista) {
			if( mClickListener != null )
				mClickListener.onItemClick(vista, getAdapterPosition());
		}
	}

	public interface ItemClickListener{
		void onItemClick(View vista, int posicion);
	}
}