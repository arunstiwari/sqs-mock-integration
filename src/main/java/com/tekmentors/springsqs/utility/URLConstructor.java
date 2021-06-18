package com.tekmentors.springsqs.utility;

public class URLConstructor {
    private final static  String SCHEME ="https://";

    public String constructUrl(String region, String accountId, String qName){
        return SCHEME+"sqs."+region+".amazonaws.com/"+accountId+"/"+qName;
    }
}
