package com.wx.demo.utils;

import javax.net.ssl.X509TrustManager;
import java.security.cert.CertificateEncodingException;
import java.security.cert.X509Certificate;

public class MyX509TrustManager implements X509TrustManager {
    /**
     * 该方法用于检查客户端的证书，若不信则抛出异常
     * 由于我们不需要对客户端进行认证，可以不做任何处理
     */
    @Override
    public void checkClientTrusted(X509Certificate[] chain, String authType)
            throws CertificateEncodingException {

    }

    /**
     * 该方法用于检验服务器端的证书，若不信任则抛出异常
     * 通过自己实现该方法，可以使之信任我们指定的任何证书
     * 在实现该方法时，也可以不做任何处理，即一个空的方法实现
     * 由于不会抛出异常，它就会信任任何证书
     */
    @Override
    public void checkServerTrusted(X509Certificate[] chain, String authType)
            throws CertificateEncodingException {

    }

    /**
     * 返回收信任的X509证书数组
     */
    @Override
    public X509Certificate[] getAcceptedIssuers() {
        return null;
    }
}
