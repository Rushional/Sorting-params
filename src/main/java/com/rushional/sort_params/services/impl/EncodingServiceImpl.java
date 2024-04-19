package com.rushional.sort_params.services.impl;

import com.rushional.sort_params.services.EncodingService;
import org.apache.commons.codec.binary.Hex;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

@Service
public class EncodingServiceImpl implements EncodingService {

    @Override
    public String hashString(String originalString, String secretKey) throws InvalidKeyException, NoSuchAlgorithmException,
            UnsupportedEncodingException {
        Mac sha256_HMAC = Mac.getInstance("HmacSHA256");
        SecretKeySpec secret_key = new SecretKeySpec(secretKey.getBytes("UTF-8"), "HmacSHA256");
        sha256_HMAC.init(secret_key);

        return new String(Hex.encodeHex(sha256_HMAC.doFinal(originalString.getBytes("UTF-8"))));
    }
}
