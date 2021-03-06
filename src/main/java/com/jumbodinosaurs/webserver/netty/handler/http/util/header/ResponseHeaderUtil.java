package com.jumbodinosaurs.webserver.netty.handler.http.util.header;

public class ResponseHeaderUtil
{
    //headers
    public static final String keepAlive = "\r\nConnection: keep-alive\r\n\r\n";
    public static final String acceptedLanguageHeader = "\r\nAccept-Language: en-US";
    public static final String originHeader = "\r\nOrigin: http://www.jumbodinosaurs.com/";
    public static final String contentTypeHeader = "\r\nContent-Type: ";
    public static final String contentApplicationHeader = "\r\nContent-Type: application/";
    public static final String contentLengthHeader = "\r\nContent-Length: "; //[length in bytes of the image]\r\n
    
    
    public static String getContentHeader(String fileType)
    {
        return contentTypeHeader + ContentTypeUtil.getContentType(fileType);
    }
}
