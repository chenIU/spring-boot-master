package com.ruida.springbootdemo.utils;

import com.ruida.springbootdemo.enums.ErrorEnum;
import com.ruida.springbootdemo.exception.BaseException;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.ContentBody;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.springframework.http.HttpStatus;

import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author Chen.J.Y
 * @date 2021/5/25
 */
public class HttpClientUtil {

    private static final String CHARSET = "UTF-8";
    private static final String FORM_CONTENT_TYPE = "application/x-www-form-urlencoded;charset=UTF-8";
    private static final String JSON_CONTENT_TYPE = "application/json;charset=UTF-8";
    private static final String XML_CONTENT_TYPE = "application/soap_xml;charset=UTF-8";

    //设置超时时间
    private static final RequestConfig requestConfig = RequestConfig.custom()
            .setSocketTimeout(60000)
            .setConnectTimeout(60000)
            .setConnectionRequestTimeout(60000)
            .setExpectContinueEnabled(false)
            .build();

    //连接池配置
    private static final PoolingHttpClientConnectionManager httpClientConnectionManager;
    private static final CloseableHttpClient client;
    private static final CloseableHttpClient sslClient;

    static {
        httpClientConnectionManager = new PoolingHttpClientConnectionManager();
        //整个线程池维护的 总的线程数
        httpClientConnectionManager.setMaxTotal(500);
        //允许并发访问（本机同时开发端口数）
        httpClientConnectionManager.setDefaultMaxPerRoute(150);

        //http连接
        HttpClientBuilder httpClientBuilder;
        client = HttpClientBuilder.create()
                .setConnectionManager(httpClientConnectionManager)
                .disableAutomaticRetries()
                .build();

        sslClient = sslClient();
    }


    /**
     * 设置SSL请求处理
     */
    private static CloseableHttpClient sslClient() {
        try {
            SSLContext ctx = SSLContext.getInstance("TLS");
            X509TrustManager tm = new X509TrustManager() {
                @Override
                public X509Certificate[] getAcceptedIssuers() {
                    return null;
                }

                @Override
                public void checkClientTrusted(X509Certificate[] xcs, String str) {
                }

                @Override
                public void checkServerTrusted(X509Certificate[] xcs, String str) {
                }
            };
            ctx.init(null, new TrustManager[]{tm}, null);
            SSLConnectionSocketFactory ssf = new SSLConnectionSocketFactory(ctx, NoopHostnameVerifier.INSTANCE);
            return HttpClients.custom().setSSLSocketFactory(ssf).build();
        } catch (NoSuchAlgorithmException | KeyManagementException e) {
            throw new BaseException(ErrorEnum.ERROR, "HTTPS连接创建失败");
        }
    }

    public static String doGet(String url, Map<String, String> params, Map<String, String> headers) {
        CloseableHttpClient httpClient = null;
        CloseableHttpResponse httpResponse = null;
        try {//构建参数
            URIBuilder builder = new URIBuilder(url);
            if (params != null) {
                for (String key : params.keySet()) {
                    builder.addParameter(key, params.get(key));
                }
            }
            URI uri = builder.build();
            //创建http GET请求
            HttpGet httpGet = new HttpGet(uri);
            //设置header
            if (headers != null) {
                for (String header : headers.keySet()) {
                    httpGet.setHeader(header, headers.get(header));
                }
            }
            //设置超时时间
            httpGet.setConfig(requestConfig);

            httpClient = declareHttpClient(url);
            httpResponse = httpClient.execute(httpGet);
            return getHttpResult(httpResponse);
        } catch (URISyntaxException e) {
            throw new BaseException(ErrorEnum.ERROR, String.format("URL解析失败,[%s],exception[%s]", url, e));
        } catch (ClientProtocolException e) {
            throw new BaseException(ErrorEnum.ERROR, String.format("http请求失败,[%s],exception[%s]", url, e));
        } catch (IOException e) {
            throw new BaseException(ErrorEnum.ERROR, String.format("http请求IO异常,[%s],exception[%s]", url, e));
        } finally {
            closeResources(httpResponse);
            //因为使用了连接池,httpClient不需要手动关闭
        }

    }

    /**
     * GET请求
     */
    public static String doGet(String url) {
        return doGet(url, null, null);
    }

    public static String doGet(String url, Map<String, String> params) {
        return doGet(url, params, null);
    }

    private static CloseableHttpClient declareHttpClient(String url) {
        if (url.startsWith("https://")) {
            return sslClient();
        } else {
            return client;
        }
    }

    private static void closeResources(CloseableHttpResponse httpResponse) {
        if (httpResponse != null) {
            try {
                httpResponse.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static String getHttpResult(CloseableHttpResponse httpResponse) throws IOException {
        HttpEntity httpEntity = httpResponse.getEntity();
        String result = EntityUtils.toString(httpEntity, CHARSET);
        if (httpResponse.getStatusLine().getStatusCode() != HttpStatus.OK.value()) {
            throw new BaseException(ErrorEnum.ERROR, httpResponse + " body:" + result);
        }
        return result;
    }

    /**
     * POST请求
     * 参数为 ?aa=vv&bb=vv
     */
    public static String doPost(String url, Map<String, String> params, Map<String, String> headers) {
        CloseableHttpClient httpClient = null;
        CloseableHttpResponse httpResponse = null;
        try {
            //创建http POST请求
            HttpPost httpPost = new HttpPost(url);
            //设置header
            if (headers != null && !headers.isEmpty()) {
                for (String header : headers.keySet()) {
                    httpPost.setHeader(header, headers.get(header));
                }
            }
            httpPost.setHeader("Content-Type", FORM_CONTENT_TYPE);
            //设置参数
            if (params != null) {
                List<NameValuePair> paramList = new ArrayList<>();
                for (String key : params.keySet()) {
                    paramList.add(new BasicNameValuePair(key, params.get(key)));
                }
                //模拟表单
                UrlEncodedFormEntity entity = new UrlEncodedFormEntity(paramList, CHARSET);
                entity.setContentEncoding(CHARSET);
                httpPost.setEntity(entity);
            }
            //设置超时时间
            httpPost.setConfig(requestConfig);

            httpClient = declareHttpClient(url);
            httpResponse = httpClient.execute(httpPost);

            return getHttpResult(httpResponse);
        } catch (UnsupportedEncodingException | ClientProtocolException e) {
            throw new BaseException(ErrorEnum.ERROR, String.format("http请求失败,[%s],exception[%s]", url, e));
        } catch (IOException e) {
            throw new BaseException(ErrorEnum.ERROR, String.format("http请求IO异常,[%s],exception[%s]", url, e));
        } finally {
            closeResources(httpResponse);
        }
    }

    public static String doPost(String url) {
        return doPost(url, null, null);
    }

    public static String doPost(String url, Map<String, String> params) {
        return doPost(url, params, null);
    }

    //参数为json
    public static String doPostJson(String url, String jsonBody, Map<String, String> headers) {
        CloseableHttpResponse httpResponse = null;
        CloseableHttpClient httpClient = null;
        try {
            HttpPost httpPost = new HttpPost();
            //设置header
            if (headers != null && !headers.isEmpty()) {
                for (String header : headers.keySet()) {
                    httpPost.setHeader(header, headers.get(header));
                }
            }
            httpPost.setHeader("Content-Type", JSON_CONTENT_TYPE);
            //设置body
            StringEntity stringEntity = new StringEntity(jsonBody, ContentType.APPLICATION_JSON);
            stringEntity.setContentEncoding(CHARSET);
            httpPost.setEntity(stringEntity);

            //配置超时时间
            httpPost.setConfig(requestConfig);
            httpClient = declareHttpClient(url);
            httpResponse = httpClient.execute(httpPost);

            return getHttpResult(httpResponse);
        } catch (ClientProtocolException e) {
            throw new BaseException(ErrorEnum.ERROR, String.format("http请求失败,[%s],exception[%s]", url, e));
        } catch (IOException e) {
            throw new BaseException(ErrorEnum.ERROR, String.format("http请求IO异常,[%s],exception[%s]", url, e));
        }
    }

    public static String doPostJson(String url, String jsonBody) {
        return doPostJson(url, jsonBody, null);
    }

    //表单形式提交
    public static String doPostMultiData(String url, Map<String, ContentBody> params, Map<String, String> headers) {
        CloseableHttpResponse httpResponse = null;
        CloseableHttpClient httpClient = null;
        try {
            HttpPost httpPost = new HttpPost(url);

            //设置header
            if (headers != null && !headers.isEmpty()) {
                for (String header : headers.keySet()) {
                    httpPost.setHeader(header, headers.get(header));
                }
            }

            //设置参数
            if (params != null && !params.isEmpty()) {
                MultipartEntityBuilder multipartEntityBuilder = MultipartEntityBuilder.create();
                for (String paramKey : params.keySet()) {
                    multipartEntityBuilder.addPart(paramKey, params.get(paramKey));
                }
                httpPost.setEntity(multipartEntityBuilder.build());
            }

            httpPost.setConfig(requestConfig);
            httpClient = declareHttpClient(url);
            httpResponse = httpClient.execute(httpPost);

            return getHttpResult(httpResponse);
        } catch (ClientProtocolException e) {
            throw new BaseException(ErrorEnum.ERROR, String.format("http请求失败,[%s],exception[%s]", url, e));
        } catch (IOException e) {
            throw new BaseException(ErrorEnum.ERROR, String.format("http请求IO异常,[%s],exception[%s]", url, e));
        }
    }

    public static String doPostMultiData(String url, Map<String, ContentBody> params) {
        return doPostMultiData(url, params, null);
    }

}
