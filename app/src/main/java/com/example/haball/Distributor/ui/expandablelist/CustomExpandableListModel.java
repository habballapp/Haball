package com.example.haball.Distributor.ui.expandablelist;

public class CustomExpandableListModel {
    public String menuName, url;
    public boolean hasChildren, isGroup;

    public CustomExpandableListModel(String menuName, boolean hasChildren, boolean isGroup) {
        this.menuName = menuName;
        this.url = url;
        this.hasChildren = hasChildren;
        this.isGroup = isGroup;
    }
}
