package de.jbamberger.offlineclient.source.jodel.model;

import android.content.Context;
import android.content.res.Resources;

import java.util.ArrayList;
import java.util.List;

import de.jbamberger.offlineclient.R;
import de.jbamberger.offlineclient.util.Strings;

public class UpVoteReason {
    public static final UpVoteReason CANCEL = new UpVoteReason(0, 0);
    public static final UpVoteReason STUB = new UpVoteReason(-1, 0);
    //TODO: reason 1..5
    private static final UpVoteReason[] REASONS = new UpVoteReason[]{
            new UpVoteReason(1, R.string.app_name),
            new UpVoteReason(2, R.string.app_name),
            new UpVoteReason(3, R.string.app_name),
            new UpVoteReason(4, R.string.app_name),
            new UpVoteReason(5, R.string.app_name)};
    //TODO: @KeepName
    public final int reasonCode;
    private final transient int stringResId;

    private UpVoteReason(int i, int i2) {
        this.reasonCode = i;
        this.stringResId = i2;
    }

    public static List<UpVoteReason> getReasons(Context context) {
        Resources resources = context.getResources();
        List<UpVoteReason> arrayList = new ArrayList<>();
        for (UpVoteReason upVoteReason : REASONS) {
            String string = resources.getString(upVoteReason.stringResId);
            if (!(Strings.isEmpty(string) || "$empty$".equalsIgnoreCase(string))) {
                arrayList.add(upVoteReason);
            }
        }
        return arrayList;
    }

    public static List<String> localize(Context context, List<UpVoteReason> list) {
        Resources resources = context.getResources();
        List<String> arrayList = new ArrayList<>(list.size());
        for (UpVoteReason upVoteReason : list) {
            arrayList.add(resources.getString(upVoteReason.stringResId));
        }
        return arrayList;
    }
}
