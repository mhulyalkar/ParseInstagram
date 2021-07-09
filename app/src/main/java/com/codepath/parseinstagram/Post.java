package com.codepath.parseinstagram;

import android.util.Log;

import com.parse.ParseClassName;
import com.parse.ParseFile;
import com.parse.ParseObject;
import com.parse.ParseUser;

import java.util.Date;

@ParseClassName("Post")
public class Post extends ParseObject {

    public static final String KEY_DESCRIPTION = "description";
    public static final String KEY_IMAGE = "image";
    public static final String KEY_USER = "user";

    public final static String calculateTimeAgo(Date createdAt) {

        final int SECOND_MILLIS = 1000;
        final int MINUTE_MILLIS = 60 * SECOND_MILLIS;
        final int HOUR_MILLIS = 60 * MINUTE_MILLIS;
        final int DAY_MILLIS = 24 * HOUR_MILLIS;

        try {
            createdAt.getTime();
            long time = createdAt.getTime();
            long now = System.currentTimeMillis();

            final long diff = now - time;
            if (diff < MINUTE_MILLIS) {
                return "just now";
            } else if (diff < 2 * MINUTE_MILLIS) {
                return "a minute ago";
            } else if (diff < 50 * MINUTE_MILLIS) {
                return diff / MINUTE_MILLIS + " m";
            } else if (diff < 90 * MINUTE_MILLIS) {
                return "an hour ago";
            } else if (diff < 24 * HOUR_MILLIS) {
                return diff / HOUR_MILLIS + " h";
            } else if (diff < 48 * HOUR_MILLIS) {
                return "yesterday";
            } else {
                return diff / DAY_MILLIS + " d";
            }
        } catch (Exception e) {
            Log.e("Error:", "getRelativeTimeAgo failed", e);
            e.printStackTrace();
        }
        return "";
    }

    public final String getDescription() {
        return getString(KEY_DESCRIPTION);
    }

    public final void setDescription(String description) {
        put(KEY_DESCRIPTION, description);
    }

    public final ParseFile getImage() {
        return getParseFile(KEY_IMAGE);
    }

    public final void setImage(ParseFile parseFile) {
        put(KEY_IMAGE, parseFile);
    }

    public final ParseUser getUser() {
        return getParseUser(KEY_USER);
    }

    public final void setUser(ParseUser user) {
        put(KEY_USER, user);
    }
}
