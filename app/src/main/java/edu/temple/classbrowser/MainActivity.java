package edu.temple.classbrowser;

import android.app.Activity;
import android.app.FragmentManager;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends Activity {

    FragmentManager fm;
    ArrayList<BrowserFragment> browserFragments;

    int currentTab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        browserFragments = new ArrayList<>();
        fm = getFragmentManager();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.browser_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onMenuItemSelected(int featureId, MenuItem item){
        int menuId = item.getItemId();
        //items in menu resources preceded by "action"
        if(menuId == R.id.new_tab){
            BrowserFragment fragment = BrowserFragment.newInstance("");
            browserFragments.add(fragment);
            fm.beginTransaction().replace(R.id.browser_container,fragment).commit();

            currentTab = browserFragments.size() - 1;
        }
        else if(menuId == R.id.previous_tab && currentTab > 0){
            fm.beginTransaction().replace(R.id.browser_container,browserFragments.get(--currentTab)).commit();
        }else if(menuId == R.id.next_tab && currentTab < browserFragments.size()-1){
            fm.beginTransaction().replace(R.id.browser_container,browserFragments.get(++currentTab)).commit();

        }
        return super.onMenuItemSelected(featureId,item);
    }
}
