package com.davidlacho.golfscorecard;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by david.lacho on 2019-06-28
 */
public class ListAdapter extends BaseAdapter {

  private final Context mContext;
  private final Hole[] mHoles;

  public ListAdapter (Context context, Hole[] holes) {
    mContext = context;
    mHoles = holes;
  }
  
  @Override
  public int getCount() {
    return mHoles.length;
  }

  @Override
  public Object getItem(int position) {
    return mHoles[position];
  }

  @Override
  public long getItemId(int position) {
    return 0; // Not implemented
  }

  @Override
  public View getView(final int position, View convertView, ViewGroup parent) {
    final ViewHolder holder;

    if (convertView == null) {
      convertView = LayoutInflater.from(mContext).inflate(R.layout.list_item, null);
      holder = new ViewHolder();
      holder.holeLabel = convertView.findViewById(R.id.holeLabel);
      holder.strokeCount = convertView.findViewById(R.id.strokeCount);
      holder.addStrokeButton = convertView.findViewById(R.id.addStrokeButton);
      holder.removeStrokeButton = convertView.findViewById(R.id.removeStrokeButton);

      convertView.setTag(holder);
    } else {
      holder = (ViewHolder) convertView.getTag();
    }

    holder.holeLabel.setText(mHoles[position].getLabel());
    holder.strokeCount.setText(mHoles[position].getStrokeCount() + "");
    holder.removeStrokeButton.setOnClickListener(new OnClickListener() {
      @Override
      public void onClick(View v) {
        int updatedStrokeCount = mHoles[position].getStrokeCount() - 1;
        if (updatedStrokeCount < 0) {
          updatedStrokeCount = 0;
        }
        mHoles[position].setStrokeCount(updatedStrokeCount);
        holder.strokeCount.setText(updatedStrokeCount + "");
      }
    });
    holder.addStrokeButton.setOnClickListener(new OnClickListener() {
      @Override
      public void onClick(View v) {
        int updatedStrokeCount = mHoles[position].getStrokeCount() + 1;
        mHoles[position].setStrokeCount(updatedStrokeCount);
        holder.strokeCount.setText(updatedStrokeCount + "");
      }
    });

    return convertView;
  }

  private static class ViewHolder {
    TextView holeLabel;
    TextView strokeCount;
    Button removeStrokeButton;
    Button addStrokeButton;
  }
}
