package com.vaudience.coding.exercise.vaudience.security;

import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;

import java.util.HashMap;
import java.util.Map;

public class UserTokenEnhancer implements TokenEnhancer {
    private static final int ADDITIONAL_INFO_CAPACITY = 2;
    @Override
    public OAuth2AccessToken enhance(OAuth2AccessToken oAuth2AccessToken, OAuth2Authentication oAuth2Authentication) {
        CustomUserDetails customUserDetails = (CustomUserDetails) oAuth2Authentication.getPrincipal();

        Map<String, Object> additionalInfo = new HashMap<>(ADDITIONAL_INFO_CAPACITY);
        additionalInfo.put("user_id", customUserDetails.getUserId());
        additionalInfo.put("username",customUserDetails.getUsername());
        ((DefaultOAuth2AccessToken)oAuth2AccessToken).setAdditionalInformation(additionalInfo);

        return oAuth2AccessToken;
    }
}
