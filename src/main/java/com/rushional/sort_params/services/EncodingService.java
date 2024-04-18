package com.rushional.sort_params.services;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

public interface EncodingService {

    String hashParamsString(String paramsString) throws InvalidKeyException, NoSuchAlgorithmException, UnsupportedEncodingException;
}
