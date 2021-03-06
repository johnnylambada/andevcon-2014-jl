package andevcon14.FragmentComms;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import andevcon14.FragmentComms.Types.ActivityIntent.ActivityIntentStarter;
import andevcon14.FragmentComms.Types.FactoryMethod.FactoryMethodActivity;
import andevcon14.FragmentComms.Types.LayoutElements.LayoutElementsActivity;
import andevcon14.FragmentComms.Types.ObserverPattern.ObserverPatternActivity;
import andevcon14.FragmentComms.Types.SetArguments.SetArgumentsActivity;

enum Menu {
    ActivityIntent(ActivityIntentStarter.class),
    SetArguments(SetArgumentsActivity.class),
    LayoutElements(LayoutElementsActivity.class),
    FactoryMethod(FactoryMethodActivity.class),
    ObserverPattern(ObserverPatternActivity.class),
    ;
    private final static String TITLE = "title";
    Class<? extends Activity> activityClass;
    Menu(Class<? extends Activity> activityClass){
        this.activityClass = activityClass;
    }
    public static SimpleAdapter getSimpleAdapter(Context context){
        return new SimpleAdapter(
                context,
                getList(),
                android.R.layout.simple_list_item_1,
                new String[] { TITLE },
                new int[] { android.R.id.text1 });
    }
    public Intent getIntent(Context context){
        return new Intent(context,activityClass);
    }
    public static Intent getIntent(Context context, int position){
        Menu m = Menu.values()[position];
        return m.getIntent(context);
    }
    static private List<Map<String,?>> getList(){
        List<Map<String,?>> list = new ArrayList<Map<String,?>>();
        Map<String,String> map;
        for(Menu m : Menu.values()){
            map = new HashMap<String,String>();
            map.put(TITLE,m.name());
            list.add(map);
        }
        return list;
    }
}
