package de.jbamberger.offlineclient.source.jodel.model;

import android.content.Context;
import android.content.res.Resources;

import java.util.ArrayList;
import java.util.Collection;

public enum UserType {
    STUDENT("student", 0/*TODO: R.string.user_profiling_type_student*/),
    APPRENTICE("apprentice", 0/*TODO: R.string.user_profiling_type_apprentice*/),
    EMPLOYEE("employee", 0/*TODO: R.string.user_profiling_type_employee*/),
    HIGH_SCHOOL("high_school", 0/*TODO: R.string.user_profiling_type_high_school*/),
    HIGH_SCHOOL_GRADUATE("high_school_graduate", 0/*TODO: R.string.user_profiling_type_high_school_graduate*/),
    OTHER(""/*TODO: FacebookRequestErrorClassification.KEY_OTHER*/, 0/*TODO: R.string.user_profiling_type_other*/);

    public final String backendValue;
    public final transient int stringResId;

    UserType(String str, int i) {
        this.backendValue = str;
        this.stringResId = i;
    }

    public static Collection<String> getAll(Context context) {
        Resources resources = context.getResources();
        Collection<String> arrayList = new ArrayList();
        for (UserType userType : values()) {
            arrayList.add(resources.getString(userType.stringResId));
        }
        return arrayList;
    }
}
