package andevcon14.FragmentComms;

/**
 * Created by john on 5/14/14.
 */
public class DynamicFragment extends CenteredTextFragment {
    public static DynamicFragment newInstance(String text){
        DynamicFragment df = new DynamicFragment();
        df.setText(text);
        return df;
    }
}
