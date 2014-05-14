package andevcon14.FragmentLogged;

/**
 * Created by john on 5/14/14.
 */
public class DynamicFragment extends LoggedFragment {
    public static DynamicFragment newInstance(String text){
        DynamicFragment df = new DynamicFragment();
        df.setText(text);
        return df;
    }
}
