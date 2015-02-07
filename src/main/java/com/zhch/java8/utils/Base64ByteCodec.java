package com.zhch.java8.utils;

import java.io.IOException;

public interface Base64ByteCodec {
    public byte[] encodeBytes(final byte[] data);
    public byte[] decodeBytes(final byte[] base64) throws IOException;
}
