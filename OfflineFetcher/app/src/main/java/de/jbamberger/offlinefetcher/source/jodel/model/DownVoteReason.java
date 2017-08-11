package de.jbamberger.offlinefetcher.source.jodel.model;

import android.content.Context;
import android.content.res.Resources;
import java.util.ArrayList;
import java.util.List;

import de.jbamberger.offlinefetcher.R;
import de.jbamberger.offlinefetcher.util.Strings;

public class DownVoteReason {
    public static final DownVoteReason CANCEL = new DownVoteReason(0, 0);
    //TODO: reason 1..5
    private static final DownVoteReason[] REASONS = new DownVoteReason[]{
            new DownVoteReason(1, R.string.app_name),
            new DownVoteReason(2, R.string.app_name),
            new DownVoteReason(3, R.string.app_name),
            new DownVoteReason(4, R.string.app_name),
            new DownVoteReason(5, R.string.app_name)};
    public static final DownVoteReason STUB = new DownVoteReason(-1, 0);
    //TODO: @KeepName
    public final int reasonCode;
    private final transient int stringResId;

    private DownVoteReason(int reasonCode, int stringResId) {
        this.reasonCode = reasonCode;
        this.stringResId = stringResId;
    }

    public static List<DownVoteReason> getReasons(Context context) {
        Resources resources = context.getResources();
        List<DownVoteReason> arrayList = new ArrayList<>();
        for (DownVoteReason downVoteReason : REASONS) {
            String string = resources.getString(downVoteReason.stringResId);
            if (!(Strings.isEmpty(string) || "$empty$".equalsIgnoreCase(string))) {
                arrayList.add(downVoteReason);
            }
        }
        return arrayList;
    }

    public static List<String> localize(Context context, List<DownVoteReason> list) {
        Resources resources = context.getResources();
        List<String> arrayList = new ArrayList<>(list.size());
        for (DownVoteReason downVoteReason : list) {
            arrayList.add(resources.getString(downVoteReason.stringResId));
        }
        return arrayList;
    }
}
