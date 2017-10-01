package de.jbamberger.offlineclient.source.jodel.model;

import android.text.TextUtils;
import java.util.List;

public class StickyPost {
    public static final String STYCKYPOST_TYPE_BUTTONS = "buttons";
    public static final String STYCKYPOST_TYPE_INFO = "info";
    public static final String STYCKYPOST_TYPE_LINK = "link";
    public static final String STYCKYPOST_TYPE_SURVEY = "survey";
    public final List<StickyButton> buttons;
    public final String color;
    public final String link;
    public final String linkedPostColor;
    public final String locationName;
    public final String message;
    public final String stickypostId;
    public final String type;
    public String voted;

    public class StickyButton {
        public final String title;

        StickyButton(String str) {
            this.title = str;
        }
    }

    public StickyPost(String str, String str2, String str3, String str4, String str5, String str6, String str7, List<StickyButton> list, String str8) {
        this.message = str;
        this.type = str2;
        this.stickypostId = str3;
        this.color = str4;
        this.locationName = str5;
        this.link = str6;
        this.linkedPostColor = str7;
        this.buttons = list;
        this.voted = str8;
    }

    public boolean isType(String str) {
        return TextUtils.equals(str, this.type);
    }

    public boolean hasButtons() {
        return this.buttons != null && this.buttons.size() > 0;
    }
}
