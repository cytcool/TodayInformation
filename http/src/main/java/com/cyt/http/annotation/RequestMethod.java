package com.cyt.http.annotation;

import androidx.annotation.IntDef;

import static com.cyt.http.annotation.RequestMethod.Get;
import static com.cyt.http.annotation.RequestMethod.Post;

@IntDef({Get,Post})
public @interface RequestMethod {
    int Get = 1;
    int Post = 2;
}
