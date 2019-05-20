package com.model.singlecode.base.mvp.helper;



import java.io.IOException;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * 创建时间：2019/5/14
 * 创建人：singleCode
 * 功能描述：
 **/
public class CacheInterceptor implements Interceptor {

    //请求头
    public static final String HTTP_HEADER_AUTHORIZATION = "Authorization";
    public static final String HTTP_HEADER_ZHAO_DEVICEID = "X-Zhao-DeviceId";
    public static final String HTTP_HEADER_ZHAO_APPID = "X-Zhao-AppId";
    public static final String HTTP_HEADER_ZHAO_USERID = "X-Zhao-UserId";
    public static final String HTTP_HEADER_ZHAO_TEST = "X-Zhao-test";
    public static final String HTTP_HEADER_CONTENT_TYPE = "Content-Type";
    public static final String HTTP_HEADER_ZHAO_OSINFO = "X-Zhao-OSInfo";
    public static final String HTTP_HEADER_CHARSET = "charset";
    public static final String HTTP_CONTENT_TYPE_VALUE = "application/json";
    public static final String HTTP_CHARSET_VALUE = "utf-8";
    public static final String HTTP_BINDER_ID = "binderId";

    @Override
    public Response intercept(Chain chain) throws IOException {

        //拦截请求，添加自定义请求体
        Request mRequest = chain.request().newBuilder()
//                .addHeader(HTTP_HEADER_AUTHORIZATION, getAuthori(chain.request().method(), chain.request().url().toString(), UUID.randomUUID().toString()))
//                .addHeader(HTTP_HEADER_ZHAO_DEVICEID, getDeviceId())
//                .addHeader(HTTP_HEADER_ZHAO_APPID, BaseApplication.mAppId)
//                .addHeader(HTTP_HEADER_ZHAO_USERID, BaseApplication.mUserId)
//                .addHeader(HTTP_HEADER_CONTENT_TYPE, HTTP_CONTENT_TYPE_VALUE)
//                .addHeader(HTTP_HEADER_ZHAO_OSINFO, getOsInfo())
//                .addHeader(HTTP_HEADER_CHARSET, HTTP_CHARSET_VALUE)
//                .addHeader(HTTP_BINDER_ID,AppCacheHelper.getHelper().getPushId())
                .build();


        Response mResponse = chain.proceed(mRequest);

//        if (!NetworkConnectionUtils.isConnected(AppUtils.getContext())) {
//            mRequest = mRequest.newBuilder()
//                    .cacheControl(CacheControl.FORCE_CACHE)
//                    .build();
//        }
//
//        if (NetworkConnectionUtils.isNetworkConnected(AppUtils.getContext())) {
//            // 有网络时, 缓存1小时
//            int maxAge = 60 * 60;
//
//            return mResponse.newBuilder()
//                    .removeHeader("Pragma")
//                    .removeHeader("Cache-Control")
//                    .header("Cache-Control", "public, max-age=" + maxAge)
//                    .build();
//        } else {
//            // 无网络时，缓存为4周
//            int maxStale = 60 * 60 * 24 * 28;
//
//            return mResponse.newBuilder()
//                    .removeHeader("Pragma")
//                    .removeHeader("Cache-Control")
//                    .header("Cache-Control", "public, only-if-cached, max-stale=" + maxStale)
//                    .build();
//        }
        return mResponse;
    }

}
