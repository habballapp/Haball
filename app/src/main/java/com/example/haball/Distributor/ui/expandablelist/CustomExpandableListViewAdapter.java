package com.example.haball.Distributor.ui.expandablelist;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import com.example.haball.R;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CustomExpandableListViewAdapter extends BaseExpandableListAdapter {
    private Context context;
    private List<CustomExpandableListModel> ListTitle;
    private HashMap<CustomExpandableListModel, List<CustomExpandableListModel>> ListItem;

    public CustomExpandableListViewAdapter(Context context, List<CustomExpandableListModel> listTitle, HashMap<CustomExpandableListModel, List<CustomExpandableListModel>> listItem) {
        this.context = context;
        ListTitle = listTitle;
        ListItem = listItem;
    }

    @Override
    public int getGroupCount() {
        return ListTitle.size();
    }

    @Override
    public int getChildrenCount(int i) {
        return ListItem.size();
    }

    @Override
    public Object getGroup(int i) {
        return ListTitle.get(i);
    }

    @Override
    public Object getChild(int i, int i1) {
        return ListItem.get(ListTitle.get(i)).get(i1);
    }

    @Override
    public long getGroupId(int i) {
        return i;
    }

    @Override
    public long getChildId(int i, int i1) {
        return i1;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int i, boolean b, View view, ViewGroup viewGroup) {
        String title = String.valueOf(getGroup(i));
        if(view == null){
            view = LayoutInflater.from(context).inflate(R.layout.list_group,null);
        }
        TextView textTitle = view.findViewById(R.id.ListTitle);
        textTitle.setTypeface(null, Typeface.BOLD);
        textTitle.setText(title);
        return view;
    }

    @Override
    public View getChildView(int i, int i1, boolean b, View view, ViewGroup viewGroup) {
        String title = (String) getChild(i,i1);
        if(view == null){
            view = LayoutInflater.from(context).inflate(R.layout.list_item,null);
        }
        TextView textTitle = view.findViewById(R.id.expandableListItem);
        textTitle.setText(title);
        return view;
    }

    @Override
    public boolean isChildSelectable(int i, int i1) {
        return true;
    }
}
