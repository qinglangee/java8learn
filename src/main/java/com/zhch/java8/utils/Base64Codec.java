package com.zhch.java8.utils;

import java.io.IOException;

public interface Base64Codec {

    public String encode(final byte[] data);
    public byte[] decode(final String base64) throws IOException;
}
