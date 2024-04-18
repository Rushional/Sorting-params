package com.rushional.sort_params.services.impl;

import com.rushional.sort_params.services.EncodingService;
import org.apache.commons.codec.binary.Hex;
import org.springframework.stereotype.Service;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

@Service
public class EncodingServiceImpl implements EncodingService {

    @Override
    public String hashParamsString(String paramsString) throws InvalidKeyException, NoSuchAlgorithmException,
            UnsupportedEncodingException {
//        TODO: define a key in environment variables
        String key = "super secure key with no downsides whatsoever";
        Mac sha256_HMAC = Mac.getInstance("HmacSHA256");
        SecretKeySpec secret_key = new SecretKeySpec(key.getBytes("UTF-8"), "HmacSHA256");
        sha256_HMAC.init(secret_key);

        return new String(Hex.encodeHex(sha256_HMAC.doFinal(paramsString.getBytes("UTF-8"))));
    }
}
