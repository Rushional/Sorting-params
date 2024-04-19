package com.rushional.sort_params.services;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

public interface EncodingService {

    String hashString(String paramsString, String secretKey) throws InvalidKeyException, NoSuchAlgorithmException, UnsupportedEncodingException;
}
