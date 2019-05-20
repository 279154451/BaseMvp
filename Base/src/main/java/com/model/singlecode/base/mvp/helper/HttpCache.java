package com.model.singlecode.base.mvp.helper;


import java.io.File;

import okhttp3.Cache;

/**
 * 创建时间：2019/5/14
 * 创建人：singleCode
 * 功能描述：
 **/
public class HttpCache {

    private static final int HTTP_RESPONSE_DISK_CACHE_MAX_SIZE = 50 * 1024 * 1024;

    public static Cache getCache() {
        return new Cache(new File("缓存路径" + File
                .separator + "data/NetCache"),
                HTTP_RESPONSE_DISK_CACHE_MAX_SIZE);
    }
}
